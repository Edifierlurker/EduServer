package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.model.TFriendinfo;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取好友列表
 * 
 * @author Administrator
 * 
 */
public class GetFriendListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    /**
     * @userIndex String UTF 否 用户名index
     * @pageNum String 4 是 请求第几页数据
     * @count String 4 是 单页请求数量，默认取值20
     */
    String userindex;

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
        log.info("获取好友列表接口接收到的参数：userindex=" + userindex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取好友列表失败");
            List<TFriendinfo> list = bbsFS.getFriendList(Long.parseLong(userindex));

            if (list != null && list.size() > 0)
            {
                resultJobj.put("result", "0");
                resultJobj.put("desc", "");
                resultJobj.put("totalCount", list.size());
                for (TFriendinfo temp : list)
                {
                    /**
                     * @friendIndex String UTF 是 好友索引
                     * @friendName String UTF 是 好友姓名
                     * @friendPhone String UTF 是 好友手机号
                     * @friendHeadPic String UTF 是 好友头像
                     * @friendId String UTF 是 好友ID
                     */
                    JSONObject tempJobj = new JSONObject();
                    tempJobj.put("friendIndex", temp.getFriendindex() + "");
                    tempJobj.put("friendName", temp.getStudentname() + "");
                    tempJobj.put("friendPhone", temp.getUserphone() + "");
                    tempJobj.put("friendHeadPic", Tools.serverURL + temp.getHeadpic() + "");
                    tempJobj.put("friendId", temp.getStudentid() + "");
                    tempJobj.put("remark", temp.getRemark() + "");
                    tempArray.add(tempJobj);

                }
            }
            else
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "暂无好友");
            }
            resultJobj.put("data", tempArray);

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("获取好友列表好友接口异常", e);

        }
        finally
        {
            log.info("获取好友列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userindex = this.getRequest().getParameter("userIndex");

            if (Tools.isNull(userindex))
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
