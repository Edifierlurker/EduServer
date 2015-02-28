package com.pinke.uni.mobile.protal.schedule.action;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.activity.fs.IUserActivityFS;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMap;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.course.fs.ICourseFS;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourseAttendMap;
import com.pinke.uni.mobile.protal.exam.fs.IExamInfoFS;
import com.pinke.uni.mobile.protal.exam.model.UserExaminfoAttendMap;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfo;
import com.pinke.uni.mobile.protal.note.fs.IUserNoteFS;
import com.pinke.uni.mobile.protal.note.model.UserNote;
import com.pinke.uni.mobile.protal.personal.fs.IPersonalFS;
import com.pinke.uni.mobile.protal.schedule.fs.IScheduleFS;
import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 退出（删除）用户笔记详情、活动、课程、个人、考试等
 * 
 * @author lucuiping
 * 
 */
public class DelUserRecordAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IUserNoteFS userNoteFS = (IUserNoteFS) SSBBus.findDomainService("muserNoteFS");
    private IUserActivityFS userActivityFS = (IUserActivityFS) SSBBus.findDomainService("muserActivityFS");
    private IPersonalFS personalFS = (IPersonalFS) SSBBus.findDomainService("mpersonalFS");
    private IExamInfoFS examInfoFS = (IExamInfoFS) SSBBus.findDomainService("mexamInfoFS");
    private ICourseFS courseInfoFS = (ICourseFS) SSBBus.findDomainService("mcourseFS");
    private IScheduleFS scheduleFS = (IScheduleFS) SSBBus.findDomainService("mscheduleFS");
    private String detailIndex;
    private String detailType;
    private String userIndex;
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
        log.info("退出（删除）用户笔记详情、活动、课程、个人、考试接口，detailIndex=" + detailIndex + ",detailType=" + detailType + ",type="
                + type);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();

        try
        {
            /**
             * detailType string UTF 类型 0课程 1活动 2考试 3笔记 type String 4 是 添加的日程类型1：退出2：删除 退出某一活动，活动是存在的；
             * 只有活动或者课程的发起者才可以删除。
             */
            jsonObj.put("result", "1");
            jsonObj.put("desc", "删除失败");
            // // 删除笔记
            // if ("2".equals(type) && "3".equals(detailType))
            // {
            // UserNote temp = new UserNote();
            // temp.setNoteindex(Long.parseLong(detailIndex));
            // boolean result = userNoteFS.delUserNote(temp);
            // if (result == true)
            // {
            // jsonObj.put("result", "0");
            // jsonObj.put("desc", "");
            // }
            //
            // }
            UserSchedule userSchedule = new UserSchedule();

            userSchedule.setDetailindex(Long.parseLong(detailIndex));

            if ("1".equals(detailType))
            {
                // 退出活动
                if ("1".equals(type))
                {
                    userSchedule.setStudentindex(Long.parseLong(userIndex));
                    userSchedule.setScheduletype(1);

                    UserActivityAttendMap attendTemp = new UserActivityAttendMap();
                    attendTemp.setActivityindex(Long.parseLong(detailIndex));
                    attendTemp.setStudentindex(Long.parseLong(userIndex));
                    attendTemp.setStatus(0);
                    boolean result = userActivityFS.updateUserActivityAttend(attendTemp);
                    if (result == true)
                    {
                        jsonObj.put("result", "0");
                        jsonObj.put("desc", "");
                    }
                }
                // 删除活动
                if ("2".equals(type))
                {
                    userSchedule.setScheduletype(1);
                    UserScheduleActivity activityTemp = userActivityFS.getUserActivityDetailByIndex(Long
                            .parseLong(detailIndex));
                    if (activityTemp != null && activityTemp.getStatus().intValue() == 1
                            && userIndex.equals(activityTemp.getOriginatorindex() + ""))
                    {
                        activityTemp.setStatus(0);
                        boolean delRes = userActivityFS.updateUserActivityDetail(activityTemp);
                        if (delRes == true)
                        {
                            UserActivityAttendMap attendTemp = new UserActivityAttendMap();
                            attendTemp.setActivityindex(Long.parseLong(detailIndex));
                            attendTemp.setStatus(0);
                            boolean delAttendRes = userActivityFS.updateUserActivityAttend(attendTemp);
                            if (delAttendRes == true)
                            {
                                jsonObj.put("result", "0");
                                jsonObj.put("desc", "");
                            }
                            else
                            {
                                jsonObj.put("result", "1");
                                jsonObj.put("desc", "删除参与者失败");
                            }
                        }
                        else
                        {
                            jsonObj.put("result", "1");
                            jsonObj.put("desc", "删除活动失败");
                        }
                    }
                    else
                    {
                        jsonObj.put("result", "1");
                        jsonObj.put("desc", "活动不存在");
                    }
                }
            }
            else if ("2".equals(detailType))
            {
                // 退出考试
                if ("1".equals(type))
                {
                    userSchedule.setStudentindex(Long.parseLong(userIndex));
                    userSchedule.setScheduletype(2);
                    UserExaminfoAttendMap examTemp = new UserExaminfoAttendMap();
                    examTemp.setExamindex(Long.parseLong(detailIndex));
                    examTemp.setUserindex(Long.parseLong(userIndex));
                    examTemp.setStatus(0);

                    boolean result = examInfoFS.updateIntoExam(examTemp);
                    if (result == true)
                    {
                        jsonObj.put("result", "0");
                        jsonObj.put("desc", "");
                    }
                }
                // 删除考试
                if ("2".equals(type))
                {
                    userSchedule.setScheduletype(2);
                    UserScheduleExaminfo examTemp = examInfoFS.getUserScheduleExaminfoByIndex(Long
                            .parseLong(detailIndex));
                    if (examTemp != null && examTemp.getStatus().intValue() == 1
                            && userIndex.equals(examTemp.getStudentindex() + ""))
                    {
                        examTemp.setStatus(0);
                        boolean delRes = examInfoFS.updateUserScheduleExamInfo(examTemp);
                        if (delRes == true)
                        {
                            jsonObj.put("result", "0");
                            jsonObj.put("desc", "");

                            // UserExaminfoAttendMap examMapTemp = new UserExaminfoAttendMap();
                            // examMapTemp.setExamindex(Long.parseLong(detailIndex));
                            // examTemp.setStatus(0);
                            // boolean delAttendRes = examInfoFS.updateIntoExam(examMapTemp);
                            // if (delAttendRes == true)
                            // {
                            // jsonObj.put("result", "0");
                            // jsonObj.put("desc", "");
                            // }
                            // else
                            // {
                            // jsonObj.put("result", "1");
                            // jsonObj.put("desc", "删除参与者失败");
                            // }
                        }
                        else
                        {
                            jsonObj.put("result", "1");
                            jsonObj.put("desc", "删除考试失败");
                        }
                    }
                    else
                    {
                        jsonObj.put("result", "1");
                        jsonObj.put("desc", "考试不存在");
                    }
                }
            }
            else if ("0".equals(detailType))
            {// 退出课程

                userSchedule.setStudentindex(Long.parseLong(userIndex));
                userSchedule.setScheduletype(0);
                UserScheduleCourseAttendMap courseTemp = new UserScheduleCourseAttendMap();
                courseTemp.setCourseindex(Long.parseLong(detailIndex));
                courseTemp.setAttendindex(Long.parseLong(userIndex));
                courseTemp.setStatus(0);
                boolean delCourseRes = courseInfoFS.updateUserCourseAttend(courseTemp);

                UserScheduleCourse course = new UserScheduleCourse();
                course.setCourseindex(Long.parseLong(detailIndex));
                course.setStatus(0);
                boolean delCourseRes1 = courseInfoFS.updateUserScheduleCourseInfo(course);
                if (delCourseRes == true && delCourseRes1 == true)
                {
                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                }
            }

            log.info("删除日程");
            scheduleFS.delUserSchedule(userSchedule);

        }
        catch (Exception e)
        {
            log.error("退出（删除）用户笔记详情、活动、课程、个人、考试接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "");
        }
        finally
        {
            log.info("退出（删除）用户笔记详情、活动、课程、个人、考试接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        try
        {
            detailIndex = this.getRequest().getParameter("detailIndex");
            detailType = this.getRequest().getParameter("detailType");
            type = this.getRequest().getParameter("type");
            userIndex = this.getRequest().getParameter("userIndex");
            if (Tools.isNull(detailIndex) || Tools.isNull(detailType) || Tools.isNull(type) || Tools.isNull(userIndex))
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
