package com.lsxk.sbticket.dto;

/**
 * 封装发起支付接口所需参数
 * Created by wjz on 2018/3/2.
 */
public class PaysDTO {
    /** 商户id*/
    private String uid;

    /** 价格，小数点后2位*/
    private float price;

    /** 支付渠道 1：支付宝，2：微信*/
    private int isType;

    /** 通知回调地址*/
    private String notifyUrl;

    /** 跳转网址*/
    private String returnUrl;

    /** 订单号id*/
    private String orderId;

    /** 用户id*/
    private String orderUid;

    /** 商品名称*/
    private String goodsName;

    /** 密钥*/
    private String key;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIsType() {
        return isType;
    }

    public void setIsType(int isType) {
        this.isType = isType;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderUid() {
        return orderUid;
    }

    public void setOrderUid(String orderUid) {
        this.orderUid = orderUid;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}