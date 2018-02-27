package com.lsxk.sbticket.entity;

/**
 * 校车站点
 * Created by wjz on 2018/2/27.
 */
public class Site {
    /**
     * 站点id
     */
    private long siteId;

    /**
     * 站点名称
     */
    private String name;

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
