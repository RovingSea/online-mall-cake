package com.wu.common.service.user;

import com.wu.common.domain.User;

/**
 * 用户相关的接口
 * @author Haixin Wu
 * @date 2021/12/16 13:26
 * @since 1.0
 */
public interface UserService {
    boolean register(User record);

    boolean login();

    User getByUsername(String username);
}

