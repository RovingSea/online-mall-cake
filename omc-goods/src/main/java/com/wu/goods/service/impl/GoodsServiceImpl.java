package com.wu.goods.service.impl;

import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.Goods;
import com.wu.common.service.goods.GoodsService;
import com.wu.common.utility.Page;
import com.wu.common.utility.annotation.ZkReadLock;
import com.wu.common.utility.annotation.ZkWriteLock;
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
    @ZkReadLock
    public Page<Goods> selectPageByType(int typeId, int eachPageSize, int amount) {
        return selectPageByType(typeId, eachPageSize, amount, 0);
    }

    @Override
    @ZkReadLock
    public Page<Goods> selectPageByType(int typeId, int eachPageSize, int amount, int from) {
        List<Goods> goodsList = goodsMapper.selectPageByType(typeId, amount, from);
        return new Page<>(eachPageSize, amount, goodsList);
    }

    @Override
    @ZkWriteLock
    public boolean addShoppingCart(int userId, int goodsId) {
        return goodsMapper.insertToShoppingCart(userId, goodsId);
    }

    @Override
    @ZkWriteLock
    public Page<Goods> selectPageLikeByGoodsName(String goodsName, int eachPageSize, int amount) {
        return selectPageLikeByGoodsName(goodsName, eachPageSize, amount, 0);
    }

    @Override
    @ZkWriteLock
    public Page<Goods> selectPageLikeByGoodsName(String goodsName, int eachPageSize, int amount, int from) {
        List<Goods> goodsList = goodsMapper.selectLikeLimit(goodsName, amount, from);
        return new Page<>(eachPageSize, amount, goodsList);
    }

    @Override
    @ZkWriteLock
    public Page<Goods> selectPage(int eachPageSize, int amount) {
        return selectPage(eachPageSize, amount, 0);
    }

    @Override
    @ZkWriteLock
    public Page<Goods> selectPage(int eachPageSize, int amount, int from) {
        List<Goods> goodsList = goodsMapper.selectLimit(amount, from);
        return new Page<>(eachPageSize, amount, goodsList);
    }
}

