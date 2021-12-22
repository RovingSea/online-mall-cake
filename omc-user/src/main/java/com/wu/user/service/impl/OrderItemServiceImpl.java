package com.wu.user.service.impl;

import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.Order;
import com.wu.common.domain.OrderItem;
import com.wu.common.service.user.OrderItemService;
import com.wu.common.utility.annotation.ZkReadLock;
import com.wu.user.repository.OrderItemMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:17
 * @since 1.0
 */
@DubboService
@Service
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem> implements OrderItemService {
    private final OrderItemMapper orderItemMapper;

    @Autowired
    public OrderItemServiceImpl(OrderItemMapper orderItemMapper) {
        super(orderItemMapper);
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    @ZkReadLock
    public List<OrderItem> getAllPaidOrdersByUserId(int userId) {
        return orderItemMapper.selectPaidOrdersByUserId(userId);
    }

    @Override
    @ZkReadLock
    public List<OrderItem> getAllUnpaidOrdersByUserId(int userId) {
        return orderItemMapper.selectUnpaidOrdersByUserId(userId);
    }

    @Override
    @ZkReadLock
    public List<OrderItem> getOrderItemsByUserId(int userId) {
        return orderItemMapper.selectByUserId(userId);
    }

    @Override
    @ZkReadLock
    public Order getOrderByOrderItemId(int orderItemId) {
        return orderItemMapper.selectOrderByOrderItemId(orderItemId);
    }
}

