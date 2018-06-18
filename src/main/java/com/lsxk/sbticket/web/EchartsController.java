package com.lsxk.sbticket.web;
import com.lsxk.sbticket.dto.EchartsDTO;
import com.lsxk.sbticket.dto.TicketResult;
import com.lsxk.sbticket.entity.QueryRecord;
import com.lsxk.sbticket.service.QueryRecordService;
import com.lsxk.sbticket.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
/**
 * 处理前端查询Echarts表格请求
 * Created by wjz on 2018/4/6.
 */
@Controller
@RequestMapping(value = "/Echarts")
public class EchartsController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QueryRecordService queryRecordService;

    @RequestMapping(value = "/{sourId}/{distId}/{duration}/time", method = RequestMethod.GET)
    @ResponseBody
    public TicketResult<EchartsDTO> getEchartsByTime(@PathVariable("sourId") long sourId,
                                                     @PathVariable("distId") long distId,
                                                     @PathVariable("duration") int duration) {
        TicketResult<EchartsDTO> ticketResult;
        String[] categorys = new String[24];
        int[] value = new int[24];
        for (int i = 0; i < 24; i++) {
            if (i < 10) {
                categorys[i] = "0" + i + ":00-0" + i + ":59";
            } else {
                categorys[i] = i + ":00-" + i + ":59";
            }
        }
        try {
            List<QueryRecord> records = queryRecordService.getQueryRecord(sourId, distId, duration);
            if (records != null && records.size() > 0) {
                for (QueryRecord queryRecord: records) {
                    String time = queryRecord.getTime();
                    if (!time.equals("all")) {
                        value[Integer.valueOf(time.substring(0,2))] += 1;
                    }
                }

                ticketResult =  new TicketResult<EchartsDTO>(true, new EchartsDTO(categorys, value));
            } else {
                ticketResult =  new TicketResult<EchartsDTO>(false, "记录为空");
            }
        } catch (Exception e) {
            ticketResult = new TicketResult<EchartsDTO>(false, "系统错误");
            logger.error("请求错误");
        }
        return ticketResult;
    }

    @RequestMapping(value = "/{sourId}/{distId}/{duration}/week", method = RequestMethod.GET)
    @ResponseBody
    public TicketResult<EchartsDTO> getEchartsByWeek(@PathVariable("sourId") long sourId,
                                                     @PathVariable("distId") long distId,
                                                     @PathVariable("duration") int duration) {

        TicketResult<EchartsDTO> ticketResult;
        String[] categorys = {"周一", "周二", "周三", "周四", "周五", "周六", "周天"};
        int[] value = new int[7];
        try {
            List<QueryRecord> records = queryRecordService.getQueryRecord(sourId, distId, duration);
            if (records != null && records.size() > 0) {
                for (QueryRecord queryRecord: records) {
                    value[DateUtil.dayForWeek(queryRecord.getDate()) - 1] += 1;
                }
                ticketResult =  new TicketResult<EchartsDTO>(true, new EchartsDTO(categorys, value));
            } else {
                ticketResult =  new TicketResult<EchartsDTO>(false, "记录为空");
            }
        } catch (Exception e) {
            ticketResult = new TicketResult<EchartsDTO>(false, "系统错误");
            logger.error("请求错误");
        }
        return ticketResult;
    }
}
