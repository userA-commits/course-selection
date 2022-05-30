package com.graduation.demo.controller.business;

import com.graduation.demo.entity.base.Student;
import com.graduation.demo.entity.base.Teacher;
import com.graduation.demo.service.CourseTableService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.business.CourseTableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 课表前端控制器
 *
 * @author 王奥
 * @since 2022-04-14
 */
@RestController
@RequestMapping("/courseTable")
public class CourseTableController {
    @Autowired
    CourseTableService courseTableService;


    //获取课表
    @RequestMapping("/getCourseTable")
    public DataResult getCourseTable(){
        return DataResult.success(courseTableService.getCourseTable());
    }
}
