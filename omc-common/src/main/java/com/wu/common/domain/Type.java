package com.wu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品类型实体类
 * @author Haixin Wu
 * @date 2021/12/16 0:24
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Type implements Serializable {
    /**
     * 商品id
     */
    private int id;
    /**
     * 商品类型
     */
    private String name;
}

