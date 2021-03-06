package com.graduation.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduation.demo.entity.business.CoursePlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.demo.vo.business.CoursePlanVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-12
 */
public interface CoursePlanService extends IService<CoursePlan> {

    IPage<CoursePlanVo> loadAllCoursePlan(IPage<CoursePlanVo> page, CoursePlanVo coursePlanVo);
}
