package com.graduation.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.graduation.demo.entity.*;
import com.graduation.demo.mapper.TeachCourseMapper;
import com.graduation.demo.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.demo.vo.TeachCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    TeacherService teacherService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    @Lazy
    SelectCourseService selectCourseService;

    @Override
    public List<TeachCourseVo> getTeachCourseVo() {
        return this.getBaseMapper().getTeachCourseVo();
    }

    @Override
    public List<TeachCourseVo> getTeachCourseVoWithCond(TeachCourse teachCourse) {
        return this.getBaseMapper().getTeachCourseVoWithCond(teachCourse);
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

    @Override
    public boolean saveRequired(TeachCourse teachCourse) {
        //存储授课信息
        this.save(teachCourse);
        //获取授课班级学生列表
        List<Student> students = studentService.list(new QueryWrapper<Student>()
                .select("student_no")
                .eq("clazz_no", teachCourse.getClazzNo())
        );
        //存储学生选课信息
        SelectCourse selectCourse;
        for(Student student : students){
            selectCourse = new SelectCourse();
            selectCourse.setStudentNo(student.getStudentNo());
            selectCourse.setTeachCourseNo(teachCourse.getTeachCourseNo());
            //TODO:考虑一个可靠的学期生成方式
            selectCourse.setSemester(1);
            selectCourseService.save(selectCourse);
        }
        return true;
    }

    @Override
    public boolean removeRequired(List<String> ids) {
        //通过ids获得授课信息列表
        List<TeachCourse> teachCourses = (List<TeachCourse>) this.listByIds(ids);
        //通过授课信息列表中的授课编号删除对应的选课信息
        for(TeachCourse teachCourse : teachCourses){
            selectCourseService.remove(new UpdateWrapper<SelectCourse>()
                    .eq("teach_course_no", teachCourse.getTeachCourseNo())
            );
        }
        //删除授课信息
        this.removeByIds(ids);
        return false;
    }
}
