package com.wu.auth.controller.common;

import com.wu.common.domain.User;
import com.wu.common.service.goods.GoodsService;
import com.wu.common.service.user.UserService;
import com.wu.common.utility.http.RestResponse;
import com.wu.common.utility.http.SystemCode;
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
@RequestMapping("omc/api/common")
@CrossOrigin
public class CommonController {
    @DubboReference
    private UserService userService;
    @DubboReference
    private GoodsService goodsService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    @Autowired
    public CommonController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @GetMapping("/admin/login")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<String> adminLogin(@RequestHeader("authentication") String token){
        String username = TokenUtil.getUserInfoFromToken(token);
        User admin = userService.getByUsername(username);
        if (admin == null){
            return RestResponse.failure("用户不存在");
        } else {
            return RestResponse.ok(SystemCode.OK.getMessage());
        }
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

