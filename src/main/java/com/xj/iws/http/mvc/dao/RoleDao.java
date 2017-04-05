package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.RoleEntity;
import com.xj.iws.http.mvc.entity.RoleSubEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/10.
 */
@Repository
public interface RoleDao {

    int addRole(RoleEntity roleEntity);

    int addSub(@Param("roleId") int roleId, @Param("subitem") RoleSubEntity[] subitem);

    int deleteRole(int roleId);

    int deleteSub(@Param("roleId") int roleId,@Param("id") int id);

    int update(RoleEntity roleEntity);

    List<RoleEntity> list();

    RoleEntity detail(int roleId);

    List<RoleSubEntity> getSub(int id);

    List<RoleEntity> query(Map<String, String> condition);
}
