package com.whh.spring.boot.utils;

import java.io.Serializable;
import java.util.Map;

/**
 * 查询类基类
 *
 * @author huahui.wu
 * @date 2018/6/25 14:56
 * @description
 */
public class BaseQuery implements Serializable {

    private Integer page;
    private Integer size;
    private String sort;
    private String orderBy;
    private Map<String, Object> params;

    /**
     * 默认 页码 1
     */
    public int getPage() {
        int defaultPage = 1;
        return page == null ? defaultPage : page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 默认 页容量 10
     */
    public int getSize() {
        int defaultSize = 10;
        return size == null ? defaultSize : size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 返回 orderBy sort的拼接，如果要得到sort,请调用{@getPureSort()}
     *
     * @return String
     */
    public String getSort() {
        if (this.orderBy != null && this.orderBy.length() > 0) {
            return this.orderBy + " " + this.sort;
        } else {
            return this.sort;
        }
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     *
     * @return size
     */
    public Integer getLimit() {
        return size;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    /**
     * 设置pageNo,如果不能正确转为正型，则使用defaultValue
     *
     * @param pageNo       页码
     * @param defaultValue 默认值
     */
    public void setPage(String pageNo, int defaultValue) {
        try {
            this.page = Integer.valueOf(pageNo);
        } catch (NumberFormatException e) {
            this.page = defaultValue;
        }
    }

    /**
     * 设置pageSize,如果不能正确转为正型，则使用defaultValue
     *
     * @param pageSize     页面容量
     * @param defaultValue 默认值
     */
    public void setSize(String pageSize, int defaultValue) {
        try {
            this.size = Integer.valueOf(pageSize);
        } catch (NumberFormatException e) {
            this.size = defaultValue;
        }
    }

    public void setSort(String sort, String defaultValue) {
        if (sort != null && sort.length() > 0) {
            this.sort = sort;
        } else {
            this.sort = defaultValue;
        }
    }

    public void setOrderBy(String orderBy, String defaultValue) {
        if (orderBy != null && orderBy.length() > 0) {
            this.orderBy = orderBy;
        } else {
            this.orderBy = defaultValue;
        }
    }


    /**
     * 仅仅返回sort
     *
     * @return sort
     */
    public String getPureSort() {
        return this.sort;
    }

    public String getOrderClause() {
        StringBuilder strBuilder = new StringBuilder();
        if (this.orderBy != null && this.orderBy.length() > 0) {
            strBuilder.append(this.orderBy);

            //有order时才会添加sort
            if (this.sort != null && this.sort.length() > 0) {
                strBuilder.append(" ").append(this.sort);
            }
        }
        return strBuilder.toString();
    }

    public int getOffset() {
        int pageNo = getPage();
        int pageSize = getSize();

        return (pageNo - 1) * pageSize;
    }
}