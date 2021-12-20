package com.wu.user.service.impl;

import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.Order;
import com.wu.common.service.user.OrderService;
import com.wu.user.repository.OrderMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:21
 * @since 1.0
 */
//@DubboService
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        super(orderMapper);
        this.orderMapper = orderMapper;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderMapper.selectByUserId(userId);
    }

    @Override
    public int initOrderAndReturnId(Order order) {
        return orderMapper.initOrder(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }
}

