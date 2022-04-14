package com.graduation.demo.service.impl;

import com.graduation.demo.entity.SelectCourse;
import com.graduation.demo.mapper.SelectCourseMapper;
import com.graduation.demo.service.SelectCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.demo.vo.SelectCourseVo;
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
public class SelectCourseServiceImpl extends ServiceImpl<SelectCourseMapper, SelectCourse> implements SelectCourseService {


    @Override
    public List<SelectCourseVo> getSelectCourseVo() {
        return this.getBaseMapper().getSelectCourseVo();
    }

    @Override
    public List<SelectCourseVo> getSelectCourseVoWithCond(SelectCourse selectCourse) {
        return this.getBaseMapper().getSelectCourseVoWithCond(selectCourse);
    }

    //对选课信息进行冲突检测
    @Override
    public boolean haveConflict(SelectCourse selectCourse){
        //对学生课程安排进行检测
        return true;
    }
}
