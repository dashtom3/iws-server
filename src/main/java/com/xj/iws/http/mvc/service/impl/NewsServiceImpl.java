package com.xj.iws.http.mvc.service.impl;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.sessionManager.VerifyCodeManager;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.HttpUtil;
import com.xj.iws.http.mvc.dao.NewsDao;
import com.xj.iws.http.mvc.dao.UserDao;
import com.xj.iws.http.mvc.entity.NewsEntity;
import com.xj.iws.http.mvc.entity.UserEntity;
import com.xj.iws.http.mvc.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/7.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;
    @Autowired
    UserDao userDao;

    @Override
    public DataWrapper<List<NewsEntity>> list(Map<String,String> condition) {
        DataWrapper<List<NewsEntity>> dataWrapper = new DataWrapper<List<NewsEntity>>();
        List<NewsEntity> news = newsDao.list(condition);
        dataWrapper.setData(news);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> inform(int newsId, int userId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = newsDao.informUser(newsId,userId);
        UserEntity user = userDao.getUserById(userId);


        String phone = user.getUsername();
        String code = VerifyCodeManager.newPhoneCode(phone);
        HttpUtil httpUtil = new HttpUtil();
        boolean result = httpUtil.sendPhoneVerifyCode(code, phone);
        if (i != 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> confirm(int newsId, int userId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = newsDao.confirm(newsId,userId);
        return dataWrapper;
    }
}
