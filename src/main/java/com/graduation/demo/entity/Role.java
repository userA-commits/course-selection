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
@TableName("xk_role")
public class Role implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "角色编号")
    private Long roleNo;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色键")
    private String roleKey;

    @ApiModelProperty(value = "备注")
    private String remark;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(Long roleNo) {
        this.roleNo = roleNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Role{" +
        "id=" + id +
        ", roleNo=" + roleNo +
        ", name=" + name +
        ", roleKey=" + roleKey +
        ", remark=" + remark +
        "}";
    }
}
