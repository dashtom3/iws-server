package com.jiang.controller;

import com.jiang.entity.LocationEntity;
import com.jiang.entity.SystemEntity;
import com.jiang.service.LocationService;
import com.jiang.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 管理全部地点设置请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    /**
     * 添加地点
     *
     * @return boolean
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public DataWrapper add(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "positationX", required = true) String positationX,
            @RequestParam(value = "positationY", required = true) String positationY,
            @RequestParam(value = "positationId", required = true) String positationId,
            @RequestParam(value = "systemId", required = true) String systemId,
            @RequestParam(value = "blockId", required = true) String blockId,
            @RequestParam(value = "blockName", required = true) String blockName,
            @RequestParam(value = "token", required = true) String token

    ) {

        return locationService.add(new LocationEntity(null, name, positationX, positationY, positationId, systemId, blockId, blockName));
    }

    /**
     * 删除地点
     *
     * @return boolean
     */
    public DataWrapper delete(
            @RequestParam(value = "locationId", required = true) String locationId,
            @RequestParam(value = "token", required = true) String token

    ) {

        return locationService.delete(new LocationEntity(locationId));
    }

    /**
     * 编辑地点
     *
     * @return boolean
     */
    public DataWrapper update(
            @RequestParam(value = "locationId", required = true) String locationId,
            @RequestParam(value = "locationName", required = true) String locationName,
            @RequestParam(value = "systemId", required = true) String systemId,
            @RequestParam(value = "blockId", required = true) String blockId,
            @RequestParam(value = "blockName", required = true) String blockName,
            @RequestParam(value = "token", required = true) String token

    ) {

        return locationService.update(new LocationEntity(locationId,locationName,null,null,null,systemId,blockId,blockName));
    }

    /**
     * 获取地点列表
     *
     * @return location list
     */
    public DataWrapper list(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "positationId", required = true) String positationId,
            @RequestParam(value = "systemId", required = true) String systemId,
            @RequestParam(value = "token", required = true) String token
    ) {

        return locationService.list(new LocationEntity(null,name,null,null,positationId,systemId,null,null));
    }


    /**
     * 获取某一地点详情
     *
     * @return location
     */
    public DataWrapper detail(
            @RequestParam(value = "locationId", required = true) String locationId,
            @RequestParam(value = "token", required = true) String token

    ) {

        return locationService.detail(new LocationEntity(locationId));
    }

}
