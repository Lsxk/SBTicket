package com.lsxk.sbticket.dao;

import com.lsxk.sbticket.entity.BusSchedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * t_bus_schedule数据库交互层
 * Created by wjz on 2018/4/1.
 */
public interface BusScheduleDao {

    /**
     * 通过路线id和出发日期查询
     * @param sourId 出发站点id
     * @param distId 目的站点id
     * @param date 出发日期
     * @return 班次列表
     */
    List<BusSchedule> queryBySiteIdAndDate(@Param("sourId") long sourId, @Param("distId") long distId, @Param("date") String date);

    /**
     * 通过路线id和出发日期查询
     * @param sourId 出发站点id
     * @param distId 目的站点id
     * @param date 出发日期
     * @param time 出发时间
     * @return 班次列表
     */
    List<BusSchedule> queryBySiteIdAndDateAndTime(@Param("sourId") long sourId, @Param("distId") long distId,
                                                  @Param("date") String date, @Param("time") String time);

    /**
     * 通过周几查询班次
     * @param date 1,2,3.。。。
     * @return 班次列表
     */
    List<BusSchedule> queryBusScheduleByDate(String date);

    /**
     * 查询全部班次
     * @return 班次列表
     */
    List<BusSchedule> queryBusSchedules();

    /**
     * 插入班次
     * @param busSchedule 班次
     * @return 1为插入成功
     */
    int insertBusSchedule(BusSchedule busSchedule);

    /**
     * 删除班次
     * @param busScheduleId id
     * @return
     */
    int deleteBusSchedule(long busScheduleId);

    /**
     * 更新班次
     * @param busSchedule
     * @return 1为更新成功
     */
    int updateBusSchedule(BusSchedule busSchedule);
}
