package com.wu.common.service.user;

import com.wu.common.base.BaseService;
import com.wu.common.domain.Order;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:16
 * @since 1.0
 */
public interface OrderService extends BaseService<Order>  {
    /**
     * 通过用户id得到所有的订单
     * @param userId 用户id
     * @return 所有订单
     */
    List<Order> getOrdersByUserId(int userId);
}

