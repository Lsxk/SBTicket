package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.dao.BusScheduleDao;
import com.lsxk.sbticket.entity.BusSchedule;
import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.exception.ParamException;
import com.lsxk.sbticket.exception.SystemException;
import com.lsxk.sbticket.service.BusScheduleService;
import com.lsxk.sbticket.service.TicketService;
import com.lsxk.sbticket.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjz on 2018/4/1.
 */
@Service
public class BusScheduleServiceImpl implements BusScheduleService {

    @Autowired
    private BusScheduleDao busScheduleDao;
    @Autowired
    private TicketService ticketService;

    private final static int DAY_INTERVAL = 7;

    public List<BusSchedule> getBusScheduleBySiteIdAndDate(long sourId, long distId, String date) throws SystemException {

        List<BusSchedule> busSchedules;
        try {

            int dayForWeek = DateUtil.dayForWeek(date);
            busSchedules = busScheduleDao.queryBySiteIdAndDate(sourId, distId, dayForWeek + "");
            busSchedules.addAll(busScheduleDao.queryBySiteIdAndDate(sourId, distId, date));

        } catch (ParamException e) {
            throw new ParamException(e.getMessage());
        } catch (Exception e) {
            throw new SystemException("系统错误");
        }


        return busSchedules;
    }

    public List<BusSchedule> getBusScheduleBySiteIdAndDateAndTime(long sourId, long distId, String date, String time) throws SystemException {
        List<BusSchedule> busSchedules;
        try {

            int dayForWeek = DateUtil.dayForWeek(date);
            busSchedules = busScheduleDao.queryBySiteIdAndDateAndTime(sourId, distId, dayForWeek + "", time);
            busSchedules.addAll(busScheduleDao.queryBySiteIdAndDateAndTime(sourId, distId, date, time));

        } catch (ParamException e) {
            throw new ParamException(e.getMessage());
        } catch (Exception e) {
            throw new SystemException("系统错误");
        }


        return busSchedules;
    }

    public List<BusSchedule> getBusScheduleByDate(String date) {
        return busScheduleDao.queryBusScheduleByDate(date);
    }

    public List<BusSchedule> getBusSchedules() {
        return busScheduleDao.queryBusSchedules();
    }

    public int addBusSchedule(BusSchedule busSchedule) throws ParamException {
        int num = busScheduleDao.insertBusSchedule(busSchedule);
        if (num == 1) {
            List<Ticket> ticketList = new ArrayList<Ticket>();
            // 固定班次
            if (busSchedule.getType() == 1) {
                String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(new java.util.Date());
                String dayDate = date.substring(0, 10);
                for (int i = 0; i < DAY_INTERVAL; i++) {
                    // 当天的出发时间大于现在时间，则插入
                    if (i == 0 && (!DateUtil.compareDate(dayDate + " " + busSchedule.getTime(), date))) {

                    } else {
                        Ticket ticket = new Ticket();
                        ticket.setNum(busSchedule.getNum());
                        ticket.setTime(busSchedule.getTime());
                        ticket.setSourId(busSchedule.getSourId());
                        ticket.setDistId(busSchedule.getDistId());
                        ticket.setDistance(busSchedule.getDistance());
                        ticket.setLasting(busSchedule.getLasting());
                        ticket.setPrice(busSchedule.getPrice());
                        ticket.setBusScheduleId(busSchedule.getBusScheduleId());
                        ticket.setDate(DateUtil.getDurationDate(date, i));

                        ticketList.add(ticket);
                    }
                }
            } else if (busSchedule.getType() == 2) {
                Ticket ticket = new Ticket();
                ticket.setNum(busSchedule.getNum());
                ticket.setTime(busSchedule.getTime());
                ticket.setSourId(busSchedule.getSourId());
                ticket.setDistId(busSchedule.getDistId());
                ticket.setDistance(busSchedule.getDistance());
                ticket.setLasting(busSchedule.getLasting());
                ticket.setPrice(busSchedule.getPrice());
                ticket.setBusScheduleId(busSchedule.getBusScheduleId());
                ticket.setDate(busSchedule.getDate());

                ticketList.add(ticket);
            }
            ticketService.addTicketList(ticketList);
        }

        return num;
    }

    public int deleteBusSchedule(long busScheduleId) {
        return busScheduleDao.deleteBusSchedule(busScheduleId);
    }

    public int modifyBusSchedule(BusSchedule busSchedule) {
        return busScheduleDao.updateBusSchedule(busSchedule);
    }
}
