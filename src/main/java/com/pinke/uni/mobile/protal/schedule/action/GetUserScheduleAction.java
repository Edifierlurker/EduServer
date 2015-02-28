package com.pinke.uni.mobile.protal.schedule.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.course.fs.ICourseFS;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.pinke.uni.mobile.protal.schedule.fs.IScheduleFS;
import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 查询用户日程
 * 
 * @author lucuiping
 * 
 */
public class GetUserScheduleAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IScheduleFS scheduleFS = (IScheduleFS) SSBBus.findDomainService("mscheduleFS");
    private ICourseFS courseInfoFS = (ICourseFS) SSBBus.findDomainService("mcourseFS");
    private String userIndex;
    private String date;
    private String weeks;
    private String type;

    @Override
    public void execute()
    {
        if (!confirm())
        {
            try
            {
                this.getResponse().sendError(CodeConstant.SC_HTTP_400, CodeConstant.HTTP_400);
            }
            catch (IOException e)
            {
                log.error("response流异常", e);
            }
            return;
        }
        log.info("查询用户日程接口，userIndex=" + userIndex + ",date=" + date + ",type=" + type + ",weeks=" + weeks);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            List<UserSchedule> list = new ArrayList();

            List<UserScheduleCourse> courseList = new ArrayList();
            int totalCount = 0;
            jsonObj.put("result", "0");
            jsonObj.put("desc", "");
            jsonObj.put("totalCount", totalCount);
            /**
             * 查询活动、考试日程
             */

            list = scheduleFS.getUserScheduleList(userIndex, date, type);

            /**
             * 查询课程
             */
            UserScheduleCourse userScheduleCourse = new UserScheduleCourse();
            userScheduleCourse.setAttendindex(Long.parseLong(userIndex));
            userScheduleCourse.setStatus(1);
            TableDataInfo courseAttendTable = courseInfoFS.getUserScheduleAttendCourseList(userScheduleCourse, 1,
                    Integer.MAX_VALUE);
            if (courseAttendTable != null)
            {
                courseList = courseAttendTable.getData();
                if (courseList != null && courseList.size() > 0)
                {
                    int dw = 0;
                    if ("3".equals(type))
                        dw = getWeekEnds(date);
                    for (UserScheduleCourse course : courseList)
                    {
                        String tempWeek = "|" + course.getWeeks();
                        int tempWeekDay = course.getWeekdays();
                        int currentWeek = Integer.parseInt(weeks);

                        if ("1".equals(type))
                        {
                            if (Tools.isNotNull(tempWeek) && Tools.isNotNull(tempWeekDay + ""))
                            {

                                JSONObject dateJobj = getWeeks(date, tempWeekDay);
                                if (dateJobj != null && dateJobj.get("days") != null)
                                {
                                    JSONArray daysArray = dateJobj.getJSONArray("days");

                                    if (daysArray != null)
                                    {

                                        for (int i = 0; i < daysArray.size(); i++)
                                        { // 判断当前周是否在课程中
                                            if (tempWeek.contains("|" + currentWeek + "|"))
                                            {
                                                JSONObject tempJobj = new JSONObject();
                                                JSONObject daysJobj = daysArray.getJSONObject(i);
                                                /**
                                                 * detailIndex string UTF 是 日程index detailType string UTF 是 日程类型
                                                 * detailTitle string UTF 是 日程标题 detailStartTime string UTF 是
                                                 * 日程开始时间，yyyyMMddHHmmss detailEndTime string UTF 是 日程结束时间
                                                 * yyyyMMddHHmmss isDelete 日程相关的活动是否已删除
                                                 */
                                                tempJobj.put("scheduleIndex", course.getCourseindex() + "");
                                                tempJobj.put("detailIndex", course.getCourseindex() + "");
                                                tempJobj.put("detailType", "0");
                                                tempJobj.put("detailTitle", course.getCoursename() + "");
                                                tempJobj.put("detailStartTime", course.getCourseStartTime() + "");
                                                tempJobj.put("detailEndTime", course.getCourseEndTime() + "");
                                                tempJobj.put("detailDate", daysJobj.get("day") + "");
                                                tempArray.add(tempJobj);
                                                totalCount++;
                                            }
                                            currentWeek++;
                                        }
                                    }

                                }

                            }

                        }
                        /**
                         * 查询某周的课程
                         **/
                        else if ("2".equals(type))
                        {
                            // 判断当前周是否在课程中
                            if (tempWeek.contains("|" + currentWeek + "|"))
                            {
                                JSONObject tempJobj = new JSONObject();
                                tempJobj.put("scheduleIndex", course.getCourseindex() + "");
                                tempJobj.put("detailIndex", course.getCourseindex() + "");
                                tempJobj.put("detailType", "0");
                                tempJobj.put("detailTitle", course.getCoursename() + "");
                                tempJobj.put("detailStartTime", course.getCourseStartTime() + "");
                                tempJobj.put("detailEndTime", course.getCourseEndTime() + "");
                                tempJobj.put("detailDate", getWeekDays(date, tempWeekDay) + "");
                                tempArray.add(tempJobj);
                            }
                        }
                        /**
                         * 查询某天的课程
                         */
                        else if ("3".equals(type))
                        {

                            // 判断当前周是否在课程中
                            if (tempWeek.contains("|" + currentWeek + "|") && dw == tempWeekDay)
                            {
                                JSONObject tempJobj = new JSONObject();
                                tempJobj.put("scheduleIndex", course.getCourseindex() + "");
                                tempJobj.put("detailIndex", course.getCourseindex() + "");
                                tempJobj.put("detailType", "0");
                                tempJobj.put("detailTitle", course.getCoursename() + "");
                                tempJobj.put("detailStartTime", course.getCourseStartTime() + "");
                                tempJobj.put("detailEndTime", course.getCourseEndTime() + "");
                                tempJobj.put("detailDate", getWeekDays(date, tempWeekDay) + "");
                                tempArray.add(tempJobj);
                            }
                        }
                    }
                }
            }

            if (list != null && list.size() > 0)
            {
                jsonObj.put("totalCount", totalCount + list.size());

                for (int i = 0; i < list.size(); i++)
                {
                    UserSchedule temp = list.get(i);
                    if (temp != null)
                    {
                        JSONObject tempJobj = new JSONObject();
                        /**
                         * detailIndex string UTF 是 日程index detailType string UTF 是 日程类型 detailTitle string UTF 是 日程标题
                         * detailStartTime string UTF 是 日程开始时间，yyyyMMddHHmmss detailEndTime string UTF 是 日程结束时间
                         * yyyyMMddHHmmss isDelete 日程相关的活动是否已删除
                         */
                        tempJobj.put("scheduleIndex", temp.getScheduleindex() + "");
                        tempJobj.put("detailIndex", temp.getDetailindex() + "");
                        tempJobj.put("detailType", temp.getScheduletype() + "");
                        tempJobj.put("detailTitle", temp.getScheduletitle() + "");
                        tempJobj.put("detailStartTime", temp.getStarttime() + "");
                        tempJobj.put("detailEndTime", temp.getEndtime() + "");
                        tempJobj.put("detailDate", temp.getScheduledate() + "");

                        tempArray.add(tempJobj);
                    }
                }

            }

            jsonObj.put("data", tempArray);
        }
        catch (Exception e)
        {
            log.error("查询用户日程接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "");
            jsonObj.put("data", tempArray);
        }
        finally
        {
            log.info("查询用户日程接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            date = this.getRequest().getParameter("date");
            type = this.getRequest().getParameter("type");
            weeks = this.getRequest().getParameter("weeks");
            if (Tools.isNull(userIndex) || Tools.isNull(date) || Tools.isNull(type) || Tools.isNull(weeks))
            {
                return false;
            }

        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }

        return true;
    }

    /**
     * 按月计算周数
     * 
     * @param currenttime
     * @return
     */
    public static JSONObject getWeeks(String currenttime, int weekdays)
    {
        JSONObject resultJobj = new JSONObject();

        // Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date date;
        try
        {

            // /**
            // * 每月有几个周
            // */
            // int count = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
            //
            // /**
            // * 每月一号是周几
            // */
            // calendar.set(Calendar.DAY_OF_MONTH, 1);
            // SimpleDateFormat format = new SimpleDateFormat("E");
            // String begin = format.format(sdf.parse(currenttime));

            /**
             * 本月的周几分别是几号
             */
            Calendar cal = Calendar.getInstance();
            date = sdf.parse(currenttime);
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH);
            cal.set(Calendar.MONTH, month);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            int day = 1;
            JSONArray daysArray = new JSONArray();
            sdf = new SimpleDateFormat("yyyyMMdd");
            do
            {
                // System.out.println(sdf.format(cal.getTime())+"   "+cal.get(Calendar.DAY_OF_WEEK)+"      "+Calendar.WEDNESDAY);
                if (cal.get(Calendar.DAY_OF_WEEK) == weekdays + 1)
                {
                    JSONObject tempJobj = new JSONObject();

                    tempJobj.put("day", sdf.format(cal.getTime()) + "");
                    daysArray.add(tempJobj);
                }
                // day++;
                cal.add(Calendar.DAY_OF_MONTH, 1);

            }
            while (cal.get(Calendar.MONTH) == month);

            // resultJobj.put("weeks", count + "");
            // resultJobj.put("begin", begin);
            resultJobj.put("days", daysArray);
            // log.info(resultJobj.toString());
            System.out.println(resultJobj.toString());
        }

        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultJobj;
    }

    /**
     * 根据一周周一的日期算出本周周几的日期
     * 
     * @param currenttime
     * @return
     */
    public static String getWeekDays(String currenttime, int weekdays)
    {
        String dates = "";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date;
        try
        {
            /**
             * 本月的周几分别是几号
             */
            date = sdf.parse(currenttime);
            calendar.setTime(date);
            calendar.add(Calendar.DATE, weekdays - 1);
            dates = sdf.format(calendar.getTime());
            System.out.println(dates);

        }

        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dates;
    }

    /**
     * 根据日期查询周几
     * 
     * @param currenttime
     * @return
     */
    public static int getWeekEnds(String currenttime)
    {
        String dates = "";
        int dw = 0;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date;
        try
        {
            date = sdf.parse(currenttime);
            calendar.setTime(date);
            dw = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (dw <= 0)
                dw = 7;
            System.out.println(dw);

        }

        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dw;
    }

    public static void main(String[] args)
    {
        // getWeekEnds("20141231");
        // getWeekDays("20141208", 3);
        getWeeks("201412", 1);
        // Calendar calendar = Calendar.getInstance();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        // Date date;
        // try
        // {
        // date = sdf.parse("201410");
        // calendar.setTime(date);
        // System.out.println(calendar.getActualMaximum(Calendar.WEEK_OF_MONTH));
        // }
        // catch (ParseException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // String[] list = Tools.getlastMonth();
        // printWeeks();
        // Calendar calendar = Calendar.getInstance();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        // calendar.set(Calendar.DAY_OF_MONTH, 1);
        // SimpleDateFormat format = new SimpleDateFormat("E");
        // try
        // {
        // System.out.println("本月第一天是：" + format.format(sdf.parse("201411")));
        // }
        // catch (ParseException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
    }

    public static void printWeeks()
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date date;
        try
        {
            date = sdf.parse("201411");

            calendar.setTime(date);
            calendar.set(Calendar.DATE, 1);
            int month = calendar.get(Calendar.MONTH);
            int count = 0;
            while (calendar.get(Calendar.MONTH) == month)
            {

                StringBuilder builder = new StringBuilder();
                builder.append("week:");
                builder.append(++count);
                builder.append(" (");
                builder.append(format.format(calendar.getTime()));
                builder.append(" - ");
                calendar.add(Calendar.DATE, 6);
                builder.append(format.format(calendar.getTime()));
                builder.append(")");
                System.out.println(builder.toString());

                calendar.add(Calendar.DATE, 1);
            }
            System.out.println(count);
        }

        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
