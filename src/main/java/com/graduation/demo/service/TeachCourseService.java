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
}
