package com.graduation.demo.controller.business;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.demo.entity.Admin;
import com.graduation.demo.entity.Student;
import com.graduation.demo.entity.Teacher;
import com.graduation.demo.enums.LoginType;
import com.graduation.demo.service.AdminService;
import com.graduation.demo.service.StudentService;
import com.graduation.demo.service.TeacherService;
import com.graduation.demo.shiro.UserToken;
import com.graduation.demo.utils.DataResult;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 登录前端控制器
 *
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AdminService adminService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(String no, String password, int userType) {

        ModelAndView modelAndView = new ModelAndView();
        UserToken userToken = null;
        Subject subject = SecurityUtils.getSubject();

        if(userType == 1){
            Admin admin = adminService.getOne(new QueryWrapper<Admin>()
                    .select("*")
                    .eq("admin_no", no)
                    .eq("password", password)
            );
            //管理员认证
            userToken = new UserToken(
                    admin.getAdminNo(),
                    admin.getPassword(),
                    LoginType.ADMIN.toString()
            );
        }else if(userType == 2){
            Teacher teacher = teacherService.getOne(new QueryWrapper<Teacher>()
                    .select("*")
                    .eq("teacher_no", no)
                    .eq("password", password)
            );
            //教师认证
            userToken = new UserToken(
                    teacher.getTeacherNo(),
                    teacher.getPassword(),
                    LoginType.ADMIN.toString()
            );
        }else{
            Student student = studentService.getOne(new QueryWrapper<Student>()
                    .select("*")
                    .eq("student_no", no)
                    .eq("password", password)
            );
            //学生认证
            userToken = new UserToken(
                    student.getStudentNo(),
                    student.getPassword(),
                    LoginType.ADMIN.toString()
            );
        }

        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(userToken);

        } catch (UnknownAccountException e) {
            modelAndView.setViewName("login");
            modelAndView.addObject("msg", "用户名不存在！");
            return modelAndView;
        } catch (AuthenticationException e) {
            modelAndView.setViewName("login");
            modelAndView.addObject("msg", "账号或密码错误！");
            return modelAndView;
        } catch (AuthorizationException e) {
            modelAndView.setViewName("login");
            modelAndView.addObject("msg", "没有权限");
            return modelAndView;
        }
        modelAndView.setViewName("index");

        return modelAndView;
    }
}
