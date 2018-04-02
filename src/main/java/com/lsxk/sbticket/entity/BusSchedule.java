package com.lsxk.sbticket.entity;

/**
 * 校车班次实体
 * Created by wjz on 2018/4/1.
 */
public class BusSchedule {
    /** 班次编号*/
    private long busScheduleId;

    /** 出发站点id*/
    private long sourId;

    /** 目的站点id*/
    private long distId;

    /** 班次总量*/
    private int num;

    /** 票价*/
    private float price;

    /** 出发时间，yyyy-mm-dd*/
    private String date;

    /** 出发时间 hh:mm*/
    private String time;

    /** 路程，单位km*/
    private float distance;

    /** 耗时,单位min*/
    private float lasting;

    /** 班次类型 1：固定班次，2：临时班次*/
    private int type;

    public long getBusScheduleId() {
        return busScheduleId;
    }

    public void setBusScheduleId(long busScheduleId) {
        this.busScheduleId = busScheduleId;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getLasting() {
        return lasting;
    }

    public void setLasting(float lasting) {
        this.lasting = lasting;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BusSchedule{" +
                "busScheduleId=" + busScheduleId +
                ", sourId=" + sourId +
                ", distId=" + distId +
                ", num=" + num +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", distance=" + distance +
                ", lasting=" + lasting +
                ", type=" + type +
                '}';
    }
}
