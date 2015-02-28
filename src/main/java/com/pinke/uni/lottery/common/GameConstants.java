package com.pinke.uni.lottery.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 14-12-25.
 */
public class GameConstants {

    public static class BET_TYPE {

        /*
        **单式投注
         */
        public static final String SSQ_DS = "00101";
        /*
        *复式投注
         */
        public static final String SSQ_FS = "00102";
        /*
         *胆拖投注
          */
        public static final String SSQ_DT = "00103";
        /*
        *单式单选
         */
        public static final String FC3D_DSDX = "00201";
        /*
         *单式组三
          */
        public static final String FC3D_DSZS = "00202";
        /*
        *单式组六
         */
        public static final String FC3D_DSZL = "00203";
        /*
         *1D
          */
        public static final String FC1D_1D = "00204";
        /*
        *2D
         */
        public static final String FC2D_2D = "00205";
        /*
         *三不同
          */
        public static final String JSKS_SBT = "00301";
        /*
        *二同号单选
         */
        public static final String JSKS_ETHDX = "00302";
        /*
         *三同号单选
          */
        public static final String JSKS_STHDX = "00303";
        /*
        *和值单式
         */
        public static final String JSKS_HZDS = "00304";
        /*
         *和值复式
          */
        public static final String JSKS_HZFS = "00305";
        /*
        *二不同
         */
        public static final String JSKS_EBT = "00306";
        /*
         *二同号复选
          */
        public static final String JSKS_ETHFX = "00307";
        /*
        *三同号通选
         */
        public static final String JSKS_STHTX = "00308";
        /*
         *三连号通选
          */
        public static final String JSKS_SLHTX = "00309";
        /*
        *二同号复式
         */
        public static final String JSKS_ETHFS = "00310";
        /*
         *三不同号复式
          */
        public static final String JSKS_SBTHFS = "00311";
        /*
        *二同号拖胆
         */
        public static final String JSKS_ETHDT = "00312";
        /*
         *三不同号拖胆
          */
        public static final String JSKS_SBTDT = "00313";
    }

    /**
     * 出票状态
     */
    public static class PRINT_STATUS {
        public static final int WAIT = 0;
        public static final int SUCCESS = 1;
        public static final int FAIL = 2;
        public static final int WIN = 3;
        public static final int NOTWIN = 4;
        public static final int PART_SUCCESS = 5;

    }

    /**
     * 订单状态
     */
    public static class ORDER_STATUS {
        public static final int TICKETS_WAIT = 0;
        public static final int TICKETS_SUCCESS = 1;
        public static final int TICKETS_FAIL = 2;
        public static final int TICKETS_WIN = 3;
        public static final int TICKETS_NOTWIN = 4;
        public static final int TICKETS_CONFIRM_FAIL = 5;
        public static final int TICKETS_CONFIRM_SUCCESS = 6;

        public static String getName(int status){
            switch (status){
                case 0 :return "待支付";
                case 1 :return "已支付";
                case 2 :return "支付失败";
                case 3 :return "未中奖";
                case 4 :return "中奖";
                case 5 :return "支付确认失败";
                case 6 :return "订单成功";
            }
            return "";
        }

    }

    /**
     * 彩种销售状态
     */
    public static class SELL_STATUS {
        public static final int OPENED = 0;
        public static final int CLOSED = 1;

    }

    /**
     * 彩种加奖状态
     */
    public static class ADD_MONEY_STATUS {
        public static final int NONE = 0;
        public static final int ING = 1;

    }

    /**
     * 彩种今日开奖状态
     */
    public static class DAILY_OPEN_STATUS {
        public static final int OPEN = 0;
        public static final int NOTOPEN = 1;

    }
    /**
     * 彩种
     */
     public static class LOTTERY_TYPE {
        public static final String SSQ = "001";
        public static final String FC3D = "002";
        public static final String JSKS = "003";

    }

    public static Map<String,String> LOTTERY = new HashMap<String,String>();
    public static Map<String,String> LOTTERY_CODE = new HashMap<String,String>();
    public static Map<String,String[]> LOTTERY_GAME = new HashMap<String,String[]>();

    static{
        LOTTERY.put("001","双色球");
        LOTTERY.put("002","福彩3D");
        LOTTERY.put("003","江苏快三");

        LOTTERY_CODE.put("001","SSQ");
        LOTTERY_CODE.put("002","FC3D");
        LOTTERY_CODE.put("003","JSKS");

        LOTTERY_GAME.put("001",new String[]{"00101","00102"});
        LOTTERY_GAME.put("002",new String[]{"00201","00202","00203"});
        LOTTERY_GAME.put("003",new String[]{"00301","00302","00303","00305","00306","00307","00308","00309"});
    }

}
