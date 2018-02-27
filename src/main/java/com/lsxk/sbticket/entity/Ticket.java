package com.lsxk.sbticket.entity;

/**
 * 校车票实体
 * Created by wjz on 2018/2/27.
 */
public class Ticket {
    /** 路线编号*/
    private int pathId;

    /** 票编号*/
    private int TicketId;

    /** 票总量*/
    private int num;

    /** 票价*/
    private int price;

    /** 出发时间，yyyy-mm-dd hh:mm*/
    private String departure;
}
