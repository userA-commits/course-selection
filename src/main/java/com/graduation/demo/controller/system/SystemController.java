package com.graduation.demo.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统控制器
 *
 * @author 王奥
 * @since 2022-04-14
 */
@Controller
@RequestMapping("/sys")
public class SystemController {

    /**
     * 系统管理跳转控制
     */
    //跳转到登录界面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "system/index/login";
    }
    //跳转到系统框架界面
    @RequestMapping("/index")
    public String index() {
        return "system/index/index";
    }
    //加载主界面
    @RequestMapping("/toDesk")
    public String toDesk() {
        return "system/index/main";
    }
    //加载公告管理界面
    @RequestMapping("/toNotice")
    public String toNotice() {
        return "system/notice/noticeManager";
    }

    /**
     * 基础信息管理跳转控制
     */
    //加载管理员管理界面
    @RequestMapping("/toAdmin")
    public String toAdmin() {
        return "base/adminManager";
    }
    //加载教师管理界面
    @RequestMapping("/toTeacher")
    public String toTeacher() {
        return "base/teacherManager";
    }
    //加载学生管理界面
    @RequestMapping("/toStudent")
    public String toStudent() {
        return "base/studentManager";
    }
    //加载学院管理界面
    @RequestMapping("/toDept")
    public String toDept() {
        return "base/deptManager";
    }
    //加载专业管理界面
    @RequestMapping("/toMajor")
    public String toMajor() {
        return "base/majorManager";
    }
    //加载教室管理界面
    @RequestMapping("/toClassroom")
    public String toClassroom() {
        return "base/classroomManager";
    }
    //加载班级管理界面
    @RequestMapping("/toClazz")
    public String toClazz() {
        return "base/clazzManager";
    }
    //加载课程管理界面
    @RequestMapping("/toCourse")
    public String toCourse() {
        return "base/courseManager";
    }

    /**
     * 课务管理跳转控制
     */
    //加载教学计划管理界面
    @RequestMapping("/toCoursePlan")
    public String toCoursePlan() {
        return "business/coursePlan/coursePlanManager";
    }
}
