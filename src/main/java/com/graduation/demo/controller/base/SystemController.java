package com.graduation.demo.controller.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统控制器
 *
 * @author 王奥
 * @since 2022-04-14
 */
@Controller
@RequestMapping("/sys")
public class SystemController {
    @Autowired
    AdminService adminService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "system/index/login";
    }

    @RequestMapping("/index")
    public String index() {
        return "system/index/index";
    }
    @RequestMapping("/toDesk")
    public String toDesk() {
        return "system/index/main";
    }
}
