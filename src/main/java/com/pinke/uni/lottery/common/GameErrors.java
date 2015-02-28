package com.pinke.uni.lottery.common;

import java.util.HashMap;

/**
 * Created by Administrator on 14-12-25.
 */
public class GameErrors {

    private static HashMap<String,String> map = new HashMap<String,String>();

    private GameErrors(){

    }

    static {
        map.put("0","成功");
        map.put("-1","必填信息不完整");
        map.put("-2","彩种错误");
        map.put("-3","彩种玩法错误");
        map.put("-4","账户余额不足");
        map.put("-5","订单金额错误");
        map.put("-6","当期未开始");
        map.put("-7","当期已结束");
        map.put("-8","期号错误");
        map.put("-9","期号非当前销售期");
        map.put("-10","投注内容格式错误");
        map.put("-98","等待处理完成");
        map.put("-99","ip鉴权错误");
        map.put("-100","签名错误");
        map.put("-999","系统错误");
    }

    public static String getErrorDesc(String code){
        return map.get(code);
    }

    public static final int SUCCESS = 0;

    public static final int INFO_ERROR = -1;

    public static final int LOTTERY_ERROR = -2;

    public static final int LOTTERY_RULE_ERROR = -3;

    public static final int ACCOUNT_MONEY_LOW = -4;

    public static final int ORDER_MONEY_ERROR = -5;

    public static final int NOT_OPEN = -6;

    public static final int CLOSED = -7;

    public static final int NUMBER_ERROR = -8;

    public static final int SERIES_NOT_CUR = -9;

    public static final int BET_UNFORMATED = -10;

    public static final int WAIT_CLOSED = -98;

    public static final int IP_ERROR = -99;

    public static final int SIGN_ERROR = -100;
    public static final int SYSTEM_ERROR = -999;
 }
