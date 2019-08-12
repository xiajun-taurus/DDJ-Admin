package com.xiajun.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiajun.admin.mapper.UsersReportMapperCustom;
import com.xiajun.admin.pojo.UsersReport;
import com.xiajun.admin.mapper.UsersReportMapper;
import com.xiajun.admin.pojo.vo.Reports;
import com.xiajun.admin.service.IUsersReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 举报用户表 服务实现类
 * </p>
 *
 * @author xiajun
 * @since 2019-05-27
 */
@Service
public class UsersReportServiceImpl extends ServiceImpl<UsersReportMapper, UsersReport> implements IUsersReportService {
    @Autowired
    private UsersReportMapperCustom custom;
    @Override
    public Page<Reports> page(Page<Reports> page) {
        return page.setRecords(custom.selectAllVideoReport());
    }
}
