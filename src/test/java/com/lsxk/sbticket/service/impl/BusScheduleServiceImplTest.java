package com.lsxk.sbticket.service.impl;

import com.lsxk.sbticket.entity.BusSchedule;
import com.lsxk.sbticket.exception.ParamException;
import com.lsxk.sbticket.service.BusScheduleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wjz on 2018/4/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class BusScheduleServiceImplTest {

    @Autowired
    private BusScheduleService busScheduleService;
    @Test
    public void getBusScheduleByDate() throws Exception {
        List<BusSchedule> busScheduleByDate = busScheduleService.getBusScheduleByDate("1");
        for (BusSchedule busSchedule : busScheduleByDate) {
            System.out.println(busSchedule);
        }
    }
    @Test
    public void addBusSchedule() throws ParamException {
        BusSchedule busSchedule = new BusSchedule();
        busSchedule.setDate("2018-04-03");
        busSchedule.setTime("14:30");
        busSchedule.setDistance(10);
        busSchedule.setLasting(40);
        busSchedule.setNum(44);
        busSchedule.setDistId(1001);
        busSchedule.setSourId(1000);
        busSchedule.setPrice(4);
        busSchedule.setType(2);

        busScheduleService.addBusSchedule(busSchedule);
    }

}