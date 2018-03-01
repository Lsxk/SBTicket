package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.entity.Site;
import com.lsxk.sbticket.service.SiteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wjz on 2018/3/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SiteServiceImplTest {

    @Autowired
    private SiteService siteService;

    @Test
    public void getSiteByName() throws Exception {
        System.out.println(siteService.getSiteByName("望江校车站"));
    }

    @Test
    public void getSiteById() throws Exception {
        System.out.println(siteService.getSiteById(1001));
    }

    @Test
    public void getSiteByCampus() throws Exception {
        List<Site> sites = siteService.getSiteByCampus("华西");

        for (Site site: sites) {
            System.out.println(site);
        }
    }

    @Test
    public void addSite() throws Exception {
        Site site1 = new Site();
        site1.setName("江安校车站");
        site1.setCampus("江安");

        Site site2 = new Site();
        site2.setName("望江校车站");
        site2.setCampus("望江");

        Site site3 = new Site();
        site3.setName("华西校车站");
        site3.setCampus("华西");

        siteService.addSite(site1);
        siteService.addSite(site2);
        siteService.addSite(site3);
    }

}