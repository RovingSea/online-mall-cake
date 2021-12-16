package com.wu.common.base;

/**
 * @author Haixin Wu
 * @date 2021/12/16
 * @time 19:59
 * @since 1.0
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{

    private final BaseMapper<T> baseMapper;

    public BaseServiceImpl(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public boolean deleteById(Integer id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public T selectById(Integer id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateById(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }
}

