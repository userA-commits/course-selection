package com.graduation.demo.service;

import com.graduation.demo.entity.TeachCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.demo.entity.Teacher;
import com.graduation.demo.vo.TeachCourseVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-11
 */
public interface TeachCourseService extends IService<TeachCourse> {
    List<TeachCourseVo> getTeachCourseVo();

    List<TeachCourseVo> getTeachCourseVoWithCond(TeachCourse teachCourse);
    //检查插入的授课信息中，教师是否与课程在同学院
    boolean isSameDept(TeachCourse teachCourse);
    //插入必修课授课信息同时插入对应学生选课信息
    boolean saveRequired(TeachCourse teachCourse);
    //删除必修课授课信息同时删除对应学生选课信息
    boolean removeRequired(List<String> ids);

}
