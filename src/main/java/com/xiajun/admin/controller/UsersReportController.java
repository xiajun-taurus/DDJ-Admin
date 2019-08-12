package com.xiajun.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiajun.admin.pojo.vo.Reports;
import com.xiajun.admin.service.impl.UsersReportServiceImpl;
import com.xiajun.admin.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 举报用户表 前端控制器
 * </p>
 *
 * @author xiajun
 * @since 2019-05-27
 */
@RestController
@RequestMapping("/users-report")
public class UsersReportController {

    @Autowired
    private UsersReportServiceImpl usersReportService;

    @PostMapping("list")
    public JSONResult list(Page<Reports> page){
        usersReportService.page(page);
        return JSONResult.ok(page);
    }

}

