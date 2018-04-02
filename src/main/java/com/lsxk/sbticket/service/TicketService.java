package com.lsxk.sbticket.service;

import com.lsxk.sbticket.entity.Ticket;

import java.util.List;

/**
 * 车票接口
 * Created by wjz on 2018/2/28.
 */
public interface TicketService {

    /**
     * 根据班次id和出发时间查询票
     * @param busScheduleId 班次id
     * @param date 出发日期
     * @return 票列表
     */
    List<Ticket> getTicketByBusScheduleIdAndDate(List<Long> busScheduleId, String date);

    /**
     * 批量插入
     * @param tickets
     * @return
     */
    int addTicketList(List<Ticket> tickets);

    /**
     * 通过id查询票
     * @param ticketId 票id
     * @return
     */
    Ticket getTicketById(long ticketId);

    /**
     * 通过路线查询票
     * @param sourId 出发站id
     * @param distId 目的地id
     * @return
     */
    List<Ticket> getTicketBySiteId(long sourId, long distId);

    /**
     * 通过日期查询票
     * @param date 格式：yyyy-mm-dd
     * @return 票列表
     */
    List<Ticket> getTicketByDate(String date);

    /**
     * 通过路线和出发时间查询票
     * @param date 格式：yyyy-mm-dd
     * @param sourId 出发站id
     * @param distId 目的地id
     * @return 票列表
     */
    List<Ticket> getTicketBySiteIdAndDate(long sourId, long distId, String date);

    /**
     * 通过路线和出发时间查询票
     * @param sourId 出发站id
     * @param distId 目的地id
     * @param date 格式：yyyy-mm-dd
     * @param time 格式：hh:mm
     * @return 票列表
     */
    List<Ticket> getTicketBySiteIdAndDateAndTime(long sourId, long distId, String date, String time);

    /**
     * 新增票
     * @param ticket 票实体
     * @return 1为插入成功
     */
    int addTicket(Ticket ticket);

    /**
     * 减库存
     * @param ticketId 票id
     * @param count 数量
     * @return boolean
     */
    boolean reduceTicket(long ticketId, int count);
}
