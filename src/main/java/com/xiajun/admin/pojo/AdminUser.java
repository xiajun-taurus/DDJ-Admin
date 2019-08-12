package com.xiajun.admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminUser {
    private String usertoken;
    private String username;
    private String password;
}
