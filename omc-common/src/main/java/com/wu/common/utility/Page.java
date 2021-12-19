package com.wu.common.utility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/19 0:46
 * @since 1.0
 */
public class Page<T> {
    private List<List<T>> layout;
    private int pageSize;
    private int eachPageSize;
    private int amount;
    /**
     * 初始化构造方法<br>
     * 建议总数 % 每页大小 = 0
     * @param eachPageSize 每页大小
     * @param amount 总数
     * @param databaseData 数据库中的数据
     */
    public Page(int eachPageSize, int amount, List<T> databaseData){
        init(eachPageSize, amount);
        convert(databaseData);
    }

    private void convert(List<T> databaseData){
        int s = 0;
        for (int i = 0; i < pageSize; ++i) {
            for (int j = 0; j < eachPageSize; ++j) {
                layout.get(j).add(databaseData.get(s));
                ++s;
            }
        }
    }

    private void init(int eachPageSize, int amount) {
        setPageSize(amount / eachPageSize);
        setEachPageSize(eachPageSize);
        setAmount(amount);
        layout = new ArrayList<>(pageSize);
        for (int i = 0; i < pageSize; ++i) {
            layout.set(i, new ArrayList<>(eachPageSize));
        }
    }


    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setEachPageSize(int eachPageSize) {
        this.eachPageSize = eachPageSize;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<List<T>> getLayout() {
        return layout;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getEachPageSize() {
        return eachPageSize;
    }

    public int getAmount() {
        return amount;
    }
}
