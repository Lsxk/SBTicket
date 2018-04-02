package com.lsxk.sbticket.dto;

/**
 * 封装前端查票参数
 * Created by wjz on 2018/3/12.
 */
public class TicketDTO {
    /** 票编号*/
    private long ticketId;

    /** 出发站点*/
    private String sourName;

    /** 目的站点*/
    private String distName;

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

    /** 票余量*/
    private int balance;

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getSourName() {
        return sourName;
    }

    public void setSourName(String sourName) {
        this.sourName = sourName;
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "ticketId=" + ticketId +
                ", sourName='" + sourName + '\'' +
                ", distName='" + distName + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", distance=" + distance +
                ", lasting=" + lasting +
                ", balance=" + balance +
                '}';
    }
}
