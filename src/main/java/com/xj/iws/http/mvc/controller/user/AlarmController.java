package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.AlarmEntity;
import com.xj.iws.http.mvc.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 管理全部数据请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/alarm")
public class AlarmController {

    @Autowired
    AlarmService alarmService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<AlarmEntity>> list(
            @RequestParam(value = "token", required = true) String token
    ) {
        return alarmService.list();
    }
}
