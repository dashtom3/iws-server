package com.xj.iws.controller;

import com.xj.iws.entity.RoomEntity;
import com.xj.iws.service.RoomService;
import com.xj.iws.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
public class RoomController {
    @Autowired
    RoomService roomService;

    /**
     * 添加泵房
     *
     * @return boolean
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute RoomEntity roomEntity,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roomService.add(roomEntity);
    }

    /**
     * 删除泵房
     *
     * @return boolean
     */
    public DataWrapper<Void> delete(
            @RequestParam(value = "roomId", required = true) int roomId,
            @RequestParam(value = "token", required = true) String token

    ) {

        return roomService.delete(roomId);
    }

    /**
     * 编辑泵房
     *
     * @return boolean
     */
    public DataWrapper<Void> update(
            @ModelAttribute RoomEntity roomEntity,
            @RequestParam(value = "token", required = true) String token

    ) {

        return roomService.update(roomEntity);
    }

    /**
     * 获取某一泵房及泵房所属地点、泵房内所有控制器
     *
     * @return room
     */
    public DataWrapper<RoomEntity> detail(
            @RequestParam(value = "roomId", required = true) int roomId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roomService.detail(roomId);
    }
}
