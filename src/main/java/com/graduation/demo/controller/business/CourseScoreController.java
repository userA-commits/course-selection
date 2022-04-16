package com.graduation.demo.controller.business;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.graduation.demo.entity.SelectCourse;
import com.graduation.demo.entity.Student;
import com.graduation.demo.entity.TeachCourse;
import com.graduation.demo.entity.Teacher;
import com.graduation.demo.service.SelectCourseService;
import com.graduation.demo.service.TeachCourseService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.SelectCourseVo;
import com.graduation.demo.vo.TeachCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 成绩管理前端控制器
 *
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/course-score")
public class CourseScoreController {
    @Autowired
    @Lazy
    TeachCourseService teachCourseService;
    @Autowired
    @Lazy
    SelectCourseService selectCourseService;

    //教师通过教师编号获得授课列表
    @PostMapping("/getTeachCourseVosByTNo")
    public DataResult getTeachCourseVosByTNo(String teacherNo){
        TeachCourse teachCourse = new TeachCourse();
        teachCourse.setTeacherNo(teacherNo);
        List<TeachCourseVo> teachCourseVos = teachCourseService.getTeachCourseVoWithCond(teachCourse);
        DataResult<List<TeachCourseVo>> result = new DataResult<>(teachCourseVos);
        return result;
    }
    //通过授课编号获取学生选课列表
    @PostMapping("/getSelectCourseVosByTCNo")
    public DataResult getSelectCourseVosByTCNo(String teachCourseNo){
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setTeachCourseNo(teachCourseNo);
        List<SelectCourseVo> selectCourseVos = selectCourseService.getSelectCourseVoWithCond(selectCourse);
        DataResult<List<SelectCourseVo>> result = new DataResult<>(selectCourseVos);
        return result;
    }
    //教师录入学生分数
    @PostMapping("/editCourseScore")
    public DataResult editCourseScore(SelectCourse selectCourse){
        selectCourseService.update(new UpdateWrapper<SelectCourse>()
                .set("*", selectCourse)
                .eq("id", selectCourse.getId())
        );

        return DataResult.success();
    }
    //学生查看成绩列表
    @PostMapping("/getCourseScoreVosForStu")
    public DataResult getCourseScoreVosForStu(String studentNo, int semester){
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setStudentNo(studentNo);
        selectCourse.setSemester(semester);
        selectCourseService.getSelectCourseVoWithCond(selectCourse);

        return DataResult.success();
    }
}

