package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.HikVisionEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.HikVisionService;
import com.xj.iws.http.mvc.service.LimitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api/hikvision")
public class UsHikVisionController {

    @Autowired
    HikVisionService hikVisionService;
    @Autowired
    LimitationService limitationService;

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<HikVisionEntity> detail(
            @RequestParam("token") String token,
            @RequestParam("id") int id
    ){
        return hikVisionService.detail(id);
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<HikVisionEntity>> list(
            @RequestParam("token") String token,
            @RequestParam(value = "areaId",required = false) String roomId
    ){
        UserEntity user = SessionManager.getSession(token);
        List<Limitation> limit = limitationService.getLimit(user);

        return hikVisionService.list(roomId,limit);
    }

    @RequestMapping(value = "query",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<HikVisionEntity>> query(
            @RequestParam("token") String token,
            @RequestParam(value = "areaId", required = false) String areaId,
            @RequestParam(value = "ip", required = false) String ip,
            @RequestParam(value = "name", required = false) String name,
            @ModelAttribute Page page
            ){
        Map<String,String> condition = new HashMap<String, String>();
        condition.put("areaId",areaId);
        condition.put("ip",ip);
        condition.put("name",name);
        return hikVisionService.query(condition,page);
    }
}
