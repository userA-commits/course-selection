package com.graduation.demo.controller.system;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.demo.common.ActiveUser;
import com.graduation.demo.common.Constant;
import com.graduation.demo.entity.Notice;
import com.graduation.demo.service.NoticeService;
import com.graduation.demo.utils.DataResult;
import com.graduation.demo.utils.WEBUtils;
import com.graduation.demo.vo.system.NoticeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
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

    @RequestMapping("/loadAllNotice")
    public DataResult loadAllNotice(NoticeVo noticeVo){
        //覆盖分页功能
        IPage<Notice> page = new Page<>(noticeVo.getPage(), noticeVo.getLimit());
        //覆盖条件查询功能
        noticeService.page(page, new QueryWrapper<Notice>()
                .like(StringUtils.isNotBlank(noticeVo.getNoticeNo()), "notice_no", noticeVo.getNoticeNo())
                .like(StringUtils.isNotBlank(noticeVo.getNoticeTitle()), "notice_title", noticeVo.getNoticeTitle())
                .like(StringUtils.isNotBlank(noticeVo.getCreateBy()), "create_by", noticeVo.getCreateBy())
                .orderByDesc("notice_no")
        );
        return DataResult.success(page.getRecords());
    }

    @RequestMapping("/addNotice")
    public DataResult addNotice(NoticeVo noticeVo){
        try{
            ActiveUser user = (ActiveUser) WEBUtils.getSession().getAttribute("user");
            noticeVo.setCreateBy(user.getAdmin().getName());
            this.noticeService.save(noticeVo);
            return Constant.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.ADD_ERROR;
        }
    }

    @RequestMapping("/updateNotice")
    public DataResult updateNotice(NoticeVo noticeVo){
        try{
            ActiveUser user = (ActiveUser) WEBUtils.getSession().getAttribute("user");
            noticeVo.setCreateBy(user.getAdmin().getName());
            this.noticeService.updateById(noticeVo);
            return Constant.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.UPDATE_ERROR;
        }
    }

    @RequestMapping("/deleteNotice")
    public DataResult deleteNotice(String id){
        try{
            noticeService.removeById(id);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }

    @RequestMapping("/batchDeleteNotice")
    public DataResult batchDeleteNoticeList(NoticeVo noticeVo){
        try{
            List<String> ids = new ArrayList<>(Arrays.asList(noticeVo.getIds()));
            noticeService.removeByIds(ids);
            return Constant.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return Constant.DELETE_ERROR;
        }
    }
}


