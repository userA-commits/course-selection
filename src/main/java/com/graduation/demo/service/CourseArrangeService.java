package com.graduation.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduation.demo.entity.business.CourseArrange;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.demo.vo.business.CourseArrangeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-11
 */
public interface CourseArrangeService extends IService<CourseArrange> {

    IPage<CourseArrangeVo> loadAllCourseArrange(IPage<CourseArrangeVo> page, CourseArrangeVo teachCourseVo);

    boolean addWithConflictCheck(CourseArrange courseArrange) throws Exception;

    boolean haveConflict(CourseArrange courseArrange) throws Exception;

}
