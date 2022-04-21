package com.graduation.demo.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统控制器
 *
 * @author 王奥
 * @since 2022-04-14
 */
@Controller
@RequestMapping("/sys")
public class SystemController {
    //跳转到登录界面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "system/index/login";
    }
    //跳转到系统框架界面
    @RequestMapping("/index")
    public String index() {
        return "system/index/index";
    }
    //加载主界面
    @RequestMapping("/toDesk")
    public String toDesk() {
        return "system/index/main";
    }
    //加载公告管理界面
    @RequestMapping("/toNotice")
    public String toNotice() {
        return "system/notice/noticeManager";
    }
}
