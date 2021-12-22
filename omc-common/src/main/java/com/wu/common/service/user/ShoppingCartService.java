package com.wu.common.service.user;

import com.wu.common.base.BaseService;
import com.wu.common.domain.ShoppingCart;
import com.wu.common.model.ShoppingCartViewModel;

import java.util.List;

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
    Boolean addGoods(int shoppingCartId);

    /**
     * 清空购物车
     * @param userId 用户id
     * @return 成功与否
     */
    Boolean deleteAllByUserId(int userId);

    /**
     * 打开购物车表信息
     * @param userId 用户id
     * @return 对应购物车表的信息
     */
    List<ShoppingCart> getShoppingCarts(int userId);

    /**
     * 打开购物车
     * @param userId 用户id
     * @return 购物车中的商品
     */
    List<ShoppingCartViewModel> getMine(int userId);

}

