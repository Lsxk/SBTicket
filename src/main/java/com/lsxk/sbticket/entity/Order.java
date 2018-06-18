package com.lsxk.sbticket.entity;

/**
 * 订单实体
 * Created by wjz on 2018/3/2.
 */
public class Order {

    /** 订单编号*/
    private String orderId;

    /** paysapi订单编号*/
    private String paysapiId;

    /** 票id*/
    private long ticketId;

    /** 用户id*/
    private String orderUid;

    /** 下单时间*/
    private String orderTime;

    /** 订单总价*/
    private float totalPrice;

    /** 订单状态*/
    private int orderStatus;

    public String getPaysapiId() {
        return paysapiId;
    }

    public void setPaysapiId(String paysapiId) {
        this.paysapiId = paysapiId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getOrderUid() {
        return orderUid;
    }

    public void setOrderUid(String orderUid) {
        this.orderUid = orderUid;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}
