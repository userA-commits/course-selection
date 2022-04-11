package com.graduation.demo;

import com.graduation.demo.service.AdminService;
import com.graduation.demo.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    RoleService roleService;
    @Test
    void test(){
        System.out.println(roleService.getPerms(1));
    }

}
