package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.dao.OrderDao;
import com.lsxk.sbticket.entity.Order;
import com.lsxk.sbticket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrderService接口实现类
 * Created by wjz on 2018/3/2.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    public Order getOrderById(String orderId) {
        return orderDao.queryById(orderId);
    }

    public int addOrder(Order order) {
        return orderDao.insertOrder(order);
    }

    public int updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }
}
