package com.pinke.uni.mobile.protal.activity.action;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
 * 搜索活动列表
 * 
 * @author lucuiping
 * 
 */
public class SearchActivityListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IUserActivityFS userActivityFS = (IUserActivityFS) SSBBus.findDomainService("muserActivityFS");
    private String keyword;
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
        log.info("搜索活动列表接口,userIndex=" + userIndex + ",keyword=" + keyword);
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

            tableInfo = userActivityFS.searchUserActivityList(keyword, pageNum, count);

            if (tableInfo != null)
            {

                list = tableInfo.getData();
                jsonObj.put("totalCount", tableInfo.getTotalCount());

                if (list != null && list.size() > 0)
                {
                    List<UserActivityAttendMapExtends> attendList = null;

                    UserActivityAttendMapExtends attendTemp = new UserActivityAttendMapExtends();
                    attendTemp.setStudentindex(Long.parseLong(userIndex));
                    attendTemp.setStatus(1);
                    attendList = userActivityFS.getUserAttendActivityList(attendTemp);

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

                        tempJobj.put("isAttend", "2");
                        if (attendList != null && attendList.size() > 0)
                        {
                            for (UserActivityAttendMapExtends attend : attendList)
                            {
                                if ((activityTemp.getActivityindex() + "").equals(attend.getActivityindex() + ""))
                                {
                                    tempJobj.put("isAttend", "1");
                                    break;
                                }
                            }

                        }

                        attendArray.add(tempJobj);

                    }
                }

            }
            jsonObj.put("data", attendArray);

        }
        catch (Exception e)
        {
            log.error("搜索活动列表接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
            jsonObj.put("data", attendArray);
        }
        finally
        {
            log.info("搜索活动列表接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            keyword = this.getRequest().getParameter("keyword");
            keyword = URLDecoder.decode(keyword,"UTF-8");
            String pageNumStr = this.getRequest().getParameter("pageNum");
            String countStr = this.getRequest().getParameter("count");
            if (Tools.isNull(keyword) || Tools.isNull(pageNumStr) || Tools.isNull(countStr))
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
