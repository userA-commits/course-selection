package com.graduation.demo.controller.base;


import com.graduation.demo.entity.Role;
import com.graduation.demo.service.RoleService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色管理控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<Role> roles = roleService.list();
        DataResult<List<Role>> result = new DataResult<>(roles);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(Role role){
        roleService.save(role);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(Role role){
        roleService.updateById(role);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        roleService.removeByIds(ids);
        return DataResult.success();
    }
}



