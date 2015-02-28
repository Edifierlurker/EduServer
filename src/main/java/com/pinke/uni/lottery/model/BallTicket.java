package com.pinke.uni.lottery.model;

import com.pinke.uni.lottery.common.GameConstants;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Administrator on 15-1-6.
 */
public class BallTicket implements Serializable{

    public BallTicket(){


    }

    public BallTicket(String ball,Integer multiple,String lottery){
        if(GameConstants.LOTTERY_TYPE.SSQ.equals(lottery)){
            String[] arr = ball.split("\\|");
            int redLen = arr[0].split(",").length;
            int blueLen = arr[1].split(",").length;
            int betCount = factorial(redLen).divide((factorial(6).multiply(factorial(redLen - 6)))).multiply(new BigDecimal(blueLen)).intValue();
            this.setCode(ball+"X"+multiple);
            this.setMultiple(multiple);
            this.setCount(betCount);
            this.setType(betCount > 1 ? "00102" : "00101");
        }
    }

    private  BigDecimal factorial(int n){
        BigDecimal result = new BigDecimal(1);
        BigDecimal a;
        for(int i = 2; i <= n; i++){
            a = new BigDecimal(i);//将i转换为BigDecimal类型
            result = result.multiply(a);//不用result*a，因为BigDecimal类型没有定义*操作</span><span>
        }
        return result;
    }

    private String code;

    private Integer multiple;

    private Double win;

    private Integer success;

    /**
     * 玩法类型
     */
    private String type;


    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Double getWin() {
        return win;
    }

    public void setWin(Double win) {
        this.win = win;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}
