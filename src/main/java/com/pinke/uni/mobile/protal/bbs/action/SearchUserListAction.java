package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.adapter.fs.ILoginFS;
import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.model.TFriendinfo;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 按条件搜索好友列表（全网）
 * 
 * @author Administrator
 * 
 */
public class SearchUserListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");

    /**
     * @userIndex String UTF 否 用户名index
     * @pageNum String 4 是 请求第几页数据
     * @count String 4 是 单页请求数量，默认取值20
     */
    String userindex;
    String keyword;
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
        log.info("按条件搜索好友列表接口接收到的参数：userindex=" + userindex + "keyword=" + keyword + ",pageNum=" + pageNum + ",count="
                + count);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "按条件搜索好友列表失败");
            TableDataInfo tabledata = loginFS.searchUserList(keyword, pageNum, count);
            if (tabledata != null)
            {
                resultJobj.put("result", "0");
                resultJobj.put("desc", "");
                List<TStudentinfo> list = tabledata.getData();
                int totalCount = tabledata.getTotalCount();
                resultJobj.put("totalCount", totalCount);
                if (list != null && list.size() > 0)
                {
                    for (TStudentinfo temp : list)
                    {
                        /**
                         * @friendIndex String UTF 是 好友索引
                         * @friendName String UTF 是 好友姓名
                         * @friendPhone String UTF 是 好友手机号
                         * @friendHeadPic String UTF 是 好友头像
                         * @friendId String UTF 是 好友ID
                         */
                        JSONObject tempJobj = new JSONObject();
                        tempJobj.put("studentIndex", temp.getStudentindex() + "");
                        tempJobj.put("studentName", temp.getStudentname() + "");
                        tempJobj.put("studentID", temp.getStudentid() + "");
                        tempJobj.put("headPic", Tools.serverURL + temp.getHeadpic() + "");
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
            log.info("按条件搜索好友列表好友接口异常", e);

        }
        finally
        {
            log.info("按条件搜索好友列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userindex = this.getRequest().getParameter("userIndex");
            keyword = this.getRequest().getParameter("keyword");
            String pageNumStr = this.getRequest().getParameter("pageNum");
            String countStr = this.getRequest().getParameter("count");
            if (Tools.isNull(userindex) || Tools.isNull(pageNumStr) || Tools.isNull(countStr) || Tools.isNull(keyword))
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
