package com.graduation.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author 王奥
 * @since 2022-04-01
 */
@TableName("sys_rm")
public class Rm implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 是否可用，0为可，1为不可
     */
    private Integer isAvailable;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Rm{" +
        "roleId=" + roleId +
        ", menuId=" + menuId +
        ", isAvailable=" + isAvailable +
        "}";
    }
}
