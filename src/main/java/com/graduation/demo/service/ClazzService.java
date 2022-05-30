package com.graduation.demo.service;

import com.graduation.demo.entity.base.Clazz;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.demo.vo.base.StudentVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-12
 */
public interface ClazzService extends IService<Clazz> {
    void decreaseStudentNumByStuNo(String id);
    void increaseStudentNumByStuNo(StudentVo studentVo);
}
