package com.wu.user.service.impl;

import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.OrderItem;
import com.wu.common.service.user.OrderItemService;
import com.wu.user.repository.OrderItemMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:17
 * @since 1.0
 */
@DubboService
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem> implements OrderItemService {
    private final OrderItemMapper orderItemMapper;

    @Autowired
    public OrderItemServiceImpl(OrderItemMapper orderItemMapper) {
        super(orderItemMapper);
        this.orderItemMapper = orderItemMapper;
    }
}

