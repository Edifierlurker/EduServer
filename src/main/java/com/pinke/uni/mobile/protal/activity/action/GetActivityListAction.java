package com.pinke.uni.mobile.protal.activity.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.activity.fs.IUserActivityFS;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMapExtends;
import com.pinke.uni.mobile.protal.activity.model.UserActivityInviteMap;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivityExtends;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 查询用户活动列表
 * 
 * @author lucuiping
 * 
 */
public class GetActivityListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IUserActivityFS userActivityFS = (IUserActivityFS) SSBBus.findDomainService("muserActivityFS");
    private String type;
    private String userIndex;
    private String activityDate;
    private String longitude;
    private String latitude;
    int pageNum;
    int count;

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
        log.info("查询用户活动列表接口,userIndex=" + userIndex + ",type=" + type);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray attendArray = new JSONArray();

        try
        {
            jsonObj.put("result", "0");
            jsonObj.put("desc", "");
            jsonObj.put("totalCount", 0);
            List<UserScheduleActivity> list = null;
            TableDataInfo tableInfo = null;

            /**
             * 查询所有的活动列表
             */
            if ("1".equals(type))
            {
                UserScheduleActivity temp = new UserScheduleActivity();
                temp.setOrderCond("starttime desc,activityindex desc");
                if (Tools.isNotNull(activityDate))
                {
                    temp.setStarttime(activityDate);
                }
                temp.setStudentindex(Long.parseLong(userIndex));
                tableInfo = userActivityFS.getUserActivityList(temp, pageNum, count);
            }
            /**
             * 查询某用户参加的活动列表
             */
            else if ("2".equals(type))
            {
                UserScheduleActivityExtends temp = new UserScheduleActivityExtends();
                if (Tools.isNotNull(userIndex))
                {
                    temp.setAttendUserindex(Long.parseLong(userIndex));
                    tableInfo = userActivityFS.getUserAttendActivityListDetail(temp, pageNum, count);

                }
            }
            /**
             * 查询附近的活动列表
             */
            else if ("3".equals(type))
            {
                UserScheduleActivity temp = new UserScheduleActivity();
                temp.setLongitude(longitude);
                temp.setLatitude(latitude);
                tableInfo = userActivityFS.getUserNearActivityList(temp, pageNum, count);
            }
            /**
             * 查询最新活动列表
             **/

            else if ("4".equals(type))
            {

                UserScheduleActivity temp = new UserScheduleActivity();
                temp.setOrderCond("starttime desc,activityindex desc");
                tableInfo = userActivityFS.getUserActivityList(temp, pageNum, count);
            }
            /**
             * 查询最热活动列表
             **/

            else if ("5".equals(type))
            {

                UserScheduleActivity temp = new UserScheduleActivity();
                temp.setOrderCond("attendcount desc,activityindex desc");
                tableInfo = userActivityFS.getUserActivityList(temp, pageNum, count);

            }
            /**
             * 发起的活动
             */
            else if ("6".equals(type))
            {
                UserScheduleActivity temp = new UserScheduleActivity();
                temp.setOriginatorindex(Long.parseLong(userIndex));
                temp.setOrderCond("attendcount desc,activityindex desc");
                tableInfo = userActivityFS.getUserActivityList(temp, pageNum, count);

            }
            /**
             * 7 收到邀请的活动
             */
            else if ("7".equals(type))
            {
                UserActivityInviteMap temp = new UserActivityInviteMap();
                tableInfo = userActivityFS.getInviteList(Long.parseLong(userIndex), pageNum, count);
            }
            if (tableInfo != null)
            {
                if (!"7".equals(type))
                {
                    list = tableInfo.getData();
                    jsonObj.put("totalCount", tableInfo.getTotalCount());

                    if (list != null && list.size() > 0)
                    {
                        List<UserActivityAttendMapExtends> attendList = null;
                        if (Tools.isNotNull(userIndex) && !"2".equals(type))
                        {
                            UserActivityAttendMapExtends attendTemp = new UserActivityAttendMapExtends();
                            attendTemp.setStudentindex(Long.parseLong(userIndex));

                            attendList = userActivityFS.getUserAttendActivityList(attendTemp);

                        }
                        /**
                         * activityIndex String UTF 是 活动index activityTitle String UTF 是 活动标题 organizerIndex String UTF
                         * 是 组织者index organizerName String UTF 是 组织者姓名 inventCount String UTF 是 参加人数 startTime String
                         * UTF 是 开始时间 yyyyMMddHHmmss endTime String UTF 是 结束时间 yyyyMMddHHmmss isAttend String UTF 是
                         * 是否已参加 1已参加 2未参加 recordUrl String UTF 是 活动语音介绍 longitude String UTF 是 活动经度 latitude String UTF
                         * 是 活动纬度
                         */
                        for (UserScheduleActivity activityTemp : list)
                        {
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("activityIndex", activityTemp.getActivityindex() + "");
                            tempJobj.put("activityTitle", activityTemp.getActivitytitle() + "");
                            tempJobj.put("organizerIndex", activityTemp.getOriginatorindex() + "");
                            tempJobj.put("organizerName", activityTemp.getOriginatorName() + "");
                            tempJobj.put("site", activityTemp.getSite() + "");
                            tempJobj.put("longitude", activityTemp.getLongitude() + "");
                            tempJobj.put("latitude", activityTemp.getLatitude() + "");
                            tempJobj.put("startTime", activityTemp.getStarttime() + "");
                            tempJobj.put("endTime", activityTemp.getEndtime() + "");
                            tempJobj.put("attendCount", activityTemp.getAttendcount() + "");
                            tempJobj.put("iconUrl", Tools.serverURL + activityTemp.getIconurl() + "");
                            tempJobj.put("recordUrl", Tools.serverURL + activityTemp.getRecordurl() + "");
                            tempJobj.put("ifPrivate", activityTemp.getOpentype() + "");
                            if ("2".equals(type))
                            {
                                tempJobj.put("isAttend", "1");
                            }
                            else
                            {
                                tempJobj.put("isAttend", "2");
                                if (attendList != null && attendList.size() > 0)
                                {
                                    for (UserActivityAttendMapExtends attend : attendList)
                                    {
                                        if ((activityTemp.getActivityindex() + "").equals(attend.getActivityindex()
                                                + ""))
                                        {
                                            tempJobj.put("isAttend", "1");
                                            break;
                                        }
                                    }

                                }
                            }

                            attendArray.add(tempJobj);

                        }
                    }
                }
                else
                {
                    List<UserActivityInviteMap> tempList = tableInfo.getData();
                    jsonObj.put("totalCount", tableInfo.getTotalCount());

                    if (tempList != null && tempList.size() > 0)
                    {

                        /**
                         * activityIndex String UTF 是 活动index activityTitle String UTF 是 活动标题 organizerIndex String UTF
                         * 是 组织者index organizerName String UTF 是 组织者姓名 inventCount String UTF 是 参加人数 startTime String
                         * UTF 是 开始时间 yyyyMMddHHmmss endTime String UTF 是 结束时间 yyyyMMddHHmmss isAttend String UTF 是
                         * 是否已参加 1已参加 2未参加 recordUrl String UTF 是 活动语音介绍 longitude String UTF 是 活动经度 latitude String UTF
                         * 是 活动纬度
                         */
                        for (UserActivityInviteMap activityTemp : tempList)
                        {
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("activityIndex", activityTemp.getActivityindex() + "");
                            tempJobj.put("activityTitle", activityTemp.getActivitytitle() + "");
                            tempJobj.put("organizerIndex", activityTemp.getOriginatorindex() + "");
                            tempJobj.put("organizerName", activityTemp.getOriginatorName() + "");
                            tempJobj.put("site", activityTemp.getSite() + "");
                            tempJobj.put("longitude", activityTemp.getLongitude() + "");
                            tempJobj.put("latitude", activityTemp.getLatitude() + "");
                            tempJobj.put("startTime", activityTemp.getStarttime() + "");
                            tempJobj.put("endTime", activityTemp.getEndtime() + "");
                            tempJobj.put("attendCount", activityTemp.getAttendcount() + "");
                            tempJobj.put("iconUrl", Tools.serverURL + activityTemp.getIconurl() + "");
                            tempJobj.put("recordUrl", Tools.serverURL + activityTemp.getRecordurl() + "");
                            tempJobj.put("isAttend", "2");
                            attendArray.add(tempJobj);

                        }
                    }
                }

            }
            jsonObj.put("data", attendArray);

        }
        catch (Exception e)
        {
            log.error("查询用户活动列表接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
            jsonObj.put("data", attendArray);
        }
        finally
        {
            log.info("查询用户活动列表接口响应的Json类型的结果字符串：" + jsonObj.toString());
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
            if ("3".equals(type))
            {
                longitude = this.getRequest().getParameter("longitude");
                latitude = this.getRequest().getParameter("latitude");
                if (Tools.isNull(longitude) || Tools.isNull(latitude))
                {
                    return false;
                }

            }
            activityDate = this.getRequest().getParameter("activityDate");
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
