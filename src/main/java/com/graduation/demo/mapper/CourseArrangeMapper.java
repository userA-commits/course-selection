package com.graduation.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduation.demo.entity.business.CourseArrange;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.demo.vo.business.CourseArrangeVo;
import com.graduation.demo.vo.business.TeachCourseVo;
import org.apache.ibatis.annotations.Param;

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
    IPage<CourseArrangeVo> loadAllCourseArrange(IPage<CourseArrangeVo> page, @Param("cav")CourseArrangeVo teachCourseVo);
}
