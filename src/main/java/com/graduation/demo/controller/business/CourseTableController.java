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
 * 课表前端控制器，分教师与学生
 *
 * @author 王奥
 * @since 2022-04-14
 */
@RestController
@RequestMapping("/course-table")
public class CourseTableController {
    @Autowired
    CourseTableService courseTableService;



    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    //获取学生课表
    @PostMapping("/getCourseTableForStu")
    public DataResult getCourseTableForStu(Student student){
        List<CourseTableVo> courseTableVos = courseTableService.getCourseTableForStu(student);
        DataResult<List<CourseTableVo>> result = new DataResult<>(courseTableVos);
        return result;
    }

    //获取教师课表
    @PostMapping("/getCourseTableForTea")
    public DataResult getCourseTableForTea(Teacher teacher){
        List<CourseTableVo> courseTableVos = courseTableService.getCourseTableForTea(teacher);
        DataResult<List<CourseTableVo>> result = new DataResult<>(courseTableVos);
        return result;
    }
}
