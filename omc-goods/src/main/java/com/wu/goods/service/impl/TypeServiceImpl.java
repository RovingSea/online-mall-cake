package com.wu.goods.service.impl;

import com.wu.common.base.BaseMapper;
import com.wu.common.base.BaseServiceImpl;
import com.wu.common.domain.Type;
import com.wu.common.service.goods.TypeService;
import com.wu.common.utility.annotation.ZkReadLock;
import com.wu.common.utility.annotation.ZkWriteLock;
import com.wu.goods.repository.TypeMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/20 21:09
 * @since 1.0
 */
@DubboService
@Service
public class TypeServiceImpl extends BaseServiceImpl<Type> implements TypeService {
    private final TypeMapper typeMapper;

    @Autowired
    public TypeServiceImpl(BaseMapper<Type> baseMapper, TypeMapper typeMapper) {
        super(baseMapper);
        this.typeMapper = typeMapper;
    }

    @Override
    @ZkReadLock
    //@Cacheable(cacheNames = GOODS, key = TYPE, unless = "#result == null", sync = true)
    public List<Type> selectAll() {
        return typeMapper.selectAll();
    }

    @Override
    @ZkWriteLock
    public Boolean deleteById(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    @ZkWriteLock
    public Boolean insert(Type record) {
        return typeMapper.insert(record);
    }

    @Override
    @ZkReadLock
    public Type selectById(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    @ZkWriteLock
    public Boolean update(Type record) {
        return typeMapper.updateByPrimaryKey(record);
    }
}

