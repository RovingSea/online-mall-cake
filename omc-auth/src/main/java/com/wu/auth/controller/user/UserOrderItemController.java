package com.wu.auth.controller.user;

import com.wu.common.base.BaseController;
import com.wu.common.domain.Order;
import com.wu.common.domain.OrderItem;
import com.wu.common.domain.User;
import com.wu.common.service.user.OrderItemService;
import com.wu.common.service.user.OrderService;
import com.wu.common.utility.http.RestResponse;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/20 0:13
 * @since 1.0
 */
@RestController
@RequestMapping("omc/api/user/orderItem")
@CrossOrigin
public class UserOrderItemController extends BaseController {
    @DubboReference
    private OrderItemService orderItemService;
    @DubboReference
    private OrderService orderService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    public UserOrderItemController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @PostMapping("/get/order/info")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Order> getOne(@RequestBody OrderItem orderItem){
        return RestResponse.ok(orderItemService.getOrderByOrderItemId(orderItem.getId()));
    }

    @PostMapping("/mine/paid")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<List<OrderItem>> minePaid(@RequestBody User user){
        List<OrderItem> paidOrders = orderItemService.getAllUnpaidOrdersByUserId(user.getId());
        return RestResponse.ok(paidOrders);
    }

    @PostMapping("/mine/unpaid")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<List<OrderItem>> mineUnpaid(@RequestBody User user){
        List<OrderItem> unpaidOrders = orderItemService.getAllUnpaidOrdersByUserId(user.getId());
        return RestResponse.ok(unpaidOrders);
    }

    @PostMapping("/mine")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<List<OrderItem>> mine(@RequestBody User user){
        return RestResponse.ok(orderItemService.getOrderItemsByUserId(user.getId()));
    }
}

