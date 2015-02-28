package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoComment;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取文章评论列表
 * 
 * @author Administrator
 * 
 */
public class GetArticleCommentListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    /**
     * @userIndex String UTF 是 用户名index
     * @type String UTF 是 1查询对我的所有文章的评论 2查询对某一文章的评论 3只看楼主
     * @articleindex String UTF 否 文章的index
     * @creatorindex String UTF 否 文章发表者的index
     * @pageNum String 4 是 请求第几页数据
     * @count String 4 是 单页请求数量，默认取值20
     */
    String userIndex;
    String articleindex;
    String creatorindex;
    int pageNum;
    int count;
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
        log.info("获取文章评论列表接口接收到的参数：userindex=" + userIndex + ",pageNum=" + pageNum + ",count=" + count
                + ",articleindex=" + articleindex + "type:" + type);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取文章评论列表失败");
            /**
             * 1查询对我的所有文章的评论
             */
            if ("1".equals(type))
            {
                TableDataInfo tabledata = bbsFS.getCommentToMeList(Long.parseLong(userIndex), pageNum, count);

                if (tabledata != null)
                {
                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");
                    List<TArticleinfoComment> list = tabledata.getData();
                    int totalCount = tabledata.getTotalCount();
                    resultJobj.put("totalCount", totalCount);
                    if (list != null && list.size() > 0)
                    {
                        for (TArticleinfoComment temp : list)
                        {
                            /**
                             * @articleIndex String UTF 文章索引
                             * @articleTitle String UTF 文章标题
                             * @createindex String UTF 文章评论者index
                             * @creator String UTF 文章评论者名称
                             * @createTime String UTF 文章评论时间
                             * @comDesc String UTF 是 评论详情
                             * @comStarts String UTF 是 评论星级
                             */
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("articleIndex", temp.getArticleindex() + "");
                            tempJobj.put("articleTitle", temp.getArticletitle() + "");
                            tempJobj.put("createindex", temp.getCommenterindex() + "");
                            tempJobj.put("creator", temp.getCommenter() + "");
                            tempJobj.put("createTime", temp.getCreatetime() + "");
                            tempJobj.put("comDesc", temp.getCommentdesc() + "");
                            tempJobj.put("comStarts", temp.getCommentstarts() + "");
                            tempJobj.put("commentCount", temp.getCommenttimes() + "");
                            tempJobj.put("headPic", Tools.serverURL + temp.getHeadpic() + "");
                            tempArray.add(tempJobj);

                        }
                    }
                    resultJobj.put("data", tempArray);
                }
            }
            /**
             * 2查询对某一文章的评论
             */
            else if ("2".equals(type))
            {
                TableDataInfo tabledata = bbsFS.getArticleCommentList(Long.parseLong(articleindex), pageNum, count);

                if (tabledata != null)
                {
                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");
                    List<TArticleinfoComment> list = tabledata.getData();
                    int totalCount = tabledata.getTotalCount();
                    resultJobj.put("totalCount", totalCount);
                    if (list != null && list.size() > 0)
                    {
                        for (TArticleinfoComment temp : list)
                        {
                            /**
                             * @articleIndex String UTF 文章索引
                             * @articleTitle String UTF 文章标题
                             * @createindex String UTF 文章评论者index
                             * @creator String UTF 文章评论者名称
                             * @createTime String UTF 文章评论时间
                             * @comDesc String UTF 是 评论详情
                             * @comStarts String UTF 是 评论星级
                             */
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("articleIndex", temp.getArticleindex() + "");
                            tempJobj.put("articleTitle", temp.getArticletitle() + "");
                            tempJobj.put("createindex", temp.getCommenterindex() + "");
                            tempJobj.put("creator", temp.getCommenter() + "");
                            tempJobj.put("createTime", temp.getCreatetime() + "");
                            tempJobj.put("comDesc", temp.getCommentdesc() + "");
                            tempJobj.put("comStarts", temp.getCommentstarts() + "");
                            tempJobj.put("commentCount", temp.getCommenttimes() + "");
                            tempJobj.put("headPic", Tools.serverURL + temp.getHeadpic() + "");
                            tempArray.add(tempJobj);

                        }
                    }
                    resultJobj.put("data", tempArray);
                }
            }
            /**
             * 3 只看楼主
             */
            else if ("3".equals(type))
            {
                TableDataInfo tabledata = bbsFS.getArticleCommentListByindex(Long.parseLong(userIndex), Long
                        .parseLong(articleindex), pageNum, count);

                if (tabledata != null)
                {
                    List<TArticleinfoComment> list = tabledata.getData();
                    int totalCount = tabledata.getTotalCount();
                    resultJobj.put("totalCount", totalCount);
                    if (list != null && list.size() > 0)
                    {
                        for (TArticleinfoComment temp : list)
                        {
                            /**
                             * @articleIndex String UTF 文章索引
                             * @articleTitle String UTF 文章标题
                             * @createindex String UTF 文章评论者index
                             * @creator String UTF 文章评论者名称
                             * @createTime String UTF 文章评论时间
                             * @comDesc String UTF 是 评论详情
                             * @comStarts String UTF 是 评论星级
                             */
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("articleIndex", temp.getArticleindex() + "");
                            tempJobj.put("articleTitle", temp.getArticletitle() + "");
                            tempJobj.put("createindex", temp.getCommenterindex() + "");
                            tempJobj.put("creator", temp.getCommenter() + "");
                            tempJobj.put("createTime", temp.getCreatetime() + "");
                            tempJobj.put("comDesc", temp.getCommentdesc() + "");
                            tempJobj.put("comStarts", temp.getCommentstarts() + "");
                            tempJobj.put("commentCount", temp.getCommenttimes() + "");
                            tempJobj.put("headPic", Tools.serverURL + temp.getHeadpic() + "");
                            tempArray.add(tempJobj);

                        }
                    }
                    resultJobj.put("data", tempArray);
                }
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("获取文章评论列表接口异常", e);

        }
        finally
        {
            log.info("获取文章评论列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
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
            articleindex = this.getRequest().getParameter("articleIndex");
            creatorindex = this.getRequest().getParameter("creatorIndex");
            type = this.getRequest().getParameter("type");
            if (Tools.isNull(pageNumStr) || Tools.isNull(countStr) || Tools.isNull(type) || Tools.isNull(userIndex))
            {
                return false;
            }

            if ("2".equals(type) || "3".equals(type))
            {
                if (Tools.isNull(articleindex))
                {
                    return false;
                }
            }
            if ("3".equals(type))
            {
                if (Tools.isNull(creatorindex))
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
