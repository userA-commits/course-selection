package com.graduation.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.demo.entity.Menu;
import com.graduation.demo.entity.Rm;
import com.graduation.demo.entity.Role;
import com.graduation.demo.mapper.MenuMapper;
import com.graduation.demo.mapper.RmMapper;
import com.graduation.demo.mapper.RoleMapper;
import com.graduation.demo.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author 王奥
 * @since 2022-03-14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    RmMapper rmMapper;


    @Override
    public List<Menu> getPerms(int roleId) {
        QueryWrapper<Rm> rmQueryWrapper = new QueryWrapper<>();
        List<Rm> rmList;
        LinkedList<Menu> tempList = new LinkedList<>();
        Set<Menu> resultSet = new HashSet<>();

        rmQueryWrapper
                .select("role_id", "menu_id")
                .eq("role_id", 1);
        rmList = rmMapper.selectList(rmQueryWrapper);

        for(Rm rm : rmList){
            Menu menu = menuMapper.selectById(rm.getMenuId());
            tempList.add(menu);
        }

        while(tempList.size() != 0){
            Menu menu = tempList.pollFirst();
            resultSet.add(menu);

            QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
            menuQueryWrapper
                    .select("*")
                    .eq("parent_id", menu.getMenuId());
            List<Menu> sonMenuList = menuMapper.selectList(menuQueryWrapper);
            tempList.addAll(sonMenuList);
            resultSet.addAll(sonMenuList);
        }

        return new ArrayList<>(resultSet);
    }
}
