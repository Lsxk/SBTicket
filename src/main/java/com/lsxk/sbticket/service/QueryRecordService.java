package com.lsxk.sbticket.service;

import com.lsxk.sbticket.entity.QueryRecord;

/**
 * Created by wjz on 2018/3/30.
 */
public interface QueryRecordService {
    /**
     * 添加记录
     * @param queryRecord 记录
     * @return 1为成功
     */
    int addRecord(QueryRecord queryRecord);
}
