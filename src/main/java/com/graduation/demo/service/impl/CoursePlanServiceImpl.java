package com.graduation.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduation.demo.entity.business.CoursePlan;
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
    public IPage<CoursePlanVo> loadAllCoursePlan(IPage<CoursePlanVo> page, CoursePlanVo coursePlanVo) {
        return this.getBaseMapper().loadAllCoursePlan(page, coursePlanVo);
    }
}
