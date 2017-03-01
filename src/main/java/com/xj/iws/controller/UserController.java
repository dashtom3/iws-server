package com.xj.iws.controller;

import com.xj.iws.service.UserService;
import com.xj.iws.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 管理全部用户请求
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     * @return boolean
     */
    public DataWrapper login(
            @RequestParam(value = "userName",required = true)String userName,
            @RequestParam(value = "name",required = true)String password

    ){

        return userService.login(userName,password);
    }

    /**
     * 用户注册
     * @return boolean
     */
    public DataWrapper register(
            @RequestParam(value = "userName",required = true)String userName,
            @RequestParam(value = "password",required = true)String password,
            @RequestParam(value = "name",required = true)String name

    ){

        return userService.register(userName,password,name);
    }

    /**
     * 查看个人资料
     * @return user
     */
    public DataWrapper detail(
            @RequestParam(value = "userId",required = true)String userId,
            @RequestParam(value = "token",required = true)String token
    ){

        return userService.detail(userId);
    }

    /**
     * 个人资料编辑
     * @return boolean
     */
    public DataWrapper update(
            @RequestParam(value = "userId",required = true)String userId,
            @RequestParam(value = "name",required = true)String name,
            @RequestParam(value = "pic",required = true)String pic,
            @RequestParam(value = "token",required = true)String token
    ){

        return userService.update(userId,name,pic);
    }
    /**
     * 重置密码
     * @return boolean
     */
    public DataWrapper updatePwd(
            @RequestParam(value = "userId",required = true)String userId,
            @RequestParam(value = "password",required = true)String password,
            @RequestParam(value = "token",required = true)String token
    ){

        return userService.updatePwd(userId,password);
    }
    /**
     * 退出登录
     * @return boolean
     */
    public DataWrapper reLogin(
            @RequestParam(value = "userId",required = true)String userId,
            @RequestParam(value = "token",required = true)String token
    ){

        return userService.reLogin(userId);
    }

}
