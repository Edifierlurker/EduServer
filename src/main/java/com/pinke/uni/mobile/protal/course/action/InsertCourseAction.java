package com.pinke.uni.mobile.protal.course.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.adapter.fs.ILoginFS;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfoHis;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.course.fs.ICourseFS;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourseAttendMap;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 添加、修改用户课程详情
 * 
 * @author lucuiping
 * 
 */
public class InsertCourseAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private ICourseFS courseInfoFS = (ICourseFS) SSBBus.findDomainService("mcourseFS");
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");
    /**
     * @userIndex String UTF 是 用户名index
     * @type String UTF 是 操作类型 1：添加 2：修改（暂不使用） 3：加入某一课程
     * @courseIndex String UTF 是 课程index type=2、3时必填
     * @title String UTF 是 课程标题
     * @teacherIndex String UTF 否 老师编号
     * @teacher String UTF 是 老师姓名
     * @roomIndex String UTF 否 教室编号 教室编号
     * @room String UTF 是 上课地点
     * @weeks String UTF 是 周数 6-16周上课 多个周以“|”分隔
     * @desc String UTF 否 课程描述
     * @sections String UTF 是 节数 多个节数以”|”分隔
     * @weekDays String UTF 是 周几
     * @CourseStartTime String UTF 否 课程上课时间 如果用户选择了时间区间才填写
     * @CourseEndTime String UTF 否 课程下课时间 如果用户选择了时间区间才填写
     */
    private String courseIndex;
    private String userIndex;
    private String type;
    private String title;
    private String teacherIndex;
    private String teacher;
    private String roomIndex;
    private String room;
    private String weeks;
    private String desc;
    private String sections;
    private String weekDays;
    private String courseStartTime;
    private String courseEndTime;
    private String schoolIndex;

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
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();

        try
        {
            jsonObj.put("result", "1");
            jsonObj.put("desc", "操作失败");
            /**
             * 新增课程的同时要加入这个课程
             */
            if ("1".equals(type))
            {
                UserScheduleCourse temp = new UserScheduleCourse();
                temp.setStudentindex(Long.parseLong(userIndex));
                if (Tools.isNotNull(title))
                {
                    temp.setCoursename(title);
                }
                if (Tools.isNotNull(teacherIndex))
                {
                    temp.setTeacherindex(Long.parseLong(teacherIndex));
                }
                if (Tools.isNotNull(teacher))
                {
                    temp.setTeachername(teacher);
                }
                if (Tools.isNotNull(roomIndex))
                {
                    temp.setRoomindex(Long.parseLong(roomIndex));
                }
                if (Tools.isNotNull(room))
                {
                    temp.setRoomname(room);
                }
                if (Tools.isNotNull(weeks))
                {
                    temp.setWeeks(weeks);
                }
                if (Tools.isNotNull(desc))
                {
                    temp.setDescription(desc);
                }
                if (Tools.isNotNull(sections))
                {
                    temp.setSections(sections);
                }
                if (Tools.isNotNull(weekDays))
                {
                    temp.setWeekdays(Integer.parseInt(weekDays));
                }
                if (Tools.isNotNull(schoolIndex))
                {
                    temp.setSchoolindex(Long.parseLong(schoolIndex));
                }
                temp.setStatus(1);
                temp.setNote(Tools.formatDate7(new Date()));
                String result = courseInfoFS.insertUserScheduleCourseInfo(temp);

                if (Tools.isNotNull(result))
                {
                    try
                    {
                        JSONObject resultJobj = JSONObject.fromObject(result);
                        if (resultJobj != null)
                        {
                            String tempResult = resultJobj.get("result") + "";
                            String courseindex = resultJobj.get("courseindex") + "";
                            if (Tools.isNotNull(tempResult) && CommonErrorcode.COMMON_SUCCESS.equals(tempResult)
                                    && Tools.isNotNull(courseindex))
                            {
                                jsonObj.put("result", "0");
                                jsonObj.put("desc", courseindex + "");
                            }
                        }

                    }
                    catch (Exception e)
                    {

                    }

                }

            }
            // else if ("2".equals(type))
            // {
            // UserScheduleCourse temp = new UserScheduleCourse();
            // temp.setCourseindex(Long.parseLong(detailIndex));
            // temp.setStudentindex(Long.parseLong(userIndex));
            //
            // if (Tools.isNotNull(title))
            // {
            // temp.setCoursename(title);
            // }
            // if (Tools.isNotNull(teacherIndex))
            // {
            // temp.setTeacherindex(Long.parseLong(teacherIndex));
            // }
            // if (Tools.isNotNull(teacher))
            // {
            // temp.setTeachername(teacher);
            // }
            // if (Tools.isNotNull(roomIndex))
            // {
            // temp.setRoomindex(Long.parseLong(roomIndex));
            // }
            // if (Tools.isNotNull(room))
            // {
            // temp.setRoomname(room);
            // }
            // if (Tools.isNotNull(weeks))
            // {
            // temp.setWeeks(weeks);
            // }
            // if (Tools.isNotNull(desc))
            // {
            // temp.setDescription(desc);
            // }
            // if (Tools.isNotNull(sections))
            // {
            // temp.setSections(sections);
            // }
            // if (Tools.isNotNull(weekDays))
            // {
            // temp.setWeekdays(Integer.parseInt(weekDays));
            // }
            // boolean result = courseInfoFS.updateUserScheduleCourseInfo(temp);
            // if (result == true)
            // {
            // jsonObj.put("result", "0");
            // jsonObj.put("desc", "");
            // }
            // }
            /**
             * 加入某一课程
             */
            else if ("3".equals(type))
            {
                UserScheduleCourse temp = new UserScheduleCourse();
                temp.setCourseindex(Long.parseLong(courseIndex));
                temp.setStatus(1);

                temp = courseInfoFS.getUserScheduleCourse(temp);
                boolean result = false;
                if (temp != null)
                {
                    UserScheduleCourseAttendMap userScheduleCourseAttendMap = new UserScheduleCourseAttendMap();
                    userScheduleCourseAttendMap.setCourseindex(Long.parseLong(courseIndex));
                    userScheduleCourseAttendMap.setAttendindex(Long.parseLong(userIndex));
                    if (Tools.isNotNull(temp.getSections()))
                    {
                        String[] sectionArray = sections.split("-");
                        int length = sectionArray.length;
                        if (sectionArray != null && sectionArray.length > 0)
                        {
                            if (Tools.isNull(schoolIndex))
                                schoolIndex = "1";
                            if (Tools.isNotNull(schoolIndex))
                            {
                                TSchoolinfoHis tschoolinfoHis = new TSchoolinfoHis();
                                tschoolinfoHis.setSchoolindex(Long.parseLong(schoolIndex));
                                List<TSchoolinfoHis> tempSchoolHisList = loginFS.getSchoolfoExtendsList(tschoolinfoHis);
                                if (tempSchoolHisList != null && tempSchoolHisList.size() > 0)
                                {

                                    for (TSchoolinfoHis tempSchool : tempSchoolHisList)
                                    {
                                        if (Tools.isNotNull(sectionArray[0])
                                                && sectionArray[0].equals(tempSchool.getSections() + ""))
                                        {
                                            courseStartTime = tempSchool.getSectionstarttime();
                                        }
                                        if (Tools.isNotNull(sectionArray[length - 1])
                                                && sectionArray[length - 1].equals(tempSchool.getSections() + ""))
                                        {
                                            courseEndTime = tempSchool.getSectionendtime();
                                        }
                                    }

                                }
                            }
                        }

                    }

                    userScheduleCourseAttendMap.setCourseendtime(courseEndTime);
                    userScheduleCourseAttendMap.setCoursestarttime(courseStartTime);

                    result = courseInfoFS.insertIntoCourse(userScheduleCourseAttendMap);
                }

                if (result == true)
                {
                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                }
            }

        }
        catch (Exception e)
        {
            log.error("添加、修改用户课程详情接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
        }
        finally
        {
            log.info("添加、修改用户课程详情接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {

        try
        {
            String content = getRequestContent();

            log.info("新增课程请求的Json类型的结果字符串：" + content);
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
             * 1：添加2：修改 3：添加参与者
             */
            type = obj.get("type") + "";
            if (Tools.isNull(type))
            {
                return false;
            }

            userIndex = obj.get("userIndex") + "";
            courseIndex = obj.get("courseIndex") + "";
            if ("1".equals(type))
            {

                if (Tools.isNull(userIndex))
                {
                    return false;
                }
            }
            else if ("2".equals(type) || "3".equals(type))
            {

                if (Tools.isNull(courseIndex) || Tools.isNull(userIndex))
                {
                    return false;
                }

            }

            title = obj.get("title") + "";
            teacherIndex = obj.get("teacherIndex") + "";
            teacher = obj.get("teacher") + "";
            roomIndex = obj.get("roomIndex") + "";
            room = obj.get("room") + "";
            weeks = obj.get("weeks") + "";
            desc = obj.get("desc") + "";
            sections = obj.get("sections") + "";
            weekDays = obj.get("weekDays") + "";
            courseStartTime = obj.get("courseStartTime") + "";
            courseEndTime = obj.get("courseEndTime") + "";
            schoolIndex = obj.get("schoolIndex") + "";
        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }
        return true;
    }

}
