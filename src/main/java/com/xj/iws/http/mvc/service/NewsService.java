package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.NewsEntity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/7.
 */
public interface NewsService {
    DataWrapper<List<NewsEntity>> list();

    DataWrapper<Void> confirm(int newsId, int userId);
}
