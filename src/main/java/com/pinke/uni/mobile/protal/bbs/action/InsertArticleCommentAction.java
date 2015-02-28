package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;
import java.util.Date;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoComment;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoLike;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoShare;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 新增文章评论
 * 
 * @author Administrator
 * 
 */
public class InsertArticleCommentAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    String userIndex;
    String articleIndex;
    String comDesc;
    String comStarts;
    String islike;
    String sharesite;
    String type;
    String shareLinkUrl;
    String addcommentindex;

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
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "新增文章评论失败");
            if ("1".equals(type))
            {// 评论
                TArticleinfoComment tarticleinfoComment = new TArticleinfoComment();
                tarticleinfoComment.setArticleindex(Long.parseLong(articleIndex));
                tarticleinfoComment.setCommenterindex(Long.parseLong(userIndex));
                tarticleinfoComment.setCommentdesc(comDesc);
                tarticleinfoComment.setCommenttype(1);
                tarticleinfoComment.setCommentstarts(Tools.isNull(comStarts) ? 0 : Integer.parseInt(comStarts));
                String createtime = Tools.formatDate7(new Date());
                tarticleinfoComment.setCreatetime(createtime);
                boolean result = bbsFS.insertArticleCommentInfo(tarticleinfoComment);
                if (result == true)
                {

                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");

                }
            }
            else if ("2".equals(type))
            {// 喜欢
                TArticleinfoLike tarticleinfoLike = new TArticleinfoLike();
                tarticleinfoLike.setArticleindex(Long.parseLong(articleIndex));
                tarticleinfoLike.setUserindex(Long.parseLong(userIndex));
                String createtime = Tools.formatDate7(new Date());
                tarticleinfoLike.setCreatetime(createtime);
                boolean result = bbsFS.insertArticleLikeInfo(tarticleinfoLike);
                if (result == true)
                {

                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");

                }
            }
            else if ("3".equals(type))
            {// 分享
                TArticleinfoShare tarticleinfoShare = new TArticleinfoShare();
                tarticleinfoShare.setArticleindex(Long.parseLong(articleIndex));
                tarticleinfoShare.setUserindex(Long.parseLong(userIndex));
                tarticleinfoShare.setSharesite(sharesite);
                tarticleinfoShare.setSharelinkurl(shareLinkUrl);
                String createtime = Tools.formatDate7(new Date());
                tarticleinfoShare.setCreatetime(createtime);
                boolean result = bbsFS.insertArticleShareInfo(tarticleinfoShare);
                if (result == true)
                {

                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");

                }
            }
            else if ("4".equals(type))
            {// 评论
                TArticleinfoComment tarticleinfoComment = new TArticleinfoComment();
                tarticleinfoComment.setArticleindex(Long.parseLong(articleIndex));
                tarticleinfoComment.setAddcommentindex(Long.parseLong(addcommentindex));
                tarticleinfoComment.setCommenterindex(Long.parseLong(userIndex));
                tarticleinfoComment.setCommentdesc(comDesc);
                tarticleinfoComment.setCommenttype(2);
                tarticleinfoComment.setCommentstarts(Tools.isNull(comStarts) ? 0 : Integer.parseInt(comStarts));
                String createtime = Tools.formatDate7(new Date());
                tarticleinfoComment.setCreatetime(createtime);
                boolean result = bbsFS.insertArticleCommentInfo(tarticleinfoComment);
                if (result == true)
                {

                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");

                }
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("新增文章评论接口异常", e);

        }
        finally
        {
            log.info("新增文章评论接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            String content = this.getRequestContent();
            log.info("新增文章评论接口接收到请求：" + content);
            if (null == content)
            {
                return false;
            }

            JSONObject obj = JSONObject.fromObject(content);
            if (null == obj)
            {
                return false;
            }

            userIndex = obj.get("userIndex") + "";
            articleIndex = obj.get("articleIndex") + "";
            comDesc = obj.get("comDesc") + "";
            comStarts = obj.get("comStarts") + "";
            islike = obj.get("islike") + "";
            sharesite = obj.get("sharesite") + "";
            type = obj.get("type") + "";
            shareLinkUrl = obj.get("shareLinkUrl") + "";
            addcommentindex = obj.get("addCommentIndex") + "";
            if (Tools.isNull(userIndex) || Tools.isNull(articleIndex) || Tools.isNull(type))
            {
                return false;
            }
            if ("4".equals(type))
            {
                if (Tools.isNull(addcommentindex))
                {
                    return false;
                }
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
