package com.xiajun.admin.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Reports {
    private String id;
    private String title;
    private String content;
    private Date createDate;
    
    private String dealUsername;

    private String dealVideoId;
    private String videoDesc;
    private String videoPath;
    private Integer status;

	@JsonFormat(pattern = "yyyy-MM-dd mm:HH:ss")
    private String submitUsername;


}