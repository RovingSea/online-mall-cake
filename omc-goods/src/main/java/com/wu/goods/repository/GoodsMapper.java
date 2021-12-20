package com.wu.goods.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/16 19:09
 * @since 1.0
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Override
    @Delete("delete from onlinemallcake.goods where id = #{id}")
    boolean deleteByPrimaryKey(Integer id);

    @Insert("insert into onlinemallcake.shoppingcart(user_id, goods_id, amount) " +
            "VALUES(#{userId}, #{goodsId}, 1)")
    boolean insertToShoppingCart(int userId, int goodsId);

    @Override
    @Insert("insert into onlinemallcake.goods(name, image1, image2, price, intro, stock, type_id)" +
            "VALUES(#{name}, #{image1}, #{image2}, #{price}, #{intro}, #{stock}, #{typeId}) ")
    boolean insert(Goods record);

    @Override
    @Select("select * from onlinemallcake.goods where id = #{id}")
    Goods selectByPrimaryKey(Integer id);

    @Select("select * from onlinemallcake.goods limit #{from},#{amount}")
    List<Goods> selectLimit(int from, int amount);

    @Select("select * from onlinemallcake.goods where name like '%#{goodsName}%' limit #{from}, #{amount}")
    List<Goods> selectLikeLimit(String goodsName, int from, int amount);

    @Override
    @Update("update onlinemallcake.goods set name = #{name}, image1 = #{image1}, image2 = #{image2}, price = #{price}, intro = #{intro}, stock = #{stock}, type_id = #{type_id}")
    boolean updateByPrimaryKey(Goods record);

}

