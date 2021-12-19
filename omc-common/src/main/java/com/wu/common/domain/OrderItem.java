package com.wu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单项实体类<br>
 * 订单项和订单的区别就是，订单项是订单提交后（即购买）后才有的
 * @author Haixin Wu
 * @date 2021/12/16 0:21
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem implements Serializable {
    public OrderItem(Order order){
        setPrice(order.getTotal() / order.getAmount());
        setAmount(order.getAmount());
        setGoodsId(order.getGoodsId());
        setOrderId(order.getId());
    }
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

