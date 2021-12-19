package com.wu.common.service.user;

import com.wu.common.base.BaseService;
import com.wu.common.domain.ShoppingCart;

/**
 * @author Haixin Wu
 * @date 2021/12/18 22:17
 * @since 1.0
 */
public interface ShoppingCartService extends BaseService<ShoppingCart> {
    /**
     * 再来一单
     * @param shoppingCartId 购物车id
     * @return 成功与否
     */
    boolean addGoods(int shoppingCartId);

    /**
     * 清空购物车
     * @param userId 用户id
     * @return 成功与否
     */
    boolean purchaseAll(int userId);

}

