package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;
import java.util.Date;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfo;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 新增论坛
 * 
 * @author Administrator
 * 
 */
public class InsertBBSDetailAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    String userindex;
    String bbsTitle;
    String bbsBref;
    String schoolIndex;

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
        log.info("新增论坛接口接收到的参数：userindex=" + userindex + ",bbsTitle=" + bbsTitle + ",bbsBref=" + bbsBref);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "新增论坛失败");
            TBbsinfo tbbsinfo = new TBbsinfo();
            tbbsinfo.setCreatorindex(Long.parseLong(userindex));
            tbbsinfo.setSchoolindex(Long.parseLong(schoolIndex));
            tbbsinfo.setBbstitle(bbsTitle);
            if (Tools.isNotNull(bbsBref))
            {
                tbbsinfo.setBbstitle(bbsBref);
            }
            String createtime = Tools.formatDate7(new Date());
            tbbsinfo.setCreatetime(createtime);
            tbbsinfo = bbsFS.insertBBSInfo(tbbsinfo);
            if (tbbsinfo != null && Tools.isNotNull(tbbsinfo.getBbsindex() + ""))
            {

                resultJobj.put("result", "0");
                resultJobj.put("desc", tbbsinfo.getBbsindex() + "");

            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("新增论坛接口异常", e);

        }
        finally
        {
            log.info("新增论坛接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            String content = this.getRequestContent();
            log.info("请求的Json类型的结果字符串：" + content);
            if (null == content)
            {
                return false;
            }

            JSONObject obj = JSONObject.fromObject(content);
            if (null == obj)
            {
                return false;
            }
            userindex = obj.get("userIndex") + "";
            bbsTitle = obj.get("bbsTitle") + "";
            bbsBref = obj.get("bbsBref") + "";
            schoolIndex = obj.get("schoolIndex") + "";

            if (Tools.isNull(userindex) || Tools.isNull(bbsTitle) || Tools.isNull(schoolIndex))
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
