package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.group.fs.IGroupFS;
import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取我的群聊列表
 * 
 * @author Administrator
 * 
 */
public class GetChatGroupListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    /**
     * @userIndex String UTF 否 用户名index
     */
    String userIndex;

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
        log.info("获取我的群聊列表接口接收到的参数：userindex=" + userIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取我的群聊列表失败");

            // 所有的我的群聊列表

            List<TGroupinfoAttendMap> list = groupFS.getMyChatGroupList(Long.parseLong(userIndex));

            resultJobj.put("result", "0");
            resultJobj.put("desc", "");
            resultJobj.put("totalCount", 0);
            if (list != null && list.size() > 0)
            {
                resultJobj.put("totalCount", list.size());
                for (TGroupinfoAttendMap temp : list)
                {
                    /**
                     * @groupIndex String UTF 我的群聊索引
                     * @groupTitle String UTF 我的群聊标题
                     * @groupPic String UTF 我的群聊图片
                     */
                    JSONObject tempJobj = new JSONObject();
                    tempJobj.put("groupIndex", temp.getGroupindex() + "");
                    tempJobj.put("groupID", temp.getGroupid() + "");
                    tempJobj.put("groupTitle", temp.getGrouptitle() + "");

                    tempJobj.put("groupPic", Tools.serverURL + temp.getGrouppic() + "");
                    tempJobj.put("groupType", temp.getGrouptype() + "");
                    tempJobj.put("groupmanagerindex",temp.getGroupmanagerindex()+"");
                    tempArray.add(tempJobj);

                }
            }
            resultJobj.put("data", tempArray);

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("获取我的群聊列表接口异常", e);

        }
        finally
        {
            log.info("获取我的群聊列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userIndex = this.getRequest().getParameter("userIndex");

        }
        catch (Exception e)
        {
            log.error("获取json数据异常", e);
            return false;
        }

        return true;

    }

}
