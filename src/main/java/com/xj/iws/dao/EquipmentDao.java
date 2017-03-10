package com.xj.iws.dao;

import com.xj.iws.entity.EquipmentEntity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
public interface EquipmentDao {
    List<EquipmentEntity> equipments(int roomId);
}
