package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfo;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletinPic;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 新增文章
 * 
 * @author Administrator
 * 
 */
public class InsertBBSArticleAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    String userIndex;
    String articleTitle;
    String articleBref;
    String articleDesc;
    String bbsIndex;
    String articleStars;
    String Ifissue;
    String articlePic = "";
    String iconArray;

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
            resultJobj.put("desc", "新增文章失败");
            TArticleinfo tarticleinfo = new TArticleinfo();
            tarticleinfo.setCreaterindex(Long.parseLong(userIndex));
            tarticleinfo.setArticletitle(articleTitle);
            tarticleinfo.setBbsindex(Long.parseLong(bbsIndex));
            if (Tools.isNotNull(articleBref))
            {
                tarticleinfo.setArticlebref(articleBref);
            }
            if (Tools.isNotNull(articleDesc))
            {
                tarticleinfo.setArticledesc(articleDesc);
            }
            if (Tools.isNotNull(Ifissue))
            {
                tarticleinfo.setIfissue(Integer.parseInt(Ifissue));
            }
            if (Tools.isNotNull(iconArray))
            {

                boolean result2 = true;
                boolean result3 = true;
                if (Tools.isNotNull(iconArray))
                {

                    JSONArray icon = JSONArray.fromObject(iconArray);

                    for (int i = 0; i < icon.size(); i++)
                    {

                        JSONObject JSONtemp = icon.getJSONObject(i);
                        articlePic += "/bbsUpload/" + JSONtemp.getString("iconUrl") + "|";

                    }

                }

                tarticleinfo.setArticlepic(articlePic);
            }
            String createtime = Tools.formatDate7(new Date());
            tarticleinfo.setCreatetime(createtime);
            tarticleinfo.setLastposttime(createtime);
            tarticleinfo = bbsFS.insertArticleInfo(tarticleinfo);
            if (tarticleinfo != null && Tools.isNotNull(tarticleinfo.getArticleindex() + ""))
            {

                resultJobj.put("result", "0");
                resultJobj.put("desc", tarticleinfo.getArticleindex() + "");

            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("新增文章接口异常", e);

        }
        finally
        {
            log.info("新增文章接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            String content = this.getRequestContent();
            log.info("新增文章接口接收到的字符串：" + content);
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
            articleTitle = obj.get("articleTitle") + "";
            articleBref = obj.get("articleBref") + "";

            articleDesc = obj.get("articleDesc") + "";
            bbsIndex = obj.get("bbsIndex") + "";
            articleStars = obj.get("articleStars") + "";
            Ifissue = obj.get("Ifissue") + "";
            iconArray = obj.get("iconArray") + "";

            if (Tools.isNull(userIndex) || Tools.isNull(bbsIndex) || Tools.isNull(articleTitle))
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
