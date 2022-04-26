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
@TableName("xk_select_course")
public class SelectCourse implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "授课编号")
    private String teachCourseNo;

    @ApiModelProperty(value = "班级编号")
    private String clazzNo;

    @ApiModelProperty(value = "学生编号")
    private String studentNo;

    @ApiModelProperty(value = "修读学期")
    private Integer semester;

    @ApiModelProperty(value = "平时成绩")
    private Integer normalScore;

    @ApiModelProperty(value = "考试成绩")
    private Integer examScore;

    @ApiModelProperty(value = "总成绩")
    private Integer totalScore;

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

    public String getClazzNo() {
        return clazzNo;
    }

    public void setClazzNo(String clazzNo) {
        this.clazzNo = clazzNo;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
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
        return "SelectCourse{" +
                "id='" + id + '\'' +
                ", teachCourseNo='" + teachCourseNo + '\'' +
                ", clazzNo='" + clazzNo + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", semester=" + semester +
                ", normalScore=" + normalScore +
                ", examScore=" + examScore +
                ", totalScore=" + totalScore +
                ", remark='" + remark + '\'' +
                '}';
    }
}
