package com.xj.iws.dao;

import com.xj.iws.entity.RoomEntity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
public interface RoomDao {
    int add(RoomEntity roomEntity);

    int delete(int roomId);

    int update(RoomEntity roomEntity);

    List<RoomEntity> list(int locationId);

    RoomEntity detail(int roomId);
}
