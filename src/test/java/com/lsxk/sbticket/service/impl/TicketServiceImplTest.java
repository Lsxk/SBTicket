package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * TicketService测试类
 * Created by wjz on 2018/2/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class TicketServiceImplTest {

    @Autowired
    private TicketService ticketService;

    @Test
    public void getTicketByPathId() throws Exception {
        List<Ticket> tickets = ticketService.getTicketByPathId(1l);

        for (Ticket ticket: tickets) {
            System.out.println(ticket);
        }
    }

    @Test
    public void getTicketByDate() throws Exception {
        List<Ticket> tickets = ticketService.getTicketByDate("2018-02-28");

        for (Ticket ticket: tickets) {
            System.out.println(ticket);
        }
    }

    @Test
    public void getTicketByPathIdAndDate() throws Exception {
        List<Ticket> tickets = ticketService.getTicketByPathIdAndDate(1, "2018-02-28");

        for (Ticket ticket: tickets) {
            System.out.println(ticket);
        }
    }

    @Test
    public void addTicket() throws Exception {

        Ticket ticket = new Ticket();
        ticket.setPathId(1000);
        ticket.setNum(40);
        ticket.setDate("2018-02-29");
        ticket.setTime("06:00");
        ticket.setPrice(4);

        Ticket ticket1 = new Ticket();
        ticket1.setPathId(1001);
        ticket1.setNum(40);
        ticket1.setDate("2018-02-29");
        ticket1.setTime("13:00");
        ticket1.setPrice(4);

        ticketService.addTicket(ticket);
        ticketService.addTicket(ticket1);
    }

}