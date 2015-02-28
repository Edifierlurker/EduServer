package com.pinke.uni.lottery.model;

import java.util.List;

/**
 * Created by Administrator on 15-1-6.
 */
public class LotteryOrderInfo {

    private String orderId;

    private List<BallTicket> items;

    private Integer status;

    private Double money;

    private Double win;

    private Integer code;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<BallTicket> getItems() {
        return items;
    }

    public void setItems(List<BallTicket> items) {
        this.items = items;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getWin() {
        return win;
    }

    public void setWin(Double win) {
        this.win = win;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
