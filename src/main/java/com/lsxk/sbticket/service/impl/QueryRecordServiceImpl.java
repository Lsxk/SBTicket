package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.dao.QueryRecordDao;
import com.lsxk.sbticket.entity.QueryRecord;
import com.lsxk.sbticket.service.QueryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wjz on 2018/3/30.
 */
@Service
public class QueryRecordServiceImpl implements QueryRecordService {


    @Autowired
    private QueryRecordDao queryRecordDao;

    public int addRecord(QueryRecord queryRecord) {
        return queryRecordDao.insertRecord(queryRecord);
    }
}
