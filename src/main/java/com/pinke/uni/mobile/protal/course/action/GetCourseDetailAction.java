package com.pinke.uni.mobile.protal.course.action;

import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.course.fs.ICourseFS;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 查询用户课程详情
 * 
 * @author lucuiping
 * 
 */
public class GetCourseDetailAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private ICourseFS courseInfoFS = (ICourseFS) SSBBus.findDomainService("mcourseFS");
    private String userIndex;
    private String detailIndex;

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
        log.info("查询用户课程详情接口,userIndex=" + userIndex + ",detailIndex=" + detailIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray courseInfoArray = new JSONArray();

        try
        {
            jsonObj.put("result", "0");
            jsonObj.put("desc", "");
            /**
             * 查询课程详情
             */
            UserScheduleCourse userScheduleCourse = new UserScheduleCourse();
            userScheduleCourse.setCourseindex(Long.parseLong(detailIndex));
            userScheduleCourse.setAttendindex(Long.parseLong(userIndex));
            userScheduleCourse.setStudentindex(Long.parseLong(userIndex));
            UserScheduleCourse userSchedulecourseinfo = courseInfoFS.getUserScheduleCourse(userScheduleCourse);
            /**
             * @result String 20 是 记录结果 0 成功 1 失败
             * @desc String UTF 是 成功:内容为空 失败:填写原因展现给用户
             * @title String UTF 是 课程标题
             * @teacherIndex String UTF 否 老师编号
             * @teacher String UTF 是 老师姓名
             * @roomIndex String UTF 否 地点编号
             * @room String UTF 是 地点
             * @weeks 是 第多少周上课
             * @desc String UTF 否 课程描述
             * @sections String UTF 是 节数
             * @weekDays String UTF 是 周几
             * @courseStartTime String UTF 是 上课时间
             * @couseEndTime String UTF 是 下课时间
             */
            if (userSchedulecourseinfo != null)
            {
                jsonObj.put("title", userSchedulecourseinfo.getCoursename() + "");
                jsonObj.put("teacherIndex", userSchedulecourseinfo.getTeacherindex() + "");
                jsonObj.put("teacher", userSchedulecourseinfo.getTeachername() + "");
                jsonObj.put("roomIndex", userSchedulecourseinfo.getRoomindex() + "");
                jsonObj.put("room", userSchedulecourseinfo.getRoomname() + "");
                jsonObj.put("weeks", userSchedulecourseinfo.getWeeks() + "");
                jsonObj.put("courseDesc", userSchedulecourseinfo.getDescription() + "");
                jsonObj.put("sections", userSchedulecourseinfo.getSections() + "");
                jsonObj.put("weekDays", userSchedulecourseinfo.getWeekdays() + "");
                jsonObj.put("courseStartTime", userSchedulecourseinfo.getCourseStartTime() + "");
                jsonObj.put("couseEndTime", userSchedulecourseinfo.getCourseEndTime() + "");
            }

        }
        catch (Exception e)
        {
            log.error("查询用户课程详情接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
            jsonObj.put("data", courseInfoArray);
        }
        finally
        {
            log.info("查询用户课程详情接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            detailIndex = this.getRequest().getParameter("detailIndex");
            if (Tools.isNull(userIndex) || Tools.isNull(detailIndex))
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
