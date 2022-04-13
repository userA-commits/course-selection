package com.graduation.demo.mapper;

import com.graduation.demo.entity.CoursePlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.demo.entity.Student;
import com.graduation.demo.vo.CoursePlanVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王奥
 * @since 2022-04-12
 */
public interface CoursePlanMapper extends BaseMapper<CoursePlan> {

    List<CoursePlanVo> getCoursePlanVo();

    List<CoursePlanVo> getCoursePlanVoWithCond(CoursePlan coursePlan);
}
