package com.wu.common.utility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 工具类——书本，其中包含很多页码
 * <br>用于分页查询
 * @author Haixin Wu
 * @date 2021/12/21 17:12
 * @since 1.0
 */
public class Book<T> {
    /**
     * 总共有多少数据
     */
    private int dataSize;
    /**
     * 总共多少页
     */
    private int amount;
    /**
     * 总本书的数据
     */
    private List<Page<T>> data;
    /**
     * 某一页的数据
     */
    private Page<T> pageData;

    public Book(){

    }

    /**
     * 初始化某一页
     * @param whichPage 第几页
     * @param eachPageSize 该页有多少数据
     * @param databaseData 从数据库中得到的数据
     * @param dataSize 数据库中总共有多少数据
     */
    public Book(int whichPage, int eachPageSize, List<T> databaseData, int dataSize){
        int databaseDataSize = databaseData.size();
        setDataSize(dataSize);
        setAmount(eachPageSize / amount);
        setPageData(new Page<T>(whichPage, eachPageSize, databaseData));
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Page<T> getPageData() {
        return pageData;
    }

    public void setPageData(Page<T> pageData) {
        this.pageData = pageData;
    }


    private static class Page<T>{
        /**
         * 当前页
         */
        private int currentPage;
        /**
         * 每页多少数据
         */
        private int size;
        /**
         * 当前页数据
         */
        private List<T> data;

        public Page(int currentPage, int size, List<T> data) {
            this.currentPage = currentPage;
            this.size = size;
            this.data = data;
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
    }
}

