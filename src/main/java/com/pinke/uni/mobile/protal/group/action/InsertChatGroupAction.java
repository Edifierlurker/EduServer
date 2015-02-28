package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.Form;
import org.jivesoftware.smackx.FormField;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.RoomInfo;

import net.sf.json.JSONArray;
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
 * 新增群聊群组
 * 
 * @author Administrator
 * 
 */
public class InsertChatGroupAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    String userIndex;

    String groupTitle;

    String type;
    String groupindex;
    String attendArray;

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
                resultJobj.put("desc", "新增群聊群组失败");
                TGroupinfo tgroupinfo = new TGroupinfo();
                tgroupinfo.setGroupcreaterindex(Long.parseLong(userIndex));
                tgroupinfo.setGroupmanagerindex(Long.parseLong(userIndex));
                tgroupinfo.setGrouptype(3);
                if (Tools.isNotNull(groupTitle))
                {
                    tgroupinfo.setGrouptitle(groupTitle);
                }

                String createtime = Tools.formatDate7(new Date());
                tgroupinfo.setCreatetime(createtime);
                tgroupinfo = groupFS.insertGroupInfo(tgroupinfo);
                if (tgroupinfo != null && Tools.isNotNull(tgroupinfo.getGroupindex() + ""))
                {

                    resultJobj.put("result", "0");
                    resultJobj.put("desc", tgroupinfo.getGroupindex() + "");
                    resultJobj.put("groupID", tgroupinfo.getGroupid() + "");

                    try
                    {
                        JSONArray attend = JSONArray.fromObject(attendArray);
                        List<TGroupinfoAttendMap> attendList = new ArrayList();
                        TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();
                        tgroupinfoAttendMap.setGroupindex(tgroupinfo.getGroupindex());
                        tgroupinfoAttendMap.setAttendindex(Long.parseLong(userIndex));
                        tgroupinfoAttendMap.setStatus(1);
                        tgroupinfoAttendMap.setApplytime(createtime);
                        tgroupinfoAttendMap.setAttendtime(createtime);
                        attendList.add(tgroupinfoAttendMap);
                        if (attend != null && attend.size() > 0)
                        {
                            for (int i = 0; i < attend.size(); i++)
                            {
                                JSONObject tempJobj = attend.getJSONObject(i);
                                if (tempJobj != null && tempJobj.get("attendIndex") != null)
                                {
                                    TGroupinfoAttendMap temp = new TGroupinfoAttendMap();
                                    temp.setGroupindex(tgroupinfo.getGroupindex());
                                    temp.setAttendindex(Long.parseLong(tempJobj.get("attendIndex") + ""));
                                    temp.setStatus(1);
                                    temp.setApplytime(createtime);
                                    temp.setAttendtime(createtime);
                                    attendList.add(temp);
                                }
                            }

                        }

                        boolean attendFlag = groupFS.insertGroupAttendList(attendList);
                        /**
                         * 创建聊天室
                         */
                        Tools.createCharByOpenFire(tgroupinfo.getGroupid() + "");
                    }
                    catch (Exception e)
                    {
                        log.info("新增群聊群组时，增加群主异常", e);

                    }
                }

            }
            catch (Exception e)
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "服务器内部错误");
                log.info("新增群聊群组接口异常", e);

            }
        }

        else if ("2".equals(type))
        {
            try
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "加入群聊失败");

                String createtime = Tools.formatDate7(new Date());

                try
                {
                    JSONArray attend = JSONArray.fromObject(attendArray);
                    List<TGroupinfoAttendMap> attendList = new ArrayList();

                    if (attend != null && attend.size() > 0)
                    {
                        for (int i = 0; i < attend.size(); i++)
                        {
                            JSONObject tempJobj = attend.getJSONObject(i);
                            if (tempJobj != null && tempJobj.get("attendIndex") != null)
                            {
                                TGroupinfoAttendMap temp = new TGroupinfoAttendMap();
                                temp.setGroupindex(Long.parseLong(groupindex));
                                temp.setAttendindex(Long.parseLong(tempJobj.get("attendIndex") + ""));
                                temp.setStatus(1);
                                temp.setApplytime(createtime);
                                temp.setAttendtime(createtime);
                            }
                        }

                    }

                    boolean attendFlag = groupFS.insertGroupAttendList(attendList);

                }
                catch (Exception e)
                {
                    log.info("新增群聊群组时，增加群主异常", e);

                }

            }
            catch (Exception e)
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "服务器内部错误");
                log.info("新增群聊群组接口异常", e);

            }
        }

        log.info("新增群聊群组接口响应的Json类型的结果字符串：" + resultJobj.toString());
        sendUtil.sendMessage(this.getResponse(), resultJobj.toString());

    }

    private boolean confirm()
    {

        try
        {
            String content = this.getRequestContent();
            log.info("新增群聊群组接口接收到的字符串：" + content);
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
            groupTitle = obj.get("groupTitle") + "";
            type = obj.get("type") + "";
            groupindex = obj.get("groupIndex") + "";
            attendArray = obj.get("attendArray") + "";

            if (Tools.isNull(type) || Tools.isNull(attendArray))
            {
                return false;
            }
            if ("1".equals(type))
            {
                if (Tools.isNull(userIndex))
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
