package com.xiajun.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiajun
 * @since 2019-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Users implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 我的头像，如果没有默认给一张
     */
    @TableField("face_image")
    private String faceImage;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 我的粉丝数量
     */
    @TableField("fans_counts")
    private Integer fansCounts;

    /**
     * 我关注的人总数
     */
    @TableField("follow_counts")
    private Integer followCounts;

    /**
     * 我接受到的赞美/收藏 的数量
     */
    @TableField("receive_like_counts")
    private Integer receiveLikeCounts;


}
