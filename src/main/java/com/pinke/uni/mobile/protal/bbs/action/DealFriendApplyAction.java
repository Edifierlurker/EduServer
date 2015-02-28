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
 * 处理好友申请
 * 
 * @author Administrator
 * 
 */
public class DealFriendApplyAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    /**
     * userIndex String UTF 是 用户名index 申请者的index friendindex String UTF 是 好友的index applyindex String UTF 是 申请的index
     * 查询好友申请列表时会返回给客户端
     */
    String userindex;
    String friendindex;
    String applyindex;
    String type;

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
        log.info("处理好友申请接口接收到的参数：userindex=" + userindex + ",friendindex=" + friendindex + ",applyindex=" + applyindex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "处理好友申请失败");
            boolean result = false;
            /**
             * 同意好友申请，加好友
             */
            if ("1".equals(type))
            {
                result = bbsFS.insertFriend(Long.parseLong(userindex), Long.parseLong(friendindex), Long
                        .parseLong(applyindex));
            }
            /**
             * 拒绝好友申请
             */
            else if ("2".equals(type))
            {
                result = bbsFS.updateFriendApply(Long.parseLong(applyindex), 0);
            }

            if (result == true)
            {

                resultJobj.put("result", "0");
                resultJobj.put("desc", "");

            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("处理好友申请接口异常", e);

        }
        finally
        {
            log.info("处理好友申请接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {

            userindex = this.getRequest().getParameter("userIndex");
            friendindex = this.getRequest().getParameter("friendIndex");
            applyindex = this.getRequest().getParameter("applyIndex");
            type = this.getRequest().getParameter("type");
            if (Tools.isNull(userindex) || Tools.isNull(friendindex) || Tools.isNull(applyindex) || Tools.isNull(type))
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
