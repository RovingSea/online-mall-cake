package com.wu.common.service.goods;

import com.wu.common.base.BaseService;
import com.wu.common.domain.Type;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/20 21:05
 * @since 1.0
 */
public interface TypeService extends BaseService<Type> {
    /**
     * 查询所有商品类型
     * @return 所有商品类型
     */
    List<Type> selectAll();
}

