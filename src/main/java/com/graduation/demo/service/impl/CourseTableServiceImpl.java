package com.graduation.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.graduation.demo.entity.base.Student;
import com.graduation.demo.entity.base.Teacher;
import com.graduation.demo.entity.business.CourseArrange;
import com.graduation.demo.entity.business.SelectCourse;
import com.graduation.demo.entity.business.TeachCourse;
import com.graduation.demo.service.CourseArrangeService;
import com.graduation.demo.service.CourseTableService;
import com.graduation.demo.service.SelectCourseService;
import com.graduation.demo.service.TeachCourseService;
import com.graduation.demo.vo.business.CourseArrangeVo;
import com.graduation.demo.vo.business.CourseTableVo;
import com.graduation.demo.vo.business.TeachCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseTableServiceImpl implements CourseTableService {
    @Autowired
    @Lazy
    SelectCourseService selectCourseService;
    @Autowired
    @Lazy
    TeachCourseService teachCourseService;
    @Autowired
    @Lazy
    CourseArrangeService courseArrangeService;
    @Override
    public List<CourseTableVo>  getCourseTableForStu(Student student) {
//        //根据学生编号获得选课列表
//        List<SelectCourse> selectCourses = selectCourseService.list(new QueryWrapper<SelectCourse>()
//                .select("teach_course_no")
//                .eq("student_no", student.getStudentNo())
//        );
//        //从选课列表获取增广授课列表
//        List<TeachCourseVo> teachCourseVoList = new ArrayList<>();
//        for(SelectCourse selectCourse : selectCourses){
//            //创建授课信息
//            TeachCourse teachCourse = new TeachCourse();
//            //录入授课号
//            teachCourse.setTeachCourseNo(selectCourse.getTeachCourseNo());
//            //获取增广授课列表
//            teachCourseVoList.addAll(teachCourseService.getTeachCourseVoWithCond(teachCourse));
//        }
//        //由授课列表获取课表列表
//        return getCourseTableByTeachCourseList(teachCourseVoList);
        return null;
    }

    @Override
    public List<CourseTableVo>  getCourseTableForTea(Teacher teacher) {
//        //根据教师编号获得授课列表
//        TeachCourse teachCourse = new TeachCourse();
//        teachCourse.setTeacherNo(teacher.getTeacherNo());
//        List<TeachCourseVo> teachCourseVoList = teachCourseService.getTeachCourseVoWithCond(teachCourse);
//        //由授课列表获取课表列表
//        return getCourseTableByTeachCourseList(teachCourseVoList);
        return null;
    }

    //根据授课列表获取排课信息并填入课表实体
    @Override
    public List<CourseTableVo>  getCourseTableByTeachCourseList(List<TeachCourseVo> teachCourseVoList) {
        List<CourseTableVo> result = new ArrayList<>();

        for(TeachCourseVo teachCourseVo : teachCourseVoList){
            //遍历授课列表，通过授课号查询对应排课
            CourseArrange courseArrange = new CourseArrange();
            courseArrange.setTeachCourseNo(teachCourseVo.getTeachCourseNo());
            List<CourseArrangeVo> courseArrangeVos = courseArrangeService.getCourseArrangeVoWithCond(courseArrange);
            //将得到的排课信息同授课信息填入课表实体中，并加入结果列表
            for(CourseArrangeVo courseArrangeVo : courseArrangeVos){
                CourseTableVo courseTableVo = new CourseTableVo(teachCourseVo, courseArrangeVo);
                result.add(courseTableVo);
            }
        }
        return result;
    }
}
