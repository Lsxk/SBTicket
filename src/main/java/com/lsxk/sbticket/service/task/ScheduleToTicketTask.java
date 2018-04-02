package com.lsxk.sbticket.service.task;

import com.lsxk.sbticket.entity.BusSchedule;
import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.exception.ParamException;
import com.lsxk.sbticket.service.BusScheduleService;
import com.lsxk.sbticket.service.TicketService;
import com.lsxk.sbticket.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 定时将班次加入票数据库
 * Created by wjz on 2018/4/2.
 */
@Component
public class ScheduleToTicketTask {

    @Autowired
    private BusScheduleService busScheduleService;
    @Autowired
    private TicketService ticketService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static int DAY_INTERVAL = 7;

    /**
     * 每天23点59启动任务
     */
    @Scheduled(cron = "0 59 23 ? * *")
    public void execute() {
        //查询班次
        String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        try {

            int dayForWeek = DateUtil.dayForWeek(date);

            List<BusSchedule> busSchedules = busScheduleService.getBusScheduleByDate(dayForWeek + "");
            if (busSchedules != null && busSchedules.size() > 0) {
                //插入7天后的票中
                List<Ticket> tickets = new ArrayList<Ticket>();
                for (BusSchedule busSchedule: busSchedules) {
                    Ticket ticket = new Ticket();
                    ticket.setNum(busSchedule.getNum());
                    ticket.setTime(busSchedule.getTime());
                    ticket.setSourId(busSchedule.getSourId());
                    ticket.setDistId(busSchedule.getDistId());
                    ticket.setDistance(busSchedule.getDistance());
                    ticket.setLasting(busSchedule.getLasting());
                    ticket.setPrice(busSchedule.getPrice());
                    ticket.setBusScheduleId(busSchedule.getBusScheduleId());
                    ticket.setDate(DateUtil.getFetureDate(date, DAY_INTERVAL));

                    tickets.add(ticket);
                }

                ticketService.addTicketList(tickets);

            }




        } catch (ParamException e) {
            logger.error("时间转化错误,位置：定时任务,参数：[" + date +"]");
            e.printStackTrace();
        }
    }
}
