package com.wu.auth.controller.user;

import com.wu.common.base.BaseController;
import com.wu.common.domain.Order;
import com.wu.common.domain.OrderItem;
import com.wu.common.domain.ShoppingCart;
import com.wu.common.model.SubmitOrderModel;
import com.wu.common.service.user.OrderItemService;
import com.wu.common.service.user.OrderService;
import com.wu.common.service.user.ShoppingCartService;
import com.wu.common.service.user.UserService;
import com.wu.common.utility.http.RestResponse;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/19 14:02
 * @since 1.0
 */
@RestController
@RequestMapping("omc/api/user/shoppingCart")
@CrossOrigin
public class ShoppingCartController extends BaseController {
    @DubboReference
    private UserService userService;
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

    @PostMapping("/mine")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<List<ShoppingCart>> mine(@RequestBody int userId){
        return RestResponse.ok(shoppingCartService.getShoppingCarts(userId));
    }

    @PostMapping("/submit/order")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> submitOrder(@RequestBody SubmitOrderModel model){
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCarts(model.getUserId());
        // 将购物车中的商品依次提交订单
        for (ShoppingCart shoppingCart : shoppingCarts) {
            Order order = MODEL_MAPPER.map(model, Order.class);
            order.setAmount(shoppingCart.getAmount());
            order.setGoodsId(shoppingCart.getGoodsId());
            order.setDatetime(LocalDateTime.now());
            orderService.insert(order);
        }
        // 把购物车表有关该用户的信息清空
        return RestResponse.ok(shoppingCartService.deleteAllByUserId(model.getUserId()));
    }

    @PostMapping("/purchase/all")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> purchaseAll(@RequestBody int userId){

        return null;
    }

    @PostMapping("/plus/one")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> addGoods(@RequestBody int shoppingCartId){
        return RestResponse.ok(shoppingCartService.addGoods(shoppingCartId));
    }

}

