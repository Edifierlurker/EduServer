package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 新增好友申请
 * 
 * @author Administrator
 * 
 */
public class InsertFriendApplyAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    /**
     * @userIndex String UTF 是 用户名index 申请者的index
     * @friendindex String UTF 是 被申请者的index
     */
    String userindex;
    String friendindex;

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
        log.info("新增好友申请接口接收到的参数：userindex=" + userindex + ",friendindex=" + friendindex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "新增好友申请失败");
            boolean tempResult = bbsFS.checkFriendApply(Long.parseLong(friendindex), Long.parseLong(userindex));
            if (tempResult == true)
            {
                boolean result = bbsFS.insertFriendApply(Long.parseLong(friendindex), Long.parseLong(userindex));
                if (result == true)
                {

                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");

                }
            }
            else
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "好友已申请");
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("新增好友申请接口异常", e);

        }
        finally
        {
            log.info("新增好友申请接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {

            userindex = this.getRequest().getParameter("userIndex");
            friendindex = this.getRequest().getParameter("friendIndex");
            if (Tools.isNull(userindex) || Tools.isNull(friendindex))
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
