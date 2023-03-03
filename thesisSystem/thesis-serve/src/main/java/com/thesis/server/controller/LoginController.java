package com.thesis.server.controller;

import com.thesis.server.pojo.*;
import com.thesis.server.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

//登录
@RestController
@Api(tags = "LoginController")
public class LoginController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody UserLoginParam userLoginParam, HttpServletRequest request) {
        return userService.login(userLoginParam.getUsername(), userLoginParam.getPassword(), request);
    }

    @ApiOperation(value = "获取当前登录用户的信息")
    @GetMapping("/user/info")
    public User getUserInfo(Principal principal) {
        if (null == principal) {
            return null;
        }
        String username = principal.getName();
        User user = userService.getUserByUserName(username);
        user.setPassword(null);
        return user;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功！");
    }


}
