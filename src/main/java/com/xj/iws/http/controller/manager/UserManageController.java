package com.xj.iws.http.controller.manager;

import com.xj.iws.common.sessionManager.AdminManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.entity.UserEntity;
import com.xj.iws.http.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Controller
@RequestMapping("api/usermanage")
public class UserManageController {

    @Autowired
    UserManageService userManageService;

    /**
     * 获取用户列表
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<UserEntity>> list(
            @RequestParam(value = "token", required = true) String token
    ) {
        return userManageService.list();
    }

    /**
     * 分配角色
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "role", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> role(
            @RequestParam(value = "userId", required = true) int userId,
            @RequestParam(value = "roleId", required = true) String roleId,
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        userEntity.setRoleId(roleId);
        return userManageService.role(userEntity);
    }

    /**
     * 修改用户状态
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "status", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> status(
            @RequestParam(value = "userId", required = true) int userId,
            @RequestParam(value = "status", required = true) int status,
            @RequestParam(value = "token", required = true) String token
    ) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        userEntity.setStatus(status);
        return userManageService.status(userEntity);
    }

    /**
     * 查询用户
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<UserEntity>> query(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "token", required = true) String token
    ) {
        Map<String, String> condition = new HashMap<String, String>();
        if (username != null && !username.equals("")) {
            condition.put("username", username);
        }
        if (name != null && !name.equals("")) {
            condition.put("name", name);
        }
        if (address != null && !address.equals("")) {
            condition.put("address", address);
        }
        return userManageService.query(condition);
    }
}
