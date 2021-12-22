package com.wu.auth.controller.user;

import com.wu.common.base.BaseController;
import com.wu.common.domain.Order;
import com.wu.common.domain.OrderItem;
import com.wu.common.domain.ShoppingCart;
import com.wu.common.domain.User;
import com.wu.common.exception.SubmitOrdersFailureException;
import com.wu.common.model.SubmitOrderModel;
import com.wu.common.service.user.OrderItemService;
import com.wu.common.service.user.OrderService;
import com.wu.common.service.user.ShoppingCartService;
import com.wu.common.utility.http.RestResponse;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.tomcat.jni.Local;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/20 0:14
 * @since 1.0
 */
@RestController
@RequestMapping("omc/api/user/order")
@CrossOrigin
public class UserOrderController extends BaseController {
    @DubboReference
    private ShoppingCartService shoppingCartService;
    @DubboReference
    private OrderItemService orderItemService;
    @DubboReference
    private OrderService orderService;

    @PostMapping("/submit")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<String> purchaseAll(@RequestBody SubmitOrderModel model){
        Order order = MODEL_MAPPER.map(model, Order.class);
        order.setStatus(1);
        order.setDatetime(LocalDateTime.now());
        if (!orderService.update(order)){
            throw new SubmitOrdersFailureException();
        }
        return RestResponse.ok("提交订单成功");
    }
}

