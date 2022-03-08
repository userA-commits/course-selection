package com.graduation.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("管理员信息")
public class Admin implements Serializable {
    @ApiModelProperty(name = "管理员ID", dataType = "String")
    private String aid;
    @ApiModelProperty(name = "管理员密码", dataType = "String")
    private String password;
    @ApiModelProperty(name = "管理员名字", dataType = "String")
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
}
