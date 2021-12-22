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
     * 得到最后一条数据的id
     * @return id
     */
    int getLastId();
    /**
     * 通过用户id得到所有的订单
     * @param userId 用户id
     * @return 所有订单
     */
    List<Order> getOrdersByUserId(int userId);
    /**
     * 向数据库中增加 Order 类型的实体数据
     * @param order Order 类型的实体数据
     * @return 返回插入数据后的主键id
     */
    @Deprecated
    Order initOrderAndReturnId(Order order);

    /**
     * 通过订单id返回订单
     * @param id 订单id
     * @return 该订单
     */
    Order getOrderById(int id);
}

