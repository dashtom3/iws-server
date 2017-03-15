package com.xj.iws.http.service.manager;

import com.xj.iws.http.entity.LocationEntity;
import com.xj.iws.http.entity.RoleEntity;
import com.xj.iws.http.entity.RoleType;
import com.xj.iws.http.entity.RoomEntity;
import com.xj.iws.common.utils.DataWrapper;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/10.
 */
public interface RoleService {

    DataWrapper<Void> add(int[] systemId, int[] provinceId, int[] cityId, int[] areaId, int[] limitation, String name, String describe);

    DataWrapper<Void> delete(String roleId);

    DataWrapper<Void> update(String roleId, int[] systemId, int[] provinceId, int[] cityId, int[] areaId, int[] limitation, String name, String describe);

    DataWrapper<List<RoleType>> list();

    DataWrapper<RoleType> detail(String roleId);

    DataWrapper<List<RoleType>> query(String systemId, String provinceId, String cityId, String areaId, String limitation, String name);
}
