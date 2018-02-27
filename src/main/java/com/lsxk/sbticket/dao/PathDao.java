package com.lsxk.sbticket.dao;

import com.lsxk.sbticket.entity.Path;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * t_path表交互接口
 * Created by wjz on 2018/2/27.
 */
public interface PathDao {
    /**
     * 查询全部路线
     * @return 路线列表
     */
    List<Path> queryAll();

    /**
     * 通过站点id查询路线
     * @param sourceSiteId
     * @param distSiteId
     * @return
     */
    List<Path> queryPathBySite(@Param("sourceSiteId") long sourceSiteId, @Param("distSiteId") long distSiteId);

    /**
     * 通过路线id查询
     * @param pathId
     * @return
     */
    Path queryById(long pathId);

    /**
     * 插入路线
     * @param path
     * @return
     */
    int insertPath(Path path);
}
