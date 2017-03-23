package com.xj.iws.http.service;

import com.xj.iws.http.entity.RoleEntity;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.entity.RoleSubEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/10.
 */
public interface RoleService {

    DataWrapper<Void> add(RoleEntity roleEntity, List<RoleSubEntity> subitem);

    DataWrapper<Void> delete(int roleId);

    DataWrapper<Void> addSub(int roleId, RoleSubEntity subitem);

    DataWrapper<Void> deleteSub(int subId);

    DataWrapper<Void> update(RoleEntity roleEntity);

    DataWrapper<List<RoleEntity>> list();

    DataWrapper<RoleEntity> detail(int roleId);

    DataWrapper<List<RoleEntity>> query(Map<String, String> condition);
}
