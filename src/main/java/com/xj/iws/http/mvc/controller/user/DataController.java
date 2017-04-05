package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.DataEntity;
import com.xj.iws.http.mvc.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 管理全部数据请求
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/data")
public class DataController {
    @Autowired
    DataService dataService;

//    /**
//     * 获取某控制器当前数据
//     * @param deviceId
//     * @param token
//     * @return
//     */
//    @RequestMapping("presentData")
//    @ResponseBody
//    public DataWrapper<DataEntity> presentData(
//            @RequestParam(value = "deviceId",required = true) int deviceId,
//            @RequestParam(value = "token",required = true) int token
//
//    ){
//        return dataService.presentData(deviceId);
//    }
}
