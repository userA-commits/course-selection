package com.graduation.demo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CourseArrangeVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id", notes = "form course arrange")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "授课编号", notes = "form course arrange")
    private String teachCourseNo;

    @ApiModelProperty(value = "教室编号", notes = "form course arrange")
    private String classroomNo;

    @ApiModelProperty(value = "教室名称", notes = "form classroom")
    private String classroomName;

    @ApiModelProperty(value = "教室类别，0为普通，1为特殊", notes = "form classroom")
    private Integer classroomType;

    @ApiModelProperty(value = "星期，1到7代表周一到周天", notes = "form course arrange")
    private Integer week;

    @ApiModelProperty(value = "使用时间段", notes = "form course arrange")
    private Integer period;

    @ApiModelProperty(value = "备注", notes = "form course arrange")
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

    public String getClassroomNo() {
        return classroomNo;
    }

    public void setClassroomNo(String classroomNo) {
        this.classroomNo = classroomNo;
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

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CourseArrangeVo{" +
                "id='" + id + '\'' +
                ", teachCourseNo='" + teachCourseNo + '\'' +
                ", classroomNo='" + classroomNo + '\'' +
                ", classroomName='" + classroomName + '\'' +
                ", classroomType=" + classroomType +
                ", week=" + week +
                ", period=" + period +
                ", remark='" + remark + '\'' +
                '}';
    }
}
