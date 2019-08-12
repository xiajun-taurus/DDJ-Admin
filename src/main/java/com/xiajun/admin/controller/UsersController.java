package com.xiajun.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiajun.admin.pojo.AdminUser;
import com.xiajun.admin.pojo.Users;
import com.xiajun.admin.service.impl.UsersServiceImpl;
import com.xiajun.admin.utils.JSONResult;
import com.xiajun.admin.utils.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiajun
 * @since 2019-05-27
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersServiceImpl usersService;
    @Autowired
    private RedisOperator redisOperator;
    public static final String USER_REDIS_SESSION = "user-redis-session";

    @PostMapping("/list")
    public JSONResult list(Page<Users> page) {
        usersService.page(page);
        return JSONResult.ok(page);
    }

    @GetMapping("count")
    public JSONResult list() {
        List<Users> list = usersService.list();
        return JSONResult.ok(list.size());
    }

    @GetMapping("todayActive")
    public JSONResult listToday() {
        Set<String> keys = redisOperator.keys(USER_REDIS_SESSION + "*");
        return JSONResult.ok(keys.size());
    }

    @PostMapping("login")
    public JSONResult userLogin(@RequestBody Users user,
                                HttpServletRequest request, HttpServletResponse response) {
        String username = user.getUsername();
        String password = user.getPassword();
        // TODO 模拟登陆
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return JSONResult.errorMap("用户名和密码不能为空");
        } else if (username.equals("admin") && password.equals("admin")) {

            String token = UUID.randomUUID().toString();
            AdminUser adminUser = new AdminUser(username, password, token);
            request.getSession().setAttribute("sessionUser", adminUser);
            return JSONResult.ok();
        }

        return JSONResult.errorMsg("登陆失败，请重试...");
    }

    @GetMapping("/logout")
    public JSONResult logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("sessionUser");
        return JSONResult.ok("退出成功");
    }

}

