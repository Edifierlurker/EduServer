package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.group.fs.IGroupFS;
import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.pinke.uni.mobile.protal.util.ChannelDataSourceUtil;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取群组详情
 * 
 * @author Administrator
 * 
 */
public class GetGroupDetailAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    String userIndex;
    String groupIndex;
    String latitude;
    String longitude;

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
        log.info("获取群组详情接口接收到的参数：userindex=" + userIndex + ",groupIndex=" + groupIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();

        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取群组详情失败");

            // 所有的群组详情
            TGroupinfo temp = groupFS.getGroupInfoByIndex(Long.parseLong(groupIndex));

            /**
             * @site String UTF 是 群组地点
             * @longitude String UTF 是 群组经度
             * @latitude String UTF 是 群组纬度
             * @groupTitle String UTF 是 群组标题
             * @groupBref String UTF 是 群组简介
             * @groupPic String UTF 是 群组图片
             * @groupDesc String UTF 是 群组描述
             * @groupMessage String UTF 是 群组留言
             * @groupCount String UTF 是 群组成员数
             * @groupLevel String UTF 是 群组等级
             * @distance String UTF 是 群组距离
             * @isAttend String UTF 是 是否已加入 0- 否1- 是
             * @groupID String UTF 是 群号
             */
            if (temp != null)
            {

                resultJobj.put("groupID", temp.getGroupid() + "");
                resultJobj.put("latitude", temp.getLatitude() + "");
                resultJobj.put("groupIndex", temp.getGroupindex() + "");
                resultJobj.put("latitude", temp.getLatitude() + "");
                resultJobj.put("longitude", temp.getLongitude() + "");
                resultJobj.put("distance", "");
                if (Tools.isNotNull(longitude) && Tools.isNotNull(latitude))
                {
                    resultJobj.put("distance",
                            getDistance(temp.getLatitude(), temp.getLongitude(), latitude, longitude) + "");
                }

                resultJobj.put("groupTitle", temp.getGrouptitle() + "");
                resultJobj.put("groupBref", temp.getGroupbref() + "");
                resultJobj.put("site", temp.getSite() + "");

                resultJobj.put("groupDesc", temp.getGroupdesc() + "");
                resultJobj.put("groupPic", Tools.serverURL + temp.getGrouppic() + "");
                resultJobj.put("groupMessage", temp.getGroupmessage() + "");
                resultJobj.put("groupLevel", temp.getNote() + "");
                resultJobj.put("groupmanagerindex", temp.getGroupmanagerindex() + "");
                resultJobj.put("isAttend", "0");
                resultJobj.put("result", "0");
                resultJobj.put("desc", "获取群组详情成功");
                List<TGroupinfoAttendMap> tempList = groupFS.getGroupAttendList(Long.parseLong(groupIndex));

                if (tempList != null && tempList.size() > 0)
                {
                    resultJobj.put("groupCount", tempList.size() + "");
                    if (Tools.isNotNull(userIndex))
                    {
                        for (int i = 0; i < tempList.size(); i++)
                        {
                            TGroupinfoAttendMap tempAttend = tempList.get(i);
                            if (tempAttend != null)
                            {
                                if (userIndex.equals(tempAttend.getAttendindex() + ""))
                                {
                                    resultJobj.put("isAttend", "1");
                                    break;
                                }
                            }
                        }
                    }

                }
                else
                {
                    resultJobj.put("groupCount", "0");
                }
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("获取群组详情接口异常", e);

        }
        finally
        {
            log.info("获取群组详情接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            groupIndex = this.getRequest().getParameter("groupIndex");
            latitude = this.getRequest().getParameter("userLatitude");
            longitude = this.getRequest().getParameter("userLongitude");
            if (Tools.isNull(groupIndex))
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

    private String getDistance(String userlat1, String userlong1, String latitude, String longitude)
    {
        StringBuffer str = new StringBuffer();
        str.append("select  GetDistance(");
        str.append(userlat1 + "," + userlong1 + "," + latitude + "," + longitude);
        str.append(")AS DISTANCE from t_groupinfo  ");
        ChannelDataSourceUtil dsu = new ChannelDataSourceUtil();
        List listMap = dsu.getList(str.toString(), new Object[] {});
        if (listMap != null && listMap.size() > 0)
        {
            String[] tempResult = (String[]) listMap.get(0);

            return tempResult[0];
        }
        else
            return "";

    }

    // public static void main(String[] args)
    // {
    // String distance = getDistance("1", "2", "1.1", "1.2");
    // System.out.print(distance);
    // }
}
