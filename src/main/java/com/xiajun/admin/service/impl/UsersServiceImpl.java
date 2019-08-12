package com.xiajun.admin.service.impl;

import com.xiajun.admin.pojo.Users;
import com.xiajun.admin.mapper.UsersMapper;
import com.xiajun.admin.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiajun
 * @since 2019-05-27
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
