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
public class OrderItemController extends BaseController {
    @DubboReference
    private OrderItemService orderItemService;
    @DubboReference
    private OrderService orderService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    public OrderItemController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @PostMapping("/mine")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<List<OrderItem>> mine(@RequestBody User user){
        return RestResponse.ok(orderItemService.getOrderItemsByUserId(user.getId()));
    }
}

