package com.graduation.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduation.demo.entity.base.Course;
import com.graduation.demo.entity.base.Student;
import com.graduation.demo.entity.base.Teacher;
import com.graduation.demo.entity.business.SelectCourse;
import com.graduation.demo.entity.business.TeachCourse;
import com.graduation.demo.mapper.TeachCourseMapper;
import com.graduation.demo.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.demo.utils.SemesterUtils;
import com.graduation.demo.vo.business.TeachCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
    TeacherService teacherService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    @Lazy
    SelectCourseService selectCourseService;

    @Override
    public IPage<TeachCourseVo> loadAllTeachCourse(IPage<TeachCourseVo> page, TeachCourseVo teachCourseVo) {
        return this.getBaseMapper().loadAllTeachCourse(page, teachCourseVo);
    }

    @Override
    public boolean isSameDept(TeachCourseVo teachCourseVo) {
        //获取教师学院编号
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper
                .select("dept_no")
                .eq("teacher_no", teachCourseVo.getTeacherNo());
        Teacher teacher = teacherService.getOne(teacherQueryWrapper);
        //获取课程学院编号
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper
                .select("dept_no")
                .eq("course_no", teachCourseVo.getCourseNo());
        Course course = courseService.getOne(courseQueryWrapper);
        //判断是否相同
        return teacher.getDeptNo().equals(course.getDeptNo());
    }

    @Override
    public boolean saveRequired(TeachCourseVo teachCourseVo) {
        //存储授课信息
        this.save(teachCourseVo);
        //获取授课班级学生列表
        List<Student> students = studentService.list(new QueryWrapper<Student>()
                .select("student_no", "grade")
                .eq("clazz_no", teachCourseVo.getClazzNo())
        );
        //存储学生选课信息
        SelectCourse selectCourse;
        for(Student student : students){
            selectCourse = new SelectCourse();
            selectCourse.setStudentNo(student.getStudentNo());
            selectCourse.setTeachCourseNo(teachCourseVo.getTeachCourseNo());
            //生成学期
            selectCourse.setSemester(SemesterUtils.getSemester(student.getGrade()));
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

    @Override
    public boolean removeRequired(String id) {
        //通过ids获得授课信息列表
        TeachCourse teachCourse = (TeachCourse) this.getById(id);
        //通过授课信息列表中的授课编号删除对应的选课信息
        selectCourseService.remove(new UpdateWrapper<SelectCourse>()
                .eq("teach_course_no", teachCourse.getTeachCourseNo())
        );
        //删除授课信息
        this.removeById(id);
        return false;
    }
}
