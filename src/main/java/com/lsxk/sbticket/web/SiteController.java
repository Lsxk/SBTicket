package com.lsxk.sbticket.web;

import com.lsxk.sbticket.dto.TicketResult;
import com.lsxk.sbticket.entity.Site;
import com.lsxk.sbticket.service.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 站点相关的控制器
 * Created by wjz on 2018/3/5.
 */
@Controller
@RequestMapping("/site")
public class SiteController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SiteService siteService;

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public TicketResult<List<Site>> queryAll() {
        List<Site> sites;
        TicketResult<List<Site>> ticketResult;
        try {
            sites = siteService.getAllSite();
            ticketResult = new TicketResult(true, sites);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            ticketResult = new TicketResult<List<Site>>(false, e.getMessage());
        }

        return ticketResult;
    }
}
