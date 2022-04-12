package com.graduation.demo.service.impl;

import com.graduation.demo.entity.CourseArrange;
import com.graduation.demo.mapper.CourseArrangeMapper;
import com.graduation.demo.service.CourseArrangeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.demo.vo.CourseArrangeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-11
 */
@Service
public class CourseArrangeServiceImpl extends ServiceImpl<CourseArrangeMapper, CourseArrange> implements CourseArrangeService {
    @Autowired
    CourseArrangeMapper courseArrangeMapper;

    @Override
    public List<CourseArrangeVo> getCourseArrangeVoForAdm() {
        return courseArrangeMapper.getCourseArrangeVoForAdm();
    }

    @Override
    public List<CourseArrangeVo> getCourseArrangeVoByNo(String teachCourseNo) {
        return courseArrangeMapper.getCourseArrangeVoByNo(teachCourseNo);
    }
}
