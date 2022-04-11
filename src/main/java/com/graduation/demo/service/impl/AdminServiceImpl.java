package com.graduation.demo.service.impl;

import com.graduation.demo.entity.Admin;
import com.graduation.demo.mapper.AdminMapper;
import com.graduation.demo.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
