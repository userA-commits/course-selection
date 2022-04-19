package com.graduation.demo.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.demo.entity.Admin;
import com.graduation.demo.entity.Menu;
import com.graduation.demo.entity.Role;
import com.graduation.demo.service.AdminService;
import com.graduation.demo.service.MenuService;
import com.graduation.demo.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;


    /**
     * @Description 认证类
     * @Param [authenticationToken]
     * @Return AuthenticationInfo
     * @Author WangShiLin
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (StringUtils.isEmpty((CharSequence) authenticationToken.getPrincipal())) {
            return null;
        }
        //获取管理员信息
        String admin_no = authenticationToken.getPrincipal().toString();
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper
                .select("*")
                .eq("admin_no", admin_no);
        Admin admin = adminService.getOne(adminQueryWrapper);
        if (admin == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    admin_no,
                    admin.getPassword().toString(),
                    getName()
            );
            return simpleAuthenticationInfo;
        }
    }

    /**
     * @Description 授权类
     * @Param [principalCollection]
     * @Return AuthorizationInfo
     * @Author WangShiLin
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //添加角色
        simpleAuthorizationInfo.addRole("admin");
        //添加权限
        for (Menu menu : roleService.getPerms(1)) {
            simpleAuthorizationInfo.addStringPermission(menu.getPerms());
        }
        return simpleAuthorizationInfo;
    }
}