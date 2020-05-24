package com.agile.agiletest.pojo;

import java.io.Serializable;

public class Message implements Serializable {
    private String username;
    private String carNum;
    private String startTime;

    public Message() {
    }

    public Message(String username, String carNum, String startTime) {
        this.username = username;
        this.carNum = carNum;
        this.startTime = startTime;
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
