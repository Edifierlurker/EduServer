package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.group.fs.IGroupFS;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 修改用户群昵称
 * 
 * @author Administrator
 * 
 */
public class updateGroupUserNicknameAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    /**
     * @userIndex String UTF 否 用户名index
     * @pageNum String 4 是 请求第几页数据
     * @count String 4 是 单页请求数量，默认取值20
     */
    String userIndex;
    String grpNickname;
    String grpMapIndex;

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
        log.info("修改用户群昵称接口接收到的参数：userindex=" + userIndex + ",grpMapIndex=" + grpMapIndex + ",grpNickname="
                + grpNickname);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "修改用户群昵称失败");

            // 所有的群组列表
            boolean result = groupFS.updateUserGroupNickname(Long.parseLong(grpMapIndex), grpNickname);

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
            log.info("修改用户群昵称接口异常", e);

        }
        finally
        {
            log.info("修改用户群昵称接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userIndex = this.getRequest().getParameter("userIndex");

            grpNickname = this.getRequest().getParameter("grpNickname");
            grpMapIndex = this.getRequest().getParameter("grpMapIndex");

            if (Tools.isNull(userIndex) || Tools.isNull(grpNickname) || Tools.isNull(grpMapIndex))
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
