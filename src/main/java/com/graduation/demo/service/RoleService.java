package com.graduation.demo.service;

import com.graduation.demo.entity.Menu;
import com.graduation.demo.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-11
 */
public interface RoleService extends IService<Role> {
    /**
     * 通过角色获取对应菜单权限
     * @return 菜单列表
     */
    List<Menu> getPerms(int roleNo);
}
