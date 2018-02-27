package com.lsxk.sbticket.entity;

/**
 * 校车票路线实体
 * Created by wjz on 2018/2/27.
 */
public class Path {
    /** 路线编号 */
    private int pathId;

    /** 行驶距离 */
    private float distance;

    /** 行驶时间,单位：分 */
    private float time;

    /** 起始站点id */
    private String sourceSiteId;

    /** 目的地站点id */
    private String distSiteId;
}
