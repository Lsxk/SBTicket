package com.lsxk.sbticket.service;

import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.exception.ParamException;

/**
 * 交易相关的接口
 * Created by wjz on 2018/3/1.
 */
public interface TradeService {

    /**
     * 生成订单号
     * @param orderUid 用户id
     * @param orderTime 下单时间
     * @return
     */
    String generateOrderId(String orderUid, String orderTime) throws ParamException;

    /**
     * 生成总票价
     * @param ticket 票
     * @param count 票数
     * @return 总票价，保留2位小数
     */
    String generatePrice(Ticket ticket, int count);
}
