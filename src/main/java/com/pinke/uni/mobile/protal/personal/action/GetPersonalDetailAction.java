package com.pinke.uni.mobile.protal.personal.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.personal.fs.IPersonalFS;
import com.pinke.uni.mobile.protal.personal.model.UserSchedulePrivate;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 查询用户个人详情
 * 
 * @author lucuiping
 * 
 */
public class GetPersonalDetailAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IPersonalFS personalFS = (IPersonalFS) SSBBus.findDomainService("mpersonalFS");;
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
        log.info("查询用户个人详情接口,userIndex=" + userIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray personalArray = new JSONArray();

        try
        {
            jsonObj.put("result", "0");
            jsonObj.put("desc", "");
            List<UserSchedulePrivate> list = personalFS.getUserPersonalDetailByIndex(Long.parseLong(detailIndex), Long
                    .parseLong(userIndex));
            if (list != null && list.size() > 0)
            {
                UserSchedulePrivate tempPersonal = list.get(0);

                jsonObj.put("title", tempPersonal.getTitle() + "");
                jsonObj.put("longitude", tempPersonal.getLatitude() + "");
                jsonObj.put("latitude", tempPersonal.getLatitude() + "");
                jsonObj.put("location", tempPersonal.getSite() + "");
                jsonObj.put("startTime", tempPersonal.getStarttime() + "");
                jsonObj.put("endTime", tempPersonal.getEndtime() + "");
                jsonObj.put("desc", tempPersonal.getContent() + "");
                jsonObj.put("note", tempPersonal.getNote() + "");

            }

        }
        catch (Exception e)
        {
            log.error("查询用户个人详情接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
        }
        finally
        {
            log.info("查询用户个人详情接口响应的Json类型的结果字符串：" + jsonObj.toString());
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
