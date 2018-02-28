package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.dao.TicketDao;
import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TicketService实现类
 * Created by wjz on 2018/2/28.
 */
//TODO 应详细操作逻辑，并增加异常处理
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    public List<Ticket> getTicketByPathId(long pathId) {
        return ticketDao.queryByPathId(pathId);
    }

    public List<Ticket> getTicketByDate(String date) {
        return ticketDao.queryByDate(date);
    }

    public List<Ticket> getTicketByPathIdAndDate(long pathId, String date) {
        return ticketDao.queryByPathIdAndDate(pathId, date);
    }

    public int addTicket(Ticket ticket) {
        return ticketDao.insertTicket(ticket);
    }
}
