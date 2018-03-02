package com.lsxk.sbticket.entity;

/**
 * 校车票实体
 * Created by wjz on 2018/2/27.
 */
public class Ticket {

    /** 票编号*/
    private long TicketId;

    /** 路线编号*/
    private long pathId;

    /** 票总量*/
    private int num;

    /** 票价*/
    private int price;

    /** 出发时间，yyyy-mm-dd*/
    private String date;

    /** 出发时间 hh:mm*/
    private String time;

    /** 票余量*/
    private int balance;

    public long getTicketId() {
        return TicketId;
    }

    public void setTicketId(long ticketId) {
        TicketId = ticketId;
    }

    public long getPathId() {
        return pathId;
    }

    public void setPathId(long pathId) {
        this.pathId = pathId;
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
                ", pathId=" + pathId +
                ", num=" + num +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", balance=" + balance +
                '}';
    }
}
