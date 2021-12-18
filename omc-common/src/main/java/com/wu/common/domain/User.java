package com.wu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Haixin Wu
 * @date 2021/12/16 0:24
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    /**
     * 用户id
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户电话
     */
    private String phone;
    /**
     * 用户地址
     */
    private String address;
    /**
     * 是否为管理员
     */
    private boolean isAdmin;
    /**
     * 账户是否有效
     */
    private boolean isValidate;
}

