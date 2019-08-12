package com.xiajun.admin.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UsersVO {

    private String id;


    private String username;


    @JsonIgnore
    private String password;


    private String faceImage;


    private String nickname;


    private Integer fansCounts;


    private Integer followCounts;


    private Integer receiveLikeCounts;

    private String userToken;
    private boolean isFollow;
}
