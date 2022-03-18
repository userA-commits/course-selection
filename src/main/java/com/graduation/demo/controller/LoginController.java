package com.graduation.demo.controller;

import com.graduation.demo.entity.Admin;
import com.graduation.demo.entity.Student;
import com.graduation.demo.entity.Teacher;
import com.graduation.demo.enums.LoginType;
import com.graduation.demo.service.AdminService;
import com.graduation.demo.service.StudentService;
import com.graduation.demo.service.TeacherService;
import com.graduation.demo.shiro.UserToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AdminService adminService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;

    @PostMapping("/adminLogin")
    public String adminLogin(Admin admin){
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UserToken userToken = new UserToken(
                admin.getAid(),
                admin.getPassword(),
                LoginType.ADMIN.toString()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(userToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (UnknownAccountException e) {
            return "用户名不存在！";
        } catch (AuthenticationException e) {
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            return "没有权限";
        }

        return "index";
    }

    @PostMapping("/teacherLogin")
    public String teacherLogin(Teacher teacher){
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UserToken userToken = new UserToken(
                teacher.getTid(),
                teacher.getPassword(),
                LoginType.TEACHER.toString()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(userToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (UnknownAccountException e) {
            return "用户名不存在！";
        } catch (AuthenticationException e) {
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            return "没有权限";
        }

        return "index";
    }

    @PostMapping("/studentLogin")
    public String studentLogin(Student student){
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UserToken userToken = new UserToken(
                student.getSid(),
                student.getPassword(),
                LoginType.TEACHER.toString()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(userToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (UnknownAccountException e) {
            return "用户名不存在！";
        } catch (AuthenticationException e) {
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            return "没有权限";
        }

        return "index";
    }
}
