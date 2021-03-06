package com.graduation.demo.entity.base;

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
 * @since 2022-04-12
 */
@TableName("xk_clazz")
public class Clazz implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "班级编号")
    private String clazzNo;

    @ApiModelProperty(value = "专业编号")
    private String majorNo;

    @ApiModelProperty(value = "年级")
    private Integer grade;

    @ApiModelProperty(value = "班级名称")
    private String name;

    @ApiModelProperty(value = "班级人数")
    private Integer studentNum;

    @ApiModelProperty(value = "班级类别，0为普通，1为特殊")
    private String clazzType;

    @ApiModelProperty(value = "描述")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazzNo() {
        return clazzNo;
    }

    public void setClazzNo(String clazzNo) {
        this.clazzNo = clazzNo;
    }

    public String getMajorNo() {
        return majorNo;
    }

    public void setMajorNo(String majorNo) {
        this.majorNo = majorNo;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getClazzType() {
        return clazzType;
    }

    public void setClazzType(String clazzType) {
        this.clazzType = clazzType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id='" + id + '\'' +
                ", clazzNo='" + clazzNo + '\'' +
                ", majorNo='" + majorNo + '\'' +
                ", grade='" + grade + '\'' +
                ", name='" + name + '\'' +
                ", studentNum=" + studentNum +
                ", clazzType='" + clazzType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
