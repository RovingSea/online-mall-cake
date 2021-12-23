package com.wu.auth.controller.user;

import com.wu.common.base.BaseController;
import com.wu.common.domain.*;
import com.wu.common.exception.GenerateOrdersFailureException;
import com.wu.common.model.ChangeShoppingCartNumModel;
import com.wu.common.model.ShoppingCartViewModel;
import com.wu.common.model.SubmitOrderModel;
import com.wu.common.service.goods.GoodsService;
import com.wu.common.service.user.OrderItemService;
import com.wu.common.service.user.OrderService;
import com.wu.common.service.user.ShoppingCartService;
import com.wu.common.service.user.UserService;
import com.wu.common.utility.http.RestResponse;
import com.wu.common.utility.http.SystemCode;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Isolation;
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

    @PostMapping("/empty")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Integer> submitOrder(@RequestBody User user) throws Exception {
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCarts(user.getId());
        //形成订单
        int orderId = 0;
        Order order = new Order(user.getId());
        // mybatis将自增长后的id放至到作为参数的order中
        if (!orderService.insert(order)) {
            throw new GenerateOrdersFailureException();
        }
        orderId = orderService.getLastId();
        // 将购物车中的商品依次提交形成订单项
        for (ShoppingCart shoppingCart : shoppingCarts) {
            Goods goods = goodsService.selectById(shoppingCart.getGoodsId());
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setGoodsId(shoppingCart.getGoodsId());
            orderItem.setAmount(shoppingCart.getAmount());
            orderItem.setPrice(goods.getPrice());
            if (!orderItemService.insert(orderItem)) {
                throw new GenerateOrdersFailureException();
            }
        }
        // 把购物车表有关该用户的信息清空
        if (!shoppingCartService.deleteAllByUserId(user.getId())){
            throw new GenerateOrdersFailureException();
        }
        return RestResponse.ok(orderId);
    }

    @PostMapping("/mine")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<List<ShoppingCartViewModel>> mine(@RequestBody User user){
        return RestResponse.ok(shoppingCartService.getMine(user.getId()));
    }


    @PostMapping("/change")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> addGoods(@RequestBody ChangeShoppingCartNumModel model){
        return RestResponse.ok(shoppingCartService.changeNum(model.getId(), model.getChangeNum()));
    }

}

