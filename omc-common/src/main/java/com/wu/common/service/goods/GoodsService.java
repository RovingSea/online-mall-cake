package com.wu.common.service.goods;

import com.wu.common.base.BaseService;
import com.wu.common.domain.Goods;

/**
 * @author Haixin Wu
 * @date 2021/12/16
 * @time 19:32
 * @since 1.0
 */
public interface GoodsService extends BaseService<Goods> {
    @Override
    boolean deleteById(Integer id);

    @Override
    boolean insert(Goods record);

    @Override
    Goods selectById(Integer id);

    @Override
    boolean updateById(Goods record);
}

