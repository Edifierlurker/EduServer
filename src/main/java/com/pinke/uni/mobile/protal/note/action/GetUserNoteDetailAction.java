package com.pinke.uni.mobile.protal.note.action;

import java.io.IOException;

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
 * 查询用户笔记详情
 * 
 * @author lucuiping
 * 
 */
public class GetUserNoteDetailAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IUserNoteFS userNoteFS = (IUserNoteFS) SSBBus.findDomainService("muserNoteFS");
    private String detailIndex;

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
        log.info("查询用户笔记详情接口，detailIndex=" + detailIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();

        try
        {
            UserNote temp = userNoteFS.getUserNoteDetailByNoteIndex(Long.parseLong(detailIndex));
            jsonObj.put("result", "0");
            jsonObj.put("desc", "");

            if (temp != null)
            {

                /**
                 * noteIndex String UTF 是 笔记index noteTitle String UTF 是 笔记名称 noteTime String UTF 是 笔记时间 noteDesc String
                 * UTF 是 笔记内容 iconURL 笔记图片地址 recordUrl 笔记录音地址
                 */
                jsonObj.put("noteIndex", temp.getNoteindex() + "");
                jsonObj.put("noteTitle", temp.getNotetitle() + "");
                jsonObj.put("noteTime", temp.getCreatetime() + "");
                jsonObj.put("noteDesc", temp.getNotedesc() + "");
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
                jsonObj.put("iconUrl", tempIcon.toString());
                jsonObj.put("recordUrl", tempRecord.toString());

            }

        }
        catch (Exception e)
        {
            log.error("查询用户笔记详情接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "");
        }
        finally
        {
            log.info("查询用户笔记详情接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        try
        {
            detailIndex = this.getRequest().getParameter("detailIndex");
            if (Tools.isNull(detailIndex))
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
