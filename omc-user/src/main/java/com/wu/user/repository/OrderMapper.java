package com.wu.user.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:19
 * @since 1.0
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    @Override
    @Delete("delete from onlinemallcake.order where id = #{id}")
    Boolean deleteByPrimaryKey(Integer id);

    @Delete("delete from onlinemallcake.order where user_id = #{userId}")
    Boolean deleteByUserId(Integer userId);

    @Override
    @Insert("insert into onlinemallcake.order(total, amount, status, pay_type, name, phone, address, datetime, user_id) " +
            "VALUES(total = #{total}, amount = #{amount}, status = #{status}, pay_type = #{payType}, name = #{name}, phone = #{phone}, address = #{address}, datetime = #{datetime}, user_id = #{userId})")
    Boolean insert(Order record);

    @Insert("insert into onlinemallcake.order(total, amount, status, pay_type, name, phone, address, datetime, user_id) " +
            "VALUES(total = #{total}, amount = #{amount}, status = #{status}, pay_type = #{payType}, name = #{name}, phone = #{phone}, address = #{address}, datetime = #{datetime}, user_id = #{userId})")
    @SelectKey(statement = "select LAST_INSERT_ID()", resultType = Integer.class, keyProperty = "id", before = false)
    int initOrder(Order order);

    @Override
    @Select("select * from onlinemallcake.order where id = #{id}")
    Order selectByPrimaryKey(Integer id);

    @Select("select * from onlinemallcake.order where user_id = #{userId}")
    List<Order> selectByUserId(int userId);

    @Override
    @Select("update onlinemallcake.order set total = #{total}, amount = #{amount}, status = #{status}, pay_type = #{payType}, name = #{name}, phone = #{phone}, address = #{address}, #{datetime} = #{datetime}, user_id = #{userId} where id = #{id}")
    Boolean updateByPrimaryKey(Order record);

    @Select("update onlinemallcake.order set total = #{total}, amount = #{amount}, status = #{status}, pay_type = #{payType}, name = #{name}, phone = #{phone}, address = #{address}, #{datetime} = #{datetime} where user_id = #{userId}")
    Boolean updateByUserId(Order record);
}

