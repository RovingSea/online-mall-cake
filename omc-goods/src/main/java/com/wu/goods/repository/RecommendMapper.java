package com.wu.goods.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.Goods;
import com.wu.common.domain.Recommend;
import com.wu.common.model.RecommendViewModel;
import org.apache.ibatis.annotations.*;
import org.checkerframework.checker.units.qual.K;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/23 16:17
 * @since 1.0
 */
@Mapper
public interface RecommendMapper extends BaseMapper<Recommend> {

    @Override
    @Delete("delete from onlinemallcake.recommend where id = #{id}")
    Boolean deleteByPrimaryKey(Integer id);

    @Override
    @Insert("insert into onlinemallcake.recommend(type, goods_id) " +
            "VALUES(#{type}, #{goodsId}) ")
    Boolean insert(Recommend record);

    @Insert("insert into onlinemallcake.recommend(type, goods_id) " +
            "VALUES('热销', #{id}) ")
    Boolean insertHot(Integer id);

    @Insert("insert into onlinemallcake.recommend(type, goods_id) " +
            "VALUES('新品', #{id}) ")
    Boolean insertNew(Integer id);

    @Override
    @Select("select * from onlinemallcake.recommend where id = #{id}")
    Recommend selectByPrimaryKey(Integer id);

    List<RecommendViewModel> selectAllModel();

    List<RecommendViewModel> selectHotModel();

    List<RecommendViewModel> selectNewModel();

    @Override
    @Update("update onlinemallcake.recommend set type = #{type}, goods_id = #{goodsId} where id = #{id}")
    Boolean updateByPrimaryKey(Recommend record);
}

