package com.wu.user.service.impl;

import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.ShoppingCart;
import com.wu.common.service.user.ShoppingCartService;
import com.wu.user.repository.ShoppingCartMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Haixin Wu
 * @date 2021/12/18 22:16
 * @since 1.0
 */
@DubboService
public class ShoppingCartServiceImpl extends BaseServiceImpl<ShoppingCart> implements ShoppingCartService {

    private final ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartMapper shoppingCartMapper) {
        super(shoppingCartMapper);
        this.shoppingCartMapper = shoppingCartMapper;
    }


    @Override
    public boolean addGoods(int shoppingCartId) {
        return shoppingCartMapper.addAmountByPrimaryKey(shoppingCartId);
    }

    @Override
    public boolean addOrder(ShoppingCart shoppingCart) {
        return false;
    }
}

