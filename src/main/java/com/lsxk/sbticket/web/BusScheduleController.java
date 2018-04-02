package com.lsxk.sbticket.web;

import com.lsxk.sbticket.dto.TicketResult;
import com.lsxk.sbticket.entity.BusSchedule;
import com.lsxk.sbticket.exception.ParamException;
import com.lsxk.sbticket.service.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 班次相关控制器
 * Created by wjz on 2018/4/2.
 */
@Controller
@RequestMapping("/busSchedule")
public class BusScheduleController {

    @Autowired
    private BusScheduleService busScheduleService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public TicketResult addBusSchedule(@ModelAttribute("form") BusSchedule busSchedule) {
        TicketResult ticketResult;
        if (busSchedule != null) {
            try {

                int num = busScheduleService.addBusSchedule(busSchedule);
                if (num == 1) {
                    ticketResult = new TicketResult(true, "");
                } else {
                    ticketResult = new TicketResult(false, "数据库写入失败");
                }
            } catch (ParamException e) {
                ticketResult = new TicketResult(false, "参数错误");
            }
        } else {
            ticketResult = new TicketResult(false, "参数错误");
        }
        return ticketResult;
    }
}
