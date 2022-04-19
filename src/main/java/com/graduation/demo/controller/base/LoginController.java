package com.graduation.demo.controller.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.demo.common.ActiveUser;
import com.graduation.demo.entity.Admin;
import com.graduation.demo.entity.Student;
import com.graduation.demo.entity.Teacher;
import com.graduation.demo.enums.LoginType;
import com.graduation.demo.service.AdminService;
import com.graduation.demo.service.RoleService;
import com.graduation.demo.service.StudentService;
import com.graduation.demo.service.TeacherService;
import com.graduation.demo.shiro.UserToken;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.utils.WEBUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 登录控制器
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
    @Autowired
    RoleService roleService;

    @RequestMapping("/login")
    public DataResult login(String no, String password, int userType){


        UserToken userToken = null;
        ActiveUser user = null;
        Subject subject = SecurityUtils.getSubject();

        try {
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
                user = new ActiveUser(admin, roleService.getPerms(roleService.getMenus(1)));
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
                user = new ActiveUser(teacher, roleService.getPerms(roleService.getMenus(2)));
            }else{
                Student student = studentService.getOne(new QueryWrapper<Student>()
                        .select("*")
                        .eq("student_no", no)
                        .eq("password", password)
                );
                user = new ActiveUser(student, roleService.getPerms(roleService.getMenus(3)));
                //学生认证
                userToken = new UserToken(
                        student.getStudentNo(),
                        student.getPassword(),
                        LoginType.ADMIN.toString()
                );
            }

            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(userToken);
            //将角色编号放入session域
            WEBUtils.getSession().setAttribute("user", user);
        } catch (NullPointerException e) {
            return DataResult.getResult(401, "账号不存在或密码错误");
        } catch (UnknownAccountException e) {
            return DataResult.getResult(401, "账号不存在或密码错误");
        } catch (AuthenticationException e) {
            return DataResult.getResult(401, "用户认证失败");
        } catch (AuthorizationException e) {
            return DataResult.getResult(401, "权限认证失败");
        }

        return DataResult.success("登录成功");
    }
}
