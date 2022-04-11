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
@TableName("xk_select_course")
public class SelectCourse implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "选课编号")
    private String selectCourseNo;

    @ApiModelProperty(value = "授课编号")
    private String teachCourseNo;

    @ApiModelProperty(value = "学生编号")
    private String studentNo;

    @ApiModelProperty(value = "备注")
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SelectCourse{" +
        "id=" + id +
        ", selectCourseNo=" + selectCourseNo +
        ", teachCourseNo=" + teachCourseNo +
        ", studentNo=" + studentNo +
        ", remark=" + remark +
        "}";
    }
}
