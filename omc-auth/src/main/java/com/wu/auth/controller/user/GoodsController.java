package com.wu.auth.controller.user;

import com.wu.common.domain.Goods;
import com.wu.common.model.PagingQueryModel;
import com.wu.common.service.goods.GoodsService;
import com.wu.common.utility.Page;
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
public class GoodsController {
    @DubboReference
    private GoodsService goodsService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    @Autowired
    public GoodsController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @PostMapping("/fuzzy/get/page")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Page<Goods>> selectPageLike(@RequestBody PagingQueryModel model){
        Page<Goods> goodsPage = goodsService.selectPageLikeByGoodsName(model.getGoodsName(), model.getEachPageSize(), model.getAmount(), model.getFrom());
        return RestResponse.ok(goodsPage);
    }

    @PostMapping("/select/one")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Goods> selectOne(@RequestBody Goods goods){
        return RestResponse.ok(goodsService.selectById(goods.getId()));
    }

    @PostMapping("/select/page")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Page<Goods>> selectPage(@RequestBody PagingQueryModel model){
        Page<Goods> goodsPage = goodsService.selectPage(model.getEachPageSize(), model.getAmount(), model.getFrom());
        return RestResponse.ok(goodsPage);
    }
}

