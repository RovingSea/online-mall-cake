package com.wu.goods.service.impl;

import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.Recommend;
import com.wu.common.model.RecommendViewModel;
import com.wu.common.service.goods.RecommendService;
import com.wu.goods.repository.RecommendMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/23 16:41
 * @since 1.0
 */
@DubboService
@Service
public class RecommendServiceImpl extends BaseServiceImpl<Recommend> implements RecommendService {
    private final RecommendMapper recommendMapper;

    @Autowired
    public RecommendServiceImpl(RecommendMapper recommendMapper) {
        super(recommendMapper);
        this.recommendMapper = recommendMapper;
    }

    @Override
    public List<RecommendViewModel> selectHotModel() {
        return recommendMapper.selectHotModel();
    }

    @Override
    public List<RecommendViewModel> selectNewModel() {
        return recommendMapper.selectNewModel();
    }

    @Override
    public List<RecommendViewModel> selectAllModel() {
        return recommendMapper.selectAllModel();
    }

    @Override
    public Boolean insertHot(Integer id) {
        return recommendMapper.insertHot(id);
    }

    @Override
    public Boolean insertNew(Integer id) {
        return recommendMapper.insertNew(id);
    }
}

