package com.wu.user.service.impl;

import com.wu.common.base.BaseMapper;
import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.User;
import com.wu.common.service.user.UserService;
import com.wu.common.utility.annotation.ZkReadLock;
import com.wu.common.utility.annotation.ZkWriteLock;
import com.wu.user.repository.UserMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Haixin Wu
 * @date 2021/12/16 13:27
 * @since 1.0
 */
@DubboService
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        super(userMapper);
        this.userMapper = userMapper;
    }

    @Override
    @ZkWriteLock
    public Boolean register(User record) {
        return super.insert(record);
    }

    @Override
    @ZkReadLock
    @Cacheable(value = USER_INFO, key = "#username", sync = true)
    public User getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    @ZkReadLock
    public User getByEmail(String email) {
        return userMapper.selectByEmail(email);
    }
}

