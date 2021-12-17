package com.wu.auth.config.security;

import com.wu.common.utility.http.SystemCode;
import com.wu.common.utility.util.RestUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 账户或密码错误
 * @author Haixin Wu
 * @date 2021/12/17
 * @time 12:53
 * @since 1.0
 */
@Component
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        RestUtil.response(response, SystemCode.AuthError);
    }
}

