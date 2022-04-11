package com.graduation.demo.controller.base;


import com.graduation.demo.entity.Menu;
import com.graduation.demo.service.MenuService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单管理控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<Menu> menus = menuService.list();
        DataResult<List<Menu>> result = new DataResult<>(menus);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(Menu menu){
        menuService.save(menu);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(Menu menu){
        menuService.updateById(menu);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        menuService.removeByIds(ids);
        return DataResult.success();
    }
}

