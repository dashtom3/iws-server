package com.xj.iws.http.mvc.controller.customer;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.SystemEntity;
import com.xj.iws.http.mvc.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理全部系统请求
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/customer/system")
public class CuSystemController {

    @Autowired
    SystemService systemService;

    /**
     * 获取全部系统及系统下全部地点
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<SystemEntity>> list(){
        return systemService.list();
    }

    /**
     * 获取某一系统及系统下全部地点
     * @param systemId
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<SystemEntity> detail(
            @RequestParam(value = "systemId",required = true) int systemId
    ){
        return systemService.detail(systemId);
    }

    /**
     * 获取全部系统及系统下全部地点封装
     * @return
     */
    @RequestMapping(value = "listPack",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<SystemEntity>> listPack(){
        return systemService.listPack();
    }

    /**
     * 获取某一系统及系统下全部地点封装
     * @param systemId
     * @return
     */
    @RequestMapping(value = "detailPack",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<SystemEntity> detailPack(
            @RequestParam(value = "systemId",required = true) int systemId
    ){
        return systemService.detailPack(systemId);
    }
}
