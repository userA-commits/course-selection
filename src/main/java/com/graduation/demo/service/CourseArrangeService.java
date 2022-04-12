package com.graduation.demo.service;

import com.graduation.demo.entity.CourseArrange;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.demo.vo.CourseArrangeVo;

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
    List<CourseArrangeVo> getCourseArrangeVoForAdm();

    List<CourseArrangeVo> getCourseArrangeVoByNo(String teachCourseNo);

}
