package com.pinke.uni.mobile.protal.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Hex;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.Form;
import org.jivesoftware.smackx.FormField;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.RoomInfo;

import com.pinke.uni.mobile.protal.common.config.ParseConfig;
import com.pinke.uni.mobile.protal.common.openfire.OpenfireConnection;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

/**
 * 版权所有：版权所有(C) 2007，中兴通讯 文件编号： 文件名称：StoreAppDAO.java 系统编号： 系统名称： 模块编号： 模块名称： 设计作者： 完成日期： 设计文档： 内容摘要：
 */
public class Tools
{
    public static final String ADD_URL = "http://passport.wostore.cn:8090/smsProxy/soo/sms/send";
    public static final String serverURL = ApplicationGlobalResource.getInstance().getValueByKey("server.url");

    /**
     * 将ISO编码转换为GBK编码
     * 
     * @param output
     *            String 输入字符串
     * @return String 输出字符串
     */
    public static String decode(String output)
    {
        try
        {
            return new String(output.getBytes("ISO-8859-1"), "GBK");
        }
        catch (Exception ex)
        {
            return "";
        }
    }

    /**
     * 将GBK编码转换为ISO编码
     * 
     * @param input
     *            String 输入字符串
     * @return String 输出字符串
     */
    public static String encode(String input)
    {
        try
        {
            return new String(input.getBytes("GBK"), "ISO-8859-1");
        }
        catch (Exception ex)
        {
            return "";
        }
    }

    /**
     * 格式化日期，格式如2006-07-09
     * 
     * @param date
     *            Date 日期
     * @return String 输出字符串
     */
    public static String formatDate(Date date)
    {
        if (date == null)
        {
            return "";
        }
        else
        {
            String disp = "";
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            disp = bartDateFormat.format(date);
            return disp;
        }
    }

    /**
     * 格式化日期，格式如2006-07-09 23:00:00
     * 
     * @param date
     *            Date 日期
     * @return String 输出字符串
     */
    public static String formatDate2(Date date)
    {
        if (date == null)
        {
            return "";
        }
        else
        {
            String disp = "";
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            disp = bartDateFormat.format(date);
            return disp;
        }
    }

    /**
     * 格式化日期，将日期从yyyyMMddHHmmss转换为yyyy-MM-dd HH:mm:ss
     * 
     * @param datetime
     *            String
     * @return String
     */
    public static String formatDate3(String datetime)
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            datetime = df.format(date1);
        }
        catch (Exception ex)
        {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从yyyyMMddHHmm转换为yyyy-MM-dd HH:mm
     * 
     * @param datetime
     *            String
     * @return String
     */
    public static String formatDate_3(String datetime)
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            datetime = df.format(date1);
        }
        catch (Exception ex)
        {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从yyyy-MM-dd转换为yyyyMMdd
     * 
     * @param datetime
     *            String
     * @return String
     */
    public static String formatDate4(String datetime)
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyyMMdd");
            datetime = df.format(date1);
        }
        catch (Exception ex)
        {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从yyyyMMdd转换为yyyy-MM-dd
     * 
     * @param datetime
     *            String
     * @return String
     */
    public static String formatDate5(String datetime)
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyy-MM-dd");
            datetime = df.format(date1);
        }
        catch (Exception ex)
        {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从yyyy-MM-dd HH:mm:ss转换为yyyyMMddHHmmss
     * 
     * @param datetime
     *            String
     * @return String
     */

    public static String formatDate6(String datetime)
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyyMMddHHmmss");
            datetime = df.format(date1);
        }
        catch (Exception ex)
        {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从yyyy-MM-dd HH:mm转换为yyyyMMddHHmm
     * 
     * @param datetime
     *            String
     * @return String
     */

    public static String formatDate_6(String datetime)
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyyMMddHHmm");
            datetime = df.format(date1);
        }
        catch (Exception ex)
        {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期为yyyyMMddHHmmss格式
     * 
     * @param date
     *            Date
     * @return String
     */
    public static String formatDate7(Date date)
    {
        if (date == null)
        {
            return "";
        }
        else
        {
            String disp = "";
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            disp = bartDateFormat.format(date);
            return disp;
        }
    }

    /**
     * 格式化日期，将日期从yyyyMMdd转换为yyyy-MM-dd
     * 
     * @param datetime
     *            String
     * @return String
     */
    public static String formatDate8(String datetime)
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyy/MM/dd");
            datetime = df.format(date1);
        }
        catch (Exception ex)
        {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期为yyyyMMdd格式
     * 
     * @param date
     *            Date
     * @return String
     */
    public static String formatDate9(Date date)
    {
        if (date == null)
        {
            return "";
        }
        else
        {
            String disp = "";
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyyMMdd");
            disp = bartDateFormat.format(date);
            return disp;
        }
    }

    /**
     * 格式化日期为yyyyMMdd格式
     * 
     * @param date
     *            Date
     * @return String
     */
    public static String formatDate10(String datetime)
    {

        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyyMMdd");
            datetime = df.format(date1);
        }
        catch (Exception ex)
        {
            datetime = "";
        }
        return datetime;

    }

    /**
     * 格式化double变量为字符串，格式为##################0.00
     * 
     * @param b
     *            double
     * @return String
     */
    public static String formatE(double b)
    {
        try
        {
            DecimalFormat df1 = new DecimalFormat("##################0.00");
            return df1.format(b);
        }
        catch (Exception ex)
        {
            return "";
        }
    }

    /**
     * 格式化float变量为字符串，格式为##################0.00
     * 
     * @param b
     *            double
     * @return String
     */
    public static String formatE(float b)
    {
        try
        {
            DecimalFormat df1 = new DecimalFormat("##################0.00");
            return df1.format(b);
        }
        catch (Exception ex)
        {
            return "";
        }
    }

    /**
     * 格式化float变量为字符串，格式为##################0.00
     * 
     * @param b
     *            double
     * @return String
     */
    public static String formatE2(float b)
    {
        String result = "";
        try
        {
            DecimalFormat df1 = new DecimalFormat("##################0.000");
            result = df1.format(b);
            String ss[] = result.split("\\.");
            String ss1 = ss[0];
            String ss2 = ss[1];
            String s21 = ss2.substring(0, 2);
            String s22 = ss2.substring(2, 3);
            if (Integer.parseInt(s22) > 4)
            {
                s21 = (Integer.parseInt(s21) + 1) + "";

                if (Integer.parseInt(s21) == 100)
                {
                    s21 = "00";
                    ss1 = (Integer.parseInt(ss1) + 1) + "";
                    result = ss1 + "." + s21;
                }
                else
                {
                    if (Integer.parseInt(s21) < 10)
                    {
                        s21 = "0" + s21;
                    }
                    result = ss1 + "." + s21;
                }
            }
            else
            {
                result = ss1 + "." + s21;
            }
            return result;
        }
        catch (Exception ex)
        {
            return "";
        }
    }

    /**
     * 将字符串根据分隔符分解成字符数组
     * 
     * @param value
     *            String 字符串
     * @param compart
     *            String 分隔符
     * @return Vector
     */
    public static Vector<String> formatString(String value, String compart)
    {
        int index = 0;
        int i = 0;
        Vector<String> vc = new Vector<String>();
        while ((index = value.indexOf(compart)) != -1)
        {
            vc.add(value.substring(0, index));
            i++;
            value = value.substring(index + 1);
        }
        return vc;
    }

    /**
     * 算出百分比
     * 
     * @param str1
     *            String 字符串
     * @param str2
     *            String 分隔符
     * @return String
     */
    public static String formatPercent(String str1, String str2)
    {
        if ("0".equals(str1))
        {
            return "0％";
        }
        double t1 = Double.parseDouble(str1);
        double t2 = Double.parseDouble(str2);
        String tt = "0";
        tt = 100 * (t1 / t2) + "0000.00000";
        String[] comm = tt.split("\\.");
        String comm1 = comm[0];
        String comm2 = comm[1].substring(0, 1);
        String comm3 = comm[1].substring(1, 2);
        String comm4 = comm[1].substring(2, 3);
        if (Integer.parseInt(comm4) >= 5)
        {
            comm3 = (Integer.parseInt(comm3) + 1) + "";
            if (Integer.parseInt(comm3) == 10)
            {
                comm3 = "0";
                comm2 = (Integer.parseInt(comm2) + 1) + "";
                if (Integer.parseInt(comm2) == 10)
                {
                    comm2 = "0";
                    comm1 = (Integer.parseInt(comm1) + 1) + "";
                }
            }
        }
        if ("0".equals(comm3))
        {
            if ("0".equals(comm2))
            {
                if ("0".equals(comm1))
                {
                    tt = "0.01％";
                }
                else
                {
                    tt = comm1 + "％";
                }
            }
            else
            {
                tt = comm1 + "." + comm2 + "％";
            }
        }
        else
        {
            tt = comm1 + "." + comm2 + comm3 + "％";
        }
        return tt;
    }

    /**
     * 算出百分比
     * 
     * @param str1
     *            String 数字字符串
     * @param str21
     *            String 数字字符串
     * @param str22
     *            String 数字字符串
     * @return String
     */
    public static String formatPercent(String str1, String str21, String str22)
    {
        if ("0".equals(str1))
        {
            return "0％";
        }
        double t1 = Double.parseDouble(str1);
        double t2 = Double.parseDouble(str21) + Double.parseDouble(str22);
        String tt = "0";
        tt = 100 * (t1 / t2) + "0000.00000";
        String[] comm = tt.split("\\.");
        String comm1 = comm[0];
        String comm2 = comm[1].substring(0, 1);
        String comm3 = comm[1].substring(1, 2);
        String comm4 = comm[1].substring(2, 3);
        if (Integer.parseInt(comm4) >= 5)
        {
            comm3 = (Integer.parseInt(comm3) + 1) + "";
            if (Integer.parseInt(comm3) == 10)
            {
                comm3 = "0";
                comm2 = (Integer.parseInt(comm2) + 1) + "";
                if (Integer.parseInt(comm2) == 10)
                {
                    comm2 = "0";
                    comm1 = (Integer.parseInt(comm1) + 1) + "";
                }
            }
        }

        if ("0".equals(comm3))
        {
            if ("0".equals(comm2))
            {
                if ("0".equals(comm1))
                {
                    tt = "0.01％";
                }
                else
                {
                    tt = comm1 + "％";
                }
            }
            else
            {
                tt = comm1 + "." + comm2 + "％";
            }
        }
        else
        {
            tt = comm1 + "." + comm2 + comm3 + "％";
        }
        return tt;
    }

    /**
     * 获得备份路径
     * 
     * @return String
     */
    public static String getBackup()
    {
        return File.separator + "app" + File.separator + "iservice_server" + File.separator + "backup";
    }

    /**
     * 获得EXCEL文件生成路径
     * 
     * @return String
     */
    public static String getExcelServer()
    {
        return System.getProperty("catalina.home") + File.separator + "webapps" + File.separator
                + "iservice_smp_client";
    }

    /**
     * 获得按照起始和终止时间，获得所有的日期
     * 
     * @param startTime
     *            String
     * @param endTime
     *            String
     * @return Vector
     */
    public static Vector<String> getMonth(String startTime, String endTime)
    {
        Vector<String> vcMonth = new Vector<String>();
        try
        {
            SimpleDateFormat startDF = new SimpleDateFormat("yyyyMMddHHmmss");
            startDF.parse(startTime);
            Calendar startCal = startDF.getCalendar();
            SimpleDateFormat endDF = new SimpleDateFormat("yyyyMMddHHmmss");
            endDF.parse(endTime);
            Calendar endCal = endDF.getCalendar();
            vcMonth.add(startTime);
            startCal.set(Calendar.DAY_OF_MONTH, 1);
            startCal.set(Calendar.HOUR_OF_DAY, 0);
            startCal.set(Calendar.MINUTE, 0);
            startCal.set(Calendar.SECOND, 0);
            startCal.add(Calendar.MONTH, 1);
            startCal.add(Calendar.SECOND, -1);
            while (endCal.after(startCal))
            {
                vcMonth.add(formatDate7(startCal.getTime()));
                vcMonth.add(Integer.toString(startCal.get(2) + 1));
                startCal.add(Calendar.SECOND, 1);
                vcMonth.add(formatDate7(startCal.getTime()));
                startCal.add(Calendar.MONTH, 1);
                startCal.add(Calendar.SECOND, -1);
            }
            vcMonth.add(endTime);
            vcMonth.add(Integer.toString(endCal.get(2) + 1));
        }
        catch (Exception ex)
        {
            vcMonth = new Vector<String>();
        }
        return vcMonth;
    }

    /**
     * 获得当天时间，格式为yyyy-MM-dd HH:mm:ss
     * 
     * @return String
     */
    public static String getNow()
    {
        Date d = new Date();
        String str = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        str = formatter.format(d);
        return str;
    }

    /**
     * 获得当天日期，格式为yyyy-MM-dd
     * 
     * @return String
     */
    public static String getNow2()
    {
        Date d = new Date();
        String str = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        str = formatter.format(d);
        return str;
    }

    /**
     * 获得当天时间，格式为yyyyMMddHHmmss
     * 
     * @return String
     */
    public static String getNow3()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = dateFormat.format(new Date());
        return strDate;
    }

    /**
     * 获得当天日期，格式为yyyyMMdd
     * 
     * @return String
     */
    public static String getNow4()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String strDate = dateFormat.format(new Date());
        return strDate;
    }

    /**
     * 获得当天日期，格式为yyMM
     * 
     * @return String
     */
    public static String getNowMonth()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
        String strDate = dateFormat.format(new Date());
        return strDate;
    }

    /**
     * 获得前一天的时间
     * 
     * @return String
     */
    public static String getPreviousDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String str = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        str = formatter.format(cal.getTime());
        return str;
    }

    /**
     * 格式化金额
     * 
     * @param acc
     *            String
     * @return String
     */
    public static String formatAcc(String acc)
    {
        // 如果是0，直接返回
        if (Float.parseFloat(acc) == 0)
        {
            return ParseConfig.messageMaps.get("Tools.tool_1");
        }

        int length = acc.length();
        String upper = "";
        double fee = Double.parseDouble(acc);
        if (fee % 10000D == 0.0D)
        {
            for (int i = length - 1; i >= 0; i--)
            {
                if (i <= 0)
                {
                    char array[] = new char[1];
                    array[0] = acc.charAt(i);
                    if (Integer.parseInt(new String(array)) != 0)
                    {
                        upper = formatNum(Integer.parseInt(new String(array))) + formatIndex(length - i) + upper;
                    }
                }
            }
            upper = upper + ParseConfig.messageMaps.get("Tools.tool_2");
        }
        else if (fee % 1000D == 0.0D)
        {
            for (int i = length - 1; i >= 0; i--)
            {
                if (i <= 1)
                {
                    char array[] = new char[1];
                    array[0] = acc.charAt(i);
                    if (Integer.parseInt(new String(array)) != 0)
                    {
                        upper = formatNum(Integer.parseInt(new String(array))) + formatIndex(length - i) + upper;
                    }
                }
            }
            upper = upper + ParseConfig.messageMaps.get("Tools.tool_2");
        }
        else if (fee % 100D == 0.0D)
        {
            for (int i = length - 1; i >= 0; i--)
            {
                if (i <= 2)
                {
                    char array[] = new char[1];
                    array[0] = acc.charAt(i);
                    if (Integer.parseInt(new String(array)) != 0)
                    {
                        upper = formatNum(Integer.parseInt(new String(array))) + formatIndex(length - i) + upper;
                    }
                }
            }
            upper = upper + ParseConfig.messageMaps.get("Tools.tool_2");
        }
        else if (fee % 10D == 0.0D)
        {
            for (int i = length - 1; i >= 0; i--)
            {
                if (i <= 3)
                {
                    if (i != length - 3)
                    {
                        char array[] = new char[1];
                        array[0] = acc.charAt(i);
                        if (Integer.parseInt(new String(array)) != 0)
                        {
                            upper = formatNum(Integer.parseInt(new String(array))) + formatIndex(length - i) + upper;
                        }
                    }
                }
            }
            upper = upper + ParseConfig.messageMaps.get("Tools.tool_2");
        }
        else if (fee % 1.0D == 0.0D)
        {
            for (int i = length - 1; i >= 0; i--)
            {
                if (i <= 4)
                {
                    if (i != length - 3)
                    {
                        char array[] = new char[1];
                        array[0] = acc.charAt(i);
                        if (Integer.parseInt(new String(array)) != 0)
                        {
                            upper = formatNum(Integer.parseInt(new String(array))) + formatIndex(length - i) + upper;
                        }
                    }
                }
            }
            upper = upper + ParseConfig.messageMaps.get("Tools.tool_3");
        }
        else
        {
            for (int i = length - 1; i >= 0; i--)
            {
                if (i != length - 3)
                {
                    char array[] = new char[1];
                    array[0] = acc.charAt(i);
                    upper = formatNum(Integer.parseInt(new String(array))) + formatIndex(length - i) + upper;
                }
            }
        }
        return upper;
    }

    /**
     * 格式化序号
     * 
     * @param index
     *            int
     * @return String
     */
    private static String formatIndex(int index)
    {
        switch (index)
        {
            case 1: // '\001'
                return ParseConfig.messageMaps.get("Tools.tool_4");

            case 2: // '\002'
                return ParseConfig.messageMaps.get("Tools.tool_5");

            case 3: // '\003'
                return "";

            case 4: // '\004'
                return ParseConfig.messageMaps.get("Tools.tool_6");

            case 5: // '\005'
                return ParseConfig.messageMaps.get("Tools.tool_7");

            case 6: // '\006'
                return ParseConfig.messageMaps.get("Tools.tool_8");

            case 7: // '\007'
                return ParseConfig.messageMaps.get("Tools.tool_9");

            case 8: // '\b'
                return ParseConfig.messageMaps.get("Tools.tool_10");
        }
        return "";
    }

    /**
     * 格式化数字，获得大写
     * 
     * @param num
     *            int 数字
     * @return String
     */
    private static String formatNum(int num)
    {
        switch (num)
        {
            case 0:
                return ParseConfig.messageMaps.get("Tools.tool_11");

            case 1:
                return ParseConfig.messageMaps.get("Tools.tool_12");

            case 2:
                return ParseConfig.messageMaps.get("Tools.tool_13");

            case 3:
                return ParseConfig.messageMaps.get("Tools.tool_14");

            case 4:
                return ParseConfig.messageMaps.get("Tools.tool_15");

            case 5:
                return ParseConfig.messageMaps.get("Tools.tool_16");

            case 6:
                return ParseConfig.messageMaps.get("Tools.tool_17");

            case 7:
                return ParseConfig.messageMaps.get("Tools.tool_18");

            case 8:
                return ParseConfig.messageMaps.get("Tools.tool_19");

            case 9:
                return ParseConfig.messageMaps.get("Tools.tool_20");
        }
        return "";
    }

    /**
     * 函数功能：获得当前日期
     * 
     * @return 返回当前日期的字符变量，如"120000"
     */
    public static String getNowTime()
    {
        Date d = new Date();
        String str = "";
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
        str = formatter.format(d);
        return str;
    }

    /**
     * 获得当前月份
     * 
     * @return String 格式：200705
     */
    public static String getMonth()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String strDate = dateFormat.format(new Date());
        return strDate;
    }

    /**
     * 获得当前月份
     * 
     * @return String 格式：2007-05
     */
    public static String getMonth2()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        String strDate = dateFormat.format(new Date());
        return strDate;
    }

    /**
     * 获得该月的第一天日期和最后一天日期
     * 
     * @param year
     *            int 年份
     * @param month
     *            int 月份
     * @return String[]
     */
    public static String[] getMonth(int year, int month)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String[] dates = new String[2];
        Calendar startCal = Calendar.getInstance();
        startCal.set(year, month - 1, 1);
        dates[0] = format.format(startCal.getTime());

        Calendar endCal = Calendar.getInstance();
        endCal.set(year, month, 1);
        endCal.add(Calendar.DATE, -1);
        dates[1] = format.format(endCal.getTime());
        return dates;
    }

    /**
     * 由日期获取日期所在月份
     * 
     * @param date
     *            日期变量，如2003-3-3
     * @param type
     *            (1表示当前日期的字符串格式,如"200612" ,2表示当前日期的日期格式,如"2006-12")
     * @return 月份
     */
    public static String formatMonth(Date date, int type)
    {
        if (date == null)
        {
            return "";
        }
        SimpleDateFormat bartDateFormat = null;
        if (type == 1)
        {
            bartDateFormat = new SimpleDateFormat("yyyyMM");
        }
        if (type == 2)
        {
            bartDateFormat = new SimpleDateFormat("yyyy-MM");
        }
        String disp = bartDateFormat.format(date);
        return disp;
    }

    /**
     * 获得两个日期之间的所有月份；
     * 
     * @param startdate
     *            起始日期
     * @param enddate
     *            截止日期
     * @return 两个月份之间的所有月份
     */
    public static List<String> getAllMonth(String startdate, String enddate)
    {
        String startMon = startdate.substring(0, 6);
        String endMon = enddate.substring(0, 6);
        List<String> dateList = new ArrayList<String>();
        if (startMon == null || startMon.length() == 0 || endMon == null || endMon.length() == 0)
        {
            return dateList;
        }

        try
        {
            SimpleDateFormat startDF = new SimpleDateFormat("yyyyMM");
            startDF.parse(startMon);
            Calendar startCal = startDF.getCalendar();
            SimpleDateFormat endDF = new SimpleDateFormat("yyyyMM");
            endDF.parse(endMon);
            Calendar endCal = endDF.getCalendar();

            while (startCal.before(endCal))
            {
                dateList.add(formatMonth(startCal.getTime(), 1));
                startCal.add(Calendar.MONTH, 1);
            }
            dateList.add(endMon);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return dateList;
    }

    /**
     * 获得两个月之间的所有月份；
     * 
     * @param startMon
     *            起始月份
     * @param endMon
     *            截止月份
     * @return 两个月份之间的所有月份
     */
    public static List<String> getAllMonths(String startMon, String endMon)
    {
        List<String> dateList = new ArrayList<String>();
        if (startMon == null || startMon.length() == 0 || endMon == null || endMon.length() == 0)
        {
            return dateList;
        }

        try
        {
            SimpleDateFormat startDF = new SimpleDateFormat("yyyyMM");
            startDF.parse(startMon);
            Calendar startCal = startDF.getCalendar();
            SimpleDateFormat endDF = new SimpleDateFormat("yyyyMM");
            endDF.parse(endMon);
            Calendar endCal = endDF.getCalendar();

            while (startCal.before(endCal))
            {
                dateList.add(formatMonth(startCal.getTime(), 1));
                startCal.add(Calendar.MONTH, 1);
            }
            dateList.add(endMon);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return dateList;
    }

    /**
     * 根据起止日期获得各个需要统计的计费月度
     * 
     * @param startdate
     *            起始日期
     * @param enddate
     *            终止日期
     * @return 月份列表
     */
    public static List<String> getMonths(String startdate, String enddate)
    {
        List<String> monthList = new ArrayList<String>();
        try
        {
            startdate = formatDate4(startdate);
            enddate = formatDate4(enddate);

            SimpleDateFormat startDF = new SimpleDateFormat("yyyyMMdd");
            startDF.parse(startdate);
            Calendar startCal = startDF.getCalendar();

            SimpleDateFormat endDF = new SimpleDateFormat("yyyyMMdd");
            endDF.parse(enddate);
            Calendar endCal = endDF.getCalendar();

            // 判断起始日期的所属财务月度
            startCal.set(Calendar.DAY_OF_MONTH, 1);
            startCal.add(Calendar.MONTH, 1);

            // 加入所有的财务月度
            while (endCal.after(startCal))
            {
                monthList.add(Integer.toString(startCal.get(Calendar.MONTH) + 1));
                startCal.add(Calendar.MONTH, 1);
            }
            monthList.add(Integer.toString(endCal.get(Calendar.MONTH) + 1));
        }
        catch (Exception ex)
        {
            monthList = null;
        }
        return monthList;
    }

    /**
     * 获得从2007年至当前年的前或后N（根据参数定制）年的所有年份
     * 
     * @param num
     *            距离当年的一个数，例：1表示当年的下年，-2表示前年。
     * @return 年份数组
     */
    private static String[] getToCurYearsWithNum(int num)
    {
        int startYear = 2007;
        Calendar c = Calendar.getInstance();
        int curYear = c.get(Calendar.YEAR) + num;
        String[] years = new String[curYear - startYear + 1];
        for (int i = startYear, j = 0; i <= curYear; i++, j++)
        {
            years[j] = "" + i;
        }
        return years;
    }

    /**
     * 获得从2007至当前年的所有年份
     * 
     * @return String[] 2007至当前年的所有年份
     */
    public static String[] getToCurYears()
    {
        return getToCurYearsWithNum(0);
    }

    /**
     * 获得所有的两位和正常数字对应的12个月份。
     * 
     * @return 所有月份，例如：String[]{ { "01", "1" }, { "02", "2" }, ... { "12", "12" } }
     */
    public static String[][] getMonths()
    {
        String[][] months = new String[12][2];

        for (int i = 1, j = 0; i <= 12; i++, j++)
        {
            months[j][0] = i < 10 ? "0" + i : "" + i;
            months[j][1] = "" + i;
        }

        return months;
    }

    /**
     * 获得上个计费月度
     * 
     * @return 上个计费月度
     */
    public static String getPreFeeMonth()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.MONTH, -1);
        return formatMonth(cal.getTime(), 1);
    }

    /**
     * 根据输入年月获取其上一个月份(YYYYMM)
     * 
     * @param yearMonth
     *            年月
     * @return 日期(YYYYMM)
     */
    public static String getPreMonth(String yearMonth)
    {
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(4, 6));
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        c.add(Calendar.DATE, -1);
        String mon;
        if (c.get(Calendar.MONTH) + 1 < 10)
        {
            mon = "0" + String.valueOf(c.get(Calendar.MONTH) + 1);
        }
        else
            mon = String.valueOf(c.get(Calendar.MONTH) + 1);

        return String.valueOf(c.get(Calendar.YEAR)) + mon;

    }

    /**
     * 获得上月的最后一天和该月最后一天日期
     * 
     * @param year
     *            int 年份
     * @param month
     *            int 月份
     * @return String[]
     */
    public static String[] getMonth2(int year, int month)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String[] dates = new String[2];
        Calendar startCal = Calendar.getInstance();
        startCal.set(year, month - 1, 1);
        startCal.add(Calendar.DATE, -1);
        dates[0] = format.format(startCal.getTime());

        Calendar endCal = Calendar.getInstance();
        endCal.set(year, month, 1);
        endCal.add(Calendar.DATE, -1);
        dates[1] = format.format(endCal.getTime());
        return dates;
    }

    /**
     * 获得前一天的日期
     * 
     * @return 返回前一天日期的字符串变量，如"20030711"
     */
    public static String getlastDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String str = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        str = formatter.format(cal.getTime());
        return str;
    }

    /**
     * 获得系统前一个礼拜的起始日期和终止日期
     * 
     * @return 数组第一个分素是起始日期，第二个是终止日期
     */
    public static String[] getWeek()
    {
        String[] dates = new String[2];
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (day == 1)
        {
            cal.add(Calendar.DATE, -7);
        }
        else
        {
            cal.add(Calendar.DATE, -(day - 1));
        }
        dates[1] = formatDate(cal.getTime());
        cal.add(Calendar.DATE, -6);
        dates[0] = formatDate(cal.getTime());
        return dates;
    }

    /**
     * 获得两个日期之间的天数日期格式为yyyy-MM-dd
     * 
     * @param startTime
     *            起始日期
     * @param endTime
     *            结束日期
     * @return int
     */
    public static int getDateFromTime1ToTime2(String startTime, String endTime)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date dt1 = null;
        Date dt2 = null;
        int checkDays = 0;
        try
        {
            dt1 = formatter.parse(endTime);
            dt2 = formatter.parse(startTime);
            long l = dt1.getTime() - dt2.getTime();
            l = (long) (l / (1000 * 60 * 60 * 24) + 0.5);
            checkDays = Integer.parseInt(String.valueOf(l));
        }
        catch (ParseException e)
        {
            return checkDays;
        }
        return checkDays / 365;
    }

    /**
     * 获得上一个自然月的起始日期和终止日期
     * 
     * @return 数组第一个分素是起始日期，第二个是终止日期
     */
    public static String[] getlastMonth()
    {
        String[] dates = new String[2];
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.MONTH, -1);
        cal2.set(Calendar.DATE, 1);
        cal2.add(Calendar.DATE, -1);
        dates[0] = formatDate(cal.getTime());
        dates[1] = formatDate(cal2.getTime());
        return dates;
    }

    /**
     * 获得收费日期
     * 
     * @return String
     */
    public static String getOptTime()
    {
        Calendar cal = Calendar.getInstance();
        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DATE));
        if (month.length() == 1)
        {
            month = "0" + month;
        }
        if (day.length() == 1)
        {
            day = "0" + day;
        }
        return year + ParseConfig.messageMaps.get("Tools.tool_21") + month
                + ParseConfig.messageMaps.get("Tools.tool_22") + day + ParseConfig.messageMaps.get("Tools.tool_23");
    }

    /**
     * 获得自动停复机系统IP
     * 
     * @return String
     */
    public static String getAutoIP()
    {
        String autoIP = "";
        try
        {
            Properties a = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("catalina.home") + File.separator
                    + "iservice.properties");
            a.load(fis);
            autoIP = a.getProperty("AutoIP");
            fis.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return autoIP;
    }

    /**
     * 获得自动停复机系统端口号
     * 
     * @return int
     */
    public static int getAutoPort()
    {
        String autoPort = "0";
        try
        {
            Properties a = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("catalina.home") + File.separator
                    + "iservice.properties");
            a.load(fis);
            autoPort = a.getProperty("AutoPort");
            fis.close();
        }
        catch (Exception e)
        {
            autoPort = "0";
            e.printStackTrace();
        }
        return Integer.parseInt(autoPort);
    }

    /**
     * 日期加减
     * 
     * @param offset
     *            日期间隔天数
     * @return 日期（yyyy-MM-dd）
     */
    public static String changeDay(int offset)
    {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, (calendar.get(Calendar.DAY_OF_YEAR) + offset));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String day = formatter.format(calendar.getTime());
        return day;
    }

    /**
     * 系统提示错误编码和含义对应
     * 
     * @param code
     *            错误编码
     * @return 含义
     */
    public static String checkError(String code)
    {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("00", ParseConfig.messageMaps.get("Tools.tool_24"));
        hm.put("01", ParseConfig.messageMaps.get("Tools.tool_25"));

        if (hm.containsKey(code.trim()))
        {
            return hm.get(code.trim());
        }
        else
        {
            return ParseConfig.messageMaps.get("Tools.tool_26");
        }
    }

    /**
     * 生成字符串的MAC校验码
     * 
     * @param src
     *            字符串
     * @return MAC校验码
     */
    public static String getMac(String src)
    {
        byte[] data = src.getBytes();
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ByteArrayInputStream input;
        byte[] mac = new byte[8];
        try
        {
            bout.write(data);

            int cover = data.length % 8;

            if (cover != 0)
            {// 如果不为8的倍数，则补位
                for (int i = 0; i < (8 - cover); i++)
                {
                    bout.write(0xff);
                }
            }
            data = bout.toByteArray();
            input = new ByteArrayInputStream(data);
            int ennumber = data.length / 8;
            byte[] temp;
            for (int i = 0; i < ennumber; i++)
            {
                temp = new byte[8];
                input.read(temp);
                for (int j = 0; j < 8; j++)
                {
                    mac[j] = (byte) (mac[j] ^ temp[j]);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new String(mac);
    }

    /**
     * 获得字符串的MAC校验码的ASCII码
     * 
     * @param src
     *            字符串
     * @return ASCII码
     */
    public static String getMacAscii(String src)
    {
        String mac = getMac(src);
        StringBuffer ascii = new StringBuffer();
        for (int i = 0, ii = mac.length(); i < ii; i++)
        {
            ascii.append((int) mac.charAt(i));
        }
        return ascii.toString();
    }

    /**
     * 重复字符串规定的次数
     * 
     * @param s
     *            要重复的字符串
     * @param num
     *            重复的次数，必须大于0，为0时返回""。
     * @return 返回重复后的字符串
     */
    public static String repeat(String s, int num)
    {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < num; i++)
        {
            str.append(s);
        }
        return str.toString();
    }

    /**
     * 将序号格式化为字符串，不足位数在前面补0
     * 
     * @param sn
     *            long 序号
     * @param length
     *            int 字符串位数
     * @return String
     */
    public static String formatSn(long sn, int length)
    {
        String str = sn + "";
        String strSn = str;
        for (int i = 0; i < length - str.length(); i++)
        {
            strSn = "0" + strSn;
        }
        return strSn;
    }

    /**
     * 获得32位唯一序列号
     * 
     * @return String
     */
    public static String getUUID_32()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }

    /**
     * 获取几天前的日期，格式为yyyyMMddhhmmss
     * 
     * @return 从现在到上周的时间字符串
     */
    public static String getDayofNum(int day)
    {
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        ca.set(Calendar.DAY_OF_YEAR, ca.get(Calendar.DAY_OF_YEAR) - day);
        Date da = ca.getTime();
        return sdf.format(da);
    }

    /**
     * 获取几年前的日期
     * 
     * @param year
     * @return
     */
    public static String getYearofNum(int year)
    {
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        ca.set(Calendar.YEAR, ca.get(Calendar.YEAR) - year);
        Date da = ca.getTime();
        return sdf.format(da);
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // System.out.println(getDayofNum(7));
        // System.out.println(ParseConfig.messageMaps.get("Tools.tool_27") +
        // getDataArr("121j232jk343433k343k").length);
    }

    /**
     * 获取从现在到上一个月的时间，格式为yyyyMMddhhmmss
     * 
     * @return 从现在到上一个月的时间字符串
     */
    public static String getLastMonthTime()
    {
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        ca.set(Calendar.MONTH, ca.get(Calendar.MONTH) - 1);
        Date da = ca.getTime();
        return sdf.format(da);
    }

    /**
     * 金额——由分转换为元 String fee
     * 
     * @return String
     */
    public static String centToYuan(String fee)
    {
        return formatE(Double.parseDouble(fee) / 100D);
    }

    /**
     * 金额——由元转换为分 String fee
     * 
     * @return String
     */
    public static int yuanToCent(String fee)
    {
        double dfee = Double.parseDouble(fee);
        return (int) (Math.round(dfee * 100));
    }

    /**
     * 静态方法,获得某一日期的前n天的日期
     * 
     * @param date
     *            既定日期,以此日期为基准进行查询.格式为"yyyyMMddhhmmss"
     * @param n
     *            在给定日期上加或减的天数.当n为正值时,将获得将来第n天的日期, 当n为负值时,将获得过去n天前的日期
     * @return String字符串,格式为"yyyyMMdd"
     */
    public static String getPreviousDate(String date, int n)
    {
        String str = "";

        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
            formatter.parse(date);
            Calendar tempCal = formatter.getCalendar();
            tempCal.add(Calendar.DATE, n);
            str = formatter.format(tempCal.getTime());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return str;
    }

    /**
     * 静态方法,获得某一日期的n小时的日期
     * 
     * @param date
     *            既定日期,以此日期为基准进行查询.格式为"yyyyMMddhhmmss"
     * @param n
     *            在给定日期上加或减的天数.当n为正值时,将获得将来第n天的日期, 当n为负值时,将获得过去n天前的日期
     * @return String字符串,格式为"yyyyMMdd"
     */
    public static String getPreviousHour(String date, int n)
    {
        String str = "";

        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
            formatter.parse(date);
            Calendar tempCal = formatter.getCalendar();
            tempCal.add(Calendar.HOUR, n);
            str = formatter.format(tempCal.getTime());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return str;
    }

    /**
     * 静态方法,获得某一日期的n年的日期
     * 
     * @param date
     *            既定日期,以此日期为基准进行查询.格式为"yyyyMMddhhmmss"
     * @param n
     *            在给定日期上加或减的天数.当n为正值时,将获得将来第n天的日期, 当n为负值时,将获得过去n天前的日期
     * @return String字符串,格式为"yyyyMMdd"
     */
    public static String getPreviousYear(String date, int n)
    {
        String str = "";

        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
            formatter.parse(date);
            Calendar tempCal = formatter.getCalendar();
            tempCal.add(Calendar.YEAR, n);
            str = formatter.format(tempCal.getTime());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return str;
    }

    /**
     * 静态方法,获得某一日期的n月的日期
     * 
     * @param date
     *            既定日期,以此日期为基准进行查询.格式为"yyyyMMddhhmmss"
     * @param n
     *            在给定日期上加或减的天数.当n为正值时,将获得将来第n天的日期, 当n为负值时,将获得过去n天前的日期
     * @return String字符串,格式为"yyyyMMdd"
     */
    public static String getPreviousMonth(String date, int n)
    {
        String str = "";

        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
            formatter.parse(date);
            Calendar tempCal = formatter.getCalendar();
            tempCal.add(Calendar.MONTH, n);
            str = formatter.format(tempCal.getTime());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return str;
    }

    /**
     * 获得随机数 int number 获得随即数的位数
     * 
     * @return String 随机数
     */
    public static String getRandom(int number)
    {
        Random ra = new Random();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < number; i++)
        {
            result.append(ra.nextInt(6));
        }
        return result.toString();
    }

    /**
     * 根据提供的页面信息，获取下一页的开始页码,该方法不考虑页码总数
     * 
     * @param crrentPage
     *            当前页码,从1开始
     * @param next
     *            下一页（上一页）
     * @param pageNum
     *            每页元素个数
     * @return 下一页开始页码，如果页码数据无效则返回-1
     */
    public static int getIndex(int crrentPage, int next, int pageNum)
    {
        if (crrentPage < 0 || pageNum <= 0)
        {
            return -1;
        }
        if (crrentPage == 1 && next == -1)
        {
            return -1;
        }
        if ((crrentPage + next) <= 0)
        {
            return -1;
        }
        if (crrentPage == 0)
        {
            return 1;
        }
        return (crrentPage + next - 1) * pageNum + 1;
    }

    /**
     * 获得n天后的日期（yyyyMMddHHmmss）
     * 
     * @param n
     * @return str 格式：yyyyMMddHHmmss
     */
    public static String getAfterDate(int n)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, n);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = formatter.format(cal.getTime());
        return str;
    }

    /**
     * 将字符串转换为数字数组，去除中间的所有的非数字符号,可能包含空串
     * 
     * @param str
     *            包含其他符号的数字字符串
     * @return 只包含数字的数组
     */
    public static String[] getDataArr(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isDigit(str.charAt(i)))
            {
                str = str.replace(str.charAt(i), '#');
            }
        }
        return str.split("#", 0);
    }

    /**
     * 获取本周的第一天，格式为yyyyMMdd
     * 
     * @return 从现在到上周的时间字符串
     */
    public static String getfirstDayOfWeek()
    {
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        ca.set(Calendar.DAY_OF_WEEK, 1);
        Date da = ca.getTime();
        return sdf.format(da);
    }

    /**
     * 获取本月的第一天，格式为yyyyMMdd
     * 
     * @return 从现在到上周的时间字符串
     */
    public static String getfirstDayOfMonth()
    {
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        ca.set(Calendar.DAY_OF_MONTH, 1);
        Date da = ca.getTime();
        return sdf.format(da);
    }

    /**
     * 获取几天前的日期，格式为yyyyMMdd type -1——当前时间减，2——当前时间加
     * 
     * @return 时间字符串
     */
    public static String getYearofNum(int year, int type)
    {
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        if (type == -1)
        {
            ca.set(Calendar.YEAR, ca.get(Calendar.YEAR) + year);
        }
        else
        {
            ca.set(Calendar.YEAR, ca.get(Calendar.YEAR) - year);
        }
        Date da = ca.getTime();
        return sdf.format(da);
    }

    /**
     * 获取几天前的日期，格式为yyyyMMdd type -1——当前时间减，2——当前时间加
     * 
     * @return 时间字符串
     */
    public static String getMonthofNum(int year, int type)
    {
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        if (type == -1)
        {
            ca.set(Calendar.MONTH, ca.get(Calendar.MONTH) + year);
        }
        else
        {
            ca.set(Calendar.MONTH, ca.get(Calendar.MONTH) - year);
        }
        Date da = ca.getTime();
        return sdf.format(da);
    }

    /**
     * 获取几天前的日期，格式为yyyyMMdd type -1——当前时间减，2——当前时间加
     * 
     * @return 时间字符串
     */
    public static String getDayofNum(int day, int type)
    {
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        if (type == -1)
        {
            ca.set(Calendar.DAY_OF_YEAR, ca.get(Calendar.DAY_OF_YEAR) - day);

        }
        else
        {
            ca.set(Calendar.DAY_OF_YEAR, ca.get(Calendar.DAY_OF_YEAR) + day);
        }
        Date da = ca.getTime();
        return sdf.format(da);
    }

    /**
     * 获取几分钟前的时间，格式为yyyyMMddHHmmss type -1——当前时间减，2——当前时间加
     * 
     * @return 从时间字符串
     */
    public static String getMinuteofNum(int minute, int type)
    {
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        if (type == -1)
        {
            ca.set(Calendar.MINUTE, ca.get(Calendar.MINUTE) - minute);
        }
        else
        {
            ca.set(Calendar.MINUTE, ca.get(Calendar.MINUTE) + minute);
        }
        Date da = ca.getTime();
        return sdf.format(da);
    }

    /**
     * 获得指定分钟之后的日期
     * 
     * @param minute
     *            为正时为指定分钟之后的日期，为负时为指定分钟之前的日期
     * @return 日期字符串，格式为"yyyyMMddHHmmss"
     */
    public static String getTimeOfMinute(int minute)
    {
        Calendar ca = Calendar.getInstance();
        long time = ca.getTimeInMillis() + minute * 60 * 1000;
        ca.setTimeInMillis(time);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(ca.getTime());
    }

    public static boolean isNotNull(String msg)
    {
        boolean flag = false;
        if (msg != null && msg.trim().length() > 0 && !"null".equals(msg))
        {
            flag = true;
        }
        return flag;
    }

    /**
     * 判断字符是否为空，如果空字符串，也返回true
     * 
     * @param msg
     * @return
     */
    public static boolean isNull(String msg)
    {
        boolean flag = true;
        if (msg != null && msg.trim().length() > 0 && !"null".equals(msg))
        {
            flag = false;
        }
        return flag;
    }

    /**
     * sql注入
     * 
     * @param sqlquery
     *            原sql
     * @return 替换后的sql
     */
    public static String checksqlerr(String sqlquery)
    {
        if (sqlquery == null || "".equals(sqlquery))
        {
            return sqlquery;
        }
        if (sqlquery.contains("'"))
        {
            sqlquery = sqlquery.replaceAll("'", "");
        }
        if (sqlquery.contains("--"))
        {
            sqlquery = sqlquery.replaceAll("--", "");
        }
        // 过滤HTML标签信息
        sqlquery = html2Text(sqlquery);

        return sqlquery;
    }

    /**
     * 过滤HTML标签信息
     * 
     * @param inputString
     *            输入的信息
     * @return 返回的信息
     */
    public static String html2Text(String inputString)
    {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;

        try
        {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
                                                                                                     // }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
                                                                                                  // }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll("*"); // 过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll("*"); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll("*"); // 过滤html标签

            textStr = htmlStr;

        }
        catch (Exception e)
        {
            System.err.println("Html2Text: " + e.getMessage());
        }
        return textStr;// 返回文本字符串
    }

    // 判断是否是数字
    public static boolean isNumeric(String str)
    {
        if (isNull(str))
        {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches())
        {
            return false;
        }
        return true;
    }

    /**
     * 截取商品描述
     * 
     * @param info
     *            原始描述
     * @return 截取后的描述
     */
    public static String subAppInfo(String info)
    {
        if (info.length() > 25)
        {
            info = info.substring(0, 25) + ".....";
        }
        return info;
    }

    public static int getDateFromTime1ToTime3(String startTime, String endTime)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date dt1 = null;
        Date dt2 = null;
        int checkDays = 0;
        try
        {
            dt1 = formatter.parse(endTime);
            dt2 = formatter.parse(startTime);
            long l = dt1.getTime() - dt2.getTime();
            l = (long) (l / (1000 * 60 * 60 * 24) + 0.5);
            checkDays = Integer.parseInt(String.valueOf(l));
        }
        catch (ParseException e)
        {
            return checkDays;
        }
        return checkDays;
    }

    /**
     * 获得两个日期之间共有多少年
     */
    public static int getTotleYearFromTime1AndTime2(String startTime, String endTime)
    {
        int totleYear = 1;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(startTime));
            int endYear = calendar.get(Calendar.YEAR);
            calendar.setTime(sdf.parse(endTime));
            int startYear = calendar.get(Calendar.YEAR);
            totleYear = startYear - endYear;
        }
        catch (ParseException e)
        {
            // Log.error("获得两个日期之间共有多少年",e);
        }
        return totleYear;
    }

    /**
     * 获取当前页起始序号，从0开始
     * 
     * @return
     */
    public static int getFirstIndex(int pageNo, int pageSize)
    {
        if (pageNo <= 0 || pageSize <= 0)
        {
            return -1;
        }
        if (pageNo == 1)
        {
            return 0;
        }
        return (pageNo - 1) * pageSize;
    }

    public static boolean checkEmail(String emailStr)
    {
        String check = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(emailStr);
        return matcher.matches();
    }

    /**
     * 验证是否为手机格式
     * 
     * @phoneNumber 传入的手机号
     */
    public static boolean checkPhoneNumber(String phoneNumber)
    {
        int length = phoneNumber.length();
        if (length >= 11)
        {
            phoneNumber = phoneNumber.substring(length - 11, length);
        }
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }

    /**
     * 生成数字型随机验证码
     * 
     * @param length
     *            需要生成的随机验证码长度
     * @return 指定长度的随机验证码
     */
    public static String createRandomCheck(int length)
    {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++)
        {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public synchronized static String getCurrentTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmssSS");
        return sdf.format(new Date());
    }

    public static char getDcacheSpace(String spaceName)
    {
        char result = '\000';
        try
        {
            /* 获取配置的缓存空间地址 */
            String key = ApplicationGlobalResource.getInstance().getValueByKey(spaceName);
            result = (char) ('\0' + Integer.parseInt(key));
        }
        catch (Exception e)
        {
            System.out.println("获取缓存空间失败" + e);
        }
        return result;
    }

    public static Long getfalg(int level)
    {
        ApplicationGlobalResource agr = ApplicationGlobalResource.getInstance();
        String time = agr.getValueByKey("store.dcache_time_level" + level);
        if (null == time || "".equals(time))
        {
            time = "0";
        }
        return Long.parseLong(time);
    }

    public static final Long MS_TIME_LEVEL1 = getfalg(1);
    public static final Long MS_TIME_LEVEL2 = getfalg(2);
    public static final Long MS_TIME_LEVEL3 = getfalg(3);
    public static final Long MS_TIME_LEVEL4 = getfalg(4);
    public static final Long MS_TIME_LEVEL5 = getfalg(5);
    public static final Long MS_TIME_LEVEL6 = getfalg(6);
    public static final String SERVICEKEY = "AppStore";

    public static Long getMemcacheTime(String key)
    {
        String time = ApplicationGlobalResource.getInstance().getValueByKey(key);
        if (null == time || "".equals(time))
        {
            time = "0";
        }
        return Long.parseLong(time);
    }

    protected static final MessageDigest getMessageDigest()
    {
        String algorithm = "MD5";
        try
        {
            return MessageDigest.getInstance(algorithm);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new IllegalArgumentException("No such algorithm [" + algorithm + "]", e);
        }
    }

    public static String encodePassword(String rawPass)
    {

        MessageDigest messageDigest = getMessageDigest();
        byte[] digest;
        try
        {
            digest = messageDigest.digest(rawPass.getBytes("UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            throw new IllegalStateException("UTF-8 not supported!");
        }
        return new String(Hex.encodeHex(digest));
    }

    public static void createCharByOpenFire(String roomID)
    {
        Connection connection = OpenfireConnection.getConnection();
        if (connection != null && connection.isConnected() == true)
        {
            String loginUser = connection.getUser();
            if (Tools.isNull(loginUser))
            {
                try
                {
                    connection.login("uniadmin", "111111");
                }
                catch (XMPPException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            RoomInfo rooms = null;
            try
            {

                try
                {
                    rooms = MultiUserChat
                            .getRoomInfo(connection, roomID + "@conference." + connection.getServiceName());
                }
                catch (XMPPException e)
                {
                    if ("item-not-found(404)".equals(e.getMessage()))
                    {
                        rooms = null;
                    }
                }

                if (rooms == null)
                {
                    MultiUserChat muc = new MultiUserChat(connection, roomID + "@conference."
                            + connection.getServiceName());
                    muc.create("group");
                    Form form = muc.getConfigurationForm();

                    // 根据原始表单创建一个要提交的新表单。
                    Form submitForm = form.createAnswerForm();
                    // 向要提交的表单添加默认答复
                    for (Iterator fields = form.getFields(); fields.hasNext();)
                    {
                        FormField field = (FormField) fields.next();
                        if (!FormField.TYPE_HIDDEN.equals(field.getType()) && field.getVariable() != null)
                        {
                            // 设置默认值作为答复
                            submitForm.setDefaultAnswer(field.getVariable());
                        }
                    }
                    // 设置聊天室是持久聊天室，即将要被保存下来
                    submitForm.setAnswer("muc#roomconfig_persistentroom", true);
                    muc.sendConfigurationForm(submitForm);
                }
            }
            catch (XMPPException e)
            {
                // TODO Auto-generated catch block

            }

        }
        else
        {
            new OpenfireConnection();
        }
    }

    public static void appadd(String mobile_phone, String sms_content)
    {

        try
        {
            // 创建连接
            URL url = new URL(ADD_URL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);

            connection.setInstanceFollowRedirects(true);
            String msg_id = "qewqrw212213231rrrq";
            String client_id = "USER";
            String client_secret = "5d64e460b5bd8522";
            String sp_number = "";
            String charge_number = "";

            connection.setRequestProperty("msg_id", msg_id);
            connection.setRequestProperty("client_id", client_id);
            connection.setRequestProperty("client_secret", client_secret);

            connection.connect();

            // POST请求
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            JSONObject obj = new JSONObject();
            String content = sms_content;
            obj.element("sms_content", content);
            obj.element("mobile_phone", mobile_phone);
            obj.element("sp_number", sp_number);
            obj.element("charge_number", charge_number);
            String sign = encodePassword(msg_id + content + mobile_phone + sp_number + charge_number + client_id
                    + client_secret);
            obj.element("sign", sign);
            JSONObject obj2 = new JSONObject();
            obj2.element("send", obj.toString());

            System.out.println(obj2.toString());

            out.write(obj2.toString().getBytes("UTF-8"));
            out.flush();
            out.close();

            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null)
            {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            reader.close();
            // 断开连接
            connection.disconnect();
        }
        catch (MalformedURLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
