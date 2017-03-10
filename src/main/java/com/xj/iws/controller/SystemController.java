package com.xj.iws.controller;

import com.xj.iws.entity.SystemEntity;
import com.xj.iws.service.SystemService;
import com.xj.iws.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 管理全部系统请求
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/system")
public class SystemController {

    @Autowired
    SystemService systemService;

    /**
     * 添加系统
     * @param systemEntity
     * @param token
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute SystemEntity systemEntity,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.add(systemEntity);
    }

    /**
     * 删除系统
     * @param systemId
     * @param token
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "systemId",required = true) int systemId,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.delete(systemId);
    }

    /**
     * 编辑系统
     * @param systemEntity
     * @param token
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
            @ModelAttribute SystemEntity systemEntity,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.update(systemEntity);
    }

    /**
     * 获取全部系统及系统下全部地点
     * @param token
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<SystemEntity>> list(
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.list();
    }

    /**
     * 获取某一系统及系统下全部地点
     * @param systemId
     * @param token
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<SystemEntity> detail(
            @RequestParam(value = "systemId",required = true) int systemId,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.detail(systemId);
    }
}
