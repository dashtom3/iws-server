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
     * @return boolean
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute SystemEntity system,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.add(system);
    }

    /**
     * 删除系统
     * @return boolean
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "systemId",required = true) String systemId,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.delete(systemId);
    }

    /**
     * 编辑系统
     * @return boolean
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
            @RequestParam(value = "systemId",required = true) String systemId,
            @RequestParam(value = "name",required = true) String name,
            @RequestParam(value = "pic",required = true) String pic,
            @ModelAttribute SystemEntity system,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.update(system);
    }

    /**
     * 获取系统列表
     * @return system list
     */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<Map<String, String>>> list(
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.list();
    }

    /**
     * 获取详细信息
     * @param systemId
     * @param token
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Map<String,String>> detail(
            @RequestParam(value = "systemId",required = true) String systemId,
            @RequestParam(value = "token",required = true) String token
    ){
        return systemService.detail(systemId);
    }
}
