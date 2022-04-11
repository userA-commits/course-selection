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
 * @since 2022-04-11
 */
@TableName("xk_course_score")
public class CourseScore implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 选课编号
     */
    private String selectCourseNo;

    /**
     * 平时成绩
     */
    private Integer normalScore;

    /**
     * 考试成绩
     */
    private Integer examScore;

    /**
     * 总成绩
     */
    private Integer totalScore;

    /**
     * 备注
     */
    private String remark;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelectCourseNo() {
        return selectCourseNo;
    }

    public void setSelectCourseNo(String selectCourseNo) {
        this.selectCourseNo = selectCourseNo;
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
        return "CourseScore{" +
        "id=" + id +
        ", selectCourseNo=" + selectCourseNo +
        ", normalScore=" + normalScore +
        ", examScore=" + examScore +
        ", totalScore=" + totalScore +
        ", remark=" + remark +
        "}";
    }
}
