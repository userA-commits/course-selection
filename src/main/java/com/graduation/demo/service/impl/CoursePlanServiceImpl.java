package com.graduation.demo.service.impl;

import com.graduation.demo.entity.CoursePlan;
import com.graduation.demo.entity.Student;
import com.graduation.demo.mapper.CoursePlanMapper;
import com.graduation.demo.service.CoursePlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.demo.vo.CoursePlanVo;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    CoursePlanMapper coursePlanMapper;

    @Override
    public List<CoursePlanVo> getCoursePlanVoForStu(Student student) {
        return coursePlanMapper.getCoursePlanVoForStu(student);
    }

    @Override
    public List<CoursePlanVo> getCoursePlanVoForAdm() {
        return coursePlanMapper.getCoursePlanVoForAdm();
    }
}
