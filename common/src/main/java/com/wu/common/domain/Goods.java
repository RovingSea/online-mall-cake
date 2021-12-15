package com.wu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品实体类
 * @author Haixin Wu
 * @date 2021/12/16
 * @time 0:10
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Goods {
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
     * 商品类型
     */
    private int typeId;
}

