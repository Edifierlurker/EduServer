package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.group.fs.IGroupFS;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletin;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 删除群公告
 * 
 * @author Administrator
 * 
 */
public class RemoveGroupBulletinAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    String userIndex;
    String bullIndex;

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
        log.info("删除群公告接口接收到的参数：userindex=" + userIndex + ",bullIndex=" + bullIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "删除群公告失败");
            TGroupinfoBulletin tempBulletin = groupFS.getGroupBulletin(Long.parseLong(bullIndex));
            if (tempBulletin == null)
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "暂无此群公告");
            }
            else
            {
                if (tempBulletin.getStatus() == 1)
                {
                    if (tempBulletin.getStudentindex() != null && userIndex.equals(tempBulletin.getStudentindex() + ""))
                    {
                        boolean result = groupFS.removeGroupBulletin(Long.parseLong(bullIndex));
                        if (result == true)
                        {
                            resultJobj.put("result", "0");
                            resultJobj.put("desc", "");
                        }
                    }
                    else
                    {
                        resultJobj.put("result", "1");
                        resultJobj.put("desc", "暂无权限");
                    }

                }
                else
                {
                    resultJobj.put("result", "1");
                    resultJobj.put("desc", "群公告状态异常");
                }
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("删除群公告接口异常", e);

        }
        finally
        {
            log.info("删除群公告接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            bullIndex = this.getRequest().getParameter("bullIndex");
            if (Tools.isNull(userIndex) || Tools.isNull(bullIndex))
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
