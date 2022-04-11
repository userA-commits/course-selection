package com.graduation.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.demo.entity.Menu;
import com.graduation.demo.entity.Role;
import com.graduation.demo.entity.RoleMenu;
import com.graduation.demo.mapper.MenuMapper;
import com.graduation.demo.mapper.RoleMapper;
import com.graduation.demo.mapper.RoleMenuMapper;
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
    MenuMapper menuMapper;
    @Autowired
    RoleMenuMapper roleMenuMapper;

    /**
     * 获得角色的所有对应权限
     * @param roleNo 角色编号
     * @return 角色权限列表
     */
    @Override
    public List<Menu> getPerms(int roleNo) {
        //存放角色与权限对应关系
        List<RoleMenu> roleMenuList;
        //暂存权限菜单列表
        LinkedList<Menu> tempList = new LinkedList<>();
        //结果权限列表
        Set<Menu> resultSet = new HashSet<>();

        //查询传入角色的权限对应关系
        QueryWrapper<RoleMenu> roleMenuQueryWrapper = new QueryWrapper<>();
        roleMenuQueryWrapper
                .select("role_no", "menu_no")
                .eq("role_no", roleNo);
        roleMenuList = roleMenuMapper.selectList(roleMenuQueryWrapper);

        //将对应菜单放入列表
        for(RoleMenu roleMenu : roleMenuList){
            QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
            menuQueryWrapper
                    .select("*")
                    .eq("menu_no", roleMenu.getMenuNo());
            tempList.add(menuMapper.selectOne(menuQueryWrapper));
        }

        while(tempList.size() != 0){
            //从临时列表弹出菜单放入结果集合
            Menu menu = tempList.pollFirst();
            resultSet.add(menu);

            //查询当前菜单项目的子菜单
            QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
            menuQueryWrapper
                    .select("*")
                    .eq("parent_no", menu.getMenuNo());
            List<Menu> sonMenuList = menuMapper.selectList(menuQueryWrapper);
            //将子菜单项放入临时列表
            tempList.addAll(sonMenuList);
        }
        List<Menu> menuList = new ArrayList<>(resultSet);
        //将得到的菜单列表按编号正序排序
        Collections.sort(menuList, new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {
                return (int) (o1.getMenuNo() - o2.getMenuNo());
            }
        });

        return menuList;
    }
}
