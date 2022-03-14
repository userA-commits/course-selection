package com.graduation.demo.shiro;

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


public class CustomRealm  extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    /**
     * @MethodName doGetAuthorizationInfo
     * @Description 权限配置类
     * @Param [principalCollection]
     * @Return AuthorizationInfo
     * @Author WangShiLin
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录管理员账号
        String aid = (String) principalCollection.getPrimaryPrincipal();
        //获取管理员对象
        Admin admin = adminService.getById(aid);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //添加角色
        simpleAuthorizationInfo.addRole("管理员");
        //添加权限
        for (Menu menu : roleService.getPerms(1)) {
            simpleAuthorizationInfo.addStringPermission(menu.getPerms());
        }
        return simpleAuthorizationInfo;
    }

    /**
     * @MethodName doGetAuthenticationInfo
     * @Description 认证配置类
     * @Param [authenticationToken]
     * @Return AuthenticationInfo
     * @Author WangShiLin
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (StringUtils.isEmpty((CharSequence) authenticationToken.getPrincipal())) {
            return null;
        }
        //获取用户信息
        String aid = authenticationToken.getPrincipal().toString();
        Admin admin = adminService.getById(aid);
        if (admin == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(aid, admin.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }
}
