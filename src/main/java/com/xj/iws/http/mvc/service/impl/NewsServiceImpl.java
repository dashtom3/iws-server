package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.dao.NewsDao;
import com.xj.iws.http.mvc.entity.NewsEntity;
import com.xj.iws.http.mvc.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/7.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;

    @Override
    public DataWrapper<List<NewsEntity>> list() {
        DataWrapper<List<NewsEntity>> dataWrapper = new DataWrapper<List<NewsEntity>>();
        List<NewsEntity> news = newsDao.list();
        dataWrapper.setData(news);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> confirm(int newsId, int userId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = newsDao.confirm(newsId,userId);
        if (i != 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }
}
