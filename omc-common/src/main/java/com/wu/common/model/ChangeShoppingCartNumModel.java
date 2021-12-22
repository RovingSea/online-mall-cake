package com.wu.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Haixin Wu
 * @date 2021/12/23 0:25
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangeShoppingCartNumModel implements Serializable {
    private int id;
    private int changeNum;
}

