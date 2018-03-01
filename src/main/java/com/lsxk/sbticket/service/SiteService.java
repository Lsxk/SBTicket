package com.lsxk.sbticket.service;

import com.lsxk.sbticket.entity.Site;

import java.util.List;

/**
 * 站点接口
 * Created by wjz on 2018/3/1.
 */
public interface SiteService {

    /**
     * 通过名字查询站点
     * @param name 名字
     * @return 站点列表
     */
    Site getSiteByName(String name);

    /**
     * 通过siteId查询站点
     * @param siteId 站点id
     * @return 站点
     */
    Site getSiteById(long siteId);

    /**
     * 通过校区查询站点
     * @param campus 校区
     * @return 站点列表
     */
    List<Site> getSiteByCampus(String campus);

    /**
     * 新增站点
     * @param site 站点
     * @return 1为新增成功
     */
    int addSite(Site site);
}
