package com.wu.goods.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.Goods;
import org.apache.ibatis.annotations.*;

/**
 * @author Haixin Wu
 * @date 2021/12/16
 * @time 19:09
 * @since 1.0
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Override
    @Delete("delete from onlinemallcake.goods where id = #{id}")
    boolean deleteByPrimaryKey(Integer id);

    @Override
    @Insert("insert into onlinemallcake.goods(name, image1, image2, price, intro, stock, type_id)" +
            "VALUES(#{name}, #{image1}, #{image2}, #{price}, #{intro}, #{stock}, #{typeId}) ")
    boolean insert(Goods record);

    @Override
    @Select("select * from onlinemallcake.goods where id = #{id}")
    Goods selectByPrimaryKey(Integer id);

    @Override
    @Update("update onlinemallcake.goods set name = #{name}, image1 = #{image1}, image2 = #{image2}, price = #{price}, intro = #{intro}, stock = #{stock}, type_id = #{type_id}")
    boolean updateByPrimaryKey(Goods record);
}
