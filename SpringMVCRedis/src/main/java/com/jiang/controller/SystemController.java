package com.jiang.controller;

import com.jiang.entity.SystemEntity;
import com.jiang.service.SystemService;
import com.jiang.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public DataWrapper<Void> add(
            @RequestParam(value = "name",required = true) String name,
            @RequestParam(value = "pic",required = true) String pic,
            @RequestParam(value = "token",required = true) String token
    ){

        return systemService.add(new SystemEntity(null,name,pic));

    }
    /**
     * 删除系统
     * @return boolean
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public DataWrapper<Void> delete(
            @RequestParam(value = "id",required = true) String id,
            @RequestParam(value = "token",required = true) String token
    ){

        return systemService.delete(new SystemEntity(id,null,null));
    }
    /**
     * 编辑系统
     * @return boolean
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public DataWrapper<Void> update(
            @RequestParam(value = "systemId",required = true) String systemId,
            @RequestParam(value = "name",required = true) String name,
            @RequestParam(value = "pic",required = true) String pic,
            @RequestParam(value = "token",required = true) String token
    ){

        return systemService.update(new SystemEntity(systemId,name,pic));
    }
    /**
     * 获取系统列表
     * @return system list
     */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public DataWrapper<List<SystemEntity>> list(
            @RequestParam(value = "name",required = true) String name,
            @RequestParam(value = "token",required = true) String token
    ){

        return systemService.list(new SystemEntity(null,name,null));
    }
    /**
     * 获取某一系统详情
     * @return system
     */
    @RequestMapping(value = "detail",method = RequestMethod.POST)
    public DataWrapper<SystemEntity> detail(
            @RequestParam(value = "systemId",required = true) String systemId,
            @RequestParam(value = "token",required = true) String token
    ){

        return systemService.detail(new SystemEntity(systemId,null,null));
    }
}
