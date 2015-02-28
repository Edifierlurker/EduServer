package com.pinke.uni.mobile.protal.exam.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.exam.fs.IExamInfoFS;
import com.pinke.uni.mobile.protal.exam.model.UserExaminfoAttendMap;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfo;
import com.pinke.uni.mobile.protal.schedule.fs.IScheduleFS;
import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 添加、修改用户考试详情
 * 
 * @author lucuiping
 * 
 */
public class InsertExamAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IExamInfoFS examInfoFS = (IExamInfoFS) SSBBus.findDomainService("mexamInfoFS");
    /**
     * @examIndex String UTF 是 考试index
     * @examTitle String UTF 是 考试名称
     * @site String UTF 是 考试地点
     * @isOpen String UTF 是 '是否开卷考试
     * @examDate String UTF 是 考试时间
     * @type String UTF 是 操作类型 1：添加 2：修改
     */
    private String detailIndex;
    private String userIndex;
    private String type;
    private String examTitle;
    private String site;
    private String examDate;
    private String examStartTime;
    private String examEndTime;
    private String isOpen;
    private IScheduleFS scheduleFS = (IScheduleFS) SSBBus.findDomainService("mscheduleFS");

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
        log.info("添加、修改用户考试详情接口，detailIndex=" + detailIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();

        try
        {
            jsonObj.put("result", "1");
            jsonObj.put("desc", "操作失败");
            if ("1".equals(type))
            {
                UserScheduleExaminfo temp = new UserScheduleExaminfo();
                UserSchedule userSchedule = new UserSchedule();
                temp.setStudentindex(Long.parseLong(userIndex));

                userSchedule.setStudentindex(Long.parseLong(userIndex));

                if (Tools.isNotNull(examTitle))
                {
                    temp.setExamname(examTitle);
                    userSchedule.setSchedulename(examTitle);
                    userSchedule.setScheduletitle(examTitle);
                }
                if (Tools.isNotNull(site))
                {
                    temp.setSite(site);
                }
                if (Tools.isNotNull(examDate))
                {
                    temp.setExamdate(examDate);
                    userSchedule.setScheduledate(examDate);
                }
                if (Tools.isNotNull(examStartTime))
                {
                    temp.setExamstarttime(examStartTime);
                    userSchedule.setStarttime(examStartTime);
                }
                if (Tools.isNotNull(examEndTime))
                {
                    temp.setExamendtime(examEndTime);
                    userSchedule.setEndtime(examEndTime);
                }
                if (Tools.isNotNull(isOpen))
                {
                    temp.setOpenexam(Integer.parseInt(isOpen));
                }
                temp.setNote(Tools.formatDate7(new Date()));
                temp.setStatus(1);
                boolean result = examInfoFS.insertUserScheduleExamInfo(temp);
                if (result == true)
                {
                    List<UserScheduleExaminfo> tempList = examInfoFS.getExamList(temp);
                    if (tempList != null && tempList.size() > 0)
                        temp = tempList.get(0);
                    if (temp != null)
                    {
                        jsonObj.put("result", "0");
                        jsonObj.put("desc", temp.getExamindex() + "");

                        try
                        {
                            userSchedule.setDetailindex(temp.getExamindex());
                            userSchedule.setScheduletype(2);
                            userSchedule.setCreatetime(Tools.formatDate7(new Date()));
                            userSchedule.setStatus(1);
                            boolean scheduleResult = scheduleFS.insertUserSchedule(userSchedule);
                        }
                        catch (Exception e)
                        {
                            log.error("添加、修改用户考试详情接口异常" + e);
                        }

                    }

                }
            }
            else if ("2".equals(type))
            {
                UserScheduleExaminfo temp = new UserScheduleExaminfo();
                temp.setExamindex(Long.parseLong(detailIndex));
                temp.setStudentindex(Long.parseLong(userIndex));

                if (Tools.isNotNull(examTitle))
                {
                    temp.setExamname(examTitle);
                }

                if (Tools.isNotNull(site))
                {
                    temp.setSite(site);
                }
                if (Tools.isNotNull(examDate))
                {
                    temp.setExamdate(examDate);
                }
                if (Tools.isNotNull(isOpen))
                {
                    temp.setOpenexam(Integer.parseInt(isOpen));
                }
                if (Tools.isNotNull(examStartTime))
                {
                    temp.setExamstarttime(examStartTime);

                }
                if (Tools.isNotNull(examEndTime))
                {
                    temp.setExamendtime(examEndTime);

                }
                boolean result = examInfoFS.updateUserScheduleExamInfo(temp);
                if (result == true)
                {
                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                }
            }

            else if ("3".equals(type))
            {
                UserExaminfoAttendMap temp = new UserExaminfoAttendMap();
                temp.setExamindex(Long.parseLong(detailIndex));
                temp.setUserindex(Long.parseLong(userIndex));

                boolean result = examInfoFS.insertIntoExam(temp);
                if (result == true)
                {
                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                }
            }

        }
        catch (Exception e)
        {
            log.error("添加、修改用户考试详情接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
        }
        finally
        {
            log.info("添加、修改用户考试详情接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {

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
            /**
             * 1：添加2：修改
             */
            type = obj.get("type") + "";
            if (Tools.isNull(type))
            {
                return false;
            }

            userIndex = obj.get("userIndex") + "";
            detailIndex = obj.get("examIndex") + "";
            examDate = obj.get("examDate") + "";
            if ("1".equals(type))
            {

                if (Tools.isNull(userIndex) || Tools.isNull(examDate))
                {
                    return false;
                }
            }
            else if ("2".equals(type))
            {

                if (Tools.isNull(detailIndex) || Tools.isNull(userIndex))
                {
                    return false;
                }

            }
            examTitle = obj.get("examTitle") + "";
            site = obj.get("site") + "";
            isOpen = obj.get("isOpen") + "";
            examStartTime = obj.get("examStartTime") + "";
            examEndTime = obj.get("examEndTime") + "";
        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }
        return true;
    }

}
