package com.wu.auth.controller.user;

import com.wu.common.domain.User;
import com.wu.common.service.user.UserService;
import com.wu.common.utility.http.RestResponse;
import com.wu.common.utility.util.JsonUtil;
import com.wu.common.utility.util.TokenUtil;
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
@RequestMapping("omc/api/user")
@CrossOrigin
public class UserController {
    @DubboReference
    private UserService userService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    @Autowired
    public UserController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @GetMapping("/current")
    public RestResponse<User> getCurrent(@RequestHeader("authentication") String authentication){
        String username = TokenUtil.getUserInfoFromToken(authentication);
        return RestResponse.ok(userService.getByUsername(username));
    }

    @PostMapping("/update")
    public RestResponse<Boolean> update(User user){
        return RestResponse.ok(userService.updateById(user));
    }

}

