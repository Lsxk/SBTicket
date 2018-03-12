package com.lsxk.sbticket.entity;

/**
 * 校车票实体
 * Created by wjz on 2018/2/27.
 */
public class Ticket {

    /** 票编号*/
    private long TicketId;

    /** 出发站点id*/
    private long sourId;

    /** 目的站点id*/
    private long distId;

    /** 票总量*/
    private int num;

    /** 票价*/
    private int price;

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
        return TicketId;
    }

    public void setTicketId(long ticketId) {
        TicketId = ticketId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
        return "Ticket{" +
                "TicketId=" + TicketId +
                ", sourId=" + sourId +
                ", distId=" + distId +
                ", num=" + num +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", distance=" + distance +
                ", lasting=" + lasting +
                ", balance=" + balance +
                '}';
    }
}
