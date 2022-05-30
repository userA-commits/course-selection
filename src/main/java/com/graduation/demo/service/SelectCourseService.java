package com.graduation.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduation.demo.entity.business.CourseArrange;
import com.graduation.demo.entity.business.SelectCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.demo.vo.business.SelectCourseVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-11
 */
public interface SelectCourseService extends IService<SelectCourse> {
    IPage<SelectCourseVo> loadAllSelectCourse(IPage<SelectCourseVo> page, SelectCourseVo selectCourseVo);

    String addWithCheck(SelectCourse selectCourse) throws Exception;

    boolean isSelectable(SelectCourse selectCourse) throws Exception;

    CourseArrange haveConflict(SelectCourse selectCourse) throws Exception;
}
