package com.lsxk.sbticket.entity;

/**
 * 封装查询校车票记录
 * Created by wjz on 2018/3/30.
 */
public class QueryRecord {
    /** 记录id*/
    private long recordId;

    /** 出发站id*/
    private long sourId;

    /** 目的站id*/
    private long distId;

    /** 出发日期*/
    private String date;

    /** 出发时间*/
    private String time;

    /** 查询时间*/
    private String queryTime;

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public long getSourId() {
        return sourId;
    }

    public void setSourId(long sourId) {
        this.sourId = sourId;
    }

    public long getDistId() {
        return distId;
    }

    public void setDistId(long distId) {
        this.distId = distId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }

    @Override
    public String toString() {
        return "QueryRecord{" +
                "recordId=" + recordId +
                ", sourId=" + sourId +
                ", distId=" + distId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", queryTime='" + queryTime + '\'' +
                '}';
    }
}
