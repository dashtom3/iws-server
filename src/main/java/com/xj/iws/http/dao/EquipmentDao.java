package com.xj.iws.http.dao;

import com.xj.iws.http.entity.EquipmentEntity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
public interface EquipmentDao {
    List<EquipmentEntity> equipments(int roomId);
}
