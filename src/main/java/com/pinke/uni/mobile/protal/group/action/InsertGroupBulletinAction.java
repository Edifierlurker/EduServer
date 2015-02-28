package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 新增群组公告
 * 
 * @author Administrator
 * 
 */
public class InsertGroupBulletinAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    /**
     * @userIndex String UTF 是 用户名index
     * @groupIndex String UTF 是 群组的index
     * @bullTheme String UTF 是 主题
     * @bullDesc String UTF 是 内容
     * @iconArray JSONArray 图片
     * @type String UTF 是 操作类型
     * @bullIndex String UTF 是 公告index
     */
    String userIndex;
    String groupIndex;
    String bullTheme;
    String bullDesc;
    String iconArray;
    String bullIndex;
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
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "新增群组公告失败");
            TGroupinfoBulletin tgroupinfoBulletin = new TGroupinfoBulletin();

            if ("1".equals(type))
            {
                tgroupinfoBulletin.setStatus(1);
                tgroupinfoBulletin.setStudentindex(Long.parseLong(userIndex));
                tgroupinfoBulletin.setGroupindex(Long.parseLong(groupIndex));

                if (Tools.isNotNull(bullTheme))
                {
                    tgroupinfoBulletin.setBulletintitle(bullTheme);
                }
                if (Tools.isNotNull(bullDesc))
                {
                    tgroupinfoBulletin.setBulletindesc(bullDesc);
                }

                String createtime = Tools.formatDate7(new Date());
                tgroupinfoBulletin.setCreatetime(createtime);
                boolean result1 = groupFS.insertGroupBulletin(tgroupinfoBulletin);

                if (result1 == true)
                {
                    TGroupinfoBulletin temp = groupFS.getGroupBulletin(tgroupinfoBulletin);
                    boolean result2 = true;
                    if (temp != null)
                    {

                        if (Tools.isNotNull(iconArray))
                        {

                            JSONArray icon = JSONArray.fromObject(iconArray);

                            if (icon != null && icon.size() > 0)
                            {
                                List<TGroupinfoBulletinPic> list = new ArrayList();
                                for (int i = 0; i < icon.size(); i++)
                                {
                                    TGroupinfoBulletinPic tempPic = new TGroupinfoBulletinPic();
                                    JSONObject JSONtemp = icon.getJSONObject(i);
                                    tempPic.setIconurl("/groupUpload/" + JSONtemp.get("iconUrl") + "");
                                    tempPic.setBulletinidnex(temp.getBulletinidnex());
                                    tempPic.setStatus(1);
                                    list.add(tempPic);
                                }
                                result2 = groupFS.insertGroupBulletinPic(list);
                            }

                        }
                        if (result2 == true)
                        {
                            resultJobj.put("result", "0");
                            resultJobj.put("desc", temp.getBulletinidnex() + "");
                        }
                        else
                        {
                            groupFS.removeGroupBulletin(temp.getBulletinidnex());
                        }

                    }

                }
            }
            else if ("2".equals(type))
            {

                TGroupinfoBulletin temp = groupFS.getGroupBulletin(Long.parseLong(bullIndex));

                if (temp != null && userIndex.equals(temp.getStudentindex() + "") && temp.getStatus() == 1)
                {
                    tgroupinfoBulletin.setStudentindex(Long.parseLong(userIndex));
                    tgroupinfoBulletin.setBulletinidnex(Long.parseLong(bullIndex));

                    if (Tools.isNotNull(bullTheme))
                    {
                        tgroupinfoBulletin.setBulletintitle(bullTheme);
                    }
                    if (Tools.isNotNull(bullDesc))
                    {
                        tgroupinfoBulletin.setBulletindesc(bullDesc);
                    }
                    boolean result1 = groupFS.updateGroupBulletin(tgroupinfoBulletin);

                    boolean result2 = true;
                    boolean result3 = true;
                    if (Tools.isNotNull(iconArray))
                    {

                        JSONArray icon = JSONArray.fromObject(iconArray);
                        if (icon != null && icon.size() > 0)
                        {
                            List<TGroupinfoBulletinPic> list = new ArrayList();
                            for (int i = 0; i < icon.size(); i++)
                            {
                                TGroupinfoBulletinPic tempPic = new TGroupinfoBulletinPic();
                                JSONObject JSONtemp = icon.getJSONObject(i);
                                tempPic.setIconurl("/groupUpload/" + JSONtemp.get("iconUrl") + "");
                                tempPic.setBulletinidnex(Long.parseLong(bullIndex));
                                list.add(tempPic);
                            }
                            result2 = groupFS.removeGroupBulletinPic(Long.parseLong(bullIndex));
                            result3 = groupFS.insertGroupBulletinPic(list);
                        }

                    }
                    if (result2 == true && result3 == true)
                    {
                        resultJobj.put("result", "0");
                        resultJobj.put("desc", "");
                    }
                }
                else
                {
                    resultJobj.put("result", "1");
                    resultJobj.put("desc", "暂无权限修改");
                }
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("新增群组公告接口异常", e);

        }
        finally
        {
            log.info("新增群组公告接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            String content = this.getRequestContent();
            log.info("新增群组公告接口接收到的字符串：" + content);
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
            groupIndex = obj.get("groupIndex") + "";
            bullTheme = obj.get("bullTheme") + "";
            bullDesc = obj.get("bullDesc") + "";
            bullDesc = obj.get("bullDesc") + "";
            type = obj.get("type") + "";
            bullIndex = obj.get("bullIndex") + "";
            iconArray = obj.get("iconArray") + "";

            if (Tools.isNull(userIndex) || Tools.isNull(type))
            {
                return false;
            }
            if ("2".equals(type))
            {
                if (Tools.isNull(bullIndex))
                {
                    return false;
                }
            }
            if ("1".equals(type))
            {
                if (Tools.isNull(groupIndex))
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
