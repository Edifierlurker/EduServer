package com.pinke.uni.mobile.protal.activity.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.activity.fs.IUserActivityFS;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMapExtends;
import com.pinke.uni.mobile.protal.activity.model.UserActivityInviteMap;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.common.config.ConfigContent;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 查询用户活动详情
 * 
 * @author lucuiping
 * 
 */
public class GetUserActivityDetailAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IUserActivityFS userActivityFS = (IUserActivityFS) SSBBus.findDomainService("muserActivityFS");
    private String detailIndex;
    private String userIndex;

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
        log.info("查询用户活动详情接口，detailIndex=" + detailIndex + ",userIndex=" + userIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();

        try
        {
            jsonObj.put("result", "0");
            jsonObj.put("desc", "");

            // 查询活动详情
            UserScheduleActivity temp = userActivityFS.getUserActivityDetailByIndex(Long.parseLong(detailIndex));
            /**
             * title string UTF 活动名称 originatorIndex string UTF 活动发起人index
             * 
             * originator string UTF 活动发起人 site string UTF 活动地点
             * 
             * startTime string UTF 开始时间 endTime string UTF 结束时间 ifPrivate string UTF 活动是否公开 desc string UTF 活动内容
             * 
             * iconUrl string UTF 活动封面
             * 
             * attendIndex string UTF 活动参与者 attendName string UTF 活动参与者名称 attendPic string UTF 活动参与者头像url isInvite
             * 活动是否被邀请 isAttend 活动是否参加
             */
            if (temp != null)
            {
                jsonObj.put("title", temp.getActivitytitle() + "");
                jsonObj.put("originatorIndex", temp.getOriginatorindex() + "");
                jsonObj.put("originator", temp.getOriginatorName() + "");
                jsonObj.put("site", temp.getSite() + "");
                jsonObj.put("longitude", temp.getLongitude() + "");
                jsonObj.put("latitude", temp.getLatitude() + "");
                jsonObj.put("startTime", temp.getStarttime() + "");
                jsonObj.put("endTime", temp.getEndtime() + "");
                jsonObj.put("ifPrivate", temp.getOpentype() + "");
                jsonObj.put("desc", temp.getContent() + "");
                jsonObj.put("iconUrl", ConfigContent.getXmlconfig().getAppstateUrlRoot() + "/upload/"
                        + temp.getIconurl() + "");
                jsonObj.put("recordUrl", ConfigContent.getXmlconfig().getAppstateUrlRoot() + "/upload/"
                        + temp.getRecordurl() + "");

                jsonObj.put("isInvite", "0");
                jsonObj.put("isAttend", "0");
                JSONArray attendArray = new JSONArray();
                // 查询参与者列表
                List<UserActivityAttendMapExtends> attendList = userActivityFS.getAttendListByIndex(Long
                        .parseLong(detailIndex));
                if (attendList != null && attendList.size() > 0)
                {

                    for (UserActivityAttendMapExtends tempAttend : attendList)
                    {
                        JSONObject tempJobj = new JSONObject();
                        tempJobj.put("attendIndex", tempAttend.getStudentindex() + "");
                        tempJobj.put("attendName", tempAttend.getAttendUserName() + "");
                        tempJobj.put("attendPic", ConfigContent.getXmlconfig().getAppstateUrlRoot() + "/upload/"
                                + tempAttend.getAttendUserHeadPic() + "");
                        attendArray.add(tempJobj);
                        if (Tools.isNotNull(userIndex) && userIndex.equals(tempAttend.getStudentindex() + ""))
                        {
                            jsonObj.put("isAttend", "1");
                        }
                    }
                }

                jsonObj.put("attendDetail", attendArray);
                if (Tools.isNotNull(userIndex))
                {
                    // 查询用户是否被邀请
                    UserActivityInviteMap tempInvite = userActivityFS.getInviteByIndex(Long.parseLong(detailIndex),
                            Long.parseLong(userIndex));
                    if (tempInvite != null)
                    {
                        jsonObj.put("isInvite", "1");
                    }
                }

            }

        }
        catch (Exception e)
        {
            log.error("查询用户活动详情接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
        }
        finally
        {
            log.info("查询用户活动详情接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        try
        {
            detailIndex = this.getRequest().getParameter("detailIndex");
            if (Tools.isNull(detailIndex))
            {
                return false;
            }
            userIndex = this.getRequest().getParameter("userIndex");
        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }

        return true;
    }

}
