package com.pinke.uni.mobile.protal.bbs.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.bbs.fs.IBBSFS;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfo;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfoNoticeMap;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取论坛列表
 * 
 * @author Administrator
 * 
 */
public class GetBBSListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IBBSFS bbsFS = (IBBSFS) SSBBus.findFacadeService("mBBSFS");

    /**
     * @userIndex String UTF 否 用户名index
     * @pageNum String 4 是 请求第几页数据
     * @count String 4 是 单页请求数量，默认取值20
     */
    String userindex;
    String schoolIndex;
    int pageNum;
    int count;
    int type;

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
        log.info("获取论坛列表接口接收到的参数：userindex=" + userindex + ",pageNum=" + pageNum + ",count=" + count + ",type=" + type);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取论坛列表失败");
            if (type == 1)
            {
                // 所有的论坛列表
                TableDataInfo tabledata = bbsFS.getBBSList(Long.parseLong(schoolIndex), Long.parseLong(userindex),
                        pageNum, count);

                if (tabledata != null)
                {
                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");
                    List<TBbsinfo> list = tabledata.getData();
                    int totalCount = tabledata.getTotalCount();
                    resultJobj.put("totalCount", totalCount);
                    if (list != null && list.size() > 0)
                    {
                        for (TBbsinfo temp : list)
                        {
                            /**
                             * @bbsIndex String UTF 论坛索引
                             * @bbsTitle String UTF 论坛标题
                             * @bbsBref String UTF 论坛一句话描述
                             * @createTime String UTF 论坛创建时间
                             */
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("bbsIndex", temp.getBbsindex() + "");
                            tempJobj.put("bbsTitle", temp.getBbstitle() + "");
                            tempJobj.put("bbsBref", temp.getBbsbref() + "");
                            tempJobj.put("createTime", temp.getCreatetime() + "");
                            tempJobj.put("attendCount", temp.getAttendcount() + "");
                            tempJobj.put("isAttend", "0");
                            if (Tools.isNotNull(temp.getAttendindex() + ""))
                            {
                                tempJobj.put("isAttend", "1");
                            }
                            tempArray.add(tempJobj);

                        }
                    }
                    resultJobj.put("data", tempArray);
                }
            }
            else if (type == 2)
            {
                // 我关注的论坛列表（我的圈子）
                TableDataInfo tabledata = bbsFS.getBBSNoticeList(Long.parseLong(userindex), pageNum, count);
                if (tabledata != null)
                {
                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");
                    List<TBbsinfoNoticeMap> list = tabledata.getData();
                    int totalCount = tabledata.getTotalCount();
                    resultJobj.put("totalCount", totalCount);
                    if (list != null && list.size() > 0)
                    {
                        for (TBbsinfoNoticeMap temp : list)
                        {
                            /**
                             * @bbsIndex String UTF 论坛索引
                             * @bbsTitle String UTF 论坛标题
                             * @bbsBref String UTF 论坛一句话描述
                             * @createTime String UTF 论坛创建时间
                             */
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("bbsIndex", temp.getBbsindex() + "");
                            tempJobj.put("bbsTitle", temp.getBbstitle() + "");
                            tempJobj.put("bbsBref", temp.getBbsbref() + "");
                            tempJobj.put("createTime", temp.getCreatetime() + "");
                            tempJobj.put("attendCount", temp.getAttendcount() + "");
                            tempJobj.put("isAttend", "1");
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
            log.info("获取论坛列表接口异常", e);

        }
        finally
        {
            log.info("获取论坛列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userindex = this.getRequest().getParameter("userIndex");
            schoolIndex = this.getRequest().getParameter("schoolIndex");
            String pageNumStr = this.getRequest().getParameter("pageNum");
            String countStr = this.getRequest().getParameter("count");
            String typeStr = this.getRequest().getParameter("type");
            if (Tools.isNull(pageNumStr) || Tools.isNull(countStr) || Tools.isNull(typeStr)
                    || Tools.isNull(schoolIndex) || Tools.isNull(userindex))
            {
                return false;
            }
            if ("2".equals(type))
            {
                if (Tools.isNull(userindex))
                {
                    return false;
                }
            }
            pageNum = Integer.parseInt(pageNumStr);
            count = Integer.parseInt(countStr);
            type = Integer.parseInt(typeStr);

        }
        catch (Exception e)
        {
            log.error("获取json数据异常", e);
            return false;
        }

        return true;

    }

}
