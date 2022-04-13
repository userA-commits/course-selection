package com.graduation.demo.controller.business;


import com.graduation.demo.entity.TeachCourse;
import com.graduation.demo.service.TeachCourseService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
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
    TeachCourseService teachCourseService;

    //TODO:需要以教师为分组的授课信息列表
    //TODO:教师只允许授同学院的课

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<TeachCourse> teachCourses = teachCourseService.list();
        DataResult<List<TeachCourse>> result = new DataResult<>(teachCourses);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(TeachCourse teachCourse){
        teachCourseService.save(teachCourse);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(TeachCourse teachCourse){
        teachCourseService.updateById(teachCourse);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        teachCourseService.removeByIds(ids);
        return DataResult.success();
    }
}




