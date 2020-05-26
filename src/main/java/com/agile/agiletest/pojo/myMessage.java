package com.agile.agiletest.pojo;

import java.io.Serializable;

public class myMessage implements Serializable {
    private String username;
    private String carNum;
    private String startTime;
    private int seat;

    public myMessage() {
    }

    public myMessage(String username, String carNum, String startTime, int seat) {
        this.username = username;
        this.carNum = carNum;
        this.startTime = startTime;
        this.seat = seat;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
