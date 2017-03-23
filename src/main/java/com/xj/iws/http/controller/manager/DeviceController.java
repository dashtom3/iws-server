package com.xj.iws.http.controller.manager;

import com.xj.iws.http.service.DeviceService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 管理全部控制器请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    /**
     * 开启串口
     *
     * @param com
     * @return
     */
    @RequestMapping(value = "start", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> start(
            @RequestParam(value = "com", required = true) String com,
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceService.start(com);
    }
}
