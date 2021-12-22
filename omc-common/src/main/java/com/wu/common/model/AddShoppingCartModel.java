package com.wu.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Haixin Wu
 * @date 2021/12/20 14:52
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddShoppingCartModel {
    /**
     * 用户id
     */
    private int userId;
    /**
     * 商品id
     */
    private int goodsId;
}

