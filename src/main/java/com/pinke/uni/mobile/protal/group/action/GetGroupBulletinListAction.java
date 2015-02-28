package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.group.fs.IGroupFS;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletin;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletinPic;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取群组公告列表
 * 
 * @author Administrator
 * 
 */
public class GetGroupBulletinListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    /**
     * @userIndex String UTF 否 用户名index
     * @groupIndex String UTF 是 群组的index
     * @pageNum String UTF 是 请求第几页数据
     * @count String UTF 是 单页请求数量，默认取值20
     */
    String userIndex;
    int pageNum;
    int count;
    String groupIndex;

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
        log.info("获取群组公告列表接口接收到的参数：userindex=" + userIndex + ",pageNum=" + pageNum + ",count=" + count + ",groupIndex="
                + groupIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取群组公告列表失败");
            // 上报自己的位置

            // 所有的群组公告列表
            TableDataInfo tabledata = groupFS.getGroupBulletinList(Long.parseLong(groupIndex), pageNum, count);

            if (tabledata != null)
            {
                resultJobj.put("result", "0");
                resultJobj.put("desc", "");
                List<TGroupinfoBulletin> list = tabledata.getData();
                int totalCount = tabledata.getTotalCount();
                resultJobj.put("totalCount", totalCount);
                if (list != null && list.size() > 0)
                {
                    for (TGroupinfoBulletin temp : list)
                    {
                        /**
                         * @bullTheme String UTF 是 主题
                         * @bullDesc String UTF 是 内容
                         * @createTime String UTF 是 创建时间
                         * @bullIndex String UTF 是 公告的index
                         * @creatorName String UTF 是 发布者姓名
                         * @creatorIndex String UTF 是 发布者index
                         * @iconArray JSONArray 图片
                         */
                        JSONObject tempJobj = new JSONObject();
                        tempJobj.put("bullTheme", temp.getBulletintitle() + "");
                        tempJobj.put("bullDesc", temp.getBulletindesc() + "");
                        tempJobj.put("createTime", temp.getCreatetime() + "");
                        tempJobj.put("bullIndex", temp.getBulletinidnex() + "");
                        tempJobj.put("creatorName", temp.getStudentname() + "");
                        tempJobj.put("creatorIndex", temp.getStudentindex() + "");
                        // 获取公告图片列表
                        JSONArray picArray = new JSONArray();
                        List<TGroupinfoBulletinPic> picList = groupFS.getGroupBulletinPicList(temp.getBulletinidnex());

                        if (picList != null && picList.size() > 0)
                        {
                            for (TGroupinfoBulletinPic tempPic : picList)
                            {
                                JSONObject picJobj = new JSONObject();
                                picJobj.put("iconUrl", Tools.serverURL + tempPic.getIconurl());
                                picJobj.put("picIndex", tempPic.getPicindex() + "");
                                picArray.add(picJobj);
                            }

                        }
                        tempJobj.put("iconArray", picArray);
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
            log.info("获取群组公告列表接口异常", e);

        }
        finally
        {
            log.info("获取群组公告列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
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
            groupIndex = this.getRequest().getParameter("groupIndex");
            if (Tools.isNull(pageNumStr) || Tools.isNull(countStr) || Tools.isNull(groupIndex))
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
