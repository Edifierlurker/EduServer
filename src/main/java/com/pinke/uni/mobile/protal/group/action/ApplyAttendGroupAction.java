package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.Date;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.group.fs.IGroupFS;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 申请加入群组
 * 
 * @author Administrator
 * 
 */
public class ApplyAttendGroupAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    /**
     * userIndex String UTF 否 用户名index site String UTF 否 群组地点 longitude String UTF 否 群组经度 latitude String UTF 否 群组纬度
     * groupTitle String UTF 群组标题 groupBref String UTF 群组简介 groupPic String UTF 群组图片 groupDesc 群组描述 groupMessage 群组留言
     */
    String userIndex;
    String groupIndex;

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
        log.info("申请加入群组接口接收到的参数：userindex=" + userIndex + ",groupIndex=" + groupIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "申请加入群组失败");
            TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();
            tgroupinfoAttendMap.setGroupindex(Long.parseLong(groupIndex));
            tgroupinfoAttendMap.setAttendindex(Long.parseLong(userIndex));
            tgroupinfoAttendMap.setStatus(2);

            String createtime = Tools.formatDate7(new Date());
            tgroupinfoAttendMap.setApplytime(createtime);
            String attendFlag = groupFS.insertGroupApplyInfo(tgroupinfoAttendMap);
            if ("1".equals(attendFlag))
            {
                resultJobj.put("result", "0");
                resultJobj.put("desc", "");
            }
            else if ("2".equals(attendFlag))
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "已经申请");
            }
            else if ("3".equals(attendFlag))
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "已经加入");
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("申请加入群组接口异常", e);

        }
        finally
        {
            log.info("申请加入群组接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {

            userIndex = this.getRequest().getParameter("userIndex");
            groupIndex = this.getRequest().getParameter("groupIndex");

            if (Tools.isNull(userIndex) || Tools.isNull(groupIndex))
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
