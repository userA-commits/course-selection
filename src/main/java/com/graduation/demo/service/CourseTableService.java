package com.graduation.demo.service;

import com.graduation.demo.entity.Student;
import com.graduation.demo.entity.Teacher;
import com.graduation.demo.vo.CourseTableVo;
import com.graduation.demo.vo.TeachCourseVo;

import java.util.List;

public interface CourseTableService {
    List<CourseTableVo> getCourseTableForStu(Student student);

    List<CourseTableVo> getCourseTableForTea(Teacher teacher);

    List<CourseTableVo> getCourseTableByTeachCourseList(List<TeachCourseVo> teachCourseVoList);
}
