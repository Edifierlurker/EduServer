package com.pinke.uni.lottery.model;

import java.io.Serializable;

/**
 * Created by Administrator on 15-1-8.
 */
public class RewardsInfo implements Serializable {

    /**
     * 玩法编号
     */
    private String game;

    /**
     * 原奖金金额
     */
    private Double money;

    /**
     * 加奖增量金额
     */
    private Double add;

    /**
     * 中奖号码
     */
    private String code;

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getAdd() {
        return add;
    }

    public void setAdd(Double add) {
        this.add = add;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
