package com.wu.auth.config.security;

import com.wu.common.domain.enums.RoleEnum;
import com.wu.common.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author Haixin Wu
 * @date 2021/12/17
 * @time 17:13
 * @since 1.0
 */
@Component
public class RestAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;

    @Autowired
    public RestAuthenticationProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();

        com.wu.common.domain.User user = userService.getByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        String password = (String) authentication.getCredentials();
        if (!password.equals(user.getPassword())){
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(RoleEnum.getName(user.isAdmin())));

        User springUser = new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        return new UsernamePasswordAuthenticationToken(springUser, springUser.getPassword(), springUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}

