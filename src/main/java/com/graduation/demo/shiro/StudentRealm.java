package com.graduation.demo.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.demo.entity.Menu;
import com.graduation.demo.entity.Student;
import com.graduation.demo.service.RoleService;
import com.graduation.demo.service.StudentService;
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

public class StudentRealm extends AuthorizingRealm {
    @Autowired
    StudentService studentService;
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
        //获取学生信息
        String student_no = authenticationToken.getPrincipal().toString();
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper
                .select("*")
                .eq("student_no", student_no);
        Student student = studentService.getOne(studentQueryWrapper);
        if (student == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    student_no,
                    student.getPassword().toString(),
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
        simpleAuthorizationInfo.addRole("student");
        //添加权限
        for (Menu menu : roleService.getPerms(3)) {
            simpleAuthorizationInfo.addStringPermission(menu.getPerms());
        }
        return simpleAuthorizationInfo;
    }
}
