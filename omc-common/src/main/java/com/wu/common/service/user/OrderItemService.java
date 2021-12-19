package com.wu.common.service.user;

import com.wu.common.base.BaseService;
import com.wu.common.domain.Order;
import com.wu.common.domain.OrderItem;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:16
 * @since 1.0
 */
public interface OrderItemService extends BaseService<OrderItem> {
    /**
     * 通过用户id得到所有的订单项
     * @param userId 用户id
     * @return 所有订单
     */
    List<OrderItem> getOrderItemsByUserId(int userId);

    /**
     * 通过订单项id查询订单
     * @param orderItemId 订单项id
     * @return 该订单
     */
    Order getOrderByOrderItemId(int orderItemId);
}

