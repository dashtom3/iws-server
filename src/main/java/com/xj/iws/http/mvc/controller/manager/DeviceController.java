package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupEntity;
import com.xj.iws.http.mvc.service.DeviceService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 创建控制器组
     * @param deviceGroup
     * @param devices
     * @param token
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<DeviceGroupEntity> add(
            @ModelAttribute DeviceGroupEntity deviceGroup,
            @RequestBody DeviceEntity[] devices,
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceService.add(deviceGroup,devices);
    }

    /**
     * 删除控制器组
     * @param deviceGroupId
     * @param token
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "deviceGroupId", required = true) int deviceGroupId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceService.delete(deviceGroupId);
    }

    /**
     * 编辑控制器组
     * @param deviceGroup
     * @param token
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<DeviceEntity> update(
            @ModelAttribute DeviceGroupEntity deviceGroup,
            @RequestBody DeviceEntity[] devices,
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceService.update(deviceGroup,devices);
    }

    /**
     * 控制器列表
     * @param token
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<DeviceGroupEntity>> list(
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceService.groupList();
    }

    /**
     * 控制器组详情
     * @param groupId
     * @param token
     * @return
     */
    @RequestMapping(value = "groupDetail",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<DeviceGroupEntity> groupDetail(
            @RequestParam(value = "groupId", required = true) int groupId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceService.groupDetail(groupId);
    }

    /**
     * 控制器详情
     * @param deviceId
     * @param token
     * @return
     */
    @RequestMapping(value = "deviceDetail",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<DeviceEntity> deviceDetail(
            @RequestParam(value = "deviceId", required = true) int deviceId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceService.deviceDetail(deviceId);
    }

    /**
     * 控制器详情
     * @param groupId
     * @param token
     * @return
     */
    @RequestMapping(value = "enable",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> enable(
            @RequestParam(value = "groupId", required = true) int groupId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceService.enable(groupId);
    }

    /**
     * 开启串口
     *
     * @param com
     * @return
     */
    @RequestMapping(value = "start", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<String> start(
            @RequestParam(value = "com", required = true) String com,
            @RequestParam(value = "token", required = true) String token
    ) {
        return deviceService.start(com);
    }
}
