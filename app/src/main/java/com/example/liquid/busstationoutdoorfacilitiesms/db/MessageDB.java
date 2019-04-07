package com.example.liquid.busstationoutdoorfacilitiesms.db;

import org.litepal.crud.DataSupport;

public class MessageDB extends DataSupport {
    private String mission;
    private String station;
    private String direction;
    private String brand;
    private String process;

    private int equipmentId;
    private int usetime;
    private String remark;
    private String state;

    public MessageDB(String mission, String station, String direction, String brand, String process, int equipmentId, int usetime, String remark, String state) {
        this.mission = mission;
        this.station = station;
        this.direction = direction;
        this.brand = brand;
        this.process = process;
        this.equipmentId = equipmentId;
        this.usetime = usetime;
        this.remark = remark;
        this.state = state;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getUsetime() {
        return usetime;
    }

    public void setUsetime(int usetime) {
        this.usetime = usetime;
    }

    public String getMark() {
        return remark;
    }

    public void setMark(String mark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
