package com.wu.user.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.Order;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:19
 * @since 1.0
 */
public interface OrderMapper extends BaseMapper<Order> {
    @Override
    boolean deleteByPrimaryKey(Integer id);

    @Override
    boolean insert(Order record);

    @Override
    Order selectByPrimaryKey(Integer id);

    @Override
    boolean updateByPrimaryKey(Order record);
}

