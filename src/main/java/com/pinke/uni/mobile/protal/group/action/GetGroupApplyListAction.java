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
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取群组申请者列表
 * 
 * @author Administrator
 * 
 */
public class GetGroupApplyListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    /**
     * @userIndex String UTF 否 用户名index
     * @pageNum String 4 是 请求第几页数据
     * @count String 4 是 单页请求数量，默认取值20
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
        log.info("获取群组申请者列表接口接收到的参数：userindex=" + userIndex + ",groupIndex=" + groupIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取群组申请者列表失败");

            TGroupinfo groupinfo = groupFS.getGroupInfoByIndex(Long.parseLong(groupIndex));
            if (groupinfo != null && groupinfo.getGroupcreaterindex() != null)
            {
                if (userIndex.equals(groupinfo.getGroupcreaterindex() + ""))
                {
                    // 所有的群组申请者列表
                    List<TGroupinfoAttendMap> list = groupFS.getGroupApplyList(Long.parseLong(groupIndex));
                    if (list != null && list.size() > 0)
                    {
                        resultJobj.put("totalCount", list.size());
                        resultJobj.put("result", "0");
                        resultJobj.put("desc", "");
                        for (TGroupinfoAttendMap temp : list)
                        {
                            /**
                             * @attendIndex String UTF 是 申请者索引
                             * @attendName String UTF 是 申请者姓名
                             * @attendPhone String UTF 是 申请者手机号
                             * @attendHeadPic String UTF 是 申请者头像
                             * @attendId String UTF 是 申请者ID
                             * @applyNote String UTF 是 申请者的留言
                             */
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("attendIndex", temp.getAttendindex() + "");
                            tempJobj.put("attendName", temp.getStudentname() + "");
                            tempJobj.put("attendPhone", temp.getUserphone() + "");
                            tempJobj.put("attendHeadPic", temp.getHeadpic() + "");
                            tempJobj.put("attendId", temp.getStudentid() + "");
                            tempJobj.put("applyNote", temp.getNote() + "");
                            tempJobj.put("mapIndex", temp.getMapindex() + "");

                            tempArray.add(tempJobj);

                        }
                    }
                    else
                    {
                        resultJobj.put("result", "1");
                        resultJobj.put("desc", "暂无申请者");
                    }

                }
                else
                {
                    resultJobj.put("result", "1");
                    resultJobj.put("desc", "用户无权限只看申请者列表");
                }

            }
            else
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "群组不存在");
            }

            resultJobj.put("data", tempArray);

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("获取群组申请者列表接口异常", e);

        }
        finally
        {
            log.info("获取群组申请者列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
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
