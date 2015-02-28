package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.model.TFriendinfoApply;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取好友申请列表
 * 
 * @author Administrator
 * 
 */
public class GetFriendApplyListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    /**
     * @userIndex String UTF 否 用户名index
     * @pageNum String 4 是 请求第几页数据
     * @count String 4 是 单页请求数量，默认取值20
     */
    String userindex;
    int pageNum;
    int count;

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
        log.info("获取好友申请列表接口接收到的参数：userindex=" + userindex + ",pageNum=" + pageNum + ",count=" + count);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取好友申请列表失败");
            TableDataInfo tabledata = bbsFS.getFriendApplyList(Long.parseLong(userindex), pageNum, count);
            if (tabledata != null)
            {
                resultJobj.put("result", "0");
                resultJobj.put("desc", "");
                List<TFriendinfoApply> list = tabledata.getData();
                int totalCount = tabledata.getTotalCount();
                resultJobj.put("totalCount", totalCount);
                if (list != null && list.size() > 0)
                {
                    for (TFriendinfoApply temp : list)
                    {
                        /**
                         * 
                         * @friendIndex String UTF 是 申请者索引
                         * @friendName String UTF 是 申请者姓名
                         * @friendPhone String UTF 是 申请者手机号
                         * @friendHeadPic String UTF 是 申请者头像
                         * @friendId String UTF 是 好友ID
                         * @applyIndex String UTF 是 申请的索引
                         * @applyNote String UTF 是 申请者的留言
                         */
                        JSONObject tempJobj = new JSONObject();
                        tempJobj.put("friendIndex", temp.getFriendindex() + "");
                        tempJobj.put("friendName", temp.getFriendname() + "");
                        tempJobj.put("friendPhone", temp.getFriendphone() + "");
                        tempJobj.put("friendHeadPic", temp.getFriendheadpic() + "");
                        tempJobj.put("friendId", temp.getFriendid() + "");
                        tempJobj.put("applyIndex", temp.getApplyindex() + "");
                        tempJobj.put("applyNote", temp.getApplynote() + "");
                        tempArray.add(tempJobj);

                    }
                }
                resultJobj.put("data", tempArray);
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("获取好友申请列表好友接口异常", e);

        }
        finally
        {
            log.info("获取好友申请列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userindex = this.getRequest().getParameter("userIndex");
            String pageNumStr = this.getRequest().getParameter("pageNum");
            String countStr = this.getRequest().getParameter("count");
            if (Tools.isNull(userindex) || Tools.isNull(pageNumStr) || Tools.isNull(countStr))
            {
                return false;
            }
            pageNum = Integer.parseInt(pageNumStr);
            count = Integer.parseInt(countStr);

        }
        catch (Exception e)
        {
            log.error("获取json数据异常", e);
            return false;
        }

        return true;

    }

}
