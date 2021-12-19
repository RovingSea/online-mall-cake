package com.wu.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页查询模型
 * @author Haixin Wu
 * @date 2021/12/19 13:24
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagingQueryModel {
    /**
     * 从第几个数据开始
     */
    private int from;
    /**
     * 每页大小
     */
    private int eachPageSize;
    /**
     * 总数
     */
    private int amount;
}

