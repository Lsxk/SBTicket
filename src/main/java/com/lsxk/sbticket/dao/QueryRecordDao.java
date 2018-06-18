package com.lsxk.sbticket.dao;

import com.lsxk.sbticket.entity.QueryRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据站点ID查询记录
     * @param sourId
     * @param distId
     * @return 记录id
     */
    List<QueryRecord> queryRecord(@Param("sourId") long sourId, @Param("distId") long distId,
                                  @Param("startDate") String startDate, @Param("endDate") String endDate);
}
