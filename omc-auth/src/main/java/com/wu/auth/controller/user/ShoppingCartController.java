package com.wu.auth.controller.user;

import com.wu.common.domain.ShoppingCart;
import com.wu.common.service.user.ShoppingCartService;
import com.wu.common.utility.http.RestResponse;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:02
 * @since 1.0
 */
@RestController
@RequestMapping("omc/api/user/shoppingCart")
@CrossOrigin
public class ShoppingCartController {
    @DubboReference
    private ShoppingCartService shoppingCartService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    public ShoppingCartController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @PostMapping("/plus/one")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> addGoods(int shoppingCartId){
        return RestResponse.ok(shoppingCartService.addGoods(shoppingCartId));
    }

    @PostMapping("add/order")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> addOrder(ShoppingCart shoppingCart){
        return RestResponse.ok(shoppingCartService.addOrder(shoppingCart));
    }

}

