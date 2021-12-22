package com.wu.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Haixin Wu
 * @date 2021/12/22 10:58
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartViewModel implements Serializable {
    private int goodsId;
    private int shoppingCartId;
    private String image1;
    private String goodsName;
    private float price;
    private int amount;
}

