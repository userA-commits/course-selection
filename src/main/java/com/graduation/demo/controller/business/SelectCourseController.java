package com.graduation.demo.controller.business;


import com.graduation.demo.entity.SelectCourse;
import com.graduation.demo.service.SelectCourseService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 选课管理前端控制器
 *
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/select-course")
public class SelectCourseController {
    @Autowired
    SelectCourseService selectCourseService;

    //TODO:需要当排课完成时自动同步插入班级学生的选课列表
    //TODO:选课允许对选修课进行操作，必修课只允许查看

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<SelectCourse> selectCourses = selectCourseService.list();
        DataResult<List<SelectCourse>> result = new DataResult<>(selectCourses);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(SelectCourse selectCourse){
        selectCourseService.save(selectCourse);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(SelectCourse selectCourse){
        selectCourseService.updateById(selectCourse);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        selectCourseService.removeByIds(ids);
        return DataResult.success();
    }
}


