package com.graduation.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.demo.entity.system.Menu;
import com.graduation.demo.entity.system.Role;
import com.graduation.demo.entity.system.RoleMenu;
import com.graduation.demo.mapper.RoleMapper;
import com.graduation.demo.service.MenuService;
import com.graduation.demo.service.RoleMenuService;
import com.graduation.demo.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    MenuService menuService;
    @Autowired
    RoleMenuService roleMenuService;

    /**
     * 获得角色的所有对应权限菜单
     * @param roleNo 角色编号
     * @return 角色权限列表
     */
    @Override
    public List<Menu> getMenus(int roleNo) {
        //存放角色与权限对应关系
        List<RoleMenu> roleMenuList;
        //菜单列表
        LinkedList<Menu> menuList = new LinkedList<>();

        //查询传入角色的权限对应关系
        QueryWrapper<RoleMenu> roleMenuQueryWrapper = new QueryWrapper<>();
        roleMenuQueryWrapper
                .select("role_no", "menu_no")
                .eq("role_no", roleNo);
        roleMenuList = roleMenuService.list(roleMenuQueryWrapper);

        //将对应菜单放入列表
        for(RoleMenu roleMenu : roleMenuList){
            QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
            menuQueryWrapper
                    .select("*")
                    .eq("menu_no", roleMenu.getMenuNo());
            menuList.add(menuService.getOne(menuQueryWrapper));
        }

        //将得到的菜单列表按编号正序排序
        Collections.sort(menuList, new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {
                return (int) (o1.getMenuNo() - o2.getMenuNo());
            }
        });

        return menuList;
    }

    @Override
    public List<String> getPerms(List<Menu> menus) {
        List<String> perms = new ArrayList<>();
        for(Menu menu : menus){
            perms.add(menu.getPerms());
        }
        return perms;
    }
}
