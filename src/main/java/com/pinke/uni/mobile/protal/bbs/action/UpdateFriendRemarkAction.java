package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 修改好友备注名称
 * 
 * @author Administrator
 * 
 */
public class UpdateFriendRemarkAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    String userIndex;
    String friendIndex;
    String remark;

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
        log.info("修改好友备注名称接口接收到的参数：userindex=" + userIndex + ",friendIndex=" + friendIndex + ",remark=" + remark);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "修改好友备注名称失败");

            boolean result = bbsFS.updateFriendRemark(Long.parseLong(userIndex), Long.parseLong(friendIndex), remark);

            if (result == true)
            {
                resultJobj.put("result", "0");
                resultJobj.put("desc", "");

            }
            else
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "修改失败");
            }
            resultJobj.put("data", tempArray);

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("修改好友备注名称好友接口异常", e);

        }
        finally
        {
            log.info("修改好友备注名称接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            friendIndex = this.getRequest().getParameter("friendIndex");
            remark = this.getRequest().getParameter("remark");
            if (Tools.isNull(userIndex) || Tools.isNull(friendIndex))
            {
                return false;
            }

        }
        catch (Exception e)
        {
            log.error("获取json数据异常", e);
            return false;
        }

        return true;

    }

}
