package com.lsxk.sbticket.service;

import com.lsxk.sbticket.entity.Ticket;

import java.util.List;

/**
 * 车票接口
 * Created by wjz on 2018/2/28.
 */
public interface TicketService {

    /**
     * 通过路线查询票
     * @param pathIds 路线id
     * @return
     */
    List<Ticket> getTicketByPathId(List<Long> pathIds);

    /**
     * 通过日期查询票
     * @param date 格式：yyyy-mm-dd
     * @return 票列表
     */
    List<Ticket> getTicketByDate(String date);

    /**
     * 通过路线和出发时间查询票
     * @param date 格式：yyyy-mm-dd
     * @param pathIds 路线id
     * @return 票列表
     */
    List<Ticket> getTicketByPathIdAndDate(List<Long> pathIds, String date);

    /**
     * 新增票
     * @param ticket 票实体
     * @return 1为插入成功
     */
    int addTicket(Ticket ticket);
}
