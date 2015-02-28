package com.pinke.uni.mobile.protal.util;



import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StoreTools {


    /**
     * 获取精分接口的关键信息
     *
     * @param pfcstr
     * @return
     */
    public static String filterPfcStr(String pfcstr) {
        if (pfcstr.indexOf("|") >= 0) {
            pfcstr = pfcstr.replaceAll("\\|", "");
        }
        if (pfcstr.indexOf("\n") >= 0) {
            pfcstr = pfcstr.replaceAll("\n", "");
        }
        if (pfcstr.indexOf("\r") >= 0) {
            pfcstr = pfcstr.replaceAll("\r", "");
        }
        return pfcstr;
    }


    public static String formatFilePath(String filePath) {
        String path = filePath;
        if (filePath.endsWith("\\") || filePath.endsWith("/")) {
            return path;
        }
        path += File.separator;
        return path;
    }

    /**
     * 对于数字前补0
     *
     * @param str 输入的字符串
     * @param num 长度
     * @return String 前补0后的字符串
     */
    public static String headFillZero(String str, int num) {
        //stringbuffer添加0
        StringBuffer buffer = new StringBuffer();
        //如果长度小于指定长度，则前补0
        if (str.length() < num) {
            for (int i = 0; i < num - str.length(); i++) {
                buffer.append("0");
            }
        }
        //返回的字符串
        str = buffer.toString() + str;

        return str;
    }

    /**
     * 将ISO编码转换为GBK编码
     *
     * @param output String  输入字符串
     * @return String  输出字符串
     */
    public static String decode(String output) {
        try {
            return new String(output.getBytes("ISO-8859-1"), "GBK");
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * 将GBK编码转换为ISO编码
     *
     * @param input String  输入字符串
     * @return String  输出字符串
     */
    public static String encode(String input) {
        try {
            return new String(input.getBytes("GBK"), "ISO-8859-1");
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * 格式化日期，格式如2006-07-09
     *
     * @param date Date  日期
     * @return String  输出字符串
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        } else {
            String disp = "";
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            disp = bartDateFormat.format(date);
            return disp;
        }
    }

    /**
     * 格式化日期，格式如2006-07-09 23:00:00
     *
     * @param date Date  日期
     * @return String  输出字符串
     */
    public static String formatDate2(Date date) {
        if (date == null) {
            return "";
        } else {
            String disp = "";
            SimpleDateFormat bartDateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            disp = bartDateFormat.format(date);
            return disp;
        }
    }

    /**
     * 格式化日期，将日期从yyyyMMddHHmmss转换为yyyy-MM-dd HH:mm:ss
     *
     * @param datetime String
     * @return String
     */
    public static String formatDate3(String datetime) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            datetime = df.format(date1);
        } catch (Exception ex) {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从yyyyMMddHHmmss转换为yyyy-MM-dd
     *
     * @param datetime String
     * @return String
     */
    public static String formatDate7(String datetime) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyy-MM-dd");
            datetime = df.format(date1);
        } catch (Exception ex) {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从yyyyMMddHHmm转换为yyyy-MM-dd HH:mm
     *
     * @param datetime String
     * @return String
     */
    public static String formatDate_3(String datetime) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            datetime = df.format(date1);
        } catch (Exception ex) {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从yyyy-MM-dd转换为yyyyMMdd
     *
     * @param datetime String
     * @return String
     */
    public static String formatDate4(String datetime) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyyMMdd");
            datetime = df.format(date1);
        } catch (Exception ex) {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从yyyyMMdd转换为yyyy-MM-dd
     *
     * @param datetime String
     * @return String
     */
    public static String formatDate5(String datetime) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyy-MM-dd");
            datetime = df.format(date1);
        } catch (Exception ex) {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从yyyy-MM-dd HH:mm:ss转换为yyyyMMddHHmmss
     *
     * @param datetime String
     * @return String
     */

    public static String formatDate6(String datetime) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyyMMddHHmmss");
            datetime = df.format(date1);
        } catch (Exception ex) {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从yyyy-MM-dd HH:mm转换为yyyyMMddHHmm
     *
     * @param datetime String
     * @return String
     */

    public static String formatDate_6(String datetime) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyyMMddHHmm");
            datetime = df.format(date1);
        } catch (Exception ex) {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期为yyyyMMddHHmmss格式
     *
     * @param date Date
     * @return String
     */
    public static String formatDate7(Date date) {
        if (date == null) {
            return "";
        } else {
            String disp = "";
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            disp = bartDateFormat.format(date);
            return disp;
        }
    }

    /**
     * 格式化日期，将日期从yyyyMMdd转换为yyyy-MM-dd
     *
     * @param datetime String
     * @return String
     */
    public static String formatDate8(String datetime) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            Date date1 = df.parse(datetime);
            df = new SimpleDateFormat("yyyy/MM/dd");
            datetime = df.format(date1);
        } catch (Exception ex) {
            datetime = "";
        }
        return datetime;
    }

    /**
     * 格式化日期，将日期从HH:mm:ss转换为HHmmss
     *
     * @return String
     */
    public static String formatTime(String time) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
            Date date1 = df.parse(time);
            df = new SimpleDateFormat("HHmmss");
            time = df.format(date1);
        } catch (Exception ex) {
            time = "";
        }
        return time;
    }

    /**
     * 格式化double变量为字符串，格式为##################0.00
     *
     * @param b double
     * @return String
     */
    public static String formatE(double b) {
        try {
            DecimalFormat df1 = new DecimalFormat("##################0.00");
            return df1.format(b);
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * 格式化float变量为字符串，格式为##################0.00
     *
     * @param b double
     * @return String
     */
    public static String formatE(float b) {
        try {
            DecimalFormat df1 = new DecimalFormat("##################0.00");
            return df1.format(b);
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * 格式化float变量为字符串，格式为##################0.00
     *
     * @param b double
     * @return String
     */
    public static String formatE2(float b) {
        String result = "";
        try {
            DecimalFormat df1 = new DecimalFormat("##################0.000");
            result = df1.format(b);
            String ss[] = result.split("\\.");
            String ss1 = ss[0];
            String ss2 = ss[1];
            String s21 = ss2.substring(0, 2);
            String s22 = ss2.substring(2, 3);
            if (Integer.parseInt(s22) > 4) {
                s21 = (Integer.parseInt(s21) + 1) + "";

                if (Integer.parseInt(s21) == 100) {
                    s21 = "00";
                    ss1 = (Integer.parseInt(ss1) + 1) + "";
                    result = ss1 + "." + s21;
                } else {
                    if (Integer.parseInt(s21) < 10) {
                        s21 = "0" + s21;
                    }
                    result = ss1 + "." + s21;
                }
            } else {
                result = ss1 + "." + s21;
            }
            return result;
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * 将序号格式化为字符串，不足位数在前面补0
     *
     * @param sn     int  序号
     * @param length int  字符串位数
     * @return String
     */
    public static String formatSn(long sn, int length) {
        String str = sn + "";
        String strSn = str;
        for (int i = 0; i < length - str.length(); i++) {
            strSn = "0" + strSn;
        }
        return strSn;
    }

    /**
     * 将字符串根据分隔符分解成字符数组
     *
     * @param value   String  字符串
     * @param compart String  分隔符
     * @return Vector
     */
    public static List formatString(String value, String compart) {
        int index = 0;
        int i = 0;
        List<String> list = new ArrayList<String>();
        while ((index = value.indexOf(compart)) != -1) {
            list.add(value.substring(0, index));
            i++;
            value = value.substring(index + 1);
        }
        return list;
    }

    /**
     * 算出百分比
     *
     * @param str1 String  字符串
     * @param str2 String  分隔符
     * @return String
     */
    public static String formatPercent(String str1, String str2) {
        if (str1.equals("0")) {
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
        if (Integer.parseInt(comm4) >= 5) {
            comm3 = (Integer.parseInt(comm3) + 1) + "";
            if (Integer.parseInt(comm3) == 10) {
                comm3 = "0";
                comm2 = (Integer.parseInt(comm2) + 1) + "";
                if (Integer.parseInt(comm2) == 10) {
                    comm2 = "0";
                    comm1 = (Integer.parseInt(comm1) + 1) + "";
                }
            }
        }
        if (comm3.equals("0")) {
            if (comm2.equals("0")) {
                if (comm1.equals("0")) {
                    tt = "0.01％";
                } else {
                    tt = comm1 + "％";
                }
            } else {
                tt = comm1 + "." + comm2 + "％";
            }
        } else {
            tt = comm1 + "." + comm2 + comm3 + "％";
        }
        return tt;
    }

    /**
     * 算出百分比
     *
     * @param str1  String  数字字符串
     * @param str21 String  数字字符串
     * @param str22 String  数字字符串
     * @return String
     */
    public static String formatPercent(String str1, String str21, String str22) {
        if (str1.equals("0")) {
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
        if (Integer.parseInt(comm4) >= 5) {
            comm3 = (Integer.parseInt(comm3) + 1) + "";
            if (Integer.parseInt(comm3) == 10) {
                comm3 = "0";
                comm2 = (Integer.parseInt(comm2) + 1) + "";
                if (Integer.parseInt(comm2) == 10) {
                    comm2 = "0";
                    comm1 = (Integer.parseInt(comm1) + 1) + "";
                }
            }
        }

        if (comm3.equals("0")) {
            if (comm2.equals("0")) {
                if (comm1.equals("0")) {
                    tt = "0.01％";
                } else {
                    tt = comm1 + "％";
                }
            } else {
                tt = comm1 + "." + comm2 + "％";
            }
        } else {
            tt = comm1 + "." + comm2 + comm3 + "％";
        }
        return tt;
    }

    /**
     * 获得备份路径
     *
     * @return String
     */
    public static String getBackup() {
        return File.separator + "app" + File.separator + "iservice_server" +
                File.separator + "backup";
    }

    /**
     * 获得EXCEL文件生成路径
     *
     * @return String
     */
    public static String getExcelServer() {
        return System.getProperty("catalina.home") + File.separator + "webapps" +
                File.separator + "iservice_smp_client";
    }

    /**
     * 获得按照起始和终止时间，获得所有的日期
     *
     * @param startTime String
     * @param endTime   String
     * @return Vector
     */
    public static Vector getMonth(String startTime, String endTime) {
        Vector vcMonth = new Vector();
        try {
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
            while (endCal.after(startCal)) {
                vcMonth.add(formatDate7(startCal.getTime()));
                vcMonth.add(Integer.toString(startCal.get(2) + 1));
                startCal.add(Calendar.SECOND, 1);
                vcMonth.add(formatDate7(startCal.getTime()));
                startCal.add(Calendar.MONTH, 1);
                startCal.add(Calendar.SECOND, -1);
            }
            vcMonth.add(endTime);
            vcMonth.add(Integer.toString(endCal.get(2) + 1));
        } catch (Exception ex) {
            vcMonth = new Vector();
        }
        return vcMonth;
    }

    /**
     * 获得当天时间，格式为yyyy-MM-dd HH:mm:ss
     *
     * @return String
     */
    public static String getNow() {
        Date d = new Date();
        String str = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        str = formatter.format(d);
        return str;
    }

    /**
     * 获得当前时间
     *
     * @return String 获得当前时间的字符串变量，如"20030114101211"
     */
    public static String getNow1() {
        Date d = new Date();
        String str = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        str = formatter.format(d);
        return str;
    }

    /**
     * 获得当天日期，格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getNow2() {
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
    public static String getNow3() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = dateFormat.format(new Date());
        return strDate;
    }

    /**
     * 获得当天日期，格式为yyyyMMdd
     *
     * @return String
     */
    public static String getNow4() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String strDate = dateFormat.format(new Date());
        return strDate;
    }

    public static String getNow(String formatType) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatType);
        String strDate = dateFormat.format(new Date());
        return strDate;
    }

    /**
     * 获得当天日期，格式为yyMM
     *
     * @return String
     */
    public static String getNowMonth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
        String strDate = dateFormat.format(new Date());
        return strDate;
    }

    /**
     * 获得前一天的时间
     *
     * @return String
     */
    public static String getPreviousDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String str = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        str = formatter.format(cal.getTime());
        return str;
    }

    /**
     * 获得前个月的的时间
     *
     * @return String
     */
    public static String getPreviousMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        String str = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        str = formatter.format(cal.getTime());
        return str;
    }

    /**
     * 格式化金额
     *
     * @param acc String
     * @return String
     */
    public static String formatAcc(String acc) {
        //如果是0，直接返回
        if (Float.parseFloat(acc) == 0) {
            return "零元";
        }

        int length = acc.length();
        String upper = "";
        double fee = Double.parseDouble(acc);
        if (fee % 10000D == 0.0D) {
            for (int i = length - 1; i >= 0; i--) {
                if (i <= 0) {
                    char array[] = new char[1];
                    array[0] = acc.charAt(i);
                    if (Integer.parseInt(new String(array)) != 0) {
                        upper = formatNum(Integer.parseInt(new String(array))) +
                                formatIndex(length - i) + upper;
                    }
                }
            }
            upper = upper + "元整";
        } else if (fee % 1000D == 0.0D) {
            for (int i = length - 1; i >= 0; i--) {
                if (i <= 1) {
                    char array[] = new char[1];
                    array[0] = acc.charAt(i);
                    if (Integer.parseInt(new String(array)) != 0) {
                        upper = formatNum(Integer.parseInt(new String(array))) +
                                formatIndex(length - i) + upper;
                    }
                }
            }
            upper = upper + "元整";
        } else if (fee % 100D == 0.0D) {
            for (int i = length - 1; i >= 0; i--) {
                if (i <= 2) {
                    char array[] = new char[1];
                    array[0] = acc.charAt(i);
                    if (Integer.parseInt(new String(array)) != 0) {
                        upper = formatNum(Integer.parseInt(new String(array))) +
                                formatIndex(length - i) + upper;
                    }
                }
            }
            upper = upper + "元整";
        } else if (fee % 10D == 0.0D) {
            for (int i = length - 1; i >= 0; i--) {
                if (i <= 3) {
                    if (i != length - 3) {
                        char array[] = new char[1];
                        array[0] = acc.charAt(i);
                        if (Integer.parseInt(new String(array)) != 0) {
                            upper = formatNum(Integer.parseInt(new String(array))) +
                                    formatIndex(length - i) + upper;
                        }
                    }
                }
            }
            upper = upper + "元整";
        } else if (fee % 1.0D == 0.0D) {
            for (int i = length - 1; i >= 0; i--) {
                if (i <= 4) {
                    if (i != length - 3) {
                        char array[] = new char[1];
                        array[0] = acc.charAt(i);
                        if (Integer.parseInt(new String(array)) != 0) {
                            upper = formatNum(Integer.parseInt(new String(array))) +
                                    formatIndex(length - i) + upper;
                        }
                    }
                }
            }
            upper = upper + "整";
        } else {
            for (int i = length - 1; i >= 0; i--) {
                if (i != length - 3) {
                    char array[] = new char[1];
                    array[0] = acc.charAt(i);
                    upper = formatNum(Integer.parseInt(new String(array))) +
                            formatIndex(length - i) +
                            upper;
                }
            }
        }
        return upper;
    }

    /**
     * 格式化序号
     *
     * @param index int
     * @return String
     */
    private static String formatIndex(int index) {
        switch (index) {
            case 1: // '\001'
                return "分";

            case 2: // '\002'
                return "角";

//            case 3: // '\003'
//                return "";

            case 4: // '\004'
                return "元";

            case 5: // '\005'
                return "拾";

            case 6: // '\006'
                return "佰";

            case 7: // '\007'
                return "仟";

            case 8: // '\b'
                return "万";

            default:
                return "";
        }
    }

    /**
     * 格式化数字，获得大写
     *
     * @param num int  数字
     * @return String
     */
    private static String formatNum(int num) {
        switch (num) {
            case 0:
                return "零";

            case 1:
                return "壹";

            case 2:
                return "贰";

            case 3:
                return "叁";

            case 4:
                return "肆";

            case 5:
                return "伍";

            case 6:
                return "陆";

            case 7:
                return "柒";

            case 8:
                return "捌";

            case 9:
                return "玖";
        }
        return "";
    }

    /**
     * 函数功能：获得当前年月日时分秒
     *
     * @return 返回当前日期的字符变量，如"20141101115412"
     */
    public static String getCurrentTime() {
        Date d = new Date();
        String str = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        str = formatter.format(d);
        return str;
    }
    /**
     * 函数功能：获得当前日期
     *
     * @return 返回当前日期的字符变量，如"120000"
     */
    public static String getNowTime() {
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
    public static String getMonth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String strDate = dateFormat.format(new Date());
        return strDate;
    }

    /**
     * 获得当前月份
     *
     * @return String 格式：2007-05
     */
    public static String getMonth2() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        String strDate = dateFormat.format(new Date());
        return strDate;
    }

    /**
     * 获得该月的第一天日期和最后一天日期
     *
     * @param year  int 年份
     * @param month int  月份
     * @return String[]
     */
    public static String[] getMonth(int year, int month) {
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
     * @param date 日期变量，如2003-3-3
     * @param type (1表示当前日期的字符串格式,如"200612" ,2表示当前日期的日期格式,如"2006-12")
     * @return 月份
     */
    public static String formatMonth(Date date, int type) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat bartDateFormat = null;
        if (type == 1) {
            bartDateFormat = new SimpleDateFormat("yyyyMM");
        }
        if (type == 2) {
            bartDateFormat = new SimpleDateFormat("yyyy-MM");
        }
        String disp = bartDateFormat.format(date);
        return disp;
    }

    /**
     * 获得两个月之间的所有月份；
     *
     * @param startMon 起始月份
     * @param endMon   截止月份
     * @return 两个月份之间的所有月份
     */
    public static List getAllMonths(String startMon, String endMon) {
        List dateList = new ArrayList();
        if (startMon == null || startMon.length() == 0 ||
                endMon == null || endMon.length() == 0) {
            return dateList;
        }

        try {
            SimpleDateFormat startDF = new SimpleDateFormat("yyyyMM");
            startDF.parse(startMon);
            Calendar startCal = startDF.getCalendar();
            SimpleDateFormat endDF = new SimpleDateFormat("yyyyMM");
            endDF.parse(endMon);
            Calendar endCal = endDF.getCalendar();

            while (startCal.before(endCal)) {
                dateList.add(formatMonth(startCal.getTime(), 1));
                startCal.add(Calendar.MONTH, 1);
            }
            dateList.add(endMon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dateList;
    }


    /**
     * 获得所有的两位和正常数字对应的12个月份。
     *
     * @return 所有月份，例如：String[]{ { "01", "1" }, { "02", "2" }, ... { "12", "12" } }
     */
    public static String[][] getMonths() {
        String[][] months = new String[12][2];

        for (int i = 1, j = 0; i <= 12; i++, j++) {
            months[j][0] = i < 10 ? "0" + i : "" + i;
            months[j][1] = "" + i;
        }

        return months;
    }

    /**
     * 根据输入年月获取其上一个月份(YYYYMM)
     *
     * @param yearMonth 年月
     * @return 日期(YYYYMM)
     */
    public static String getPreMonth(String yearMonth) {
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(4, 6));
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        c.add(Calendar.DATE, -1);
        String mon;
        if (c.get(Calendar.MONTH) + 1 < 10) {
            mon = "0" + String.valueOf(c.get(Calendar.MONTH) + 1);
        } else
            mon = String.valueOf(c.get(Calendar.MONTH) + 1);

        return String.valueOf(c.get(Calendar.YEAR)) + mon;

    }

    /**
     * 获得上月的最后一天和该月最后一天日期
     *
     * @param year  int 年份
     * @param month int  月份
     * @return String[]
     */
    public static String[] getMonth2(int year, int month) {
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
    public static String getlastDate() {
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
    public static String[] getWeek() {
        String[] dates = new String[2];
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (day == 1) {
            cal.add(Calendar.DATE, -7);
        } else {
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
     * @param startTime 起始日期
     * @param endTime   结束日期
     * @return int
     */
    public static int getDateFromTime1ToTime2(String startTime, String endTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = null;
        Date dt2 = null;
        int checkDays = 0;
        try {
            dt1 = formatter.parse(endTime);
            dt2 = formatter.parse(startTime);
            long l = dt1.getTime() - dt2.getTime();
            l = (long) (l / (1000 * 60 * 60 * 24) + 0.5);
            checkDays = Integer.parseInt(String.valueOf(l));
        } catch (ParseException e) {
            return checkDays;
        }
        return checkDays;
    }

    public static boolean beforComDate(String orgTime, String startdate, String enddate) {
        boolean flag = false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date org = null;
        Date start = null;
        Date end = null;
        try {
            org = formatter.parse(orgTime);
            if ((startdate == null || startdate.length() == 0) && (enddate == null || enddate.length() == 0))//都为空
                return true;

            if ((startdate == null || startdate.length() == 0))//开始时间为空，比较结束时间
            {
                end = formatter.parse(enddate);
                if (org.after(end)) {
                    return false;
                }
                return true;
            }
            if ((enddate == null || enddate.length() == 0))//结束时间为空
            {
                start = formatter.parse(startdate);
                if (org.before(start)) {
                    return false;
                }
                return true;
            }
            ////////////
            start = formatter.parse(startdate);
            end = formatter.parse(enddate);
            if (org.after(start) && org.before(end))
                return true;

        } catch (ParseException e) {

        }

        return flag;
    }

    /**
     * 获得上一个自然月的起始日期和终止日期
     *
     * @return 数组第一个分素是起始日期，第二个是终止日期
     */
    public static String[] getlastMonth() {
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
    public static String getOptTime() {
        Calendar cal = Calendar.getInstance();
        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String day = Integer.toString(cal.get(Calendar.DATE));
        if (month.length() == 1) {
            month = "0" + month;
        }
        if (day.length() == 1) {
            day = "0" + day;
        }
        return year + "年" + month + "月" + day + "日";
    }

    /**
     * 获得自动停复机系统IP
     *
     * @return String
     */
    public static String getAutoIP() {
        FileInputStream fis = null;
        String autoIP = "";
        try {
            Properties a = new Properties();
            fis = new FileInputStream(System.getProperty(
                    "catalina.home") + File.separator + "iservice.properties");
            a.load(fis);
            autoIP = a.getProperty("AutoIP");
            fis.close();
        } catch (Exception e) {
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
            }
        }
        return autoIP;
    }

    /**
     * 获得自动停复机系统端口号
     *
     * @return int
     */
    public static int getAutoPort() {
        String autoPort = "0";
        FileInputStream fis = null;
        try {
            Properties a = new Properties();
            fis = new FileInputStream(System.getProperty(
                    "catalina.home") + File.separator + "iservice.properties");
            a.load(fis);
            autoPort = a.getProperty("AutoPort");
            fis.close();
        } catch (Exception e) {
            autoPort = "0";
            try {
                if (fis != null) fis.close();
            } catch (IOException e1) {
            }
        }
        return Integer.parseInt(autoPort);
    }

    /**
     * 日期加减
     *
     * @param offset 日期间隔天数
     * @return 日期（yyyy-MM-dd）
     */
    public static String changeDay(int offset) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR,
                (calendar.get(Calendar.DAY_OF_YEAR) + offset));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String day = formatter.format(calendar.getTime());
        return day;
    }

    /**
     * 生成字符串的MAC校验码
     *
     * @param src 字符串
     * @return MAC校验码
     */
    public static String getMac(String src) {
        byte[] data = src.getBytes();
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ByteArrayInputStream input;
        byte[] mac = new byte[8];
        try {
            bout.write(data);

            int cover = data.length % 8;

            if (cover != 0) {//如果不为8的倍数，则补位
                for (int i = 0; i < (8 - cover); i++) {
                    bout.write(0xff);
                }
            }
            data = bout.toByteArray();
            input = new ByteArrayInputStream(data);
            int ennumber = data.length / 8;
            byte[] temp;
            for (int i = 0; i < ennumber; i++) {
                temp = new byte[8];
                input.read(temp);
                for (int j = 0; j < 8; j++) {
                    mac[j] = (byte) (mac[j] ^ temp[j]);
                }
            }
            bout.close();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(mac);
    }

    /**
     * 获得字符串的MAC校验码的ASCII码
     *
     * @param src 字符串
     * @return ASCII码
     */
    public static String getMacAscii(String src) {
        String mac = getMac(src);
        StringBuffer ascii = new StringBuffer();
        for (int i = 0, ii = mac.length(); i < ii; i++) {
            ascii.append((int) mac.charAt(i));
        }
        return ascii.toString();
    }

    /**
     * 重复字符串规定的次数
     *
     * @param s   要重复的字符串
     * @param num 重复的次数，必须大于0，为0时返回""。
     * @return 返回重复后的字符串
     */
    public static String repeat(String s, int num) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < num; i++) {
            str.append(s);
        }
        return str.toString();
    }


    //检查文件是否符合angine带采集或解析日志文件格式
    public static boolean checkAngineFile(String filename) {
        if (filename == null || "".equals(filename) || ".".equals(filename) || "..".equals(filename)) {
            return false;
        }
        if (!filename.endsWith("doing"))
            return true;
        else
            return false;
    }

    //判断接入类型
    public static int getAcctype(int i_acctype, String url) {
        int acctype = 0;
        if (i_acctype == 6) {
            if (url.contains("appstore_agent")) {
                acctype = 3;//client
            } else {
                acctype = 2;//web
            }
        } else if (i_acctype == 7) {
            if (url.contains("/bbs/")) {
                acctype = 5;//bbs
            } else {
                acctype = 4;//社区
            }

        } else {
            acctype = i_acctype;
        }
        return acctype;
    }

    //判断请求类型
    public static int getReqType(String url) {
        int reqType = 3;
        try {
            if ((url.contains("wostore") && url.contains(".html")) || url.contains("appstore_agent") || url.contains(".jsp")) {
                String[] blackname = new String[]{"/wostore/top_wra.html", "/wostore/top.html",
                        "/wostore/phonemodel.html", "/wostore/foot1.html",
                        "/wostore/sorttop10.html", "/wostore/phonemodelForIndex.html",
                        "/wostore/common/top1.html", "/wostore/404.html",
                        "/wostore/checkapp.html", "waptop.jsp", "foot.jsp",
                        "topForFantastic.jsp"};
                for (int i = 0; i < blackname.length; i++) {
                    if (url.contains(blackname[i])) {
                        reqType = 4;
                        break;
                    }
                }
                reqType = 1;
            } else if (url.equals("-")) {
                reqType = 2;
            }


        } catch (Exception e) {
        }
        return reqType;
    }

}
