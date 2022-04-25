package com.graduation.demo.controller.business;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.base.Clazz;
import com.graduation.demo.entity.base.Course;
import com.graduation.demo.entity.business.TeachCourse;
import com.graduation.demo.service.ClazzService;
import com.graduation.demo.service.CourseService;
import com.graduation.demo.service.TeachCourseService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.vo.business.TeachCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 授课管理前端控制器
 *
 * @author 王奥
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/teachCourse")
public class TeachCourseController {
    @Autowired
    TeachCourseService teachCourseService;
    @Autowired
    CourseService courseService;
    @Autowired
    ClazzService clazzService;

    @RequestMapping("/loadAllTeachCourse")
    public DataResult loadAllTeachCourse(TeachCourseVo teachCourseVo){
        //覆盖分页功能
        IPage<TeachCourseVo> page = new Page<>(teachCourseVo.getPage(), teachCourseVo.getLimit());
        //覆盖条件查询功能
        teachCourseService.loadAllTeachCourse(page, teachCourseVo);

        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addTeachCourse")
    public DataResult addTeachCourse(TeachCourseVo teachCourseVo){
        try{
            //插入授课需要条件：教师与课程在同学院
            if(!teachCourseService.isSameDept(teachCourseVo)) throw new Exception("添加失败;只允许为教师安排同学院的课程");
            //将教师编号、课程编号、班级编号联立设为授课编号
            teachCourseVo.setTeachCourseNo(teachCourseVo.getCourseNo()
                    + "." + teachCourseVo.getTeacherNo()
                    + "." + teachCourseVo.getClazzNo());
            //获得课程是否必修
            Course course = courseService.getOne(new QueryWrapper<Course>()
                    .select("is_required")
                    .eq("course_no", teachCourseVo.getCourseNo())
            );
            //获得班级人数
            Clazz clazz = clazzService.getOne(new QueryWrapper<Clazz>()
                    .select("student_num")
                    .eq("clazz_no", teachCourseVo.getClazzNo())
            );
            //如果课程为必修，将选择班级人数设为授课人数和上限人数
            if(course.getIsRequired() == 1){
                teachCourseVo.setStudentNum(clazz.getStudentNum());
                teachCourseVo.setUpperNum(clazz.getStudentNum());
            }
            //如果课程为选修，将选择班级人数设为零
            else{
                teachCourseVo.setStudentNum(0);
            }
            this.teachCourseService.saveRequired(teachCourseVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return DataResult.getResult(401, e.getMessage());
        }
    }

    @RequestMapping("/deleteTeachCourse")
    public DataResult deleteTeachCourse(String id){
        try{
            teachCourseService.removeRequired(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteTeachCourse")
    public DataResult batchDeleteTeachCourseList(TeachCourseVo teachCourseVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(teachCourseVo.getIds()));
            teachCourseService.removeRequired(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

}




