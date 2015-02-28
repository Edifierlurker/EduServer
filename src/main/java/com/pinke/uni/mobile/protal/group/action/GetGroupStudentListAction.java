package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
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
 * 查询群组成员列表
 * 
 * @author Administrator
 * 
 */
public class GetGroupStudentListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

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
        log.info("查询群组成员列表接口接收到的参数：userindex=" + userIndex + ",groupIndex=" + groupIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "查询群组成员列表失败");

            // 所有的群组列表
            List<TGroupinfoAttendMap> list = groupFS.getGroupUserList(Long.parseLong(groupIndex));

            resultJobj.put("result", "0");
            resultJobj.put("desc", "");

            if (list != null && list.size() > 0)
            {

                resultJobj.put("totalCount", list.size());
                for (TGroupinfoAttendMap temp : list)
                {
                    /**
                     * @studentIndex String UTF 成员索引
                     * @studentName String UTF 成员姓名
                     * @studentID String UTF 成员号
                     * @headPic String UTF 成员头像
                     */
                    JSONObject tempJobj = new JSONObject();
                    tempJobj.put("studentIndex", temp.getAttendindex() + "");
                    tempJobj.put("studentName", temp.getStudentname() + "");
                    tempJobj.put("studentID", temp.getStudentid() + "");
                    tempJobj.put("headPic", Tools.serverURL + temp.getHeadpic() + "");
                    tempJobj.put("grpNickName", temp.getGrpnickname() + "");
                    tempJobj.put("grpMapIndex", temp.getMapindex() + "");
                    tempArray.add(tempJobj);

                }
            }
            resultJobj.put("data", tempArray);

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("查询群组成员列表接口异常", e);

        }
        finally
        {
            log.info("查询群组成员列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            groupIndex = this.getRequest().getParameter("groupIndex");
            if (Tools.isNull(groupIndex))
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
