package com.lsxk.sbticket.web;

import com.lsxk.sbticket.dto.PaySaPi;
import com.lsxk.sbticket.dto.TicketResult;
import com.lsxk.sbticket.entity.Order;
import com.lsxk.sbticket.entity.Site;
import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.enums.OrderStateEnum;
import com.lsxk.sbticket.exception.ParamException;
import com.lsxk.sbticket.service.*;
import com.lsxk.sbticket.util.PayUtil;
import com.lsxk.sbticket.util.TicketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 交易相关的控制器
 * Created by wjz on 2018/3/2.
 */
@Controller
@RequestMapping("/trade")
public class TradeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TicketService ticketService;
    @Autowired
    private SiteService siteService;
    @Autowired
    private TradeService tradeService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{ticketId}/{count}/queryTotalPrice")
    @ResponseBody
    public TicketResult<Object> queryTotalPrice(@PathVariable("ticketId") long ticketId, @PathVariable("count") int count) {
        TicketResult<Object> totalPriceResult;
        try {
            Ticket ticket = ticketService.getTicketById(ticketId);
            float price = ticket.getPrice() * count;
            Object totalPrice = new DecimalFormat("##0.00").format(price);
            totalPriceResult = new TicketResult<Object>(true, totalPrice);
        } catch (Exception e) {
            totalPriceResult = new TicketResult<Object>(false, "获取价格失败");
            logger.error(e.getMessage());
        }
        return totalPriceResult;
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseBody
    public TicketResult<Map<String, Object>> pay(HttpServletRequest request, String orderUid, long ticketId, int count, int istype) {

        TicketResult<Map<String, Object>> ticketResult;
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> remoteMap = new HashMap<String, Object>();

        String goodsName;
        String price;
        String orderId;
        String orderTime;

        Ticket ticket = ticketService.getTicketById(ticketId);
        Site sourceSite = siteService.getSiteById(ticket.getSourId());
        Site distSite = siteService.getSiteById(ticket.getDistId());

        try {
            orderTime = System.currentTimeMillis() + "";
            goodsName = TicketUtil.generateGoodsName(sourceSite.getName(), distSite.getName());
            orderId = tradeService.generateOrderId(orderUid, orderTime);
            price = tradeService.generatePrice(ticket, count);

            remoteMap.put("price", price);
            remoteMap.put("istype", istype);
            //remoteMap.put("orderid", PayUtil.getOrderIdByUUId());

            remoteMap.put("orderid", orderId);

            remoteMap.put("orderuid", orderUid);
            remoteMap.put("goodsname", goodsName);
            resultMap.put("data", PayUtil.payOrder(remoteMap));

            ticketResult = new TicketResult<Map<String, Object>>(true, resultMap);
            /**
             * 减库存
             */

            if (ticketService.reduceTicket(ticketId, count)) {
                /**
                 * 订单入库，此时还未付款成功
                 */
                Order order = new Order();
                order.setOrderId(orderId);
                order.setOrderUid(orderUid);
                order.setOrderTime(orderTime);
                order.setTicketId(ticketId);
                order.setTotalPrice(Float.valueOf(price));
                order.setOrderStatus(OrderStateEnum.UNPAID.getState());
                orderService.addOrder(order);
            } else {
                // 查询库存
                ticketResult = new TicketResult<Map<String, Object>>(false, "已卖完");
            }
        } catch (ParamException e) {
            ticketResult = new TicketResult<Map<String, Object>>(false, "参数错误");
            e.printStackTrace();
        }
        return ticketResult;
    }

    @RequestMapping(value = "/notifyPay", method = RequestMethod.POST)
    public void notifyPay(HttpServletRequest request, HttpServletResponse response, PaySaPi paySaPi) {
        // 保证密钥一致性
        if (PayUtil.checkPayKey(paySaPi)) {
            // 更新订单状态
            Order order = new Order();
            order.setOrderId(paySaPi.getOrderid());
            order.setOrderStatus(OrderStateEnum.PAID.getState());
            if (orderService.updateOrder(order) == 1) {
                logger.info("付款成功"+ order.getOrderId());
            }
        } else {
            Order order = new Order();
            order.setOrderId(paySaPi.getOrderid());
            order.setOrderStatus(OrderStateEnum.CANCEL.getState());
            orderService.updateOrder(order);
            if (orderService.updateOrder(order) == 1) {
                logger.info("付款失败，已取消订单"+ order.getOrderId());
            }
        }
    }
}
