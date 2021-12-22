package com.wu.auth.config.security;

import com.wu.common.domain.enums.RoleEnum;
import com.wu.common.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 登录过程
 * @author Haixin Wu
 * @date 2021/12/17 21:52
 * @since 1.0
 */
@Component
@Slf4j
public class AuthenticationHandler implements UserDetailsService {

    @DubboReference
    private UserService userService;

    private final PasswordEncoder pw;

    @Autowired
    public AuthenticationHandler(PasswordEncoder pw) {
        this.pw = pw;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.wu.common.domain.User user = userService.getByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("username is null");
        }
        log.info("用户[{}]发送了登录请求", username);

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(RoleEnum.getName(user.getIsAdmin())));

        return new User(user.getUsername(), pw.encode(user.getPassword()), grantedAuthorities);
    }
}

