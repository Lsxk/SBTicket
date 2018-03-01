package com.lsxk.sbticket.dto;

/**
 * 封装json结果
 * Created by wjz on 2018/3/1.
 */
public class TicketResult<T> {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 返回结果
     */
    private T data;

    /**
     * 错误信息
     */
    private String error;

    public TicketResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public TicketResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "TicketResult{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
