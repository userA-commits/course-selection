package com.graduation.demo.vo.business;

import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;

/**
 * 课表联合实体
 *
 * @author 王奥
 * @since 2022-04-15
 */
public class CourseTableVo {
    //保留空构造器
    public CourseTableVo(){}
    //通过填入授课信息和排课信息生成课表实体
    public CourseTableVo(TeachCourseVo teachCourseVo, CourseArrangeVo courseArrangeVo) {
        this.teachCourseNo = teachCourseVo.getTeachCourseNo();
        this.teacherNo = teachCourseVo.getTeacherNo();
        this.TeacherName = teachCourseVo.getTeacherName();
        this.courseNo = teachCourseVo.getCourseNo();
        this.state = teachCourseVo.getState();
        this.courseName = teachCourseVo.getCourseName();
        this.classroomNo = courseArrangeVo.getClassroomNo();
        this.classroomName = courseArrangeVo.getClassroomName();
        this.week = courseArrangeVo.getWeek();
        this.period = courseArrangeVo.getPeriod();
    }

    @ApiModelProperty(value = "授课编号", notes = "form course arrange vo")
    private String teachCourseNo;

    @ApiModelProperty(value = "教师编号", notes = "form teach course vo")
    private String teacherNo;

    @ApiModelProperty(value = "教师姓名", notes = "form teach course vo")
    private String TeacherName;

    @ApiModelProperty(value = "课程编号", notes = "form teach course vo")
    private String courseNo;

    @ApiModelProperty(value = "状态，0代表正使用，1代表已结束", notes = "form teach course vo")
    private int state;

    @ApiModelProperty(value = "课程名称", notes = "form teach course vo")
    private String courseName;

    @ApiModelProperty(value = "教室编号", notes = "form course arrange vo")
    private String classroomNo;

    @ApiModelProperty(value = "教室名称", notes = "form course arrange vo")
    private String classroomName;

    @ApiModelProperty(value = "星期，1到7代表周一到周天", notes = "form course arrange vo")
    private Integer week;

    @ApiModelProperty(value = "使用时间段", notes = "form course arrange vo")
    private Integer period;

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

    @Override
    public String toString() {
        return "CourseTableVo{" +
                "teachCourseNo='" + teachCourseNo + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", TeacherName='" + TeacherName + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", state=" + state +
                ", courseName='" + courseName + '\'' +
                ", classroomNo='" + classroomNo + '\'' +
                ", classroomName='" + classroomName + '\'' +
                ", week=" + week +
                ", period=" + period +
                ", page=" + page +
                ", limit=" + limit +
                ", ids=" + Arrays.toString(ids) +
                '}';
    }
}
