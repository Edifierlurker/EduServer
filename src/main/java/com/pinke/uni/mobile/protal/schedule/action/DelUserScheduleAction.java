package com.pinke.uni.mobile.protal.schedule.action;

import java.io.IOException;

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
 * 删除用户某一日程
 * 
 * @author lucuiping
 * 
 */
public class DelUserScheduleAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IScheduleFS scheduleFS = (IScheduleFS) SSBBus.findDomainService("mscheduleFS");
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
        log.info("删除用户日程接口，userIndex=" + userIndex + ",detailIndex=" + detailIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            UserSchedule userSchedule = new UserSchedule();
            userSchedule.setStudentindex(Long.parseLong(userIndex));
            userSchedule.setScheduleindex(Long.parseLong(detailIndex));
            boolean result = scheduleFS.delUserSchedule(userSchedule);
            if (result == true)
            {
                jsonObj.put("result", "0");
                jsonObj.put("desc", "");
            }
            else
            {
                jsonObj.put("result", "1");
                jsonObj.put("desc", "删除失败");
            }

            jsonObj.put("data", tempArray);
        }
        catch (Exception e)
        {
            log.error("删除用户日程接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");

        }
        finally
        {
            log.info("删除用户日程接口响应的Json类型的结果字符串：" + jsonObj.toString());
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
