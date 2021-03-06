package com.wu.user.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * @author Haixin Wu
 * @date 2021/12/17 13:19
 * @since 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Override
    @Delete("delete from onlinemallcake.user where id = #{id}")
    @Deprecated
    Boolean deleteByPrimaryKey(Integer id);

    @Override
    @Insert("insert into onlinemallcake.user(username, password, name, email, phone, address, is_admin, is_validate) " +
            "VALUES(#{username}, #{password}, #{name}, #{email}, #{phone}, #{address}, #{isAdmin}, #{isValidate}) ")
    Boolean insert(User record);

    @Override
    @Select("select * from user where id = #{id}")
    User selectByPrimaryKey(Integer id);

    @Override
    @Update("update onlinemallcake.user set username = #{username}, password = #{password}, name = #{name}, phone = #{phone}, address = #{address}, is_admin = #{isAdmin}, is_validate = #{isValidate} where id = #{id}")
    Boolean updateByPrimaryKey(User record);

    @Select("select * from onlinemallcake.user where username = #{username}")
    User selectByUsername(String username);

    @Select("select * from onlinemallcake.user where email = #{email}")
    User selectByEmail(String email);
}

