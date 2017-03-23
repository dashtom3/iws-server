package com.xj.iws.http.dao;

import com.xj.iws.http.entity.RoleEntity;
import com.xj.iws.http.entity.RoleSubEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/10.
 */
@Repository
public interface RoleDao {

    int getNextId();

    int addRole(RoleEntity roleEntity);

    int addSub(@Param("roleId") int roleId, @Param("subitem") List<RoleSubEntity> subitem);

    int deleteRole(int roleId);

    int deleteSub(@Param("roleId") int roleId,@Param("id") int id);

    int update(RoleEntity roleEntity);

    List<RoleEntity> list();

    List<RoleSubEntity> getSub(int id);

    RoleEntity detail(int roleId);

    List<RoleEntity> query(Map<String, String> condition);
}
