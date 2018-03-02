package com.lsxk.sbticket.web;

import com.lsxk.sbticket.entity.Order;
import com.lsxk.sbticket.entity.Path;
import com.lsxk.sbticket.entity.Site;
import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.exception.ParamException;
import com.lsxk.sbticket.service.*;
import com.lsxk.sbticket.util.PayUtil;
import com.lsxk.sbticket.util.TicketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    private PathService pathService;
    @Autowired
    private SiteService siteService;
    @Autowired
    private TradeService tradeService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/pay")
    @ResponseBody
    public Map<String, Object> pay(HttpServletRequest request, String orderUid, long ticketId, int count, int istype) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> remoteMap = new HashMap<String, Object>();

        String goodsName;
        String price;
        String orderId;
        String orderTime;

        Ticket ticket = ticketService.getTicketById(ticketId);
        Path path = pathService.getPathById(ticket.getPathId());
        Site sourceSite = siteService.getSiteById(path.getSourceSiteId());
        Site distSite = siteService.getSiteById(path.getDistSiteId());

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

            /**
             * 订单入库，此时还未付款成功
             */
            Order order = new Order();
            order.setOrderId(orderId);
            order.setOrderUid(orderUid);
            order.setOrderTime(orderTime);
            order.setTicketId(ticketId);
            order.setTotalPrice(Float.valueOf(price));
            order.setOrderStatus(0);

            orderService.addOrder(order);

            /**
             * 减库存
             */

            ticketService.reduceTicket(ticketId, count);


        } catch (ParamException e) {
            e.printStackTrace();
        }




        return resultMap;
    }
}
