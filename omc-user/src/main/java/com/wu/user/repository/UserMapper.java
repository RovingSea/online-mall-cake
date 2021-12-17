package com.wu.user.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * @author Haixin Wu
 * @date 2021/12/17
 * @time 13:19
 * @since 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Override
    @Delete("delete from onlinemallcake.user where id = #{id}")
    @Deprecated
    boolean deleteByPrimaryKey(Integer id);

    @Override
    @Insert("insert into onlinemallcake.user(username, password, name, email, phone, address, is_admin, is_validate) " +
            "VALUES(#{username}, #{passwod}, #{name}, #{email}, #{phone}, #{address}, #{isAdmin}, #{isValidate}) ")
    boolean insert(User record);

    @Override
    @Select("select * from user where id = #{id}")
    User selectByPrimaryKey(Integer id);

    @Override
    @Update("update onlinemallcake.user set username = #{username}, password = #{password}, name = #{name}, phone = #{phone}, address = #{address}, is_admin = #{isAdmin}, is_validate = #{isValidate}")
    boolean updateByPrimaryKey(User record);
}

