package com.graduation.demo.mapper;

import com.graduation.demo.entity.SelectCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.demo.vo.SelectCourseVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王奥
 * @since 2022-04-11
 */
public interface SelectCourseMapper extends BaseMapper<SelectCourse> {
    List<SelectCourseVo> getSelectCourseVo();

    List<SelectCourseVo> getSelectCourseVoWithCond(SelectCourse selectCourse);
}
