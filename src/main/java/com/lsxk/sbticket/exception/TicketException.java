package com.lsxk.sbticket.exception;

/**
 * 异常处理父类
 * Created by wjz on 2018/3/2.
 */
public class TicketException extends Exception {
    public TicketException(String message) {
        super(message);
    }

    public TicketException(String message, Throwable cause) {
        super(message, cause);
    }
}
