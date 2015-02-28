package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.group.fs.IGroupFS;
import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取群组列表
 * 
 * @author Administrator
 * 
 */
public class GetGroupListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    /**
     * @userIndex String UTF 否 用户名index
     * @pageNum String 4 是 请求第几页数据
     * @count String 4 是 单页请求数量，默认取值20
     */
    String userIndex;
    int pageNum;
    int count;
    String site;
    String longitude;
    String latitude;
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
        log.info("获取群组列表接口接收到的参数：userindex=" + userIndex + ",pageNum=" + pageNum + ",count=" + count + ",site=" + site
                + ",longitude=" + longitude + ",latitude=" + latitude);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取群组列表失败");

            // 所有的群组列表
            TableDataInfo tabledata = null;
            if ("1".equals(type))
            {

                tabledata = groupFS.getGroupListByDistance(longitude, latitude, pageNum, count);
                if (tabledata != null)
                {
                    List<TGroupinfo> list = tabledata.getData();
                    int totalCount = tabledata.getTotalCount();
                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");
                    resultJobj.put("totalCount", totalCount);
                    if (list != null && list.size() > 0)
                    {
                        for (TGroupinfo temp : list)
                        {
                            /**
                             * @groupIndex String UTF 群组索引
                             * @groupTitle String UTF 群组标题
                             * @groupBref String UTF 群组简介
                             * @groupCount String UTF 群组成员数
                             * @site String UTF 群组地点
                             * @distance String UTF 群组距离
                             * @groupPic String UTF 群组图片
                             */
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("groupIndex", temp.getGroupindex() + "");
                            tempJobj.put("groupID", temp.getGroupid() + "");
                            tempJobj.put("groupTitle", temp.getGrouptitle() + "");
                            tempJobj.put("groupBref", temp.getGroupbref() + "");
                            tempJobj.put("site", temp.getSite() + "");
                            tempJobj.put("distance", temp.getDISTANCE() + "");
                            tempJobj.put("groupPic", Tools.serverURL + temp.getGrouppic() + "");
                            // List<TGroupinfoAttendMap> tempList = groupFS.getGroupAttendList(temp.getGroupindex());
                            // if (tempList != null && tempList.size() > 0)
                            // {
                            // tempJobj.put("groupCount", tempList.size() + "");
                            // }
                            // else
                            // {
                            // tempJobj.put("groupCount", "0");
                            // }

                            tempArray.add(tempJobj);

                        }
                    }
                    resultJobj.put("data", tempArray);
                }
            }
            else if ("2".equals(type))
            {
                tabledata = groupFS.getAttendGroupList(Long.parseLong(userIndex), pageNum, count);
                if (tabledata != null)
                {
                    List<TGroupinfoAttendMap> list = tabledata.getData();
                    int totalCount = tabledata.getTotalCount();
                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");
                    resultJobj.put("totalCount", totalCount);
                    if (list != null && list.size() > 0)
                    {
                        for (TGroupinfoAttendMap temp : list)
                        {
                            /**
                             * @groupIndex String UTF 群组索引
                             * @groupTitle String UTF 群组标题
                             * @groupBref String UTF 群组简介
                             * @groupCount String UTF 群组成员数
                             * @site String UTF 群组地点
                             * @distance String UTF 群组距离
                             * @groupPic String UTF 群组图片
                             */
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("groupIndex", temp.getGroupindex() + "");
                            tempJobj.put("groupID", temp.getGroupid() + "");
                            tempJobj.put("groupTitle", temp.getGrouptitle() + "");
                            tempJobj.put("groupBref", temp.getGroupbref() + "");
                            tempJobj.put("site", temp.getSite() + "");
                            tempJobj.put("distance", "");
                            tempJobj.put("groupPic", Tools.serverURL + temp.getGrouppic() + "");
                            // List<TGroupinfoAttendMap> tempList = groupFS.getGroupAttendList(temp.getGroupindex());
                            // if (tempList != null && tempList.size() > 0)
                            // {
                            // tempJobj.put("groupCount", tempList.size() + "");
                            // }
                            // else
                            // {
                            // tempJobj.put("groupCount", "0");
                            // }

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
            log.info("获取群组列表接口异常", e);

        }
        finally
        {
            log.info("获取群组列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
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
            site = this.getRequest().getParameter("site");
            longitude = this.getRequest().getParameter("longitude");
            latitude = this.getRequest().getParameter("latitude");
            type = this.getRequest().getParameter("type");
            if (Tools.isNull(pageNumStr) || Tools.isNull(countStr) || Tools.isNull(userIndex))
            {
                return false;
            }
            if (Tools.isNull(type))
            {
                type = "1";
            }
            if ("1".equals(type))
            {
                if (Tools.isNull(longitude) || Tools.isNull(latitude) || Tools.isNull(site))
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
