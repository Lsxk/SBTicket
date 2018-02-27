package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.entity.Path;
import com.lsxk.sbticket.service.PathService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * PathService测试类
 * Created by wjz on 2018/2/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class PathServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PathService pathService;

    @Test
    public void getPathList() throws Exception {
        List<Path> paths = pathService.getPathList();

        for (Path path: paths) {
            System.out.println(path);
        }
    }

    @Test
    public void getPathBySite() throws Exception {
        List<Path> paths = pathService.getPathBySite(1, 2);

        for (Path path: paths) {
            System.out.println(path);
        }
    }

    @Test
    public void getPathById() throws Exception {
    }

    @Test
    public void addPath() throws Exception {
        Path path = new Path();
        path.setDistance(23);
        path.setTime(34);
        path.setSourceSiteId(1l);
        path.setDistSiteId(2l);

        int i = pathService.addPath(path);
        System.out.println(i);
    }

}