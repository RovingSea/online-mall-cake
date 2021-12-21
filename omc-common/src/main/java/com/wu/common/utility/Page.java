package com.wu.common.utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具类——页码，用于分页查询
 * @author Haixin Wu
 * @date 2021/12/19 0:46
 * @since 1.0
 */
public class Page<T> implements Serializable {
    /**
     * 总共有多少数据
     */
    private int databaseDataSize;
    /**
     * 总共多少页
     */
    private int totalPage;
    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 当前页有多少数据
     */
    private int size;
    /**
     * 当前页数据
     */
    private List<T> data;

    public Page(){

    }

    public Page(int whichPage, int eachPageSize, List<T> databaseData, int databaseDataSize){
        setDatabaseDataSize(databaseDataSize);
        setTotalPage((databaseData.size() / eachPageSize) + 1);
        setCurrentPage(whichPage);
        setSize(eachPageSize);
        data = new ArrayList<>(databaseData);
    }



    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getDatabaseDataSize() {
        return databaseDataSize;
    }

    public void setDatabaseDataSize(int databaseDataSize) {
        this.databaseDataSize = databaseDataSize;
    }
}

