package com.graduation.demo.controller.system;

import com.graduation.demo.common.ActiveUser;
import com.graduation.demo.common.TreeNode;
import com.graduation.demo.common.TreeNodeBuilder;
import com.graduation.demo.entity.Menu;
import com.graduation.demo.service.MenuService;
import com.graduation.demo.service.RoleService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.utils.WEBUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单管理控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
    @Autowired
    RoleService roleService;

    /**
     * 获取菜单列表
     * @return
     */
    @RequestMapping("/loadIndexLeftMenuJson")
    public DataResult loadIndexLeftMenuJson(){
        //获取用户活动类
        ActiveUser user = (ActiveUser) WEBUtils.getSession().getAttribute("user");
        //通过获取角色类型获得菜单
        List<Menu> menuList = roleService.getMenus(user.getRoleType());
        //生成菜单列表
        List<TreeNode> treeNodeList = new ArrayList<>();
        for(Menu menu : menuList){
            TreeNode treeNode = new TreeNode(menu.getMenuNo(), menu.getParentNo(), menu.getName(), menu.getIcon(), menu.getComponent());
            treeNodeList.add(treeNode);
        }
        //生成菜单树
        List<TreeNode> treeNodeTree = TreeNodeBuilder.build(treeNodeList, 1L);
        //返回跟节点
        return DataResult.success(treeNodeTree);
    }
}

