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
 * 查询用户个人列表
 * 
 * @author lucuiping
 * 
 */
public class GetPersonalListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IPersonalFS personalFS = (IPersonalFS) SSBBus.findDomainService("mpersonalFS");;
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
        log.info("查询用户个人列表接口,userIndex=" + userIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray personalArray = new JSONArray();

        try
        {
            jsonObj.put("result", "0");
            jsonObj.put("desc", "");
            List<UserSchedulePrivate> list = personalFS.getUserPersonalList(Long.parseLong(userIndex));
            if (list != null && list.size() > 0)
            {
                for (UserSchedulePrivate tempPersonal : list)
                {
                    JSONObject tempJobj = new JSONObject();
                    tempJobj.put("title", tempPersonal.getTitle() + "");
                    tempJobj.put("longitude", tempPersonal.getLatitude() + "");
                    tempJobj.put("latitude", tempPersonal.getLatitude() + "");
                    tempJobj.put("location", tempPersonal.getSite() + "");
                    tempJobj.put("startTime", tempPersonal.getStarttime() + "");
                    tempJobj.put("endTime", tempPersonal.getEndtime() + "");
                    tempJobj.put("desc", tempPersonal.getContent() + "");
                    tempJobj.put("note", tempPersonal.getNote() + "");
                    personalArray.add(tempJobj);
                }
            }
            jsonObj.put("data", personalArray);

        }
        catch (Exception e)
        {
            log.error("查询用户个人列表接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
            jsonObj.put("data", personalArray);
        }
        finally
        {
            log.info("查询用户个人列表接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            if(Tools.isNull(userIndex)){
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
