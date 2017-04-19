package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.NewsEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/11.
 */
@Repository
public interface NewsDao {

    List<NewsEntity> list();

    int confirm(@Param("newsId") int newsId,@Param("userId") int userId);
}
