package com.graduation.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王奥
 * @since 2022-03-11
 */
@ApiModel("学生实体")
public class Student implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "sid", type = IdType.AUTO)
    @ApiModelProperty(name = "学生ID", dataType = "String")
    private String sid;
    @ApiModelProperty(name = "学生名", dataType = "String")
    private String sname;
    @ApiModelProperty(name = "密码", dataType = "String")
    private String password;
    @ApiModelProperty(name = "性别", dataType = "String")
    private Integer sex;
    @ApiModelProperty(name = "年级", dataType = "String")
    private String grade;
    @ApiModelProperty(name = "专业", dataType = "String")
    private String major;


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
        "sid=" + sid +
        ", sname=" + sname +
        ", password=" + password +
        ", sex=" + sex +
        ", grade=" + grade +
        ", major=" + major +
        "}";
    }
}
