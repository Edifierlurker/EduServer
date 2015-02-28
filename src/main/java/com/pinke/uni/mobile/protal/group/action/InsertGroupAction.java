package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.Form;
import org.jivesoftware.smackx.FormField;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.RoomInfo;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.common.openfire.OpenfireConnection;
import com.pinke.uni.mobile.protal.group.fs.IGroupFS;
import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 新增群组
 * 
 * @author Administrator
 * 
 */
public class InsertGroupAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    /**
     * userIndex String UTF 否 用户名index site String UTF 否 群组地点 longitude String UTF 否 群组经度 latitude String UTF 否 群组纬度
     * groupTitle String UTF 群组标题 groupBref String UTF 群组简介 groupPic String UTF 群组图片 groupDesc 群组描述 groupMessage 群组留言
     */
    String userIndex;
    String site;
    String longitude;
    String latitude;
    String groupTitle;
    String groupBref;
    String groupPic;
    String groupDesc;
    String groupMessage;
    String type;
    String groupindex;

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
        if ("1".equals(type))
        {
            try
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "新增群组失败");
                TGroupinfo tgroupinfo = new TGroupinfo();
                tgroupinfo.setGroupcreaterindex(Long.parseLong(userIndex));
                tgroupinfo.setGroupmanagerindex(Long.parseLong(userIndex));
                tgroupinfo.setSite(site);
                tgroupinfo.setLongitude(longitude);
                tgroupinfo.setLatitude(latitude);
                if (Tools.isNotNull(groupTitle))
                {
                    tgroupinfo.setGrouptitle(groupTitle);
                }
                if (Tools.isNotNull(groupBref))
                {
                    tgroupinfo.setGroupbref(groupBref);
                }
                if (Tools.isNotNull(groupPic))
                {
                    tgroupinfo.setGrouppic(groupPic);
                }
                if (Tools.isNotNull(groupDesc))
                {
                    tgroupinfo.setGroupdesc(groupDesc);
                }
                if (Tools.isNotNull(groupMessage))
                {
                    tgroupinfo.setGroupdesc(groupMessage);
                }
                String createtime = Tools.formatDate7(new Date());
                tgroupinfo.setCreatetime(createtime);
                tgroupinfo = groupFS.insertGroupInfo(tgroupinfo);
                if (tgroupinfo != null && Tools.isNotNull(tgroupinfo.getGroupindex() + ""))
                {

                    resultJobj.put("result", "0");
                    resultJobj.put("desc", tgroupinfo.getGroupindex() + "");

                    try
                    {
                        TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();
                        tgroupinfoAttendMap.setGroupindex(tgroupinfo.getGroupindex());
                        tgroupinfoAttendMap.setAttendindex(Long.parseLong(userIndex));
                        tgroupinfoAttendMap.setStatus(1);
                        tgroupinfoAttendMap.setApplytime(createtime);
                        tgroupinfoAttendMap.setAttendtime(createtime);
                        boolean attendFlag = groupFS.insertGroupAttendInfo(tgroupinfoAttendMap);
                        /**
                         * 创建聊天室
                         */
                        Tools.createCharByOpenFire(tgroupinfo.getGroupid() + "");
                    }
                    catch (Exception e)
                    {
                        log.info("新增群组时，增加群主异常", e);

                    }
                }

            }
            catch (Exception e)
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "服务器内部错误");
                log.info("新增群组接口异常", e);

            }
        }
        if ("2".equals(type))
        {
            try
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "新增群组失败");
                TGroupinfo tgroupinfo = groupFS.getGroupInfoByIndex(Long.valueOf(groupindex));
                if (tgroupinfo != null)
                {
                    if ((tgroupinfo.getGroupmanagerindex().toString()).equals(userIndex))
                    {

                        resultJobj.put("result", "0");
                        resultJobj.put("desc", tgroupinfo.getGroupindex() + "");

                        if (Tools.isNotNull(site))
                        {
                            tgroupinfo.setSite(site);
                        }
                        if (Tools.isNotNull(longitude))
                        {
                            tgroupinfo.setLongitude(longitude);
                        }
                        if (Tools.isNotNull(latitude))
                        {
                            tgroupinfo.setLatitude(latitude);
                        }
                        if (Tools.isNotNull(groupTitle))
                        {
                            tgroupinfo.setGrouptitle(groupTitle);
                        }
                        if (Tools.isNotNull(groupBref))
                        {
                            tgroupinfo.setGroupbref(groupBref);
                        }
                        if (Tools.isNotNull(groupPic))
                        {
                            tgroupinfo.setGrouppic("/groupUpload/" + groupPic);
                        }
                        if (Tools.isNotNull(groupDesc))
                        {
                            tgroupinfo.setGroupdesc(groupDesc);
                        }
                        if (Tools.isNotNull(groupMessage))
                        {
                            tgroupinfo.setGroupdesc(groupMessage);
                        }
                        tgroupinfo = groupFS.updateGroupInfo(tgroupinfo);

                    }
                    else
                    {
                        resultJobj.put("result", "1");
                        resultJobj.put("desc", "修改群组失败，用户不为群主");
                    }
                }
                else
                {
                    resultJobj.put("result", "1");
                    resultJobj.put("desc", "修改群组失败，群组不存在");
                }

            }
            catch (Exception e)
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "服务器内部错误");
                log.info("新增群组接口异常", e);

            }
        }

        log.info("新增群组接口响应的Json类型的结果字符串：" + resultJobj.toString());
        sendUtil.sendMessage(this.getResponse(), resultJobj.toString());

    }

    private boolean confirm()
    {

        try
        {
            String content = this.getRequestContent();
            log.info("新增群组接口接收到的字符串：" + content);
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
            site = obj.get("site") + "";
            longitude = obj.get("longitude") + "";
            latitude = obj.get("latitude") + "";
            groupTitle = obj.get("groupTitle") + "";
            groupBref = obj.get("groupBref") + "";
            groupPic = obj.get("groupPic") + "";
            groupDesc = obj.get("groupDesc") + "";
            groupMessage = obj.get("groupMessage") + "";
            type = obj.get("type") + "";
            groupindex = obj.get("groupIndex") + "";

            if (Tools.isNull(type))
            {
                return false;
            }
            if ("1".equals(type))
            {
                if (Tools.isNull(userIndex) || Tools.isNull(site) || Tools.isNull(longitude) || Tools.isNull(latitude))
                {
                    return false;
                }
            }
            else if ("2".equals(type))
            {
                if (Tools.isNull(userIndex) || Tools.isNull(groupindex))
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
