package com.lsxk.sbticket.service;

import com.lsxk.sbticket.entity.QueryRecord;
import com.lsxk.sbticket.exception.ParamException;

import java.util.List;

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

    /**
     * 根据站点id查询记录
     * @param sourId
     * @param distId
     * @param duration
     * @return 记录列表
     */
    List<QueryRecord> getQueryRecord(long sourId, long distId, int duration) throws ParamException;
}
