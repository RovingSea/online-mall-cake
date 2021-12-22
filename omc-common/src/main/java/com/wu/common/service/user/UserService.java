package com.wu.common.service.user;

import com.wu.common.base.BaseService;
import com.wu.common.domain.User;

/**
 * 用户相关的接口
 * @author Haixin Wu
 * @date 2021/12/16 13:26
 * @since 1.0
 */
public interface UserService extends BaseService<User> {
    /**
     * 注册
     * @param record {@link User}
     * @return 成功与否
     */
    Boolean register(User record);

    /**
     * 通过username查询
     * @param username 用户名
     * @return 这个用户
     */
    User getByUsername(String username);

    /**
     * 通过email查询
     * @param email 邮箱
     * @return 这个用户
     */
    User getByEmail(String email);
}

