package com.wu.goods.service.impl;

import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.Goods;
import com.wu.common.service.goods.GoodsService;
import com.wu.goods.repository.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Haixin Wu
 * @date 2021/12/16
 * @time 19:32
 * @since 1.0
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {

    private final GoodsMapper goodsMapper;

    @Autowired
    public GoodsServiceImpl(GoodsMapper goodsMapper) {
        super(goodsMapper);
        this.goodsMapper = goodsMapper;
    }
}

