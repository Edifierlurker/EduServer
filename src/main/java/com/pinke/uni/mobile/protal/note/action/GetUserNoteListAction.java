package com.pinke.uni.mobile.protal.note.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.common.config.ConfigContent;
import com.pinke.uni.mobile.protal.note.fs.IUserNoteFS;
import com.pinke.uni.mobile.protal.note.model.UserNote;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 查询用户笔记列表
 * 
 * @author lucuiping
 * 
 */
public class GetUserNoteListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IUserNoteFS userNoteFS = (IUserNoteFS) SSBBus.findDomainService("muserNoteFS");
    private String userIndex;

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
        log.info("查询用户笔记列表接口，userIndex=" + userIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            List<UserNote> list = userNoteFS.getUserNoteListByUserIndex(Long.parseLong(userIndex));
            jsonObj.put("result", "0");
            jsonObj.put("desc", "");
            if (list != null && list.size() > 0)
            {

                for (int i = 0; i < list.size(); i++)
                {
                    UserNote temp = list.get(i);
                    if (temp != null)
                    {
                        JSONObject tempJobj = new JSONObject();

                        /**
                         * noteIndex String UTF 是 笔记index noteTitle String UTF 是 笔记名称 noteTime String UTF 是 笔记时间
                         * noteDesc String UTF 是 笔记内容 iconURL 笔记图片地址 recordUrl 笔记录音地址
                         */
                        tempJobj.put("noteIndex", temp.getNoteindex() + "");
                        tempJobj.put("noteTitle", temp.getNotetitle() + "");
                        tempJobj.put("noteTime", temp.getCreatetime() + "");
                        tempJobj.put("noteDesc", temp.getNotedesc() + "");
                        String iconURL = temp.getIconurl();
                        StringBuffer tempIcon = new StringBuffer();
                        if (Tools.isNotNull(iconURL))
                        {
                            String[] icons = iconURL.split("\\|");
                            if (icons != null && icons.length > 0)
                            {
                                for (int j = 0; j < icons.length; j++)
                                {
                                    tempIcon.append(ConfigContent.getXmlconfig().getAppstateUrlRoot());
                                    tempIcon.append("upload/");
                                    tempIcon.append(icons[j]);
                                    tempIcon.append("\\|");

                                }
                            }

                        }
                        String recordURL = temp.getRecordurl();
                        StringBuffer tempRecord = new StringBuffer();
                        if (Tools.isNotNull(recordURL))
                        {
                            String[] records = recordURL.split("\\|");
                            if (records != null && records.length > 0)
                            {
                                for (int j = 0; j < records.length; j++)
                                {
                                    tempRecord.append(ConfigContent.getXmlconfig().getAppstateUrlRoot());
                                    tempRecord.append("upload/");
                                    tempRecord.append(records[j]);
                                    tempRecord.append("\\|");

                                }
                            }

                        }
                        tempJobj.put("iconUrl", tempIcon.toString());
                        tempJobj.put("recordUrl", tempRecord.toString());

                        tempArray.add(tempJobj);
                    }
                }

            }
            jsonObj.put("data", tempArray);
        }
        catch (Exception e)
        {
            log.error("查询用户笔记列表接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "");
            jsonObj.put("data", tempArray);
        }
        finally
        {
            log.info("查询用户笔记列表接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        try
        {
            userIndex = this.getRequest().getParameter("userIndex");

            if (Tools.isNull(userIndex))
            {
                return false;
            }
        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }

        return true;
    }

}
