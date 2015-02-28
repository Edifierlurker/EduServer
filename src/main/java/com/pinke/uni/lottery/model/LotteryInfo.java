package com.pinke.uni.lottery.model;

import java.io.Serializable;

/**
 * Created by Administrator on 15-1-6.
 */
public class LotteryInfo implements Serializable {

    private Integer code;

    private String lottery;

    private Integer status;

    private String note;

    private Integer award;

    private String startTime;

    private String endTime;

    private Integer periods;

    private Long interval;

    private Integer open;

    public String getLottery() {
        return lottery;
    }

    public void setLottery(String lottery) {
        this.lottery = lottery;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
