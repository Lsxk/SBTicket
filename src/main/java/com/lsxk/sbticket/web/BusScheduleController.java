package com.lsxk.sbticket.web;

import com.lsxk.sbticket.dto.BusScheduleDTO;
import com.lsxk.sbticket.dto.TicketResult;
import com.lsxk.sbticket.entity.BusSchedule;
import com.lsxk.sbticket.exception.ParamException;
import com.lsxk.sbticket.service.BusScheduleService;
import com.lsxk.sbticket.service.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 班次相关控制器
 * Created by wjz on 2018/4/2.
 */
@Controller
@RequestMapping("/busSchedule")
public class BusScheduleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusScheduleService busScheduleService;
    @Autowired
    private SiteService siteService;

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

    @RequestMapping(value = "/getBusSchedules", method = RequestMethod.GET)
    @ResponseBody
    public TicketResult<List<BusScheduleDTO>> getALL() {
        TicketResult<List<BusScheduleDTO>> ticketResult;
        try {
            List<BusSchedule> busSchedules = busScheduleService.getBusSchedules();

            if (busSchedules != null && busSchedules.size() > 0) {

                List<BusScheduleDTO> busScheduleDTOS = new ArrayList<BusScheduleDTO>();
                for (BusSchedule busSchedule : busSchedules) {
                    BusScheduleDTO busScheduleDTO = new BusScheduleDTO();
                    busScheduleDTO.setBusScheduleId(busSchedule.getBusScheduleId());
                    busScheduleDTO.setDistance(busSchedule.getDistance());
                    busScheduleDTO.setLasting(busSchedule.getLasting());
                    busScheduleDTO.setNum(busSchedule.getNum());
                    busScheduleDTO.setPrice(busSchedule.getPrice());
                    busScheduleDTO.setTime(busSchedule.getTime());
                    busScheduleDTO.setSourName(siteService.getSiteById(busSchedule.getSourId()).getName());
                    busScheduleDTO.setDistName(siteService.getSiteById(busSchedule.getDistId()).getName());
                    busScheduleDTO.setType(busSchedule.getType());
                    busScheduleDTO.setDate(busSchedule.getDate());
                    busScheduleDTOS.add(busScheduleDTO);
                }

                ticketResult = new TicketResult<List<BusScheduleDTO>>(true, busScheduleDTOS);
            } else {
                ticketResult = new TicketResult<List<BusScheduleDTO>>(false, "班次列表为空");
            }
        } catch (Exception e) {
            logger.error("系统错误");
            ticketResult = new TicketResult<List<BusScheduleDTO>>(false, "系统错误");
        }
        return ticketResult;
    }

    @RequestMapping(value = "/{busScheduleId}/delete", method = RequestMethod.GET)
    @ResponseBody
    public TicketResult delete(@PathVariable("busScheduleId") long busScheduleId) {
        TicketResult ticketResult;
        try {
            if (busScheduleService.deleteBusSchedule(busScheduleId) == 1) {
                ticketResult = new TicketResult(true, null);
            } else {
                ticketResult = new TicketResult(false, "系统中无此班次");
            }
        } catch (Exception e) {
            ticketResult = new TicketResult(false, "系统错误");
        }
        return ticketResult;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public TicketResult modifyBusSchedule(@ModelAttribute("form") BusSchedule busSchedule) {
        TicketResult ticketResult;
        if (busSchedule != null && busSchedule.getBusScheduleId() != 0) {
            try {
                int num = busScheduleService.modifyBusSchedule(busSchedule);
                if (num == 1) {
                    ticketResult = new TicketResult(true, "");
                } else {
                    ticketResult = new TicketResult(false, "修改失败");
                }
            } catch (Exception e) {
                ticketResult = new TicketResult(false, "参数错误");
            }
        } else {
            ticketResult = new TicketResult(false, "参数错误");
        }
        return ticketResult;
    }
}
