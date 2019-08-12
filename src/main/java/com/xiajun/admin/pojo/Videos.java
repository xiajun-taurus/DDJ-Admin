package com.xiajun.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 视频信息表
 * </p>
 *
 * @author xiajun
 * @since 2019-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Videos implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 发布者id
     */
    @TableField("user_id")
    private String userId;

    /**
     * 用户使用音频的信息
     */
    @TableField("audio_id")
    private String audioId;

    /**
     * 视频描述
     */
    @TableField("video_desc")
    private String videoDesc;

    /**
     * 视频存放的路径
     */
    @TableField("video_path")
    private String videoPath;

    /**
     * 视频秒数
     */
    @TableField("video_seconds")
    private Float videoSeconds;

    /**
     * 视频宽度
     */
    @TableField("video_width")
    private Integer videoWidth;

    /**
     * 视频高度
     */
    @TableField("video_height")
    private Integer videoHeight;

    /**
     * 视频封面图
     */
    @TableField("cover_path")
    private String coverPath;

    /**
     * 喜欢/赞美的数量
     */
    @TableField("like_counts")
    private Long likeCounts;

    /**
     * 视频状态：
1、发布成功
2、禁止播放，管理员操作
     */
    @TableField("status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


}
