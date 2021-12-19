package com.wu.user.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.OrderItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:18
 * @since 1.0
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    @Override
    @Delete("delete from onlinemallcake.orderitem where id = #{id}")
    @Deprecated
    boolean deleteByPrimaryKey(Integer id);

    @Override
    @Insert("insert into onlinemallcake.orderitem(price, amount, goods_id, order_id) " +
            "VALUES(price = #{price}, amount = #{amount}, goods_id = #{goodsId}, order_id = #{orderId})")
    boolean insert(OrderItem record);

    @Override
    @Select("select * from onlinemallcake.orderitem where id = #{id}")
    OrderItem selectByPrimaryKey(Integer id);

    @Override
    @Update("update onlinemallcake.orderitem set price = #{price}, amount = #{amount}, goods_id = #{goodsId}, order_id = #{orderId} where id = #{id}")
    boolean updateByPrimaryKey(OrderItem record);
}

