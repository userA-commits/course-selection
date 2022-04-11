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
@TableName("xk_teacher")
public class Teacher implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 教师编号
     */
    private String teacherNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 用户类别
     */
    private Integer userType;

    /**
     * 职位
     */
    private String position;

    /**
     * 院系编号
     */
    private String deprNo;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String emali;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDeprNo() {
        return deprNo;
    }

    public void setDeprNo(String deprNo) {
        this.deprNo = deprNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmali() {
        return emali;
    }

    public void setEmali(String emali) {
        this.emali = emali;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        "id=" + id +
        ", teacherNo=" + teacherNo +
        ", name=" + name +
        ", password=" + password +
        ", sex=" + sex +
        ", userType=" + userType +
        ", position=" + position +
        ", deprNo=" + deprNo +
        ", telephone=" + telephone +
        ", emali=" + emali +
        "}";
    }
}
