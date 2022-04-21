package com.graduation.demo.vo.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 教学计划联合实体
 *
 * @author 王奥
 * @since 2022-04-12
 */
public class CoursePlanVo implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "教学计划主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "院系编号", notes = "form course plan")
    private String deptNo;

    @ApiModelProperty(value = "院系名称", notes = "form dept")
    private String deptName;

    @ApiModelProperty(value = "专业编号", notes = "form course plan")
    private String majorNo;

    @ApiModelProperty(value = "专业名称", notes = "form major")
    private String majorName;

    @ApiModelProperty(value = "年级", notes = "form course plan")
    private String grade;

    @ApiModelProperty(value = "课程编号", notes = "form course plan")
    private String courseNo;

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

    @ApiModelProperty(value = "备注", notes = "form course plan")
    private String remark;

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getMajorNo() {
        return majorNo;
    }

    public void setMajorNo(String majorNo) {
        this.majorNo = majorNo;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MajorWithCourse{" +
                "deptNo='" + deptNo + '\'' +
                ", deptName='" + deptName + '\'' +
                ", majorNo='" + majorNo + '\'' +
                ", majorName='" + majorName + '\'' +
                ", grade='" + grade + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credit=" + credit +
                ", isRequired=" + isRequired +
                ", testType='" + testType + '\'' +
                ", semester=" + semester +
                ", remark='" + remark + '\'' +
                '}';
    }
}
