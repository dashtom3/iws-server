package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.NewsEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/11.
 */
@Repository
public interface NewsDao {

    List<NewsEntity> list(Map<String,String> condition);

    int confirm(@Param("newsId") int newsId,@Param("userId") int userId);

    int informUser(@Param("newsId") int newsId,@Param("userId") int userId);
}
