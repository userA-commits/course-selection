package com.graduation.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstPageController {
    @PostMapping("/index")
    public String firstPage(){
        return "index";
    }
}
