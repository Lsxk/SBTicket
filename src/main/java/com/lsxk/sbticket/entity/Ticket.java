package com.lsxk.sbticket.entity;

/**
 * 校车票实体
 * Created by wjz on 2018/2/27.
 */
public class Ticket {
    /** 路线编号*/
    private long pathId;

    /** 票编号*/
    private long TicketId;

    /** 票总量*/
    private int num;

    /** 票价*/
    private int price;

    /** 出发时间，yyyy-mm-dd hh:mm*/
    private String departure;

    public long getPathId() {
        return pathId;
    }

    public void setPathId(long pathId) {
        this.pathId = pathId;
    }

    public long getTicketId() {
        return TicketId;
    }

    public void setTicketId(long ticketId) {
        TicketId = ticketId;
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

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
}
