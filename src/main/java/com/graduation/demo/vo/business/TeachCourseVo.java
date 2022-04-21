package com.graduation.demo.vo.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 授课管理联合实体
 *
 * @author 王奥
 * @since 2022-04-12
 */
public class TeachCourseVo  implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "授课编号", notes = "form teach course")
    private String teachCourseNo;

    @ApiModelProperty(value = "教师编号", notes = "form teach course")
    private String teacherNo;

    @ApiModelProperty(value = "教师姓名", notes = "form teacher")
    private String TeacherName;

    @ApiModelProperty(value = "课程编号", notes = "form teach course")
    private String courseNo;

    @ApiModelProperty(value = "状态，0代表正使用，1代表已结束", notes = "form teach course")
    private int state;

    @ApiModelProperty(value = "课程名称", notes = "form course")
    private String courseName;

    @ApiModelProperty(value = "学分", notes = "form course")
    private Float credit;

    @ApiModelProperty(value = "学生人数", notes = "form teach course")
    private int studentNum;

    @ApiModelProperty(value = "学生人数上限", notes = "form teach course")
    private int upperNum;

    @ApiModelProperty(value = "班级编号", notes = "form teach course")
    private String clazzNo;

    @ApiModelProperty(value = "班级名称", notes = "form clazz")
    private String clazzName;

    @ApiModelProperty(value = "班级类别", notes = "form clazz")
    private String clazzType;

    @ApiModelProperty(value = "备注", notes = "form teach course")
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

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public int getUpperNum() {
        return upperNum;
    }

    public void setUpperNum(int upperNum) {
        this.upperNum = upperNum;
    }

    public String getClazzNo() {
        return clazzNo;
    }

    public void setClazzNo(String clazzNo) {
        this.clazzNo = clazzNo;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TeachCourseVo{" +
                "id='" + id + '\'' +
                ", teachCourseNo='" + teachCourseNo + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", TeacherName='" + TeacherName + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", state=" + state +
                ", courseName='" + courseName + '\'' +
                ", credit=" + credit +
                ", studentNum=" + studentNum +
                ", upperNum=" + upperNum +
                ", clazzNo='" + clazzNo + '\'' +
                ", clazzName='" + clazzName + '\'' +
                ", clazzType='" + clazzType + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
