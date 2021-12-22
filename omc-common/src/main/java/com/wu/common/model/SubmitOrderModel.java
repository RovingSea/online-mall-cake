package com.wu.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 提交订单模型
 * @author Haixin Wu
 * @date 2021/12/19 22:40
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubmitOrderModel implements Serializable {
    private int orderId;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 支付类型
     */
    private int payType;
    /**
     * 收件人姓名
     */
    private String name;
    /**
     * 收件人电话号码
     */
    private String phone;
    /**
     * 总额
     */
    private float total;
    /**
     * 买了多少东西
     */
    private int amount;
}

