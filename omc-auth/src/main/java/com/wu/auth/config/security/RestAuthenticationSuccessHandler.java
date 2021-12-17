package com.wu.auth.config.security;

import com.wu.common.service.user.UserService;
import com.wu.common.utility.http.SystemCode;
import com.wu.common.utility.util.RestUtil;
import com.wu.common.utility.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户登陆成功
 * @author Haixin Wu
 * @date 2021/12/17
 * @time 12:54
 * @since 1.0
 */
@Component
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Map<String, Object> MAP;
    static {
        MAP = new ConcurrentHashMap<>(1);
    }

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Object object = authentication.getPrincipal();
        if (object != null){
            User springUser = (User) object;
            com.wu.common.domain.User user = userService.selectByUsername(springUser.getUsername());
            if (user != null){
                String token = TokenUtil.createToken(springUser.getUsername());
                MAP.put("token", token);
                RestUtil.response(response, SystemCode.OK.getCode(), SystemCode.OK.getMessage(), MAP);
            }
        } else {
            RestUtil.response(response, SystemCode.UNAUTHORIZED.getCode(), SystemCode.UNAUTHORIZED.getMessage());
        }

    }
}

