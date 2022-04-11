package com.graduation.demo;

import com.graduation.demo.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    AdminService adminService;
    @Test
    void test(){
        System.out.println(adminService.getById("1"));
    }

}
