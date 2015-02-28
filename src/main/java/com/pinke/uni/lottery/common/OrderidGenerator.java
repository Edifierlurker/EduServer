package com.pinke.uni.lottery.common;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 15-1-6.
 */
public class OrderidGenerator {
    private static Integer count = 100000;
    private static Integer pcount = 100000;

    private OrderidGenerator() {

    }

    public static String generateLotteryOrderid(String game) {
        String id = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        synchronized (count) {
            if (count < 199999)
                count++;
            else
                count = 100001;
            id += String.valueOf(count).substring(1);
        }
        return game + id;
    }

    public static String generateLotteryPrintid() {
        String id = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        synchronized (pcount) {
            if (pcount < 199999)
                pcount++;
            else
                pcount = 100001;
            id += String.valueOf(pcount).substring(1);
        }
        return "P" + id;
    }

}
