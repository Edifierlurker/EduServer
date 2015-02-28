package com.pinke.uni.mobile.protal.schedule.action;

import java.io.IOException;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.schedule.fs.IScheduleFS;
import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 添加用户日程
 * 
 * @author lucuiping
 * 
 */
public class InsertUserScheduleAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IScheduleFS scheduleFS = (IScheduleFS) SSBBus.findDomainService("mscheduleFS");
    private String userIndex;
    private String date;
    private String type;
    private String title;// 日程标题
    private String detailIndex;// 日程相关联的课程、活动等index
    private String scheduleName;// 日程表名称
    private String startTime;
    private String endTime;

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
        log.info("添加用户日程接口，userIndex=" + userIndex + ",date=" + date);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            UserSchedule userSchedule = new UserSchedule();
            userSchedule.setStudentindex(Long.parseLong(userIndex));
            userSchedule.setSchedulename(scheduleName);
            userSchedule.setDetailindex(Long.parseLong(detailIndex));
            userSchedule.setScheduletitle(title);
            userSchedule.setScheduledate(date);
            userSchedule.setScheduletype(Integer.parseInt(type));
            userSchedule.setStarttime(startTime);
            userSchedule.setEndtime(endTime);
            userSchedule.setCreatetime(Tools.formatDate7(new Date()));
            boolean result = scheduleFS.insertUserSchedule(userSchedule);
            if (result == true)
            {
                jsonObj.put("result", "0");
                jsonObj.put("desc", "");
            }
            else
            {
                jsonObj.put("result", "1");
                jsonObj.put("desc", "");
            }

        }
        catch (Exception e)
        {
            log.error("添加用户日程接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "");

        }
        finally
        {
            log.info("添加用户日程接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        /**
         * type int 4 是 添加的日程类型 0：课程 1：活动 2：考试 3：个人 date String UTF 是 日程日期 title string UTF 是 日程标题 detailIndex string
         * UTF 是 日程相关联的课程、活动等index userIndex string UTF 是 用户账号index scheduleName string UTF 否 日程表名称
         */
        try
        {

            String content = getRequestContent();

            log.info("请求的Json类型的结果字符串：" + content);
            if (null == content)
            {
                return false;
            }

            JSONObject obj = JSONObject.fromObject(content);
            if (null == obj)
            {
                return false;
            }
            userIndex = obj.get("userIndex") + "";
            detailIndex = obj.get("detailIndex") + "";
            date = obj.get("date")+"";
            type = obj.get("type")+"";
            title = obj.get("title")+"";
            detailIndex = obj.get("detailIndex")+"";
            scheduleName = obj.get("scheduleName")+"";
            startTime = obj.get("startTime")+"";
            endTime = obj.get("endTime")+"";
            if (Tools.isNull(userIndex) || Tools.isNull(date) || Tools.isNull(type) || Tools.isNull(title)
                    || Tools.isNull(detailIndex) || Tools.isNull(startTime) || Tools.isNull(endTime))
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

}
