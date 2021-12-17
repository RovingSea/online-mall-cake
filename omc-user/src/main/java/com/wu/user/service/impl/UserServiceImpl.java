package com.wu.user.service.impl;

import com.wu.common.base.BaseMapper;
import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.User;
import com.wu.common.service.user.UserService;
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
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        super(userMapper);
        this.userMapper = userMapper;
    }

    @Override
    public boolean register(User record) {
        return super.insert(record);
    }

    @Override
    public boolean login() {
        return false;
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}

