package com.wu.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 推荐栏实体类
 * @author Haixin Wu
 * @date 2021/12/16 0:23
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recommend {
    /**
     * 推荐栏id
     */
    private int id;
    /**
     * 商品类型
     */
    private int typeId;
    /**
     * 商品id
     */
    private int goodsId;
}

