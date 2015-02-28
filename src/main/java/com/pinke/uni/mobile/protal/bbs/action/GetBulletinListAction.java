package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.model.TBulletin;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取校园公告列表
 * 
 * @author Administrator
 * 
 */
public class GetBulletinListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    String userIndex;
    String schoolIndex;
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
        log.info("获取校园公告列表接口接收到的参数：userindex=" + userIndex + ",pageNum=" + pageNum + ",count=" + count
                + ",schoolIndex=" + schoolIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取校园公告列表失败");

            TableDataInfo tabledata = bbsFS.getBulletinList(Long.parseLong(schoolIndex), pageNum, count);

            if (tabledata != null)
            {
                resultJobj.put("result", "0");
                resultJobj.put("desc", "");
                List<TBulletin> list = tabledata.getData();
                int totalCount = tabledata.getTotalCount();
                resultJobj.put("totalCount", totalCount);
                if (list != null && list.size() > 0)
                {
                    for (TBulletin temp : list)
                    {
                        JSONObject tempJobj = new JSONObject();
                        tempJobj.put("bullTheme", temp.getTheme() + "");
                        tempJobj.put("bullDesc", temp.getContent() + "");
                        tempJobj.put("createTime", temp.getCreatetime() + "");
                        tempJobj.put("bullIndex", temp.getBulindex() + "");
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
            log.info("获取校园公告列表接口异常", e);

        }
        finally
        {
            log.info("获取校园公告列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
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
            schoolIndex = this.getRequest().getParameter("schoolIndex");

            if (Tools.isNull(pageNumStr) || Tools.isNull(countStr) || Tools.isNull(schoolIndex)
                    || Tools.isNull(userIndex))
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
