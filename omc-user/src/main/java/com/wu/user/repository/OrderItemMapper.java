package com.wu.user.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.OrderItem;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:18
 * @since 1.0
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    @Override
    boolean deleteByPrimaryKey(Integer id);

    @Override
    boolean insert(OrderItem record);

    @Override
    OrderItem selectByPrimaryKey(Integer id);

    @Override
    boolean updateByPrimaryKey(OrderItem record);
}

