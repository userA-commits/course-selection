package com.graduation.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 课程编号
     */
    private String courseNo;

    /**
     * 院系编号
     */
    private String deptNo;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 学分
     */
    private Float cridit;

    /**
     * 课程类别
     */
    private Integer type;

    /**
     * 考核方式
     */
    private String testType;

    /**
     * 描述
     */
    private String desc;


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

    public Float getCridit() {
        return cridit;
    }

    public void setCridit(Float cridit) {
        this.cridit = cridit;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Course{" +
        "id=" + id +
        ", courseNo=" + courseNo +
        ", deptNo=" + deptNo +
        ", name=" + name +
        ", cridit=" + cridit +
        ", type=" + type +
        ", testType=" + testType +
        ", desc=" + desc +
        "}";
    }
}
