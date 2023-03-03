package com.thesis.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thesis.server.pojo.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
public interface IUserService extends IService<User> {
    //登录之后返回token
    RespBean login(String username, String password, HttpServletRequest request);

//   根据用户名获取用户
    User getUserByUserName(String username);


}
