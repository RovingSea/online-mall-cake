package com.wu.auth.config.security;

import com.wu.common.service.user.UserService;
import com.wu.common.utility.annotation.ZkWriteLock;
import com.wu.common.utility.http.SystemCode;
import com.wu.common.utility.util.RedisUtil;
import com.wu.common.utility.util.RestUtil;
import com.wu.common.utility.util.TokenUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 用户登陆成功
 * @author Haixin Wu
 * @date 2021/12/17 12:54
 * @since 1.0
 */
@Component

public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @DubboReference
    private UserService userService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;
    private final RedisUtil redisUtil;
    private final static String USER_TOKEN = "omc-user-token-";

    private static final Map<String, Object> MAP;
    static {
        MAP = new ConcurrentHashMap<>(1);
    }

    @Autowired
    public RestAuthenticationSuccessHandler(ThreadPoolTaskExecutor authApplicationExecutor, RedisUtil redisUtil) {
        this.authApplicationExecutor = authApplicationExecutor;
        this.redisUtil = redisUtil;
    }

    @Override
    @ZkWriteLock
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Object object = authentication.getPrincipal();
        if (object != null){
            User springUser = (User) object;
            com.wu.common.domain.User user = userService.getByUsername(springUser.getUsername());
            if (user != null){
                String token = TokenUtil.createToken(springUser.getUsername());
                // 异步将token放入redis存放
                CompletableFuture<Void> setTokenOnRedis = CompletableFuture.runAsync(() ->
                        redisUtil.set(USER_TOKEN+user.getUsername(), token, 2, TimeUnit.HOURS), authApplicationExecutor);
                MAP.put("token", token);
                CompletableFuture.allOf(setTokenOnRedis);
                RestUtil.response(response, SystemCode.OK.getCode(), SystemCode.OK.getMessage(), MAP);
            }
        } else {
            RestUtil.response(response, SystemCode.UNAUTHORIZED.getCode(), SystemCode.UNAUTHORIZED.getMessage());
        }
    }
}

