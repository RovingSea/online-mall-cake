package com.wu.auth.controller.admin;

import com.wu.common.domain.Goods;
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
@RequestMapping("omc/api/admin/goods")
@CrossOrigin
public class GoodsController {
    @DubboReference
    private GoodsService goodsService;

    private final ThreadPoolTaskExecutor authApplicationExecutor;

    @Autowired
    public GoodsController(ThreadPoolTaskExecutor authApplicationExecutor) {
        this.authApplicationExecutor = authApplicationExecutor;
    }

    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<String> add(@RequestBody Goods goods){
        goodsService.insert(goods);
        return RestResponse.ok("添加成功");
    }

    @PostMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<String> delete(@RequestBody Goods goods){
        goodsService.deleteById(goods.getId());
        return RestResponse.ok("删除成功");
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<String> update(@RequestBody Goods goods){
        goodsService.update(goods);
        return RestResponse.ok("更新成功");
    }
}

