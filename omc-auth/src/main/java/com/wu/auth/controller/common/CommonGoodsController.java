package com.wu.auth.controller.common;

import com.wu.common.domain.Goods;
import com.wu.common.model.GoodsPagingQueryByNameModel;
import com.wu.common.model.GoodsPagingQueryByTypeModel;
import com.wu.common.model.GoodsViewModel;
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

    @PostMapping("/get")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<GoodsViewModel> getById(@RequestBody Goods goods){
        GoodsViewModel g = goodsService.selectModelById(goods.getId());
        return RestResponse.ok(g);
    }

    @PostMapping("/select/page/type")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Page<GoodsViewModel>> selectPageByType(@RequestBody GoodsPagingQueryByTypeModel model){
        Page<GoodsViewModel> goodsViewModelPages = goodsService.selectModelPageByType(model.getTypeId(), model.getEachPageSize(), model.getWhichPage());
        return RestResponse.ok(goodsViewModelPages);
    }

    @PostMapping("/fuzzy/get/page")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Page<GoodsViewModel>> selectPageLike(@RequestBody GoodsPagingQueryByNameModel model){
        Page<GoodsViewModel> goodsViewModelPages = goodsService.selectModelPageLikeByGoodsName(model.getName(), model.getEachPageSize(), model.getWhichPage());
        return RestResponse.ok(goodsViewModelPages);
    }

    @PostMapping("/select/page")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<Page<GoodsViewModel>> selectPage(@RequestBody PagingQueryModel model){
        Page<GoodsViewModel> goodsViewModelPages = goodsService.selectModelPage(model.getEachPageSize(), model.getWhichPage());
        return RestResponse.ok(goodsViewModelPages);
    }
}

