package com.lsxk.sbticket.service;

import com.lsxk.sbticket.entity.Order;

/**
 * 订单相关服务接口
 * Created by wjz on 2018/3/2.
 */
public interface OrderService {

    /**
     * 通过订单号查询订单
     * @param orderId 订单号
     * @return 订单
     */
    Order getOrderById(String orderId);

    /**
     * 插入订单记录
     * @param order 订单
     * @return 1为插入成功
     */
    int addOrder(Order order);

    /**
     * 修改订单记录
     * @param order 订单
     * @return 1为修改成功
     */
    int updateOrder(Order order);
}
