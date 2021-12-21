package com.wu.auth.controller.common;

import com.wu.common.domain.Goods;
import com.wu.common.model.GoodsPagingQueryByNameModel;
import com.wu.common.model.GoodsPagingQueryByTypeModel;
import com.wu.common.model.PagingQueryModel;
import com.wu.common.service.goods.GoodsService;
import com.wu.common.utility.Page;
import com.wu.common.utility.http.RestResponse;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author Haixin Wu
 * @date 2021/12/20 20:39
 * @since 1.0
 */
@RestController
@RequestMapping("omc/api/common/goods")
@CrossOrigin
public class CommonGoodsController {

    @DubboReference
    private GoodsService goodsService;

    @PostMapping("/select/page/type")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Page<Goods>> selectPageByType(@RequestBody GoodsPagingQueryByTypeModel model){
        Page<Goods> goodsPage = goodsService.selectPageByType(model.getTypeId(), model.getEachPageSize(), model.getAmount(), model.getFrom());
        return RestResponse.ok(goodsPage);
    }

    @PostMapping("/fuzzy/get/page")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Page<Goods>> selectPageLike(@RequestBody GoodsPagingQueryByNameModel model){
        Page<Goods> goodsPage = goodsService.selectPageLikeByGoodsName(model.getName(), model.getEachPageSize(), model.getAmount());
        return RestResponse.ok(goodsPage);
    }

    @PostMapping("/select/page")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Page<Goods>> selectPage(@RequestBody PagingQueryModel model){
        Page<Goods> goodsPage = goodsService.selectPage(model.getEachPageSize(), model.getAmount(), model.getFrom());
        return RestResponse.ok(goodsPage);
    }
}

