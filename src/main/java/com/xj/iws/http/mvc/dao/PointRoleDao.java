package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.PointRoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/27.
 */
@Repository
public interface PointRoleDao {

    List<PointRoleEntity> list();
}
