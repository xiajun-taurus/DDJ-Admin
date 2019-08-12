# 基于springboot的短视频后台管理

对应[基于springboot仿抖音微信小程序](https://github.com/JunXia0425/DDJ-Video)的管理员后台管理



## 账号密码

代码里写死，账号密码都是`admin`

**代码位置**

`com.xiajun.admin.controller`包内`UsersController`类第64行

```java
 if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return JSONResult.errorMap("用户名和密码不能为空");
   //账号密码测试写死，均为admin
        } else if (username.equals("admin") && password.equals("admin")) {

            String token = UUID.randomUUID().toString();
            AdminUser adminUser = new AdminUser(username, password, token);
            request.getSession().setAttribute("sessionUser", adminUser);
            return JSONResult.ok();
        }
```



## 相关链接

[微信小程序](https://github.com/JunXia0425/DDJ)

[小程序后端](https://github.com/JunXia0425/DDJ-Video)

[管理平台后端](https://github.com/JunXia0425/DDJ-Admin)

[管理平台前端](https://github.com/JunXia0425/VideoManage)

