package com.lsxk.sbticket.web;

import com.lsxk.sbticket.dto.TicketDTO;
import com.lsxk.sbticket.dto.TicketResult;
import com.lsxk.sbticket.entity.QueryRecord;
import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.service.QueryRecordService;
import com.lsxk.sbticket.service.SiteService;
import com.lsxk.sbticket.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

/**
 * 校车票相关的控制器
 * Created by wjz on 2018/3/1.
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TicketService ticketService;
    @Autowired
    private SiteService siteService;
    @Autowired
    private QueryRecordService queryRecordService;

    @RequestMapping(value = "/{date}/{sourceSiteId}/{distSiteId}/query", method = RequestMethod.GET)
    @ResponseBody
    public TicketResult queryByDate(@PathVariable("date") String date, @PathVariable("sourceSiteId") long sourceSiteId,
                              @PathVariable("distSiteId") long distSiteId) {

        TicketResult<List<TicketDTO>> ticketResult;
        List<TicketDTO> ticketDTOS = new ArrayList<TicketDTO>();
        try {
            List<Ticket> tickets = ticketService.getTicketBySiteIdAndDate(sourceSiteId, distSiteId, date);
            filterTickets(ticketDTOS, tickets);
            if (ticketDTOS.size() > 0) {
                ticketResult = new TicketResult<List<TicketDTO>>(true, ticketDTOS);
            } else {
                ticketResult = new TicketResult<List<TicketDTO>>(false, "没有查询到班次");
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            ticketResult = new TicketResult<List<TicketDTO>>(false, e.getMessage());
        }

        return ticketResult;
    }



    @RequestMapping(value = "/{date}/{time}/{sourceSiteId}/{distSiteId}/query", method = RequestMethod.GET)
    @ResponseBody
    public TicketResult queryByDateAndTime(@PathVariable("date") String date, @PathVariable("time") String time, @PathVariable("sourceSiteId") long sourceSiteId,
                                    @PathVariable("distSiteId") long distSiteId) {

        // 添加查询记录
        QueryRecord queryRecord = new QueryRecord();
        queryRecord.setDate(date);
        queryRecord.setTime(time);
        queryRecord.setSourId(sourceSiteId);
        queryRecord.setDistId(distSiteId);
        queryRecord.setQueryTime(new java.text.SimpleDateFormat("yyyy-mm-dd hh:mm").format(new java.util.Date()));
        queryRecordService.addRecord(queryRecord);

        TicketResult<List<TicketDTO>> ticketResult;
        List<TicketDTO> ticketDTOS = new ArrayList<TicketDTO>();
        try {
            List<Ticket> tickets = ticketService.getTicketBySiteIdAndDateAndTime(sourceSiteId, distSiteId, date, time);
            filterTickets(ticketDTOS, tickets);
            if (ticketDTOS.size() > 0) {
                ticketResult = new TicketResult<List<TicketDTO>>(true, ticketDTOS);
            } else {
                ticketResult = new TicketResult<List<TicketDTO>>(false, "没有查询到班次");
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            ticketResult = new TicketResult<List<TicketDTO>>(false, e.getMessage());
        }

        return ticketResult;
    }

    private void filterTickets(List<TicketDTO> ticketDTOS, List<Ticket> tickets) {
        TicketDTO ticketDTO;
        for (Ticket ticket: tickets) {
            ticketDTO = new TicketDTO();
            if (ticket.getBalance() > 0) {
                ticketDTO.setTicketId(ticket.getTicketId());
                ticketDTO.setSourName(siteService.getSiteById(ticket.getSourId()).getName());
                ticketDTO.setDistName(siteService.getSiteById(ticket.getDistId()).getName());
                ticketDTO.setDate(ticket.getDate());
                ticketDTO.setTime(ticket.getTime());
                ticketDTO.setDistance(ticket.getDistance());
                ticketDTO.setLasting(ticket.getLasting());
                ticketDTO.setPrice(ticket.getPrice());
                ticketDTO.setBalance(ticket.getBalance());

                ticketDTOS.add(ticketDTO);
            }
        }
    }
}
