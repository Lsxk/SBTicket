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
     * 通过路线id查询
     * @param pathIds 路线id
     * @return 列表
     */
    List<Ticket> queryByPathId(List<Long> pathIds);

    /**
     * 通过路线id和出发日期查询
     * @param pathIds 路线id
     * @param date 出发日期
     * @return 票列表
     */
    List<Ticket> queryByPathIdAndDate(@Param("pathIds") List<Long> pathIds, @Param("date") String date);

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
