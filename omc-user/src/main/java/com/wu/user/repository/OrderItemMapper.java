package com.wu.user.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.Order;
import com.wu.common.domain.OrderItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:18
 * @since 1.0
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    @Override
    @Delete("delete from onlinemallcake.orderitem where id = #{id}")
    @Deprecated
    Boolean deleteByPrimaryKey(Integer id);

    @Override
    @Insert("insert into onlinemallcake.orderitem(price, amount, goods_id, order_id) " +
            "VALUES(price = #{price}, amount = #{amount}, goods_id = #{goodsId}, order_id = #{orderId})")
    Boolean insert(OrderItem record);

    @Override
    @Select("select * from onlinemallcake.orderitem where id = #{id}")
    OrderItem selectByPrimaryKey(Integer id);

    List<OrderItem> selectByUserId(int userId);

    Order selectOrderByOrderItemId(int orderItemId);

    List<OrderItem> selectUnpaidOrdersByUserId(int userId);

    List<OrderItem> selectPaidOrdersByUserId(int userId);

    @Override
    @Update("update onlinemallcake.orderitem set price = #{price}, amount = #{amount}, goods_id = #{goodsId}, order_id = #{orderId} where id = #{id}")
    Boolean updateByPrimaryKey(OrderItem record);
}

