package com.pinke.uni.mobile.protal.activity.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.Form;
import org.jivesoftware.smackx.FormField;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.RoomInfo;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.activity.fs.IUserActivityFS;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMap;
import com.pinke.uni.mobile.protal.activity.model.UserActivityInviteMap;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.common.openfire.OpenfireConnection;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.pinke.uni.mobile.protal.schedule.fs.IScheduleFS;
import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 添加、修改用户活动详情
 * 
 * @author lucuiping
 * 
 */
public class InsertUserActivityAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IUserActivityFS userActivityFS = (IUserActivityFS) SSBBus.findDomainService("muserActivityFS");
    private IScheduleFS scheduleFS = (IScheduleFS) SSBBus.findDomainService("mscheduleFS");
    /**
     * userIndex 用户名index type 操作类型 1：添加 2：修改 detailIndex 活动index type=2时，必填 title 活动标题 originatorIndex 活动发起人index site
     * 活动地点 startTime string UTF 开始时间 endTime string UTF 结束时间 ifPrivate string UTF 活动是否公开 1公开 0 隐私 desc string UTF 活动内容
     * iconUrl string UTF 活动封面 attendindex 活动邀请者index 多个邀请人以“|”分隔longitude String UTF 是 活动经度 latitude String UTF 是 活动纬度
     */
    private String detailIndex;
    private String userIndex;
    private String type;
    private String title;
    private String originatorIndex;
    private String site;
    private String startTime;
    private String endTime;
    private String ifPrivate;
    private String desc;
    private String iconUrl;
    private String inviteIndex;
    private String comments;
    private String recordUrl;
    private String longitude;
    private String latitude;

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
        log.info("新增、修改用户活动详情接口，detailIndex=" + detailIndex + ",userIndex=" + userIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();

        try
        {
            jsonObj.put("result", "1");
            jsonObj.put("desc", "操作失败");
            if ("1".equals(type))
            {
                UserScheduleActivity temp = new UserScheduleActivity();
                temp.setOriginatorindex(Long.parseLong(originatorIndex));
                UserSchedule userSchedule = new UserSchedule();
                userSchedule.setStudentindex(Long.parseLong(originatorIndex));
                if (Tools.isNotNull(title))
                {
                    temp.setActivitytitle(title);
                    userSchedule.setSchedulename(title);
                    userSchedule.setScheduletitle(title);
                }
                if (Tools.isNotNull(desc))
                {
                    temp.setContent(desc);
                }
                if (Tools.isNotNull(startTime))
                {
                    temp.setStarttime(startTime);
                    userSchedule.setScheduledate(Tools.formatDate10(startTime));
                    userSchedule.setStarttime(startTime);
                }
                if (Tools.isNotNull(endTime))
                {
                    temp.setEndtime(endTime);
                    userSchedule.setEndtime(endTime);
                }
                if (Tools.isNotNull(ifPrivate))
                {
                    temp.setOpentype(Integer.parseInt(ifPrivate));
                }
                if (Tools.isNotNull(iconUrl))
                {
                    temp.setIconurl("/activityUpload/" + iconUrl);
                }
                if (Tools.isNotNull(recordUrl))
                {
                    temp.setRecordurl("/activityUpload/" + recordUrl);
                }
                if (Tools.isNotNull(site))
                {
                    temp.setSite(site);
                }
                if (Tools.isNotNull(longitude))
                {
                    temp.setSite(longitude);
                }
                if (Tools.isNotNull(latitude))
                {
                    temp.setSite(latitude);
                }
                String createTime = Tools.formatDate7(new Date());
                temp.setCreatetime(createTime);
                // 新增活动
                boolean result = userActivityFS.insertUserActivity(temp);
                if (result == true)
                {

                    UserScheduleActivity activityDetail = new UserScheduleActivity();
                    activityDetail.setOriginatorindex(Long.parseLong(originatorIndex));
                    activityDetail.setCreatetime(createTime);
                    activityDetail.setStatus(1);
                    activityDetail = userActivityFS.getUserActivityDetail(activityDetail);
                    if (activityDetail != null)
                    {
                        /**
                         * 创建聊天室
                         */
                        Tools.createCharByOpenFire(activityDetail.getActivityindex() + "");

                        UserActivityAttendMap tempAttend = new UserActivityAttendMap();
                        tempAttend.setStudentindex(Long.parseLong(userIndex));
                        if (Tools.isNotNull(comments))
                        {
                            tempAttend.setComments(Integer.parseInt(comments));
                        }
                        tempAttend.setActivityindex(activityDetail.getActivityindex());

                        /**
                         * 新增参与者和日程
                         */
                        boolean attendRes = userActivityFS.insertUserActivityAttend(tempAttend);
                        //
                        // /**
                        // * 新增日程
                        // */
                        //
                        // try
                        // {
                        // userSchedule.setDetailindex(activityDetail.getActivityindex());
                        // userSchedule.setScheduletype(1);
                        // userSchedule.setCreatetime(Tools.formatDate7(new Date()));
                        // userSchedule.setStatus(1);
                        // boolean scheduleResult = scheduleFS.insertUserSchedule(userSchedule);
                        // }
                        // catch (Exception e)
                        // {
                        // log.error("添加、修改用户日程接口异常" + e);
                        // }

                        /**
                         * 新增邀请者
                         */
                        if (Tools.isNotNull(inviteIndex))
                        {
                            String[] invites = inviteIndex.split("\\|");
                            List<UserActivityInviteMap> inviteList = new ArrayList();
                            if (invites != null && invites.length > 0)
                            {
                                for (int i = 0; i < invites.length; i++)
                                {
                                    if (Tools.isNotNull(invites[i]))
                                    {
                                        UserActivityInviteMap tempInvite = new UserActivityInviteMap();
                                        tempInvite.setActivityindex(activityDetail.getActivityindex());
                                        tempInvite.setStudentindex(Long.parseLong(invites[i]));
                                        inviteList.add(tempInvite);
                                    }

                                }
                                boolean inviteRes = userActivityFS.insertUserActivityInviteList(inviteList);
                            }
                        }

                        jsonObj.put("result", "0");
                        jsonObj.put("desc", activityDetail.getActivityindex() + "");

                        // UserSchedule userSchedule = new UserSchedule();
                        // userSchedule.setStudentindex(Long.parseLong(userIndex));
                        // userSchedule.setSchedulename(title);
                        // userSchedule.setDetailindex(activityDetail.getActivityindex());
                        // userSchedule.setScheduletitle(title);
                        // userSchedule.setScheduledate(Tools.formatDate9(new Date()));
                        // userSchedule.setScheduletype(1);
                        // userSchedule.setStarttime(startTime);
                        // userSchedule.setEndtime(endTime);
                        // userSchedule.setCreatetime(createTime);
                        // /**
                        // * 新增用户日程
                        // */
                        // boolean scheduleRes = scheduleFS.insertUserSchedule(userSchedule);
                    }

                }
            }
            else if ("2".equals(type))
            {
                UserScheduleActivity temp = new UserScheduleActivity();
                temp.setActivityindex(Long.parseLong(detailIndex));
                if (Tools.isNotNull(title))
                {
                    temp.setActivitytitle(title);
                }
                if (Tools.isNotNull(desc))
                {
                    temp.setContent(desc);
                }
                if (Tools.isNotNull(startTime))
                {
                    temp.setStarttime(startTime);
                }
                if (Tools.isNotNull(endTime))
                {
                    temp.setEndtime(endTime);
                }
                if (Tools.isNotNull(ifPrivate))
                {
                    temp.setOpentype(Integer.parseInt(ifPrivate));
                }
                if (Tools.isNotNull(iconUrl))
                {
                    temp.setIconurl(iconUrl);
                }
                if (Tools.isNotNull(recordUrl))
                {
                    temp.setRecordurl(recordUrl);
                }
                temp.setUpdatetime(Tools.formatDate7(new Date()));
                // 更新活动详情
                boolean updateRes = userActivityFS.updateUserActivityDetail(temp);

                if (updateRes == true)
                {
                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                }
            }
            else if ("3".equals(type))
            {

                UserActivityAttendMap tempAttend = new UserActivityAttendMap();
                tempAttend.setStudentindex(Long.parseLong(userIndex));

                tempAttend.setComments(Integer.parseInt(comments));

                tempAttend.setActivityindex(Long.parseLong(detailIndex));
                /**
                 * 更新参与者评论
                 */
                boolean attendRes = userActivityFS.updateUserActivityAttend(tempAttend);
                if (attendRes == true)
                {
                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                }

            }
            else if ("4".equals(type))
            {

                UserActivityAttendMap tempAttend = new UserActivityAttendMap();
                tempAttend.setStudentindex(Long.parseLong(userIndex));
                if (Tools.isNotNull(comments))
                {
                    tempAttend.setComments(Integer.parseInt(comments));
                }
                tempAttend.setActivityindex(Long.parseLong(detailIndex));
                /**
                 * 新增参与者
                 */
                boolean attendRes = userActivityFS.insertUserActivityAttend(tempAttend);

                if (attendRes == true)
                {

                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                }

            }

        }
        catch (Exception e)
        {
            log.error("新增用户活动详情接口异常", e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
        }
        finally
        {
            log.info("新增用户活动详情接口响应的Json类型的结果字符串：" + jsonObj.toString());
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
             * 1：添加2：修改3:修改评论
             */
            type = obj.get("type") + "";
            if (Tools.isNull(type))
            {
                return false;
            }

            userIndex = obj.get("userIndex") + "";
            detailIndex = obj.get("detailIndex") + "";
            originatorIndex = obj.get("originatorIndex") + "";
            comments = obj.get("comments") + "";
            if ("1".equals(type))
            {

                if (Tools.isNull(userIndex) || Tools.isNull(originatorIndex))
                {
                    return false;
                }
            }
            else if ("2".equals(type))
            {

                if (Tools.isNull(detailIndex))
                {
                    return false;
                }

            }
            else if ("3".equals(type))
            {

                if (Tools.isNull(comments) || Tools.isNull(userIndex) || Tools.isNull(detailIndex))
                {
                    return false;
                }
            }
            else if ("4".equals(type))
            {
                if (Tools.isNull(userIndex) || Tools.isNull(detailIndex))
                {
                    return false;
                }
            }

            title = obj.get("title") + "";
            site = obj.get("site") + "";
            startTime = obj.get("startTime") + "";
            endTime = obj.get("endTime") + "";
            ifPrivate = obj.get("ifPrivate") + "";
            desc = obj.get("desc") + "";
            inviteIndex = obj.get("inviteIndex") + "";
            iconUrl = obj.get("iconUrl") + "";
            recordUrl = obj.get("recordUrl") + "";
            site = obj.get("site") + "";
            longitude = obj.get("longitude") + "";
            latitude = obj.get("latitude") + "";

        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }
        return true;
    }

}
