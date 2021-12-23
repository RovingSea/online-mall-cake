package com.wu.common.service.goods;

import com.wu.common.base.BaseService;
import com.wu.common.domain.Recommend;
import com.wu.common.model.RecommendViewModel;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/23 16:39
 * @since 1.0
 */
public interface RecommendService extends BaseService<Recommend> {
    /**
     * 返回所有的热销商品
     * @return 所有热销商品
     */
    List<RecommendViewModel> selectHotModel();

    /**
     * 返回所有的新品
     * @return 所有的新品
     */
    List<RecommendViewModel> selectNewModel();
    /**
     * 返回所有推荐商品
     * @return 所有推荐商品
     */
    List<RecommendViewModel> selectAllModel();

    /**
     * 插入一个热销商品
     * @param id 商品id
     * @return 成功与否
     */
    Boolean insertHot(Integer id);

    /**
     * 插入一个新品商品
     * @param id 商品id
     * @return 成功与否
     */
    Boolean insertNew(Integer id);
}

