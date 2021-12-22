package com.wu.goods.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/20 21:03
 * @since 1.0
 */
@Mapper
public interface TypeMapper extends BaseMapper<Type> {

    @Override
    @Delete("delete from onlinemallcake.type where id = #{id}")
    boolean deleteByPrimaryKey(Integer id);

    @Override
    @Insert("insert into onlinemallcake.type(id, name) " +
            "VALUES(#{id}, #{name}) ")
    boolean insert(Type record);

    @Override
    @Select("select * from onlinemallcake.type where id = #{id}")
    Type selectByPrimaryKey(Integer id);

    @Select("select * from onlinemallcake.type")
    List<Type> selectAll();

    @Override
    @Update("update onlinemallcake.type set id = #{id}, name = #{name}")
    boolean updateByPrimaryKey(Type record);
}

