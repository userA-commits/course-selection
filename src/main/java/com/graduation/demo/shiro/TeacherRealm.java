package com.graduation.demo.shiro;

import com.graduation.demo.entity.Menu;
import com.graduation.demo.entity.Teacher;
import com.graduation.demo.service.RoleService;
import com.graduation.demo.service.TeacherService;
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

public class TeacherRealm  extends AuthorizingRealm {
    @Autowired
    TeacherService teacherService;
    @Autowired
    RoleService roleService;

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
        //获取管理员信息
        String tid = authenticationToken.getPrincipal().toString();
        Teacher teacher = teacherService.getById(tid);
        if (teacher == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    tid,
                    teacher.getPassword().toString(),
                    getName()
            );
            return simpleAuthenticationInfo;
        }
    }

    /**
     * @MethodName doGetAuthorizationInfo
     * @Description 权限配置类
     * @Param [principalCollection]
     * @Return AuthorizationInfo
     * @Author WangShiLin
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //添加角色
        simpleAuthorizationInfo.addRole("Admin");
        //添加权限
        for (Menu menu : roleService.getPerms(2)) {
            simpleAuthorizationInfo.addStringPermission(menu.getPerms());
        }
        return simpleAuthorizationInfo;
    }
}
