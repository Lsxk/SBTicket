package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.dao.SiteDao;
import com.lsxk.sbticket.entity.Site;
import com.lsxk.sbticket.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SiteService实现类
 * Created by wjz on 2018/3/1.
 */
//TODO 应详细操作逻辑，并增加异常处理
@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteDao siteDao;

    public Site getSiteByName(String name) {
        return siteDao.queryByName(name);
    }

    public Site getSiteById(long siteId) {
        return siteDao.queryBySiteId(siteId);
    }

    public List<Site> getSiteByCampus(String campus) {
        return siteDao.queryByCampus(campus);
    }

    public List<Site> getAllSite() {
        return siteDao.queryAll();
    }

    public int addSite(Site site) {
        return siteDao.insertSite(site);
    }
}
