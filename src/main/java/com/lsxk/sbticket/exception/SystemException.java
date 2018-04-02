package com.lsxk.sbticket.exception;

/**
 * 异常处理父类
 * Created by wjz on 2018/3/2.
 */
public class SystemException extends Exception {
    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
