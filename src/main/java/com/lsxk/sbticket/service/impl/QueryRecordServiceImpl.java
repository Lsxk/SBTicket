package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.dao.QueryRecordDao;
import com.lsxk.sbticket.entity.QueryRecord;
import com.lsxk.sbticket.exception.ParamException;
import com.lsxk.sbticket.service.QueryRecordService;
import com.lsxk.sbticket.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    public List<QueryRecord> getQueryRecord(long sourId, long distId, int duration) throws ParamException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = format.format(new Date());
        String startDate;
        try {
            startDate = DateUtil.getDurationDate(endDate, 0 - duration);

        } catch (ParamException e) {
            throw new ParamException("时间格式错误");
        }

        return queryRecordDao.queryRecord(sourId, distId, startDate, endDate);
    }
}
