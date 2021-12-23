package com.wu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 推荐栏实体类
 * @author Haixin Wu
 * @date 2021/12/16 0:23
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recommend implements Serializable {
    /**
     * 推荐栏id
     */
    private int id;
    /**
     * 推荐类型
     */
    private String type;
    /**
     * 商品id
     */
    private int goodsId;
}

