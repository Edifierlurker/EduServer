package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfo;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取文章列表
 * 
 * @author Administrator
 * 
 */
public class GetArticleListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    /**
     * @userIndex String UTF 否 用户名index
     * @pageNum String 4 是 请求第几页数据
     * @count String 4 是 单页请求数量，默认取值20
     */
    String userIndex;
    int pageNum;
    int count;
    String bbsIndex;
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
        log.info("获取文章列表接口接收到的参数：userindex=" + userIndex + ",pageNum=" + pageNum + ",count=" + count + ",bbsIndex="
                + bbsIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取文章列表失败");
            TableDataInfo tabledata = null;
            // 所有的文章列表
            if ("1".equals(type))
            {
                tabledata = bbsFS.getArticleList(Long.parseLong(bbsIndex), pageNum, count);
            }
            else if ("2".equals(type))
            {
                tabledata = bbsFS.getUserNoticeArticleList(Long.parseLong(userIndex), pageNum, count);
            }
            else if ("3".equals(type))
            {
                tabledata = bbsFS.getMyArticleList(Long.parseLong(userIndex), pageNum, count);
            }

            if (tabledata != null)
            {
                resultJobj.put("result", "0");
                resultJobj.put("desc", "");
                List<TArticleinfo> list = tabledata.getData();
                int totalCount = tabledata.getTotalCount();
                resultJobj.put("totalCount", totalCount);
                if (list != null && list.size() > 0)
                {
                    for (TArticleinfo temp : list)
                    {
                        /**
                         * @articleIndex String UTF 文章索引
                         * @articleTitle String UTF 文章标题
                         * @createindex String UTF 文章创建者index
                         * @creator String UTF 文章创建者名称
                         * @createTime String UTF 文章创建时间
                         * @commentCount String UTF 文章评论数
                         */
                        JSONObject tempJobj = new JSONObject();
                        tempJobj.put("articleIndex", temp.getArticleindex() + "");
                        tempJobj.put("articleTitle", temp.getArticletitle() + "");
                        tempJobj.put("articleDesc", temp.getArticledesc() + "");
                        tempJobj.put("createindex", temp.getCreaterindex() + "");
                        tempJobj.put("creator", temp.getCreator() + "");
                        tempJobj.put("createTime", temp.getCreatetime() + "");
                        tempJobj.put("commentCount", temp.getCommenttimes() + "");
                        if ("2".equals(type))
                        {
                            tempJobj.put("bbsIndex", temp.getBbsindex() + "");
                            tempJobj.put("bbsTitle", temp.getBbstitle() + "");
                        }
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
            log.info("获取文章列表接口异常", e);

        }
        finally
        {
            log.info("获取文章列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            String pageNumStr = this.getRequest().getParameter("pageNum");
            String countStr = this.getRequest().getParameter("count");
            bbsIndex = this.getRequest().getParameter("bbsIndex");
            type = this.getRequest().getParameter("type");
            if (Tools.isNull(pageNumStr) || Tools.isNull(countStr) || Tools.isNull(type))
            {
                return false;
            }
            if ("1".equals(type) && Tools.isNull(bbsIndex))
            {
                return false;
            }
            if ("2".equals(type) || "3".equals(type))
            {
                if (Tools.isNull(userIndex))
                {
                    return false;
                }
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
