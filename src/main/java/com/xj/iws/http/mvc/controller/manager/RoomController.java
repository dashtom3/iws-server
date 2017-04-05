package com.xj.iws.http.mvc.controller.manager;

import com.xj.iws.http.mvc.entity.RoleEntity;
import com.xj.iws.http.mvc.entity.RoomEntity;
import com.xj.iws.http.mvc.service.RoomService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
@Controller
@RequestMapping("api/room")
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
    public DataWrapper<RoomEntity> add(
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
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
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
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<RoomEntity> update(
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
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<RoomEntity> detail(
            @RequestParam(value = "roomId", required = true) int roomId,
            @RequestParam(value = "token", required = true) String token
    ) {
        return roomService.detail(roomId);
    }
}
