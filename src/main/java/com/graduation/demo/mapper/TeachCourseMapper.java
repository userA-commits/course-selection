package com.graduation.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduation.demo.entity.business.TeachCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface TeachCourseMapper extends BaseMapper<TeachCourse> {
    IPage<TeachCourseVo> loadAllTeachCourse(IPage<TeachCourseVo> page, @Param("tcv")TeachCourseVo teachCourseVo);
}
