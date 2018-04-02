package com.lsxk.sbticket.util;

import com.lsxk.sbticket.exception.ParamException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wjz on 2018/4/1.
 */
public class DateUtil {
    /**
     * 判断日期为周几
     * @param pTime 需判断的日期
     * @return 结果
     * @throws Exception
     */
    public static int dayForWeek(String pTime) throws ParamException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {

            c.setTime(format.parse(pTime));

        } catch (ParseException e) {
            throw new ParamException("日期格式错误");
        }

        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    /**
     * 得到未来几天的日期字符串
     * @param date yyyy-MM-dd
     * @param days 天数
     * @return yyyy-MM-dd
     */
    public static String getFetureDate(String date, int days) throws ParamException {
        String fetureDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(date));
            c.add(Calendar.DATE, days);
            fetureDate = format.format(c.getTime());
        } catch (ParseException e) {
            throw new ParamException("日期格式错误");
        }

        return fetureDate;
    }

    /**
     * 判断时间1是否大于大于时间2
     * @param date1 "yyyy-MM-dd HH:mm"
     * @param date2 "yyyy-MM-dd HH:mm"
     * @return true or false
     */
    public static boolean compareDate(String date1, String date2) throws ParamException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            if (format.parse(date1).getTime() > format.parse(date2).getTime()) {
                return true;
            }
        } catch (ParseException e) {
            throw new ParamException("日期格式错误");
        }
        return false;
    }
}
