package com.wu.user.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
    boolean deleteByPrimaryKey(Integer id);

    @Delete("delete from onlinemallcake.order where user_id = #{userId}")
    boolean deleteByUserId(Integer userId);

    @Override
    @Insert("insert into onlinemallcake.order(total, amount, status, pay_type, name, phone, address, datetime, user_id, goods_id) " +
            "VALUES(total = #{total}, amount = #{amount}, status = #{status}, pay_type = #{payType}, name = #{name}, phone = #{phone}, address = #{address}, #{datetime} = #{datetime}, user_id = #{userId}, goods_id = #{goodsId})")
    boolean insert(Order record);

    @Override
    @Select("select * from onlinemallcake.order where id")
    Order selectByPrimaryKey(Integer id);

    @Select("select * from onlinemallcake.order where user_id = #{userId}")
    List<Order> selectByUserId(int userId);

    @Override
    @Select("update onlinemallcake.order set total = #{total}, amount = #{amount}, status = #{status}, pay_type = #{payType}, name = #{name}, phone = #{phone}, address = #{address}, #{datetime} = #{datetime}, user_id = #{userId} where id = #{id}")
    boolean updateByPrimaryKey(Order record);

    @Select("update onlinemallcake.order set total = #{total}, amount = #{amount}, status = #{status}, pay_type = #{payType}, name = #{name}, phone = #{phone}, address = #{address}, #{datetime} = #{datetime} where user_id = #{userId}")
    boolean updateByUserId(Order record);
}

