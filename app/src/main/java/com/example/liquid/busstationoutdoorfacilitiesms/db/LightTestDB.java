package com.example.liquid.busstationoutdoorfacilitiesms.db;

import org.litepal.crud.DataSupport;

public class LightTestDB extends DataSupport {
    private String testid;

    public String getTestid() {
        return testid;
    }

    public void setTestid(String testid) {
        this.testid = testid;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LightTestDB(String testid, String station, String state, int time, String clean, String remark) {
        this.testid = testid;
        this.station = station;
        this.state = state;
        this.time = time;
        this.clean = clean;
        this.remark = remark;
    }

    private String station;
    private String state;
    private int time;
    private String clean;
    private String remark;

}
