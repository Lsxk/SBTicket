package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.dao.PathDao;
import com.lsxk.sbticket.entity.Path;
import com.lsxk.sbticket.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PathService实现类
 * Created by wjz on 2018/2/27.
 */

//TODO 应详细操作逻辑，并增加异常处理
@Service
public class PathServiceImpl implements PathService {

    @Autowired
    private PathDao pathDao;

    public List<Path> getPathList() {
        return pathDao.queryAll();
    }

    public List<Path> getPathBySite(int sourceSiteId, int distSiteId) {
        return pathDao.queryPathBySite(sourceSiteId, distSiteId);
    }

    public Path getPathById(int pathId) {
        return pathDao.queryById(pathId);
    }

    public int addPath(Path path) {
        return pathDao.insertPath(path);
    }
}
