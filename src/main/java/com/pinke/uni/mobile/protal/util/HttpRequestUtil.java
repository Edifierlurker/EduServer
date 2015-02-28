package com.pinke.uni.mobile.protal.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-7-19
 * Time: 上午9:39
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestUtil {

    public static String fetchRemoteIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.indexOf(",") >= 0 ) {
            List<String> list = Arrays.asList(ip.split(","));
            Iterator<String> iter = list.iterator();
            while (iter.hasNext()) {
                String tmp = iter.next();
                if (!"unknown".equalsIgnoreCase(ip) && ip != null)
                    ip = tmp;
            }
        }
        return ip;
    }


    public static String formatIp(String ip, char[] format) {

        if (format == null)
            throw new NullPointerException("the array for format is null!!!");

        for (int i = 0; i < format.length; i++) {
            format[i] = ' ';
        }
        for (int index = 0; index < ip.length(); index++) {
            format[index] = ip.charAt(index);
        }
        return String.valueOf(format);
    }


    public static String fetchIp(HttpServletRequest request, char[] format) {
        if (format == null || request == null)
            throw new NullPointerException("the array for format is null!!! || the request is null!!!!");
        String ip = HttpRequestUtil.fetchRemoteIp(request);
        return HttpRequestUtil.formatIp(ip, format);
    }


}
