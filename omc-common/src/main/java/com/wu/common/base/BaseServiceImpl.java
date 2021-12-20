package com.wu.common.base;

import com.wu.common.utility.annotation.ZkReadLock;
import com.wu.common.utility.annotation.ZkWriteLock;
import org.springframework.stereotype.Service;

/**
 * 各模块ServiceImpl的父类<br>
 * 为各个ServiceImpl提供切面业务会用到的属性
 * @author Haixin Wu
 * @date 2021/12/16 19:59
 * @since 1.0
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{

    private final BaseMapper<T> baseMapper;

    public BaseServiceImpl(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    @ZkWriteLock
    public boolean deleteById(Integer id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    @ZkWriteLock
    public boolean insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    @ZkReadLock
    public T selectById(Integer id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    @ZkReadLock
    public boolean update(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }
}

