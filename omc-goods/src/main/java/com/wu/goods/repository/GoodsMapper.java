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
    Boolean deleteByPrimaryKey(Integer id);

    @Insert("insert into onlinemallcake.shoppingcart(user_id, goods_id, amount) " +
            "VALUES(#{userId}, #{goodsId}, 1)")
    Boolean insertToShoppingCart(int userId, int goodsId);

    @Override
    @Insert("insert into onlinemallcake.goods(name, image1, image2, price, intro, stock, type_id)" +
            "VALUES(#{name}, #{image1}, #{image2}, #{price}, #{intro}, #{stock}, #{typeId}) ")
    Boolean insert(Goods record);

    @Select("select count(*) from onlinemallcake.goods")
    int selectAllSize();

    @Select("select count(*) from onlinemallcake.goods where type_id = #{typeId}")
    int selectAllSizeByTypeId(int typeId);

    int selectAllSizeLike(String goodsName);

    @Override
    @Select("select * from onlinemallcake.goods where id = #{id}")
    Goods selectByPrimaryKey(Integer id);

    @Select("select * from onlinemallcake.goods limit #{from},#{eachPageSize}")
    List<Goods> selectPage(int from, int eachPageSize);

    List<Goods> selectPageLike(String goodsName, int from, int eachPageSize);

    List<Goods> selectPageByType(int typeId, int from, int eachPageSize);

    @Override
    @Update("update onlinemallcake.goods set name = #{name}, image1 = #{image1}, image2 = #{image2}, price = #{price}, intro = #{intro}, stock = #{stock}, type_id = #{type_id}")
    Boolean updateByPrimaryKey(Goods record);

}

