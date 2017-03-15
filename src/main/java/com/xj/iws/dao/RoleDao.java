package com.xj.iws.dao;

import com.xj.iws.entity.RoleEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/10.
 */
public interface RoleDao {

    int add(RoleEntity roleEntity);

    int delete(String roleId);

    String name(String roleId);

    List<RoleEntity> list(String roleId);

    List<String> queryId(Map<String, String> condition);
}
