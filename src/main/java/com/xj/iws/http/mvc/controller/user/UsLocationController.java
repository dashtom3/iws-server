package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.dao.RoleDao;
import com.xj.iws.http.mvc.entity.LocationEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.LimitationService;
import com.xj.iws.http.mvc.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 依据用户权限返回可操作地点
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/location")
public class UsLocationController {

    @Autowired
    LocationService locationService;
    @Autowired
    RoleDao roleDao;
    @Autowired
    LimitationService limitationService;


    /**
     * 获取可查看地点
     *
     * @return location
     */
    @RequestMapping(value = "lockedList", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<LocationEntity>> lockedList(
            @RequestParam(value = "systemId", required = true) int systemId,
            @RequestParam(value = "token", required = true) String token
    ) {
        DataWrapper<List<LocationEntity>> dataWrapper = new DataWrapper<List<LocationEntity>>();
        UserEntity user = SessionManager.getSession(token);

        // 查询用户是否为管理员
        if (limitationService.checkAdmin(user)){
            dataWrapper = locationService.list(systemId);
            //查询用户是否有该系统操作权限
        }else if (limitationService.checkSystem(user,systemId)){
            List<Map> conditions = new ArrayList<Map>();
            List<String> roleAreas = roleDao.getSubArea(user.getRoleId());
            for (String areaId : roleAreas) {
                Map<String, String> condition = new HashMap<String, String>();
                if (systemId != 0) {
                    condition.put("systemId", String.valueOf(systemId));
                }
                if (areaId != null && !"".equals(areaId)) {
                    if ("00".equals(areaId.substring(4, 6))) {
                        if ("0000".equals(areaId.substring(2, 6))) {
                            condition.put("provinceId", areaId);
                        } else {
                            condition.put("cityId", areaId);
                        }
                    } else {
                        condition.put("areaId", areaId);
                    }
                }
                conditions.add(condition);
            }
            dataWrapper = locationService.lockedList(conditions);
        }else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Limitation_error);
        }
        return dataWrapper;
    }
}
