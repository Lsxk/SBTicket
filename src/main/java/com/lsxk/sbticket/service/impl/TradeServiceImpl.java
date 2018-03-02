package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.exception.ParamException;
import com.lsxk.sbticket.service.TradeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * TradeService接口实现类
 * Created by wjz on 2018/3/1.
 */
@Service
public class TradeServiceImpl implements TradeService {

    /**
     * 生成订单号
     * @param orderUid 用户id
     * @param orderTime 下单时间
     * @return 生成的订单号码，
     * @throws ParamException
     */
    public String generateOrderId(String orderUid, String orderTime) throws ParamException {
        if (StringUtils.isAnyBlank(orderUid, orderTime)) {
            throw new ParamException("参数错误");
        }

        return orderTime + orderUid;
    }

    public String generatePrice(Ticket ticket, int count) {
        float p = ticket.getPrice() * count;

        DecimalFormat decimalFormat = new DecimalFormat(".00");

        return decimalFormat.format(p);
    }
}
