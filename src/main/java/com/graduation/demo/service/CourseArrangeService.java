package com.graduation.demo.service;

import com.graduation.demo.entity.business.CourseArrange;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.demo.vo.business.CourseArrangeVo;

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
    List<CourseArrangeVo> getCourseArrangeVo();

    List<CourseArrangeVo> getCourseArrangeVoWithCond(CourseArrange courseArrange);

    CourseArrange addWithConflictCheck(CourseArrange courseArrange);

    CourseArrange haveConflict(CourseArrange courseArrange);

}
