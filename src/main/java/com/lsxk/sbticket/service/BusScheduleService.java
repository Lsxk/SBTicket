package com.lsxk.sbticket.service;


import com.lsxk.sbticket.entity.BusSchedule;
import com.lsxk.sbticket.exception.ParamException;
import com.lsxk.sbticket.exception.SystemException;

import java.util.List;

/**
 * 班次接口
 * Created by wjz on 2018/4/1.
 */
public interface BusScheduleService {

    /**
     * 通过站点id和出发时间查询班次
     * @param date 区分班次类型的时间
     * @param sourId 出发站id
     * @param distId 目的地id
     * @return 班次列表
     */
    List<BusSchedule> getBusScheduleBySiteIdAndDate(long sourId, long distId, String date) throws SystemException;

    /**
     * 通过站点id和出发时间查询班次
     *
     * @param date   区分班次类型的时间
     * @param sourId 出发站id
     * @param distId 目的地id
     * @param time   出发时间
     * @return 班次列表
     */
    List<BusSchedule> getBusScheduleBySiteIdAndDateAndTime(long sourId, long distId, String date, String time) throws SystemException;

    /**
     * 根据周几查询班次
     * @param date 日期：1,2,3，。。。
     * @return 班次列表
     */
    List<BusSchedule> getBusScheduleByDate(String date);

    /**
     * 查出全部班次
     * @return 班次列表
     */
    List<BusSchedule> getBusSchedules();

    /**
     * 新增班次,同时增加一周的票
     * @param busSchedule 班次实体
     * @return 1为成功
     */
    int addBusSchedule(BusSchedule busSchedule) throws ParamException;


    /**
     * 删除班次
     * @param busScheduleId
     * @return
     */
    int deleteBusSchedule(long busScheduleId);

    /**
     * 修改班次
     * @param busSchedule 班次
     * @return 1为成功
     */
    int modifyBusSchedule(BusSchedule busSchedule);
}
