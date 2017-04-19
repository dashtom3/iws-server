package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.ViewDataEntity;
import com.xj.iws.http.mvc.service.DataService;
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
 * 管理全部数据请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/data")
public class DataController {

    /**
     *
     */
    @Autowired
    DataService dataService;

    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<ViewDataEntity>> query(
            @RequestParam(value = "deviceId", required = true) String deviceId,
            @RequestParam(value = "startTime", required = true) String startTime,
            @RequestParam(value = "endTime", required = true) String endTime,
            @RequestParam(value = "timeStep", required = true) String timeStep,
            @RequestParam(value = "token", required = true) String token
    ) {
        Map<String, String> conditions = new HashMap<String, String>();
        conditions.put("deviceId",deviceId);
        conditions.put("startTime",startTime);
        conditions.put("endTime",endTime);
        conditions.put("timeStep",timeStep);
        return dataService.query(conditions);
    }

    @RequestMapping(value = "presentData", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<ViewDataEntity> presentData(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "deviceId", required = true) String deviceId
    ) {
        return dataService.presentData(deviceId);
    }
}
