package com.wu.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Haixin Wu
 * @date 2021/12/20 22:26
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagingQueryModel implements Serializable {
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

