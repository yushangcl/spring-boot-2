package com.whh.spring.boot.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 查询返回类基类
 *
 * @author huahui.wu
 * @date 2018/6/25 14:09
 * @description
 */
public class Pagination<T> implements Serializable {
    private int page;
    private int size;
    private long total;
    private List<T> list;

    /**
     * 当前页码
     *
     * @return
     */
    public int getPage() {
        return page;
    }

    /**
     * 当前页码
     *
     * @param page 当前页码
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 每页项数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 每页项数
     *
     * @param size 每页项数
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 总记录数
     *
     * @return
     */
    public long getTotal() {
        return total;
    }

    /**
     * 总记录数
     *
     * @param total 总记录数
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 当前页的记录list
     *
     * @return
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 当前页的记录list
     *
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    public Pagination() {

    }

    public Pagination(int page, int size, int total, List<T> list) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.list = list;
    }
}
