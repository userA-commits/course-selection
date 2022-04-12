package com.graduation.demo.service.impl;

import com.graduation.demo.entity.TeachCourse;
import com.graduation.demo.entity.Teacher;
import com.graduation.demo.mapper.TeachCourseMapper;
import com.graduation.demo.service.TeachCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.demo.vo.TeachCourseVo;
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
public class TeachCourseServiceImpl extends ServiceImpl<TeachCourseMapper, TeachCourse> implements TeachCourseService {
    @Autowired
    TeachCourseMapper teachCourseMapper;

    @Override
    public List<TeachCourseVo> getTeachCourseVoForAdm() {
        return teachCourseMapper.getTeachCourseVoForAdm();
    }

    @Override
    public List<TeachCourseVo> getTeachCourseVoForTea(Teacher teacher) {
        return teachCourseMapper.getTeachCourseVoForTea(teacher);
    }

    @Override
    public List<TeachCourseVo> getTeachCourseVoByNo(String teachCourseNo) {
        return teachCourseMapper.getTeachCourseVoByNo(teachCourseNo);
    }
}
