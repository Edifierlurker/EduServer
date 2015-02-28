package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfoNoticeMap;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.AppstoreOnlineErrorCode;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 新增论坛关注
 * 
 * @author Administrator
 * 
 */
public class InsertBBSNoticeAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    String userindex;
    String bbsIndex;
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
        log.info("新增论坛关注接口接收到的参数：userindex=" + userindex + ",bbsIndex=" + bbsIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            if ("1".equals(type))
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "论坛关注失败");
                TBbsinfoNoticeMap tbbsinfoNoticeMap = new TBbsinfoNoticeMap();
                tbbsinfoNoticeMap.setBbsindex(Long.parseLong(bbsIndex));
                tbbsinfoNoticeMap.setAttendindex(Long.parseLong(userindex));
                String result = bbsFS.insertBBSNoticeInfo(tbbsinfoNoticeMap);
                if ("2".equals(result))
                {

                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");

                }
                else if ("1".equals(result))
                {
                    resultJobj.put("result", "1");
                    resultJobj.put("desc", "您已关注此论坛");
                }
            }
            else if ("2".equals(type))
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "取消论坛关注失败");
                TBbsinfoNoticeMap tbbsinfoNoticeMap = new TBbsinfoNoticeMap();
                tbbsinfoNoticeMap.setBbsindex(Long.parseLong(bbsIndex));
                tbbsinfoNoticeMap.setAttendindex(Long.parseLong(userindex));
                String result = bbsFS.removeBBSNoticeInfo(tbbsinfoNoticeMap);
                if ("2".equals(result))
                {

                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");

                }
                else if ("1".equals(result))
                {
                    resultJobj.put("result", "1");
                    resultJobj.put("desc", "您未关注此论坛");
                }
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("新增论坛关注接口异常", e);

        }
        finally
        {
            log.info("新增论坛关注接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {

            userindex = this.getRequest().getParameter("userIndex");
            bbsIndex = this.getRequest().getParameter("bbsIndex");
            type = this.getRequest().getParameter("type");

            if (Tools.isNull(userindex) || Tools.isNull(bbsIndex) || Tools.isNull(type))
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
