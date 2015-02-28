package com.pinke.uni.mobile.protal.adapter.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.adapter.fs.ILoginFS;
import com.pinke.uni.mobile.protal.adapter.model.TClassinfo;
import com.pinke.uni.mobile.protal.adapter.model.TCollegeinfo;
import com.pinke.uni.mobile.protal.adapter.model.TMajorinfo;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfo;
import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

/**
 * 根据userid查看用户信息
 * 
 * @author lucuiping
 */
public class GetUserInfoByUseridAction extends Business
{

    private Log log = SSBBus.getLog(getClass());
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");
    private String userID;

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

            TStudentinfo userInfo = loginFS.getUserInfoByUserID(userID);
            if (userInfo == null)
            {
                jsonObj.put("result", "1");
                jsonObj.put("desc", "用户不存在，无法查看信息");
            }
            else
            {

                jsonObj.put("result", "0");
                jsonObj.put("desc", "");
                jsonObj.put("name", userInfo.getStudentname());
                jsonObj.put("userCode", userInfo.getUserphone() + "");
                jsonObj.put("userIndex", userInfo.getStudentindex() + "");
                jsonObj.put("headPic", Tools.serverURL + userInfo.getHeadpic() + "");
                jsonObj.put("userID",  userInfo.getStudentid() + "");

            }

        }
        catch (Exception e)
        {
            log.info("根据userID查询用户信息接口异常", e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "查询用户信息失败");

        }
        finally
        {
            log.info("根据userID查询用户信息接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }

    }

    private boolean confirm()
    {
        try
        {
            userID = this.getRequest().getParameter("userID");

            if (Tools.isNull(userID))
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
