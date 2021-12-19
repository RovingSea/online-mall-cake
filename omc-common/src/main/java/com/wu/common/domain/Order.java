package com.wu.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 订单实体类
 * @author Haixin Wu
 * @date 2021/12/16 0:16
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order implements Serializable {
    /**
     * 商品id
     */
    private int id;
    /**
     * 商品总额
     */
    private Float total;
    /**
     * 商品数量
     */
    private int amount;
    /**
     * 支付状态
     * <li>0代表未支付
     * <li>1代表已支付
     */
    private int status;
    /**
     * 支付类型
     */
    private int payType;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户电话
     */
    private String phone;
    /**
     * 用户地址
     */
    private String address;
    /**
     * 订单日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime datetime;
    /**
     * 用户id
     */
    private int userId;
}

