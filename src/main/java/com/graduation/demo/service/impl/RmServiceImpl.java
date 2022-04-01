package com.graduation.demo.service.impl;

import com.graduation.demo.entity.Rm;
import com.graduation.demo.mapper.RmMapper;
import com.graduation.demo.service.RmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author 王奥
 * @since 2022-04-01
 */
@Service
public class RmServiceImpl extends ServiceImpl<RmMapper, Rm> implements RmService {

}
