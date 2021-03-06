package com.graduation.demo.service;

import com.graduation.demo.entity.base.Student;
import com.graduation.demo.entity.base.Teacher;
import com.graduation.demo.vo.business.CourseTableVo;
import com.graduation.demo.vo.business.TeachCourseVo;

import java.util.List;

public interface CourseTableService {
    List<CourseTableVo> getCourseTable();

    List<CourseTableVo> getCourseTableByTeachCourseList(List<TeachCourseVo> teachCourseVoList);
}
