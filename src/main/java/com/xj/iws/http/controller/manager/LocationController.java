package com.xj.iws.http.controller.manager;

import com.xj.iws.http.entity.LocationEntity;
import com.xj.iws.http.service.manager.LocationService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute LocationEntity locationEntity,
            @RequestParam(value = "token", required = true) String token
    ) {
        return locationService.add(locationEntity);
    }

    /**
     * 删除地点
     *
     * @return boolean
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "locationId", required = true) int locationId,
            @RequestParam(value = "token", required = true) String token

    ) {

        return locationService.delete(locationId);
    }

    /**
     * 编辑地点
     *
     * @return boolean
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
            @ModelAttribute LocationEntity locationEntity,
            @RequestParam(value = "token", required = true) String token

    ) {

        return locationService.update(locationEntity);
    }

    /**
     * 获取某一地点及地点下全部泵房
     *
     * @return location
     */
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<LocationEntity> detail(
            @RequestParam(value = "locationId", required = true) int locationId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return locationService.detail(locationId);
    }

    /**
     * 条件查询,获取条件下全部地点
     * province,city,area中按一项查询，若同时存在则优先级为area,city,province
     *
     * @param systemId
     * @param provinceId
     * @param cityId
     * @param areaId
     * @param token
     * @return
     */
    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<LocationEntity>> query(
            @RequestParam(value = "systemId", required = false) String systemId,
            @RequestParam(value = "provinceId", required = false) String provinceId,
            @RequestParam(value = "cityId", required = false) String cityId,
            @RequestParam(value = "areaId", required = false) String areaId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return locationService.query(systemId,provinceId,cityId,areaId);
    }

}
