package com.wu.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Haixin Wu
 * @date 2021/12/23 16:23
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecommendViewModel implements Serializable {
    /**
     * 推荐品id
     */
    private int id;
    /**
     * 推荐类型
     */
    private String recommendType;
    /**
     * 推荐商品的id
     */
    private int goodsId;
    /**
     * 推荐商品名
     */
    private String goodsName;
    /**
     * 推荐品图片
     */
    private String image1;
    /**
     * 推荐品价格
     */
    private float price;
    /**
     * 推荐品是什么类型，面包、冰淇淋···
     */
    private String typeName;
}

