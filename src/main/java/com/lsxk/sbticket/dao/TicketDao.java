package com.lsxk.sbticket.dao;

import com.lsxk.sbticket.entity.Ticket;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * t_ticket表数据库交互层
 * Created by wjz on 2018/2/28.
 */
public interface TicketDao {

    Ticket queryById(long ticketId);

    /**
     * 通过日期查询
     * @param date 格式:yyyy-mm-dd
     * @return 票列表
     */
    List<Ticket> queryByDate(String date);

    /**
     * 根据站点id查询
     * @param sourId 出发站点id
     * @param distId 目的站点id
     * @return 票列表
     */
    List<Ticket> queryBySiteId(@Param("sourId") long sourId, @Param("distId") long distId);

    /**
     * 通过路线id和出发日期查询
     * @param sourId 出发站点id
     * @param distId 目的站点id
     * @param date 出发日期
     * @return 票列表
     */
    List<Ticket> queryBySiteIdAndDate(@Param("sourId") long sourId, @Param("distId") long distId, @Param("date") String date);

    /**
     * 通过路线id和出发日期查询
     * @param sourId 出发站点id
     * @param distId 目的站点id
     * @param date 出发日期
     * @param time 出发时间
     * @return 票列表
     */
    List<Ticket> queryBySiteIdAndDateAndTime(@Param("sourId") long sourId, @Param("distId") long distId,
                                             @Param("date") String date, @Param("time") String time);

    /**
     * 插入票
     * @param ticket 票
     * @return 1为插入成功
     */
    int insertTicket(Ticket ticket);

    /**
     * 减少票库存
     * @param ticketId 票id
     * @param count 数量
     * @return 1为成功
     */
    int reduceTicketNum(@Param("ticketId") long ticketId, @Param("count") int count);
}
