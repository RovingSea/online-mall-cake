package com.wu.auth.config.security;

import com.wu.common.utility.http.SystemCode;
import com.wu.common.utility.util.RestUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 没有权限访问
 * @author Haixin Wu
 * @date 2021/12/17 14:18
 * @since 1.0
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        RestUtil.response(response, SystemCode.AccessDenied);
    }
}

