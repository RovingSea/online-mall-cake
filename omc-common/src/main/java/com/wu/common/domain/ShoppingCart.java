package com.wu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Haixin Wu
 * @date 2021/12/18 22:12
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCart implements Serializable {
    /**
     * 购物车id
     */
    private int id;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 商品id
     */
    private int goodsId;
    /**
     * 购物车中某个商品的数量
     */
    private int amount;
}

