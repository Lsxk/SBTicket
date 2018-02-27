package com.lsxk.sbticket.entity;

/**
 * 校车票路线实体
 * Created by wjz on 2018/2/27.
 */
public class Path {
    /** 路线编号 */
    private long pathId;

    /** 行驶距离 */
    private float distance;

    /** 行驶时间,单位：分 */
    private float time;

    /** 起始站点id */
    private long sourceSiteId;

    /** 目的地站点id */
    private long distSiteId;

    public long getPathId() {
        return pathId;
    }

    public void setPathId(long pathId) {
        this.pathId = pathId;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public long getSourceSiteId() {
        return sourceSiteId;
    }

    public void setSourceSiteId(long sourceSiteId) {
        this.sourceSiteId = sourceSiteId;
    }

    public long getDistSiteId() {
        return distSiteId;
    }

    public void setDistSiteId(long distSiteId) {
        this.distSiteId = distSiteId;
    }

    @Override
    public String toString() {
        return "Path{" +
                "pathId=" + pathId +
                ", distance=" + distance +
                ", time=" + time +
                ", sourceSiteId=" + sourceSiteId +
                ", distSiteId=" + distSiteId +
                '}';
    }
}
