package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.enums.CallStatusEnum;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.LimitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 查询用户系统权限
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/limitation")
public class LimitationController {

    @Autowired
    LimitationService limitationService;


    /**
     * 查询用户是否有该系统权限
     * @param systemId
     * @param token
     * @return
     */
    @RequestMapping(value = "checkSystem", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<Void> checkSystem(
            @RequestParam(value = "systemId", required = true) int systemId,
            @RequestParam(value = "token", required = true) String token
    ) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        UserEntity user = SessionManager.getSession(token);

        //用户是否为管理员
        if (!limitationService.checkAdmin(user)) {
            //用户是否有该系统权限
            if (!limitationService.checkSystem(user,systemId)) {
                dataWrapper.setErrorCode(ErrorCodeEnum.Limitation_error);
                dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
            }
        }
        return dataWrapper;
    }

    /**
     * 查询用户是否有该地区读/写权限
     * @param systemId
     * @param areaId
     * @param token
     * @return
     */
    @RequestMapping(value = "checkLimit", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<Void> checkWritable(
            @RequestParam(value = "systemId", required = true) int systemId,
            @RequestParam(value = "areaId", required = true) String areaId,
            @RequestParam(value = "writable", required = true) int writable,
            @RequestParam(value = "token", required = true) String token
    ) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        UserEntity user = SessionManager.getSession(token);

        //用户是否为管理员
        if (!limitationService.checkAdmin(user)) {
            //用户是否有该系统该地区相应权限 writable 0只读,1可写
            if (!limitationService.checkLimit(user,systemId,areaId,writable)) {
                dataWrapper.setErrorCode(ErrorCodeEnum.Limitation_error);
                dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
            }
        }
        return dataWrapper;
    }
}
