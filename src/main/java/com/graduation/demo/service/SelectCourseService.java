package com.graduation.demo.service;

import com.graduation.demo.entity.CourseArrange;
import com.graduation.demo.entity.SelectCourse;
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
    List<SelectCourseVo> getSelectCourseVo();

    List<SelectCourseVo> getSelectCourseVoWithCond(SelectCourse selectCourse);

    String addWithCheck(SelectCourse selectCourse);

    boolean removeRequired(List<String> ids);

    boolean isSelectable(SelectCourse selectCourse);

    CourseArrange haveConflict(SelectCourse selectCourse);
}
