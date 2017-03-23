package com.xj.iws.http.service;

import com.xj.iws.http.entity.RoomEntity;
import com.xj.iws.common.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
public interface RoomService {

    DataWrapper<Void> add(RoomEntity roomEntity);

    DataWrapper<Void> delete(int roomId);

    DataWrapper<Void> update(RoomEntity roomEntity);

    DataWrapper<RoomEntity> detail(int roomId);
}
