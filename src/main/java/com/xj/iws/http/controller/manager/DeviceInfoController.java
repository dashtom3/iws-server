package com.xj.iws.http.controller.manager;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.entity.DeviceInfoEntity;
import com.xj.iws.http.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Controller
@RequestMapping("api/deviceinfo")
public class DeviceInfoController {

    @Autowired
    DeviceInfoService deviceInfoService;

    /**
     * 获取控制器信息列表
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<DeviceInfoEntity>> list(
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceInfoService.list();
    }

    /**
     * 编辑控制器信息
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
//            @RequestParam(value = "name", required = false) String name,
//            @RequestParam(value = "pic", required = false) String pic,
//            @RequestParam(value = "describes", required = false) String describes,
            @ModelAttribute DeviceInfoEntity deviceInfoEntity,
            @RequestParam(value = "token", required = true) String token
    ) {

        return deviceInfoService.update(deviceInfoEntity);
    }

}
