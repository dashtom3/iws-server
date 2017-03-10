package com.xj.iws.controller;

import com.xj.iws.entity.RoleType;
import com.xj.iws.entity.RoleEntity;
import com.xj.iws.service.RoleService;
import com.xj.iws.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理全部角色请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 添加角色
     * @param systemId
     * @param provinceId
     * @param cityId
     * @param areaId
     * @param limitation
     * @param name
     * @param describe
     * @param token
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @RequestParam(value = "systemId" ,required = true) int[] systemId,
            @RequestParam(value = "provinceId" ,required = true) int[] provinceId,
            @RequestParam(value = "cityId" ,required = true) int[] cityId,
            @RequestParam(value = "areaId", required = true) int[] areaId,
            @RequestParam(value = "limitation" ,required = true) int[] limitation,
            @RequestParam(value = "name" ,required = true) String name,
            @RequestParam(value = "describe" ,required = false) String describe,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roleService.add(systemId,provinceId,cityId,areaId,limitation,name,describe);
    }

    /**
     * 删除角色
     * @param roleId
     * @param token
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "roleId",required = true) long roleId,
            @RequestParam(value = "token",required = true) String token
    ){
        return roleService.delete(roleId);
    }

    /**
     * 编辑角色
     * @param roleId
     * @param systemId
     * @param provinceId
     * @param cityId
     * @param areaId
     * @param limitation
     * @param name
     * @param describe
     * @param token
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
            @RequestParam(value = "roleId" ,required = true) long roleId,
            @RequestParam(value = "systemId" ,required = true) int[] systemId,
            @RequestParam(value = "provinceId" ,required = true) int[] provinceId,
            @RequestParam(value = "cityId" ,required = true) int[] cityId,
            @RequestParam(value = "areaId", required = true) int[] areaId,
            @RequestParam(value = "limitation" ,required = true) int[] limitation,
            @RequestParam(value = "name" ,required = true) String name,
            @RequestParam(value = "describe" ,required = false) String describe,
            @RequestParam(value = "token", required = true) String token
    ){
        return roleService.update(roleId,systemId,provinceId,cityId,areaId,limitation,name,describe);
    }

    /**
     * 获取角色列表
     * @param token
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<RoleType>> list(
            @RequestParam(value = "token",required = true) String token
    ){
        return roleService.list();
    }

    /**
     * 获取某一角色及角色下全部地点
     * @param roleId
     * @param token
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<RoleType> detail(
            @RequestParam(value = "roleId",required = true) long roleId,
            @RequestParam(value = "token",required = true) String token
    ){
        return roleService.detail(roleId);
    }

    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<RoleType>> query(
            @RequestParam(value = "systemId" ,required = true) String systemId,
            @RequestParam(value = "provinceId" ,required = false) String provinceId,
            @RequestParam(value = "cityId" ,required = false) String cityId,
            @RequestParam(value = "areaId", required = false) String areaId,
            @RequestParam(value = "limitation" ,required = false) String limitation,
            @RequestParam(value = "name" ,required = false) String name,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roleService.query(systemId,provinceId,cityId,areaId,limitation,name);
    }
}
