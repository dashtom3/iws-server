package com.xj.iws.http.controller.user;

import com.xj.iws.http.entity.UserEntity;
import com.xj.iws.http.service.user.UserService;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 管理全部用户请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     *
     * @return boolean
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<UserEntity> login(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password
    ) {
        return userService.login(username, password);
    }

    /**
     * 用户注册
     *
     * @return boolean
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<UserEntity> register(
            @ModelAttribute UserEntity user,
            @RequestParam(value = "code", required = true) String code
    ) {
        return userService.register(user, code);
    }

    //获取验证码
    @RequestMapping(value = "getVerifyCode")
    @ResponseBody
    public DataWrapper<Void> getVerifyCode(
            @RequestParam(value = "username", required = true) String username
    ) {
        return userService.getVerifyCode(username);
    }

    /**
     * 查看个人资料
     *
     * @return user
     */
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<UserEntity> detail(
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity user = SessionManager.getSession(token);
        int userId = user.getId();
        return userService.detail(userId);
    }

    /**
     * 个人资料编辑
     *
     * @return boolean
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<UserEntity> update(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "describes", required = false) String describes,
            @RequestParam(value = "pic", required = false) String pic,
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity user = SessionManager.getSession(token);
        user.setName(name);
        user.setDescribes(describes);
        user.setPic(pic);
        return userService.update(user);
    }

    /**
     * 修改密码
     *
     * @return boolean
     */
    @RequestMapping(value = "changePwd", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> changePwd(
            @RequestParam(value = "oldPwd", required = true) String oldPwd,
            @RequestParam(value = "newPwd", required = true) String newPwd,
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity user = SessionManager.getSession(token);
        int userId = user.getId();
        return userService.changePwd(userId, oldPwd, newPwd);
    }

    /**
     * 忘记密码
     *
     * @return boolean
     */
    @RequestMapping(value = "forgetPwd", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> forgetPwd(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "code", required = true) String code
    ) {
        return userService.forgetPwd(username, password, code);
    }

    /**
     * 退出登录
     *
     * @return boolean
     */
    @RequestMapping(value = "reLogin", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> reLogin(
            @RequestParam(value = "token", required = true) String token
    ) {
        return userService.reLogin(token);
    }

}
