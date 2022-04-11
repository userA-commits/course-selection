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
 * @since 2022-04-12
 */
@TableName("xk_admin")
public class Admin implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 管理员编号
     */
    @ApiModelProperty(value = "管理员编号")
    private String adminNo;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字")
    private String name;

    /**
     * 用户类别
     */
    @ApiModelProperty(value = "用户类别")
    private Integer userType;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo;
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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Admin{" +
        "id=" + id +
        ", adminNo=" + adminNo +
        ", password=" + password +
        ", name=" + name +
        ", userType=" + userType +
        ", email=" + email +
        "}";
    }
}
