package com.xj.iws.http.service.impl;

import com.xj.iws.http.dao.RoleDao;
import com.xj.iws.http.entity.RoleEntity;
import com.xj.iws.common.enums.CallStatusEnum;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.entity.RoleSubEntity;
import com.xj.iws.http.service.RoleService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/3/10.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public DataWrapper<Void> add(RoleEntity roleEntity, List<RoleSubEntity> subitem) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int roleId = roleDao.getNextId();

        int i = roleDao.addRole(roleEntity);
        int j = roleDao.addSub(roleId,subitem);
        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int roleId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int i = roleDao.deleteSub(roleId,0);
        int j = roleDao.deleteRole(roleId);
        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> addSub(int roleId, RoleSubEntity subitem) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        List<RoleSubEntity> subitems = new ArrayList<RoleSubEntity>();
        subitems.add(subitem);
        int i = roleDao.addSub(roleId, subitems);
        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> deleteSub(int id) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = roleDao.deleteSub(0,id);
        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> update(RoleEntity roleEntity) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int i = roleDao.update(roleEntity);
        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<RoleEntity>> list() {
        DataWrapper<List<RoleEntity>> dataWrapper = new DataWrapper<List<RoleEntity>>();
        List<RoleEntity> roles = roleDao.list();
        for (RoleEntity role : roles) {
            role.setSubitem(roleDao.getSub(role.getId()));
        }
        if (roles == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }else {
            dataWrapper.setData(roles);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<RoleEntity> detail(int roleId) {
        DataWrapper<RoleEntity> dataWrapper = new DataWrapper<RoleEntity>();
        RoleEntity role = roleDao.detail(roleId);
        role.setSubitem(roleDao.getSub(roleId));
        dataWrapper.setData(role);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<RoleEntity>> query(Map<String, String> condition) {
        DataWrapper<List<RoleEntity>> dataWrapper = new DataWrapper<List<RoleEntity>>();
        List<RoleEntity> roles = roleDao.query(condition);
        //遍历roleId获取其名称和系统、地区、权限
        for (RoleEntity role : roles) {
            role.setSubitem(roleDao.getSub(role.getId()));
        }
        if (roles == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }else {
            dataWrapper.setData(roles);
        }
        return dataWrapper;
    }
}
