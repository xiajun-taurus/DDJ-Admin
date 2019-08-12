package com.xiajun.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiajun.admin.pojo.Videos;
import com.xiajun.admin.pojo.vo.VideosVO;

import java.util.List;

/**
 * <p>
 * 视频信息表 Mapper 接口
 * </p>
 *
 * @author xiajun
 * @since 2019-05-27
 */
public interface VideosMapper extends BaseMapper<Videos> {
    /**
     * @Description: 条件查询所有视频列表
     */
    public List<VideosVO> queryAllVideos(Page<VideosVO> page);


}
