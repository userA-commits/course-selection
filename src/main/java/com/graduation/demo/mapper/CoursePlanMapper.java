package com.graduation.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduation.demo.entity.business.CoursePlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.demo.vo.business.CoursePlanVo;
import org.apache.ibatis.annotations.Param;

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

    IPage<CoursePlanVo> loadAllCoursePlan(IPage<CoursePlanVo> page, @Param("cpv") CoursePlanVo coursePlanVo);
}
