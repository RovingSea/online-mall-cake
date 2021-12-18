package com.wu.auth.config.security;

import com.wu.common.utility.http.SystemCode;
import com.wu.common.utility.util.RestUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录
 * @author Haixin Wu
 * @date 2021/12/17 22:52
 * @since 1.0
 */
@Component
public class RestLoginAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public RestLoginAuthenticationEntryPoint() {
        super("/omc/api/user/login");
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        RestUtil.response(response, SystemCode.UNAUTHORIZED);
    }
}

