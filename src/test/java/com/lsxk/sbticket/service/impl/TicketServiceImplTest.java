package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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
    public void getTicketBySiteIdAndDate() throws Exception {


        List<Ticket> tickets = ticketService.getTicketBySiteIdAndDate(1000, 1001, "2018-04-03");

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
        List<Ticket> tickets = ticketService.getTicketBySiteIdAndDate(1000l, 1001l, "2018-02-28");

        for (Ticket ticket: tickets) {
            System.out.println(ticket);
        }
    }

    @Test
    public void getTicketByPathIdAndDateAndTime() throws Exception {
        List<Ticket> tickets = ticketService.getTicketBySiteIdAndDateAndTime(1000l, 1001l, "2018-03-30", "06:00");

        for (Ticket ticket: tickets) {
            System.out.println(ticket);
        }
    }
    @Test
    public void addTicket() throws Exception {

        Ticket ticket = new Ticket();
        ticket.setSourId(1000);
        ticket.setDistId(1001);
        ticket.setNum(40);
        ticket.setDate("2018-03-12");
        ticket.setTime("15:00");
        ticket.setDistance(10);
        ticket.setLasting(42);
        ticket.setPrice(4);

        Ticket ticket1 = new Ticket();
        ticket1.setSourId(1000);
        ticket1.setDistId(1001);
        ticket1.setNum(40);
        ticket1.setDate("2018-03-12");
        ticket1.setTime("17:00");
        ticket1.setDistance(10);
        ticket1.setLasting(42);
        ticket1.setPrice(4);

        ticketService.addTicket(ticket);
        ticketService.addTicket(ticket1);
    }

    @Test
    public void reduceTicket() {
        ticketService.reduceTicket(1061L, 1);
    }

}