package com.graduation.demo.entity;

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
 * @since 2022-04-11
 */
@TableName("xk_teach_course")
public class TeachCourse implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "授课编号")
    private String teachCourseNo;

    @ApiModelProperty(value = "教师编号")
    private String teacherNo;

    @ApiModelProperty(value = "课程编号")
    private String courseNo;

    @ApiModelProperty(value = "学生人数")
    private int studentNum;

    @ApiModelProperty(value = "学生人数上限")
    private int upperNum;

    @ApiModelProperty(value = "班级编号")
    private String clazzNo;

    @ApiModelProperty(value = "备注")
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

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TeachCourse{" +
                "id='" + id + '\'' +
                ", teachCourseNo='" + teachCourseNo + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", studentNum=" + studentNum +
                ", upperNum=" + upperNum +
                ", clazzNo='" + clazzNo + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
