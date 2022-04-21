package com.graduation.demo.vo.base;

import com.graduation.demo.entity.Classroom;

public class ClassroomVo extends Classroom {

    private static final long serialVersionUID=1L;

    private Integer page = 1;
    private Integer limit = 10;

    private String[] ids;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

}
