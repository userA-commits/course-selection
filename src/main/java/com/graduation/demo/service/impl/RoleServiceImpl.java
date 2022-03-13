package com.graduation.demo.service.impl;

import com.graduation.demo.entity.Role;
import com.graduation.demo.mapper.RoleMapper;
import com.graduation.demo.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author 王奥
 * @since 2022-03-14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
