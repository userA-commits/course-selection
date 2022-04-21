package com.graduation.demo.service.impl;

import com.graduation.demo.entity.CoursePlan;
import com.graduation.demo.mapper.CoursePlanMapper;
import com.graduation.demo.service.CoursePlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.demo.vo.business.CoursePlanVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-12
 */
@Service
public class CoursePlanServiceImpl extends ServiceImpl<CoursePlanMapper, CoursePlan> implements CoursePlanService {

    @Override
    public List<CoursePlanVo> getCoursePlanVo() {
        return this.getBaseMapper().getCoursePlanVo();
    }

    @Override
    public List<CoursePlanVo> getCoursePlanVoWithCond(CoursePlan coursePlan) {
        return this.getBaseMapper().getCoursePlanVoWithCond(coursePlan);
    }
}
