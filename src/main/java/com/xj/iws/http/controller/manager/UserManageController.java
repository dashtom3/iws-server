package com.xj.iws.http.controller.manager;

import com.xj.iws.common.sessionManager.AdminManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.entity.UserEntity;
import com.xj.iws.http.service.manager.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Controller
@RequestMapping("api/usermanage")
public class UserManageController {

    @Autowired
    UserManageService userManageService;

//    /**
//     * 获取用户列表
//     *
//     * @param token
//     * @return
//     */
//    @RequestMapping(value = "list", method = RequestMethod.POST)
//    @ResponseBody
//    public DataWrapper<List<UserEntity>> list(
//            @RequestParam(value = "token", required = true) String token
//    ) {
//        if (AdminManager.adminCheck(token)) {
//            return userManageService.list();
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * 获取用户列表
//     *
//     * @param token
//     * @return
//     */
//    @RequestMapping(value = "list", method = RequestMethod.POST)
//    @ResponseBody
//    public DataWrapper<List<UserEntity>> list(
//            @RequestParam(value = "token", required = true) String token
//    ) {
//        if (AdminManager.adminCheck(token)) {
//            return userManageService.list();
//        } else {
//            return null;
//        }
//    }
}
