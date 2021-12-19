package com.wu.auth.controller.user;

import com.wu.common.domain.ShoppingCart;
import com.wu.common.service.user.OrderItemService;
import com.wu.common.service.user.OrderService;
import com.wu.common.service.user.ShoppingCartService;
import com.wu.common.utility.http.RestResponse;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @DubboReference
    private OrderItemService orderItemService;
    @DubboReference
    private OrderService orderService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    public ShoppingCartController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @PostMapping("/purchase/all")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> purchaseAll(@RequestBody int userId){
        shoppingCartService.purchaseAll(userId);

    }

    @PostMapping("/plus/one")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> addGoods(@RequestBody int shoppingCartId){
        return RestResponse.ok(shoppingCartService.addGoods(shoppingCartId));
    }

    @PostMapping("add/order")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> addOrder(@RequestBody ShoppingCart shoppingCart){
        return RestResponse.ok(shoppingCartService.addOrder(shoppingCart));
    }

}

