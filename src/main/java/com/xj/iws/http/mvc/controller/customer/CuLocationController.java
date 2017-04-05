package com.xj.iws.http.mvc.controller.customer;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.LocationEntity;
import com.xj.iws.http.mvc.service.LocationService;
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
public class CuLocationController {

    @Autowired
    LocationService locationService;


    /**
     * 获取全部地点
     *
     * @return location
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<LocationEntity>> list(
            @RequestParam(value = "systemId", required = false)int systemId
    ) {
        return locationService.list(systemId);
    }
}
