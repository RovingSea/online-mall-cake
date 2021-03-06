package com.wu.auth.controller.user;

import com.wu.common.domain.Goods;
import com.wu.common.model.AddShoppingCartModel;
import com.wu.common.service.goods.GoodsService;
import com.wu.common.utility.http.RestResponse;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author Haixin Wu
 * @date 2021/12/20 14:14
 * @since 1.0
 */
@RestController
@RequestMapping("omc/api/user/goods")
@CrossOrigin
public class UserGoodsController {
    @DubboReference
    private GoodsService goodsService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    @Autowired
    public UserGoodsController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @PostMapping("/get/info")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Goods> getInfo(@RequestBody Goods goods){
        return RestResponse.ok(goodsService.selectById(goods.getId()));
    }

    @PostMapping("/add/shoppingCart")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> addShoppingCart(@RequestBody AddShoppingCartModel model){
        return RestResponse.ok(goodsService.addShoppingCart(model.getUserId(), model.getGoodsId()));
    }
}

