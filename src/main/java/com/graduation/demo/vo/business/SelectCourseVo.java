package com.graduation.demo.vo.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SelectCourseVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "授课编号", notes = "form select course")
    private String teachCourseNo;

    @ApiModelProperty(value = "学生编号", notes = "form select course")
    private String studentNo;

    @ApiModelProperty(value = "学生姓名", notes = "form student")
    private String studentName;

    @ApiModelProperty(value = "课程编号", notes = "form teach course")
    private String courseNo;

    @ApiModelProperty(value = "课程名称", notes = "form course")
    private String courseName;

    @ApiModelProperty(value = "学分", notes = "form course")
    private Float credit;

    @ApiModelProperty(value = "修读学期", notes = "form select course")
    private Integer semester;

    @ApiModelProperty(value = "平时成绩", notes = "form select course")
    private Integer normalScore;

    @ApiModelProperty(value = "考试成绩", notes = "form select course")
    private Integer examScore;

    @ApiModelProperty(value = "总成绩", notes = "form select course")
    private Integer totalScore;

    @ApiModelProperty(value = "备注", notes = "form select course")
    private String remark;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeachCourseNo() {
        return teachCourseNo;
    }

    public void setTeachCourseNo(String teachCourseNo) {
        this.teachCourseNo = teachCourseNo;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getNormalScore() {
        return normalScore;
    }

    public void setNormalScore(Integer normalScore) {
        this.normalScore = normalScore;
    }

    public Integer getExamScore() {
        return examScore;
    }

    public void setExamScore(Integer examScore) {
        this.examScore = examScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SelectCourseVo{" +
                "id='" + id + '\'' +
                ", teachCourseNo='" + teachCourseNo + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credit=" + credit +
                ", semester=" + semester +
                ", normalScore=" + normalScore +
                ", examScore=" + examScore +
                ", totalScore=" + totalScore +
                ", remark='" + remark + '\'' +
                '}';
    }
}
