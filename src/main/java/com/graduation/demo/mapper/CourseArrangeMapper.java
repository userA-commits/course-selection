package com.graduation.demo.mapper;

import com.graduation.demo.entity.business.CourseArrange;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.demo.vo.business.CourseArrangeVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王奥
 * @since 2022-04-11
 */
public interface CourseArrangeMapper extends BaseMapper<CourseArrange> {
    List<CourseArrangeVo> getCourseArrangeVo();

    List<CourseArrangeVo> getCourseArrangeVoWithCond(CourseArrange courseArrange);
}
