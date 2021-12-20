package com.wu.goods.service.impl;

import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.Goods;
import com.wu.common.service.goods.GoodsService;
import com.wu.common.utility.Page;
import com.wu.goods.repository.GoodsMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/16 19:32
 * @since 1.0
 */
@DubboService
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {

    private final GoodsMapper goodsMapper;

    @Autowired
    public GoodsServiceImpl(GoodsMapper goodsMapper) {
        super(goodsMapper);
        this.goodsMapper = goodsMapper;
    }

    @Override
    public boolean addShoppingCart(int userId, int goodsId) {
        return goodsMapper.insertToShoppingCart(userId, goodsId);
    }

    @Override
    public Page<Goods> selectPageLikeByGoodsName(String goodsName, int eachPageSize, int amount) {
        return selectPageLikeByGoodsName(goodsName, eachPageSize, amount, 0);
    }

    @Override
    public Page<Goods> selectPageLikeByGoodsName(String goodsName, int eachPageSize, int amount, int from) {
        List<Goods> goodsList = goodsMapper.selectLikeLimit(goodsName, from, amount);
        return new Page<>(eachPageSize, amount, goodsList);
    }

    @Override
    public Page<Goods> selectPage(int eachPageSize, int amount) {
        return selectPage(eachPageSize, amount, 0);
    }

    @Override
    public Page<Goods> selectPage(int eachPageSize, int amount, int from) {
        List<Goods> goodsList = goodsMapper.selectLimit(from, amount);
        return new Page<>(eachPageSize, amount, goodsList);
    }
}

