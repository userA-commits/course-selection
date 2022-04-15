package com.graduation.demo.controller.business;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.demo.entity.Course;
import com.graduation.demo.entity.TeachCourse;
import com.graduation.demo.entity.Teacher;
import com.graduation.demo.service.CourseService;
import com.graduation.demo.service.TeachCourseService;
import com.graduation.demo.service.TeacherService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.TeachCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 授课管理前端控制器
 *
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/teach-course")
public class TeachCourseController {
    @Autowired
    @Lazy
    TeachCourseService teachCourseService;


    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    //用于获取以教师为分组的授课信息列表
    @PostMapping("/getTeachCourseVosByCond")
    public DataResult getTeachCourseVosByCond(TeachCourse teachCourse){
        List<TeachCourseVo> teachCourseVos = teachCourseService.getTeachCourseVoWithCond(teachCourse);
        DataResult<List<TeachCourseVo>> result = new DataResult<>(teachCourseVos);
        return result;
    }

    @PostMapping("/getTeachCourseVos")
    public DataResult getTeachCourseVos(){
        List<TeachCourseVo> teachCourseVos = teachCourseService.getTeachCourseVo();
        DataResult<List<TeachCourseVo>> result = new DataResult<>(teachCourseVos);
        return result;
    }

    @PostMapping("/query")
    public DataResult query(){
        List<TeachCourse> teachCourses = teachCourseService.list();
        DataResult<List<TeachCourse>> result = new DataResult<>(teachCourses);
        return result;
    }
    //如果添加的授课信息中教师与课程不是同学院，提示不合规
    @PostMapping("/add")
    public DataResult add(TeachCourse teachCourse){
        //当教师学院编号与课程学院编号相同时，执行插入，否则提示失败
        if(teachCourseService.isSameDept(teachCourse)){
            //存储时，存入对应的学生选课信息
            teachCourseService.saveRequired(teachCourse);
            return DataResult.success();
        }else{
            return DataResult.getResult(401, "不能让给教师赋予非本院课程");
        }
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        teachCourseService.removeRequired(ids);
        return DataResult.success();
    }
}




