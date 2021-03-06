package com.wu.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分页查询模型
 * @author Haixin Wu
 * @date 2021/12/19 13:24
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodsPagingQueryByTypeModel implements Serializable {
    /**
     * 类型
     */
    private int typeId;
    /**
     * 从第几页开始查
     */
    private int whichPage;
    /**
     * 每页大小
     */
    private int eachPageSize;
    /**
     * 总数
     */
    private int amount;
}

