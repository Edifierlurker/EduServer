package com.pinke.uni.mobile.protal.util;

import java.util.HashMap;
import java.util.Map;

public class ProvinceUtil
{
    /**
     * 根据省份Id，返回省份编号 如 4040 - 31
     * @param index
     * @return
     */
    public static String getProvinceByProvinceIndex(int index){

        String province = "";
        switch (index)
        {
            case 4040: // 上海
                province = "31";
                break;
            case 4041: // 云南
                province = "86";
                break;
            case 4042: // 内蒙古
                province = "10";
                break;
            case 4043: // 北京
                province = "11";
                break;
            case 4044: // 吉林
                province = "90";
                break;
            case 4045: // 四川
                province = "81";
                break;
            case 4046: // 天津
                province = "13";
                break;
            case 4047: // 宁夏
                province = "88";
                break;
            case 4048: // 安徽
                province = "30";
                break;
            case 4049: // 山东
                province = "17";
                break;
            case 4050: // 山西
                province = "19";
                break;
            case 4051: // 广东
                province = "51";
                break;
            case 4052: // 广西
                province = "59";
                break;
            case 4053: // 新疆
                province = "89";
                break;
            case 4054: // 江苏
                province = "34";
                break;
            case 4055: // 江西
                province = "75";
                break;
            case 4056: // 河北
                province = "18";
                break;
            case 4057: // 河南
                province = "76";
                break;
            case 4058: // 浙江
                province = "36";
                break;
            case 4059: // 海南
                province = "50";
                break;
            case 4060: // 湖北
                province = "71";
                break;
            case 4061: // 湖南
                province = "74";
                break;
            case 4062: // 甘肃
                province = "87";
                break;
            case 4063: // 福建
                province = "38";
                break;
            case 4064: // 西藏
                province = "79";
                break;
            case 4065: // 贵州
                province = "85";
                break;
            case 4066: // 辽宁
                province = "91";
                break;
            case 4067: // 重庆
                province = "83";
                break;
            case 4068: // 陕西
                province = "84";
                break;
            case 4069: // 青海
                province = "70";
                break;
            case 4070: // 黑龙江
                province = "97";
                break;
            default:
                // 默认北京
                province = "11";
                break;
        }
        return province;
    
        
        
    }
    /**
     * 根据省份Id，返回省份名称  如 4040 - 上海
     * @param index
     * @return
     */
    public static String getProvinceByIndex(int index){
        String id = getProvinceByProvinceIndex(index);
        return getProvinceStrByProvinceIndex(id);
    }
    /**
     * 根据省份ProvinceIndex，返回省份名称  如 31 - 上海
     * @param index
     * @return
     */
    public static String getProvinceStrByProvinceIndex(String province){
        Map<String, String> map = new HashMap<String, String>();
        map.put("31", "上海");
        map.put("86", "云南");
        map.put("10", "内蒙古");
        map.put("11", "北京");
        map.put("90", "吉林");
        map.put("81", "四川");
        map.put("13", "天津");
        map.put("88", "宁夏");
        map.put("30", "安徽");
        map.put("17", "山东");
        map.put("19", "山西");
        map.put("51", "广东");
        map.put("59", "广西");
        map.put("89", "新疆");
        map.put("34", "江苏");
        map.put("75", "江西");
        map.put("18", "河北");
        map.put("76", "河南");
        map.put("36", "浙江");
        map.put("50", "海南");
        map.put("71", "湖北");
        map.put("74", "湖南");
        map.put("87", "甘肃");
        map.put("38", "福建");
        map.put("79", "西藏");
        map.put("85", "贵州");
        map.put("83", "重庆");
        map.put("84", "陕西");
        map.put("70", "青海");
        map.put("97", "黑龙江");
        map.put("11", "北京");
        return map.get(province);
    
        
        
    }
}
