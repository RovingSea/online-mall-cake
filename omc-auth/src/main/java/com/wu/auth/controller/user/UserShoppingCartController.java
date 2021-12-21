package com.wu.auth.controller.user;

import com.wu.common.base.BaseController;
import com.wu.common.domain.*;
import com.wu.common.model.SubmitOrderModel;
import com.wu.common.service.goods.GoodsService;
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
public class UserShoppingCartController extends BaseController {
    @DubboReference
    private UserService userService;
    @DubboReference
    private ShoppingCartService shoppingCartService;
    @DubboReference
    private OrderItemService orderItemService;
    @DubboReference
    private OrderService orderService;
    @DubboReference
    private GoodsService goodsService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    public UserShoppingCartController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @PostMapping("/empty/shoppingCart")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Integer> submitOrder(@RequestBody User user){
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCarts(user.getId());
        //形成订单
        Order order = new Order();
        order.init();
        int orderId = orderService.initOrderAndReturnId(order);
        // 将购物车中的商品依次提交形成订单项
        for (ShoppingCart shoppingCart : shoppingCarts) {
            Goods goods = goodsService.selectById(shoppingCart.getGoodsId());
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setGoodsId(shoppingCart.getGoodsId());
            orderItem.setAmount(shoppingCart.getAmount());
            orderItem.setPrice(goods.getPrice());
            orderItemService.insert(orderItem);
        }
        // 把购物车表有关该用户的信息清空
        boolean deleteSuccessfully = shoppingCartService.deleteAllByUserId(user.getId());
        if (deleteSuccessfully){
            return RestResponse.ok(orderId);
        } else {
            return RestResponse.failure(0);
        }
    }

    @PostMapping("/mine")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<List<ShoppingCart>> mine(@RequestBody User user){
        return RestResponse.ok(shoppingCartService.getShoppingCarts(user.getId()));
    }


    @PostMapping("/plus/one")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> addGoods(@RequestBody ShoppingCart shoppingCart){
        return RestResponse.ok(shoppingCartService.addGoods(shoppingCart.getId()));
    }

}

