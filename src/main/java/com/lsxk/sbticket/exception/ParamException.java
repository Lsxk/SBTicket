package com.lsxk.sbticket.exception;

/**
 * 参数异常
 * Created by wjz on 2018/3/2.
 */
public class ParamException extends SystemException {
    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }
}
