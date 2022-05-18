package com.graduation.demo.controller.system;

import com.graduation.demo.common.ActiveUser;
import com.graduation.demo.utils.WEBUtils;
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
        //根据用户角色返回不同的界面
        ActiveUser user = (ActiveUser) WEBUtils.getSession().getAttribute("user");
        if(user.getRoleType() == 1){
            return "system/notice/noticeManager";
        }
        return "system/notice/noticeSearch";
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
        //根据用户角色返回不同的界面
        ActiveUser user = (ActiveUser) WEBUtils.getSession().getAttribute("user");
        if(user.getRoleType() == 1){
            //管理员进入管理界面
            return "business/coursePlan/coursePlanManager";
        }
        //学生进入查看界面
        return "business/coursePlan/coursePlanSearch";
    }
    //加载授课管理界面
    @RequestMapping("/toTeachCourse")
    public String toTeachCourse() {
        return "business/teachCourse/teachCourseManager";
    }
    //加载排课管理界面
    @RequestMapping("/toCourseArrange")
    public String toCourseArrange() {
        return "business/courseArrange/courseArrangeManager";
    }
    //加载排课管理界面
    @RequestMapping("/toSelectCourse")
    public String toSelectCourse() {
        ActiveUser user = (ActiveUser) WEBUtils.getSession().getAttribute("user");
        if(user.getRoleType() == 3){
            return "business/selectCourse/stuSelectCourse";
        }else{
            return "business/selectCourse/selectCourseManager";
        }
    }
    //加载成绩管理界面
    @RequestMapping("/toCourseScore")
    public String toCourseScore() {
        ActiveUser user = (ActiveUser) WEBUtils.getSession().getAttribute("user");
        if(user.getRoleType() == 3){
            return "business/courseScore/courseScoreSearch";
        }else{
            return "business/courseScore/courseScoreManager";
        }
    }
}
