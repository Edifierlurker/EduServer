package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.Date;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.group.fs.IGroupFS;
import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 处理群组申请
 * 
 * @author Administrator
 * 
 */
public class DealGroupApplyAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    String userindex;
    String mapIndex;
    String attendIndex;
    String groupIndex;
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
        log.info("处理群组申请接口接收到的参数：userindex=" + userindex + ",groupIndex=" + groupIndex + ",attendIndex=" + attendIndex
                + ",mapIndex=" + mapIndex + ",type=" + type);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "处理群组申请失败");
            boolean result = false;
            TGroupinfo groupinfo = groupFS.getGroupInfoByIndex(Long.parseLong(groupIndex));
            if (groupinfo != null && groupinfo.getGroupcreaterindex() != null)
            {
                if (userindex.equals(groupinfo.getGroupcreaterindex() + ""))
                {
                    /**
                     * 同意群组申请，加群组
                     */
                    if ("1".equals(type))
                    {
                        TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();
                        tgroupinfoAttendMap.setMapindex(Long.parseLong(mapIndex));
                        tgroupinfoAttendMap.setStatus(1);
                        tgroupinfoAttendMap.setAttendtime(Tools.formatDate7(new Date()));
                        result = groupFS.insertGroupAttendInfo(tgroupinfoAttendMap);
                    }
                    /**
                     * 拒绝群组申请
                     */
                    else if ("2".equals(type))
                    {
                        TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();
                        tgroupinfoAttendMap.setMapindex(Long.parseLong(mapIndex));
                        tgroupinfoAttendMap.setStatus(0);
                        result = groupFS.updateGroupAttendInfo(tgroupinfoAttendMap);
                    }

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
                resultJobj.put("desc", "群主不存在");
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("处理群组申请接口异常", e);

        }
        finally
        {
            log.info("处理群组申请接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {

            userindex = this.getRequest().getParameter("userIndex");
            mapIndex = this.getRequest().getParameter("friendIndex");
            attendIndex = this.getRequest().getParameter("applyIndex");
            type = this.getRequest().getParameter("type");
            groupIndex = this.getRequest().getParameter("groupIndex");
            if (Tools.isNull(groupIndex) || Tools.isNull(userindex) || Tools.isNull(attendIndex)
                    || Tools.isNull(mapIndex) || Tools.isNull(type))
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
