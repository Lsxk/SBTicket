package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.dao.TicketDao;
import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Ticket> getTicketByBusScheduleIdAndDate(List<Long> busScheduleId, String date) {
        List<Ticket> tickets = ticketDao.queryByBusScheduleIdAndDate(busScheduleId, date);
        return filterTickets(tickets);
    }

    public int addTicketList(List<Ticket> tickets) {
        return ticketDao.insertTicketList(tickets);
    }

    public Ticket getTicketById(long ticketId) {
        return ticketDao.queryById(ticketId);
    }

    public List<Ticket> getTicketBySiteId(long sourId, long distId) {
        return ticketDao.queryBySiteId(sourId, distId);
    }

    public List<Ticket> getTicketByDate(String date) {
        return ticketDao.queryByDate(date);
    }

    public List<Ticket> getTicketBySiteIdAndDate(long sourId, long distId, String date) {
        return ticketDao.queryBySiteIdAndDate(sourId, distId, date);
    }

    public List<Ticket> getTicketBySiteIdAndDateAndTime(long sourId, long distId, String date, String time) {
        return ticketDao.queryBySiteIdAndDateAndTime(sourId, distId, date, time);
    }

    public int addTicket(Ticket ticket) {
        return ticketDao.insertTicket(ticket);
    }

    public boolean reduceTicket(long ticketId, int count) {

        if (ticketDao.reduceTicketNum(ticketId, count) == 1) {
            return true;
        }

        return false;
    }


    private List<Ticket> filterTickets(List<Ticket> tickets) {
        List<Ticket> ticketList = new ArrayList<Ticket>();
        for (Ticket ticket: tickets) {
            if (ticket.getBalance() > 0) {
                ticketList.add(ticket);
            }
        }
        return ticketList;
    }
}
