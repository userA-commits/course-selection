package com.graduation.demo.vo.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.graduation.demo.entity.business.CoursePlan;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 教学计划联合实体
 *
 * @author 王奥
 * @since 2022-04-12
 */
public class CoursePlanVo extends CoursePlan implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "院系名称", notes = "form dept")
    private String deptName;

    @ApiModelProperty(value = "专业名称", notes = "form major")
    private String majorName;

    @ApiModelProperty(value = "课程名称", notes = "form course")
    private String courseName;

    @ApiModelProperty(value = "学分", notes = "form course")
    private Float credit;

    @ApiModelProperty(value = "课程类别，0必修，1选修", notes = "form course")
    private Integer isRequired;

    @ApiModelProperty(value = "考核方式", notes = "form course")
    private String testType;

    @ApiModelProperty(value = "建议修读学期", notes = "form course")
    private Integer semester;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
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

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

}
