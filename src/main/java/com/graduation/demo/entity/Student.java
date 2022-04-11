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
@TableName("xk_student")
public class Student implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 学生编号
     */
    private String studentNo;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户类别
     */
    private Integer sex;

    /**
     * 年级
     */
    private Integer userType;

    /**
     * 院系编号
     */
    private String grade;

    /**
     * 专业编号
     */
    private String deptNo;

    /**
     * 班级编号
     */
    private String najorNo;

    private String clazzNo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getNajorNo() {
        return najorNo;
    }

    public void setNajorNo(String najorNo) {
        this.najorNo = najorNo;
    }

    public String getClazzNo() {
        return clazzNo;
    }

    public void setClazzNo(String clazzNo) {
        this.clazzNo = clazzNo;
    }

    @Override
    public String toString() {
        return "Student{" +
        "id=" + id +
        ", studentNo=" + studentNo +
        ", password=" + password +
        ", name=" + name +
        ", sex=" + sex +
        ", userType=" + userType +
        ", grade=" + grade +
        ", deptNo=" + deptNo +
        ", najorNo=" + najorNo +
        ", clazzNo=" + clazzNo +
        "}";
    }
}
