package com.xiajun.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiajun.admin.enums.VideoStatusEnum;
import com.xiajun.admin.pojo.UsersReport;
import com.xiajun.admin.pojo.Videos;
import com.xiajun.admin.pojo.vo.VideosVO;
import com.xiajun.admin.service.impl.UsersReportServiceImpl;
import com.xiajun.admin.service.impl.VideosServiceImpl;
import com.xiajun.admin.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 视频信息表 前端控制器
 * </p>
 *
 * @author xiajun
 * @since 2019-05-27
 */
@RestController
@RequestMapping("/videos")
public class VideosController {
    @Autowired
    private VideosServiceImpl videoService;
    @Autowired
    private UsersReportServiceImpl usersReportService;



    @PostMapping("/reportList")
    public IPage<UsersReport> reportList(IPage<UsersReport> page) {

        page = usersReportService.page(page);
        return page;
    }

    @PostMapping("/forbidVideo")
    public JSONResult forbidVideo(@RequestBody Videos videos) {
        videos.setStatus(VideoStatusEnum.FORBID.value);
        videoService.updateById(videos);
        QueryWrapper<UsersReport> wrapper = new QueryWrapper<>();
        wrapper.eq("deal_video_id",videos.getId());
        usersReportService.remove(wrapper);
        return JSONResult.ok();
    }

    @PostMapping(value="/list")
    public JSONResult showAll(Page<VideosVO> page) throws Exception {

        Page<VideosVO> allVideos = videoService.page(page);
        return JSONResult.ok(allVideos);
    }

}

