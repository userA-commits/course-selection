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
@ApiModel("管理员实体")
public class Admin implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "aid", type = IdType.AUTO)
    @ApiModelProperty(name = "管理员ID", dataType = "String")
    private String aid;
    @ApiModelProperty(name = "管理员密码", dataType = "String")
    private String password;
    @ApiModelProperty(name = "名字", dataType = "String")
    private String name;


    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
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

    @Override
    public String toString() {
        return "Admin{" +
        "aid=" + aid +
        ", password=" + password +
        ", name=" + name +
        "}";
    }
}
