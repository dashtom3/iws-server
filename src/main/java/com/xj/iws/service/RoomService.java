package com.xj.iws.service;

import com.xj.iws.entity.RoomEntity;
import com.xj.iws.utils.DataWrapper;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
public interface RoomService {

    DataWrapper<Void> add(RoomEntity roomEntity);

    DataWrapper<Void> delete(int roomId);

    DataWrapper<Void> update(RoomEntity roomEntity);

    DataWrapper<RoomEntity> detail(int roomId);
}
