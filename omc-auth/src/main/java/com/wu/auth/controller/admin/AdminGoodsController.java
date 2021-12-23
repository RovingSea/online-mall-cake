package com.wu.auth.controller.admin;

import com.wu.common.domain.Goods;
import com.wu.common.service.goods.GoodsService;
import com.wu.common.service.goods.RecommendService;
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
@RequestMapping("omc/api/admin/goods")
@CrossOrigin
public class AdminGoodsController {
    @DubboReference
    private GoodsService goodsService;
    @DubboReference
    private RecommendService recommendService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    @Autowired
    public AdminGoodsController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @PostMapping("/be/hot")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> beHot(@RequestBody Goods goods){
        if (recommendService.insertHot(goods.getId())){
            return RestResponse.ok(true);
        }
        return RestResponse.failure(false);
    }

    @PostMapping("/be/new")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> beNew(@RequestBody Goods goods){
        if (recommendService.insertNew(goods.getId())){
            return RestResponse.ok(true);
        }
        return RestResponse.failure(false);
    }

    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> add(@RequestBody Goods goods){
        if (goodsService.insert(goods)) {
            return RestResponse.ok(true);
        }
        return RestResponse.failure(false);
    }

    @PostMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> delete(@RequestBody Goods goods){
        if (goodsService.deleteById(goods.getId())) {
            return RestResponse.ok(true);
        }
        return RestResponse.failure(false);
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Boolean> update(@RequestBody Goods goods){
        if (goodsService.update(goods)) {
            return RestResponse.ok(true);
        }
        return RestResponse.failure(false);
    }
}

