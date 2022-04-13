package com.graduation.demo.controller.business;


import com.graduation.demo.entity.Notice;
import com.graduation.demo.service.NoticeService;
import com.graduation.demo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 公告管理前端控制器
 *
 * @author 王奥
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @PostMapping("/index")
    public String index(){
        return "underinstruction";
    }

    @PostMapping("/query")
    public DataResult query(){
        List<Notice> notices = noticeService.list();
        DataResult<List<Notice>> result = new DataResult<>(notices);
        return result;
    }

    @PostMapping("/add")
    public DataResult add(Notice notice){
        noticeService.save(notice);
        return DataResult.success();
    }

    @PostMapping("/edit")
    public DataResult edit(Notice notice){
        noticeService.updateById(notice);
        return DataResult.success();
    }

    @PostMapping("/remove")
    public DataResult remove(List<String> ids){
        noticeService.removeByIds(ids);
        return DataResult.success();
    }
}


