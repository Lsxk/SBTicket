package com.lsxk.sbticket.dao;

import com.lsxk.sbticket.entity.QueryRecord;

/**
 * t_queryOrder数据层
 * Created by wjz on 2018/3/30.
 */
public interface QueryRecordDao {

    /**
     * 插入记录
     * @param queryRecord 记录
     * @return 1为成功
     */
    int insertRecord(QueryRecord queryRecord);
}
