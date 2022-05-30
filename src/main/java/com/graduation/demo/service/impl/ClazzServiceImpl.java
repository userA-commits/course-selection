package com.graduation.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.graduation.demo.entity.base.Clazz;
import com.graduation.demo.entity.base.Student;
import com.graduation.demo.mapper.ClazzMapper;
import com.graduation.demo.service.ClazzService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.demo.service.StudentService;
import com.graduation.demo.vo.base.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-12
 */
@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {
    @Autowired
    StudentService studentService;

    @Override
    public void decreaseStudentNumByStuNo(String id) {
        Student student = studentService.getById(id);
        Clazz clazz = this.getOne(new QueryWrapper<Clazz>()
                .select("grade, student_num")
                .eq("clazz_no", student.getClazzNo())
        );
        this.update(new UpdateWrapper<Clazz>()
                .eq("clazz_no", student.getClazzNo())
                .set("student_num", clazz.getStudentNum()-1)
        );
    }

    @Override
    public void increaseStudentNumByStuNo(StudentVo studentVo) {
        Clazz clazz = this.getOne(new QueryWrapper<Clazz>()
                .select("grade, student_num")
                .eq("clazz_no", studentVo.getClazzNo())
        );
        this.update(new UpdateWrapper<Clazz>()
                .eq("clazz_no", studentVo.getClazzNo())
                .set("student_num", clazz.getStudentNum()+1)
        );
    }
}
