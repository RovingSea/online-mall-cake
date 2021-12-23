package com.wu.common.base;

import com.wu.common.utility.annotation.ZkReadLock;
import com.wu.common.utility.annotation.ZkWriteLock;
import org.springframework.stereotype.Component;
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
    protected final String GOODS = "omc:goods";
    protected final String TYPE = "type";
    protected final String GOODS_PAGE = "omc:goods:page";
    protected final String GOODS_INFO = "omc:goods:info";
    protected final String USER_INFO = "omc:user:info";

    public BaseServiceImpl(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    @ZkWriteLock
    public Boolean deleteById(Integer id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    @ZkWriteLock
    public Boolean insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    @ZkReadLock
    public T selectById(Integer id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    @ZkReadLock
    public Boolean update(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }
}


