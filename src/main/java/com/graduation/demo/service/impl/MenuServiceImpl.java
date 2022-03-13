package com.graduation.demo.service.impl;

import com.graduation.demo.entity.Menu;
import com.graduation.demo.mapper.MenuMapper;
import com.graduation.demo.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author 王奥
 * @since 2022-03-14
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
