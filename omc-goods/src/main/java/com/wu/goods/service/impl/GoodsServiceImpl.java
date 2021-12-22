package com.wu.goods.service.impl;

import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.Goods;
import com.wu.common.model.GoodsViewModel;
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
@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {

    private final GoodsMapper goodsMapper;

    @Autowired
    public GoodsServiceImpl(GoodsMapper goodsMapper) {
        super(goodsMapper);
        this.goodsMapper = goodsMapper;
    }

    @Override
    public Page<GoodsViewModel> selectModelPageLikeByGoodsName(String goodsName, int eachPageSize) {
        return selectModelPageLikeByGoodsName(goodsName, eachPageSize, 1);
    }

    @Override
    @ZkReadLock
    public Page<GoodsViewModel> selectModelPageLikeByGoodsName(String goodsName, int eachPageSize, int whichPage) {
        List<GoodsViewModel> goodsViewModels = goodsMapper.selectModelPageLike(goodsName, (whichPage - 1) * eachPageSize, eachPageSize);
        return new Page<>(whichPage, eachPageSize, goodsViewModels, goodsMapper.selectAllSizeLike(goodsName));
    }

    @Override
    @ZkReadLock
    public GoodsViewModel selectModelById(Integer goodsId) {
        return goodsMapper.selectModelByPrimaryKey(goodsId);
    }

    @Override
    public Page<GoodsViewModel> selectModelPage(int eachPageSize) {
        return selectModelPage(eachPageSize, 1);
    }

    @Override
    @ZkReadLock
    public Page<GoodsViewModel> selectModelPage(int eachPageSize, int whichPage) {
        List<GoodsViewModel> goodsViewModels = goodsMapper.selectModelPage((whichPage - 1) * eachPageSize, eachPageSize);
        return new Page<>(whichPage, eachPageSize, goodsViewModels, goodsMapper.selectAllSize());
    }


    @Override
    @ZkReadLock
    public Page<Goods> selectPageByType(int typeId, int eachPageSize) {
        return selectPageByType(typeId, eachPageSize, 1);
    }

    @Override
    public Page<GoodsViewModel> selectModelPageByType(int typeId, int eachPageSize) {
        return selectModelPageByType(typeId, eachPageSize, 1);
    }

    @Override
    @ZkReadLock
    public Page<Goods> selectPageByType(int typeId, int eachPageSize, int whichPage) {
        List<Goods> goodsList = goodsMapper.selectPageByType(typeId, (whichPage - 1) * eachPageSize, eachPageSize);
        return new Page<>(whichPage, eachPageSize, goodsList, goodsMapper.selectAllSizeByTypeId(typeId));
    }

    @Override
    public Page<GoodsViewModel> selectModelPageByType(int typeId, int eachPageSize, int whichPage) {
        List<GoodsViewModel> goodsViewModels = goodsMapper.selectModelPageByType(typeId, (whichPage - 1) * eachPageSize, eachPageSize);
        return new Page<>(whichPage, eachPageSize, goodsViewModels, goodsMapper.selectAllSizeByTypeId(typeId));
    }

    @Override
    @ZkWriteLock
    public Boolean addShoppingCart(int userId, int goodsId) {
        return goodsMapper.insertToShoppingCart(userId, goodsId);
    }

    @Override
    @ZkWriteLock
    public Page<Goods> selectPageLikeByGoodsName(String goodsName, int eachPageSize) {
        return selectPageLikeByGoodsName(goodsName, eachPageSize, 1);
    }

    @Override
    @ZkWriteLock
    public Page<Goods> selectPageLikeByGoodsName(String goodsName, int eachPageSize, int whichPage) {
        List<Goods> goodsList = goodsMapper.selectPageLike(goodsName, (whichPage - 1) * eachPageSize, eachPageSize);
        return new Page<>(whichPage, eachPageSize, goodsList, goodsMapper.selectAllSizeLike(goodsName));
    }

    @Override
    @ZkWriteLock
    public Page<Goods> selectPage(int eachPageSize) {
        return selectPage(eachPageSize, 1);
    }

    @Override
    @ZkWriteLock
    public Page<Goods> selectPage(int eachPageSize, int whichPage) {
        List<Goods> goodsList = goodsMapper.selectPage((whichPage - 1) * eachPageSize, eachPageSize);
        return new Page<>(whichPage, eachPageSize, goodsList, goodsMapper.selectAllSize());
    }
}

