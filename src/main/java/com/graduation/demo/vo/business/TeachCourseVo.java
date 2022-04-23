package com.graduation.demo.vo.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.graduation.demo.entity.business.TeachCourse;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 授课管理联合实体
 *
 * @author 王奥
 * @since 2022-04-12
 */
public class TeachCourseVo extends TeachCourse implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "教师姓名", notes = "form teacher")
    private String TeacherName;

    @ApiModelProperty(value = "课程名称", notes = "form course")
    private String courseName;

    @ApiModelProperty(value = "学分", notes = "form course")
    private Float credit;

    @ApiModelProperty(value = "班级名称", notes = "form clazz")
    private String clazzName;

    @ApiModelProperty(value = "班级类别", notes = "form clazz")
    private String clazzType;

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

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getClazzType() {
        return clazzType;
    }

    public void setClazzType(String clazzType) {
        this.clazzType = clazzType;
    }

}
