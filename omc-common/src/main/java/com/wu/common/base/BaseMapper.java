package com.wu.common.base;

/**
 * 各模块Mapper的父类<br>
 * 为各个Mapper提供通用方法
 * @author Haixin Wu
 * @date 2021/12/16
 * @time 18:49
 * @since 1.0
 */
public interface BaseMapper<T> {
    /**
     * 通过主键删除 T 类型的实体数据
     * @param id T 类型的实体数据的主键id
     * @return 成功与否
     */
    boolean deleteByPrimaryKey(Integer id);
    /**
     * 向数据库中增加 T 类型的实体数据
     * @param record T 类型的实体数据
     * @return 成功与否
     */
    boolean insert(T record);
    /**
     * 通过 T 类型的实体数据的主键id 查询数据
     * @param id T 类型的实体数据的主键id
     * @return 主键为id的 T 类型的实体数据
     */
    T selectByPrimaryKey(Integer id);
    /**
     * 向数据库中更新 T 类型的实体数据
     * @param record T 类型的实体数据
     * @return 成功与否
     */
    boolean updateByPrimaryKey(T record);
}

