package com.graduation.demo.entity.business;

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
@TableName("xk_course_arrange")
public class CourseArrange implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "授课编号")
    private String teachCourseNo;

    @ApiModelProperty(value = "教室编号")
    private String classroomNo;

    @ApiModelProperty(value = "星期，1到7代表周一到周天")
    private Integer week;

    @ApiModelProperty(value = "使用时间段，由1到5，上午2下午2晚上1")
    private Integer period;

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

    public String getClassroomNo() {
        return classroomNo;
    }

    public void setClassroomNo(String classroomNo) {
        this.classroomNo = classroomNo;
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
        return "CourseArrange{" +
                "id='" + id + '\'' +
                ", teachCourseNo='" + teachCourseNo + '\'' +
                ", classroomNo='" + classroomNo + '\'' +
                ", week=" + week +
                ", period=" + period +
                ", remark='" + remark + '\'' +
                '}';
    }
}
