package com.wu.user.service.impl;

import com.wu.common.base.BaseMapper;
import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.User;
import com.wu.user.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Haixin Wu
 * @date 2021/12/16
 * @time 13:27
 * @since 1.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        super(userMapper);
        this.userMapper = userMapper;
    }

    public boolean register(User user){
        return super.insert(user);
    }
}

