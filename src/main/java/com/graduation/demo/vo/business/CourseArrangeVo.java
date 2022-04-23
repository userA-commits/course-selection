package com.graduation.demo.vo.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.graduation.demo.entity.business.CourseArrange;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Arrays;

public class CourseArrangeVo extends CourseArrange implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "教室名称", notes = "form classroom")
    private String classroomName;

    @ApiModelProperty(value = "教室类别，0为普通，1为特殊", notes = "form classroom")
    private Integer classroomType;

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

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public Integer getClassroomType() {
        return classroomType;
    }

    public void setClassroomType(Integer classroomType) {
        this.classroomType = classroomType;
    }

}
