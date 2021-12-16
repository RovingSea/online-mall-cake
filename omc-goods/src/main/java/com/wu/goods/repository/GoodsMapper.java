package com.wu.goods.repository;

import com.wu.common.base.BaseMapper;
import com.wu.common.domain.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Haixin Wu
 * @date 2021/12/16
 * @time 19:09
 * @since 1.0
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Override
    boolean deleteByPrimaryKey(Integer id);

    @Override
    boolean insert(Goods record);

    @Override
    Goods selectByPrimaryKey(Integer id);

    @Override
    boolean updateByPrimaryKey(Goods record);
}

