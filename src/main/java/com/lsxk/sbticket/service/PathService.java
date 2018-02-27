package com.lsxk.sbticket.service;

import com.lsxk.sbticket.entity.Path;

import java.util.List;

/**
 * 路线接口类
 * Created by wjz on 2018/2/27.
 */
public interface PathService {
    /**
     * 查询所有路线
     * @return 路线列表
     */
    List<Path> getPathList();

    /**
     * 通过站点查询路线信息
     * @param sourceSiteId 起始站点id
     * @param distSiteId 目的地站点id
     * @return 站点列表
     */
    List<Path> getPathBySite(int sourceSiteId, int distSiteId);

    /**
     * 通过路线id查询路线
     * @param pathId 路线id
     * @return 路线对象
     */
    Path getPathById(int pathId);

    /**
     * 增加路线
     * @param path 路线
     * @return
     */
    int addPath(Path path);
}
