package com.graduation.demo.service;

import com.graduation.demo.entity.SelectCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.demo.vo.SelectCourseVo;

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

    boolean haveConflict(SelectCourse selectCourse);
}
