package com.wu.user.service.impl;

import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.ShoppingCart;
import com.wu.common.model.ShoppingCartViewModel;
import com.wu.common.service.user.ShoppingCartService;
import com.wu.common.utility.annotation.ZkReadLock;
import com.wu.common.utility.annotation.ZkWriteLock;
import com.wu.user.repository.ShoppingCartMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/18 22:16
 * @since 1.0
 */
@DubboService
@Service
public class ShoppingCartServiceImpl extends BaseServiceImpl<ShoppingCart> implements ShoppingCartService {

    private final ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartMapper shoppingCartMapper) {
        super(shoppingCartMapper);
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @Override
    @ZkWriteLock
    public Boolean deleteAllByUserId(int userId) {
        return shoppingCartMapper.deleteByUserId(userId);
    }

    @Override
    @ZkReadLock
    public List<ShoppingCart> getShoppingCarts(int userId) {
        return shoppingCartMapper.getShoppingCarts(userId);
    }

    @Override
    public List<ShoppingCartViewModel> getMine(int userId) {
        return shoppingCartMapper.selectMine(userId);
    }

    @Override
    public Boolean changeNum(int id, int num) {
        return shoppingCartMapper.changeNumByPrimaryKey(id, num);
    }

    @Override
    @ZkWriteLock
    public Boolean addGoods(int shoppingCartId) {
        return shoppingCartMapper.addAmountByPrimaryKey(shoppingCartId);
    }

}

