package com.xiajun.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiajun.admin.pojo.UsersReport;
import com.xiajun.admin.pojo.vo.Reports;

/**
 * <p>
 * 举报用户表 服务类
 * </p>
 *
 * @author xiajun
 * @since 2019-05-27
 */
public interface IUsersReportService extends IService<UsersReport> {

    Page<Reports> page(Page<Reports> page);

}
