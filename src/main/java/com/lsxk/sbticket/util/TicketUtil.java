package com.lsxk.sbticket.util;


import com.lsxk.sbticket.exception.ParamException;
import org.apache.commons.lang3.StringUtils;

/**
 * 票相关工具类
 * Created by wjz on 2018/3/2.
 */
public class TicketUtil {
    public static String generateGoodsName(String sourSiteName, String distSiteName) throws ParamException {
        if (StringUtils.isAnyBlank(sourSiteName, distSiteName)) {
            throw new ParamException("参数错误");
        }

        return sourSiteName + " - " + distSiteName + " 校车票";
    }
}
