package com.graduation.demo.entity.base;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王奥
 * @since 2022-04-12
 */
@TableName("xk_course")
public class Course implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "课程编号")
    private String courseNo;

    @ApiModelProperty(value = "院系编号")
    private String deptNo;

    @ApiModelProperty(value = "课程名称")
    private String name;

    @ApiModelProperty(value = "学分")
    private Float credit;

    @ApiModelProperty(value = "需要教室类型，0为普通，1为特殊")
    private Integer classroomType;

    @ApiModelProperty(value = "课程类别，0选修，1必修")
    private Integer isRequired;

    @ApiModelProperty(value = "考核方式，0考核，1考试")
    private Integer testType;

    @ApiModelProperty(value = "描述")
    private String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Integer getClassroomType() {
        return classroomType;
    }

    public void setClassroomType(Integer classroomType) {
        this.classroomType = classroomType;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
        "id=" + id +
        ", courseNo=" + courseNo +
        ", deptNo=" + deptNo +
        ", name=" + name +
        ", credit=" + credit +
        ", classroomType=" + classroomType +
        ", isRequired=" + isRequired +
        ", testType=" + testType +
        ", description=" + description +
        "}";
    }
}
