package com.lsxk.sbticket.dao;

import com.lsxk.sbticket.entity.Site;

/**
 * t_site数据库交互层
 * Created by wjz on 2018/2/28.
 */
public interface SiteDao {

    /**
     * 通过站点id查询
     * @param siteId id
     * @return 站点实体
     */
    Site queryBySiteId(long siteId);

    /**
     * 根据出发地和目的地查询
     * @param name 名字
     * @return 站点实体
     */
    Site queryByName(String name);

    /**
     * 新增站点
     * @param site 站点实体
     * @return 1为插入成功
     */
    int insertSite(Site site);
}
