package com.pinke.uni.lottery.model;

import java.io.Serializable;

/**
 * Created by Administrator on 15-1-6.
 */
public class IssueInfo implements Serializable {

    private Integer code;

    private String lottery;

    private String issue;

    private String number;

    private String nextIssue;

    private String endTime;

    private String closeTime;

    private Integer saleStatus;

    public String getLottery() {
        return lottery;
    }

    public void setLottery(String lottery) {
        this.lottery = lottery;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNextIssue() {
        return nextIssue;
    }

    public void setNextIssue(String nextIssue) {
        this.nextIssue = nextIssue;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }
}
