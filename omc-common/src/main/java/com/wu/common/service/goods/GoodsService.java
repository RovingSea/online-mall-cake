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
     * 根据商品类型分页查询
     * @param typeId 商品类型
     * @param eachPageSize 每页大小
     * @return 整理好页码布局后的商品
     */
    Page<Goods> selectPageByType(int typeId, int eachPageSize);

    /**
     * 根据商品类型分页查询
     * @param typeId 商品类型
     * @param eachPageSize 每页大小
     * @param whichPage 从第几页开始查
     * @return
     */
    Page<Goods> selectPageByType(int typeId, int eachPageSize, int whichPage);
    /**
     * 将商品加入购物车
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 成功与否
     */
    Boolean addShoppingCart(int userId, int goodsId);
    /**
     * 根据商品名模糊分页查询
     * @param goodsName 商品名
     * @param eachPageSize 每页大小
     * @return 整理好页码布局后的商品
     */
    Page<Goods> selectPageLikeByGoodsName(String goodsName, int eachPageSize);

    /**
     * 根据商品名模糊分页查询
     * @param goodsName 商品名
     * @param eachPageSize 每页大小
     * @param whichPage 从第几页开始查
     * @return 整理好页码布局后的商品
     */
    Page<Goods> selectPageLikeByGoodsName(String goodsName, int eachPageSize, int whichPage);
    /**
     * 通过id删除商品
     * @param id {@link Goods} 类型的实体数据的主键id
     * @return 成功与否
     */
    @Override
    Boolean deleteById(Integer id);

    /**
     * 新增商品
     * @param record {@link Goods} 类型的实体数据
     * @return 成功与否
     */
    @Override
    Boolean insert(Goods record);

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
    Boolean update(Goods record);

    /**
     * 分页查询商品
     * @param eachPageSize 每页大小
     * @return 整理好页码布局后的商品
     */
    Page<Goods> selectPage(int eachPageSize);

    /**
     * 从第几页开始分页查询
     * @param eachPageSize 每页大小
     * @param whichPage 从第几个数据开始
     * @return 整理好页码布局后的商品
     */
    Page<Goods> selectPage(int eachPageSize, int whichPage);
}

