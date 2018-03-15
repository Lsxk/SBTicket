package com.lsxk.sbticket.dto;

/**
 * 查询站点校区结果封装
 * Created by wjz on 2018/3/12.
 */
public class SiteCampusDTO {

    /** 出发站校区*/
    private String sourCampus;

    /** 目的站站校区*/
    private String distCampus;

    public String getSourCampus() {
        return sourCampus;
    }

    public void setSourCampus(String sourCampus) {
        this.sourCampus = sourCampus;
    }

    public String getDistCampus() {
        return distCampus;
    }

    public void setDistCampus(String distCampus) {
        this.distCampus = distCampus;
    }
}
