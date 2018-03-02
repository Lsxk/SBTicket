package com.lsxk.sbticket.web;

import com.lsxk.sbticket.dto.TicketResult;
import com.lsxk.sbticket.entity.Path;
import com.lsxk.sbticket.entity.Ticket;
import com.lsxk.sbticket.service.PathService;
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
    private PathService pathService;

    @RequestMapping(value = "/{date}/{sourceSiteId}/{distSiteId}/query", method = RequestMethod.GET)
    @ResponseBody
    public TicketResult query(@PathVariable("date") String date, @PathVariable("sourceSiteId") long sourceSiteId,
                              @PathVariable("distSiteId") long distSiteId) {

        TicketResult<List<Ticket>> ticketResult;

        /** 查询路线
         * 先通过出发站点和目的站点查询线路列表
         * 再通过线路列表查询票列表
         * */
        try {
            List<Path> paths = pathService.getPathBySite(sourceSiteId, distSiteId);
            List<Long> pathIds = new ArrayList<Long>();
            for (Path path: paths) {
                pathIds.add(path.getPathId());
            }

            List<Ticket> tickets = ticketService.getTicketByPathIdAndDate(pathIds, date);

            ticketResult = new TicketResult<List<Ticket>>(true, tickets);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            ticketResult = new TicketResult<List<Ticket>>(false, e.getMessage());
        }

        return ticketResult;
    }

}
