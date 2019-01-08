package com.hjljy.blog.common;

import java.io.Serializable;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/27 0027 18:31
 * @Description: 分页对象，用于接受前端传过来的分页信息
 */
public class PageData implements Serializable {
    private static final long serialVersionUID = 1L;
    private int limit = 10;
    private int page = 1;

    private String orderBy ="create_time desc";

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getLimit() {
        return limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
