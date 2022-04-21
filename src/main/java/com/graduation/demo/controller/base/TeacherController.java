package com.graduation.demo.controller.base;


import com.graduation.demo.entity.base.Teacher;
import com.graduation.demo.service.TeacherService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 教师管理控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<Teacher> teachers = teacherService.list();
        DataResult<List<Teacher>> result = new DataResult<>(teachers);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(Teacher teacher){
        teacherService.save(teacher);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(Teacher teacher){
        teacherService.updateById(teacher);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        teacherService.removeByIds(ids);
        return DataResult.success();
    }
}
