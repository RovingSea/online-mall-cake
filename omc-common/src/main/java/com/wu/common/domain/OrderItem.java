package com.wu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单项实体类
 * @author Haixin Wu
 * @date 2021/12/16 0:21
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {
    /**
     * 订单项id
     */
    private int id;
    /**
     * 商品价格
     */
    private Float price;
    /**
     * 商品数量
     */
    private int amount;
    /**
     * 商品id
     */
    private int goodsId;
    /**
     * 订单id
     */
    private int orderId;
}

