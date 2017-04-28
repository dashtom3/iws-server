package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.data.DataProcess;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.NewsEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.LimitationService;
import com.xj.iws.http.mvc.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理全部消息请求
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/news")
public class UsNewsController {
    @Autowired
    NewsService newsService;
    @Autowired
    LimitationService limitationService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<NewsEntity>> list(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "systemId", required = false) String systemId
    ) {
        UserEntity user = SessionManager.getSession(token);
        Map<String, String> condition = new HashMap<String, String>();
        if (!limitationService.checkAdmin(user)) {
            condition.put("userId", String.valueOf(user.getId()));
        }
        condition.put("startTime", startTime);
        condition.put("endTime", startTime);
        condition.put("status", status);
        condition.put("systemId", systemId);
        return newsService.list(condition);
    }

    @RequestMapping(value = "confirm", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> confirm(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "newsId", required = true) int newsId
    ) {
        UserEntity user = SessionManager.getSession(token);
        return newsService.confirm(newsId, user.getId());
    }
}
