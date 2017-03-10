package com.xj.iws.service.impl;

import com.xj.iws.dao.RoleDao;
import com.xj.iws.entity.RoleEntity;
import com.xj.iws.entity.RoleType;
import com.xj.iws.enums.CallStatusEnum;
import com.xj.iws.enums.ErrorCodeEnum;
import com.xj.iws.service.RoleService;
import com.xj.iws.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/3/10.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public DataWrapper<Void> add(int[] systemId, int[] provinceId, int[] cityId, int[] areaId, int[] limitation, String name, String describes) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //获取roleId
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        long roleId = Long.parseLong(dateFormat.format(new Date()));

        int sign = 0;
        //遍历数组写入role
        for (int i = 0; i < systemId.length; i++) {

            RoleEntity roleEntity = new RoleEntity();

            roleEntity.setRoleId(roleId);
            roleEntity.setName(name);
            roleEntity.setSystemId(systemId[i]);
            roleEntity.setProvinceId(provinceId[i]);
            roleEntity.setCityId(cityId[i]);
            roleEntity.setAreaId(areaId[i]);
            roleEntity.setLimitation(limitation[i]);
            roleEntity.setDescribes(describes);

            int j = roleDao.add(roleEntity);
            sign += j;
        }

        if (sign == systemId.length) {
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(long roleId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        int sign = roleDao.delete(roleId);

        if (sign == 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> update(long roleId, int[] systemId, int[] provinceId, int[] cityId, int[] areaId, int[] limitation, String name, String describe) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //删除原有role
        roleDao.delete(roleId);

        int sign = 0;
        //遍历数组写入role
        for (int i = 0; i < systemId.length; i++) {

            RoleEntity roleEntity = new RoleEntity();

            roleEntity.setRoleId(roleId);
            roleEntity.setName(name);
            roleEntity.setSystemId(systemId[i]);
            roleEntity.setProvinceId(provinceId[i]);
            roleEntity.setCityId(cityId[i]);
            roleEntity.setAreaId(areaId[i]);
            roleEntity.setLimitation(limitation[i]);

            int j = roleDao.add(roleEntity);
            sign += j;
        }

        if (sign == systemId.length) {
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }


        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<RoleType>> list() {
        DataWrapper<List<RoleType>> dataWrapper = new DataWrapper<List<RoleType>>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        List<RoleType> roleTypes = new ArrayList<RoleType>();
        //获取所有roleId
        List<Long> roleIds = roleDao.qureyId(null);
        //遍历roleId获取其名称和管辖地区
        for (long roleId : roleIds) {
            RoleType roleType = new RoleType();
            roleType.setRoleId(roleId);
            roleType.setName(roleDao.name(roleId));
            roleType.setRole(roleDao.list(roleId));
            roleTypes.add(roleType);
        }
        if (roleTypes != null) {
            dataWrapper.setData(roleTypes);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<RoleType> detail(long roleId) {
        DataWrapper<RoleType> dataWrapper = new DataWrapper<RoleType>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //按roleId获取其名称和管辖地区
        RoleType roleType = new RoleType();
        roleType.setRoleId(roleId);
        roleType.setName(roleDao.name(roleId));
        roleType.setRole(roleDao.list(roleId));

        if (roleType != null) {
            dataWrapper.setData(roleType);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<RoleType>> query(String systemId, String provinceId, String cityId, String areaId, String limitation, String name) {
        DataWrapper<List<RoleType>> dataWrapper = new DataWrapper<List<RoleType>>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //创建查询条件
        Map<String, String> condition = new HashMap<String, String>();

        if (systemId != null && systemId != ""){
            condition.put("systemId", systemId);
        }
        if (areaId != null && areaId != "" && areaId != "0") {
            condition.put("areaId", areaId);
        } else if (cityId != null && cityId != "" && cityId != "0") {
            condition.put("cityId", cityId);
        } else if (provinceId != null && provinceId != "" && provinceId != "0") {
            condition.put("provinceId", provinceId);
        }
        if (limitation != null && limitation != ""){
            condition.put("limitation", limitation);
        }
        if (name != null && name != ""){
            condition.put("name", name);
        }

        List<RoleType> roleTypes = new ArrayList<RoleType>();
        //获取所有roleId
        List<Long> roleIds = roleDao.qureyId(condition);
        //遍历roleId获取其名称和管辖地区
        for (long roleId : roleIds) {
            RoleType roleType = new RoleType();
            roleType.setRoleId(roleId);
            roleType.setName(roleDao.name(roleId));
            roleType.setRole(roleDao.list(roleId));
            roleTypes.add(roleType);
        }
        if (roleTypes != null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }
}
