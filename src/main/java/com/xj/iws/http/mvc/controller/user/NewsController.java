package com.xj.iws.http.mvc.controller.user;

import com.xj.iws.common.sessionManager.SessionManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.NewsEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 管理全部消息请求
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Controller
@RequestMapping("api/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<NewsEntity>> list(
            @RequestParam(value = "token", required = true) String token
    ) {
        return newsService.list();
    }

    @RequestMapping(value = "confirm", method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<Void> confirm(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "newsId", required = true) int newsId
    ) {
        UserEntity user = SessionManager.getSession(token);
        int userId = user.getId();
        return newsService.confirm(newsId,userId);
    }
}
