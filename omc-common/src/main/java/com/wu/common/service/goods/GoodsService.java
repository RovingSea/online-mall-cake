package com.wu.common.service.goods;

import com.wu.common.base.BaseService;
import com.wu.common.domain.Goods;
import com.wu.common.utility.Page;

/**
 * @author Haixin Wu
 * @date 2021/12/16 19:32
 * @since 1.0
 */
public interface GoodsService extends BaseService<Goods> {
    /**
     * 模糊分页查询
     * @param goodsName 商品名
     * @param eachPageSize 每页大小
     * @param amount 总数
     * @return 整理好页码布局后的商品
     */
    Page<Goods> selectPageLikeByGoodsName(String goodsName, int eachPageSize, int amount);

    /**
     * 模糊分页查询
     * @param goodsName 商品名
     * @param eachPageSize 每页大小
     * @param amount 总数
     * @param from 整理好页码布局后的商品
     * @return 整理好页码布局后的商品
     */
    Page<Goods> selectPageLikeByGoodsName(String goodsName, int eachPageSize, int amount, int from);
    /**
     * 通过id删除商品
     * @param id {@link Goods} 类型的实体数据的主键id
     * @return 成功与否
     */
    @Override
    boolean deleteById(Integer id);

    /**
     * 新增商品
     * @param record {@link Goods} 类型的实体数据
     * @return 成功与否
     */
    @Override
    boolean insert(Goods record);

    /**
     * 通过id查询一个商品
     * @param id {@link Goods} 类型的实体数据的主键id
     * @return 成功与否
     */
    @Override
    Goods selectById(Integer id);

    /**
     * 更新商品信息
     * @param record {@link Goods} 类型的实体数据
     * @return
     */
    @Override
    boolean updateById(Goods record);

    /**
     * 分页查询商品
     * @param eachPageSize 每页大小
     * @param amount 总数
     * @return 整理好页码布局后的商品
     */
    Page<Goods> selectPage(int eachPageSize, int amount);

    /**
     * 从第几个数据开始分页查询
     * @param eachPageSize 每页大小
     * @param amount 总数
     * @param from 从第几个数据开始
     * @return 整理好页码布局后的商品
     */
    Page<Goods> selectPage(int eachPageSize, int amount, int from);
}

