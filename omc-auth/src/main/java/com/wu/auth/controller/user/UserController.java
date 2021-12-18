package com.wu.auth.controller.user;

import com.wu.common.domain.User;
import com.wu.common.service.user.UserService;
import com.wu.common.utility.http.RestResponse;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author Haixin Wu
 * @date 2021/12/18 14:56
 * @since 1.0
 */
@RestController
@RequestMapping("moc/api/user")
@CrossOrigin
public class UserController {
    @DubboReference
    private UserService userService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    @Autowired
    public UserController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @PostMapping("/register")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<String> register(@RequestBody User user){
        if (userService.getByUsername(user.getUsername()) != null){
            return RestResponse.failure("该用户名已被注册");
        }
        if (userService.getByEmail(user.getEmail()) != null){
            return RestResponse.failure("该邮箱已被注册");
        }
        userService.register(user);
        return RestResponse.ok("注册成功");
    }
}

