package com.pinke.uni.mobile.protal.course.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.course.fs.ICourseFS;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 查询用户课程列表
 * 
 * @author lucuiping
 * 
 */
public class GetCourseListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private ICourseFS courseInfoFS = (ICourseFS) SSBBus.findDomainService("mcourseFS");
    private String userIndex;
    private String type;
    private int pageNum;
    private int count;

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
        log.info("查询用户课程列表接口,userIndex=" + userIndex + ",type=" + type + ",pageNum=" + pageNum + ",count=" + count);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray courseInfoArray = new JSONArray();

        try
        {
            jsonObj.put("result", "0");
            jsonObj.put("desc", "");
            jsonObj.put("totalCount", 0);
            /**
             * 查询课程列表
             */

            UserScheduleCourse userScheduleCourseinfo = new UserScheduleCourse();

            userScheduleCourseinfo.setUserindex(Long.parseLong(userIndex));

            List<UserScheduleCourse> list = new ArrayList();
            TableDataInfo tableInfo = null;
            if ("1".equals(type))
            {
                tableInfo = courseInfoFS.getUserScheduleCourseList(userScheduleCourseinfo, pageNum, count);
            }
            else if ("2".equals(type))
            {// 用户已经参加的
                userScheduleCourseinfo.setAttendindex(Long.parseLong(userIndex));
                tableInfo = courseInfoFS.getUserScheduleCourseList(userScheduleCourseinfo, pageNum, count);
            }
            if (tableInfo != null)
            {
                list = tableInfo.getData();
                jsonObj.put("totalCount", tableInfo.getTotalCount());
                if (list != null && list.size() > 0)
                {
                    for (UserScheduleCourse tempCourse : list)
                    {
                        /**
                         * @courseIndex String UTF 是 课程index
                         * @courseTitle String UTF 是 课程名称
                         * @teacherIndex String UTF 是 老师index
                         * @teacherName String UTF 是 老师姓名
                         * @roomIndex String UTF 否 地点编号
                         * @room String UTF 是 地点
                         * @weeks String UTF 是 上课周数
                         * @attendCount String UTF 是 参加人数
                         * @isAttend String UTF 是 是否参加
                         * @weekdays String UTF 是 周几上课
                         * @sections String UTF 是 第几节课
                         * @courseStartTime String UTF 是 上课时间
                         * @couseEndTime String UTF 是 下课时间
                         */
                        JSONObject tempJobj = new JSONObject();
                        tempJobj.put("courseIndex", tempCourse.getCourseindex() + "");
                        tempJobj.put("courseTitle", tempCourse.getCoursename() + "");
                        tempJobj.put("teacherIndex", tempCourse.getTeacherindex() + "");
                        tempJobj.put("teacherName", tempCourse.getTeachername() + "");
                        tempJobj.put("roomIndex", tempCourse.getRoomindex() + "");
                        tempJobj.put("room", tempCourse.getRoomname() + "");
                        tempJobj.put("weeks", tempCourse.getWeeks() + "");
                        tempJobj.put("weekdays", tempCourse.getWeekdays() + "");
                        tempJobj.put("sections", tempCourse.getSections() + "");
                        tempJobj.put("courseStartTime", tempCourse.getCourseStartTime() + "");
                        tempJobj.put("couseEndTime", tempCourse.getCourseEndTime() + "");
                        int attendcount = courseInfoFS.getAttendUserCount(tempCourse.getCourseindex());
                        tempJobj.put("attendCount", attendcount + "");
                        if (Tools.isNotNull(tempCourse.getAttendindex() + ""))
                        {
                            tempJobj.put("isAttend", "1");
                        }
                        else
                        {
                            tempJobj.put("isAttend", "0");
                        }
                        courseInfoArray.add(tempJobj);
                    }
                }
            }

            jsonObj.put("data", courseInfoArray);

        }
        catch (Exception e)
        {
            log.error("查询用户课程列表接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
            jsonObj.put("data", courseInfoArray);
        }
        finally
        {
            log.info("查询用户课程列表接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            type = this.getRequest().getParameter("type");
            String pageNumStr = this.getRequest().getParameter("pageNum");
            String countStr = this.getRequest().getParameter("count");
            if (Tools.isNull(type) || Tools.isNull(userIndex) || Tools.isNull(pageNumStr) || Tools.isNull(countStr))
            {
                return false;
            }

            pageNum = Integer.parseInt(pageNumStr);
            count = Integer.parseInt(countStr);

        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }

        return true;
    }

}
