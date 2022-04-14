package com.graduation.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.demo.entity.Course;
import com.graduation.demo.entity.TeachCourse;
import com.graduation.demo.entity.Teacher;
import com.graduation.demo.mapper.TeachCourseMapper;
import com.graduation.demo.service.CourseService;
import com.graduation.demo.service.TeachCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.demo.service.TeacherService;
import com.graduation.demo.vo.TeachCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-11
 */
@Service
public class TeachCourseServiceImpl extends ServiceImpl<TeachCourseMapper, TeachCourse> implements TeachCourseService {
    @Autowired
    TeachCourseMapper teachCourseMapper;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;

    @Override
    public List<TeachCourseVo> getTeachCourseVo() {
        return teachCourseMapper.getTeachCourseVo();
    }

    @Override
    public List<TeachCourseVo> getTeachCourseVoWithCond(TeachCourse teachCourse) {
        return teachCourseMapper.getTeachCourseVoWithCond(teachCourse);
    }

    @Override
    public boolean isSameDept(TeachCourse teachCourse) {
        //获取教师学院编号
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper
                .select("dept_no")
                .eq("teacher_no", teachCourse.getTeacherNo());
        Teacher teacher = teacherService.getOne(teacherQueryWrapper);
        //获取课程学院编号
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper
                .select("dept_no")
                .eq("course_no", teachCourse.getCourseNo());
        Course course = courseService.getOne(courseQueryWrapper);
        //判断是否相同
        return teacher.getDeptNo().equals(course.getDeptNo());
    }

}
