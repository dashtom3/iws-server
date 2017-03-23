package com.xj.iws.http.controller.manager;

import com.xj.iws.http.entity.RoleEntity;
import com.xj.iws.http.entity.RoleSubEntity;
import com.xj.iws.http.service.RoleService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute RoleEntity roleEntity,
            @ModelAttribute List<RoleSubEntity> subitems,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roleService.add(roleEntity, subitems);
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @param token
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "roleId", required = true) int roleId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roleService.delete(roleId);
    }

    /**
     * 添加角色权限
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "addsub", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> addSub(
            @RequestParam(value = "roleId", required = true) int roleId,
            @ModelAttribute RoleSubEntity subitem,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roleService.addSub(roleId, subitem);
    }

    /**
     * 删除角色权限
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "deletesub", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> deleteSub(
            @RequestParam(value = "subId", required = true) int subId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roleService.deleteSub(subId);
    }

    /**
     * 编辑角色
     *
     * @param roleEntity
     * @param token
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
            @ModelAttribute RoleEntity roleEntity,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roleService.update(roleEntity);
    }

    /**
     * 获取角色列表
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<RoleEntity>> list(
            @RequestParam(value = "token", required = true) String token
    ) {
        return roleService.list();
    }

    /**
     * 获取某一角色
     *
     * @param roleId
     * @param token
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<RoleEntity> detail(
            @RequestParam(value = "roleId", required = true) int roleId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roleService.detail(roleId);
    }

    /**
     * 查询角色
     *
     * @param systemId
     * @param areaId
     * @param limitation
     * @param name
     * @param token
     * @return
     */
    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<RoleEntity>> query(
            @RequestParam(value = "systemId", required = true) String systemId,
            @RequestParam(value = "areaId", required = false) String areaId,
            @RequestParam(value = "limitation", required = false) String limitation,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "token", required = true) String token
    ) {
        //创建查询条件
        Map<String, String> condition = new HashMap<String, String>();

        if (systemId != null && systemId != "") {
            condition.put("systemId", systemId);
        }
        if (areaId != null && areaId != "" && areaId != "0") {
            if ("00".equals(areaId.substring(4,6))){
                if ("0000".equals(areaId.substring(2,6))){
                    condition.put("provinceId",areaId);
                }else {
                    condition.put("cityId",areaId);
                }
            }else {
                condition.put("areaId",areaId);
            }
        }
        if (limitation != null && limitation != "") {
            condition.put("limitation", limitation);
        }
        if (name != null && name != "") {
            condition.put("name", name);
        }
        return roleService.query(condition);
    }
}
