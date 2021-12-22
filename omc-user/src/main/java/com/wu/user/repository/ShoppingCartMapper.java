package com.wu.user.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.ShoppingCart;
import com.wu.common.model.ShoppingCartViewModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/18 22:18
 * @since 1.0
 */
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
    @Select("select * from onlinemallcake.shoppingcart where user_id = #{userId}")
    List<ShoppingCart> getShoppingCarts(int userId);

    List<ShoppingCartViewModel> selectMine(int userId);

    @Override
    @Delete("delete from onlinemallcake.shoppingcart where id = #{id}")
    Boolean deleteByPrimaryKey(Integer id);

    @Override
    @Insert("insert into onlinemallcake.shoppingcart(user_id, goods_id, amount) " +
            "VALUES (#{userId}, #{goodsId}, #{amount})")
    Boolean insert(ShoppingCart record);

    @Override
    @Select("select * from onlinemallcake.shoppingcart where id = #{id}")
    ShoppingCart selectByPrimaryKey(Integer id);

    @Override
    @Deprecated
    @Update("update onlinemallcake.shoppingcart set amount = #{amount} where id = #{id}")
    Boolean updateByPrimaryKey(ShoppingCart record);

    @Update("update onlinemallcake.shoppingcart set amount = #{amount} + 1 where id = #{id}")
    Boolean addAmountByPrimaryKey(int id);

    @Update("update onlinemallcake.shoppingcart set amount = #{amount} + #{num} where id = #{id}")
    Boolean changeNumByPrimaryKey(int id, int num);

    @Delete("delete from onlinemallcake.shoppingcart where user_id = #{userId}")
    Boolean deleteByUserId(Integer userId);
}

