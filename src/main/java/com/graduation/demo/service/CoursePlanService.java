package com.graduation.demo.service;

import com.graduation.demo.entity.CoursePlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.demo.entity.Student;
import com.graduation.demo.vo.CoursePlanVo;

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

    List<CoursePlanVo> getCoursePlanVoForStu(Student student);

    List<CoursePlanVo> getCoursePlanVoForAdm();
}
