package com.wu.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Haixin Wu
 * @date 2021/12/22 22:31
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodsViewModel {

    /**
     * 商品id
     */
    private int id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品详情图1
     */
    private String image1;
    /**
     * 商品详情图2
     */
    private String image2;
    /**
     * 商品价格
     */
    private Float price;
    /**
     * 商品描述
     */
    private String intro;
    /**
     * 商品库存
     */
    private int stock;
    /**
     * 商品类型名称
     */
    private int typeName;
}

