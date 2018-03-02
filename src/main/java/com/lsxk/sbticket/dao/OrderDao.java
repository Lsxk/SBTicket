package com.lsxk.sbticket.dao;

import com.lsxk.sbticket.entity.Order;

/**
 * t_order数据层
 * Created by wjz on 2018/3/2.
 */
public interface OrderDao {
    /**
     * 通过订单id查询
     * @param orderId 订单id
     * @return 订单
     */
    Order queryById(String orderId);

    /**
     * 插入订单
     * @param order 订单
     * @return 1为插入成功
     */
    int insertOrder(Order order);

    /**
     * 更新订单
     * @param order 订单
     * @return 1为更新成功
     */
    int updateOrder(Order order);
}
