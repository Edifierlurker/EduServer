package com.pinke.uni.mobile.protal.note.action;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.note.fs.IUserNoteFS;
import com.pinke.uni.mobile.protal.note.model.UserNote;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 添加、修改用户笔记详情
 * 
 * @author lucuiping
 * 
 */
public class InsertUserNoteAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IUserNoteFS userNoteFS = (IUserNoteFS) SSBBus.findDomainService("muserNoteFS");
    /**
     * userIndex string UTF 是 用户名index type string UTF 是 操作类型 detailIndex string UTF 是 笔记index noteTitle string UTF 是
     * 笔记标题 noteTime string UTF 是 笔记时间 noteDesc string UTF 是 笔记详情 iconUrl string UTF 是 笔记图片地址 recordUrl string UTF 是
     * 笔记录音地址
     */
    private String detailIndex;
    private String userIndex;
    private String type;
    private String noteTitle;
    private String noteTime;
    private String noteDesc;
    private String iconUrl;
    private String recordUrl;

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
        log.info("添加、修改用户笔记详情接口，detailIndex=" + detailIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();

        try
        {
            jsonObj.put("result", "1");
            jsonObj.put("desc", "操作失败");
            if ("1".equals(type))
            {
                UserNote temp = new UserNote();
                temp.setStudentindex(Long.parseLong(userIndex));

                if (Tools.isNotNull(noteTitle))
                {
                    temp.setNotetitle(noteTitle);
                }
                if (Tools.isNotNull(noteTime))
                {
                    temp.setCreatetime(noteTime);
                }
                if (Tools.isNotNull(noteDesc))
                {
                    temp.setNotedesc(noteDesc);
                }
                if (Tools.isNotNull(iconUrl))
                {
                    temp.setIconurl(iconUrl);
                }
                if (Tools.isNotNull(recordUrl))
                {
                    temp.setRecordurl(recordUrl);
                }
                boolean result = userNoteFS.insertUserNote(temp);
                if (result == true)
                {
                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                }
            }
            else if ("2".equals(type))
            {
                UserNote temp = new UserNote();
                temp.setNoteindex(Long.parseLong(detailIndex));

                if (Tools.isNotNull(noteTitle))
                {
                    temp.setNotetitle(noteTitle);
                }
                if (Tools.isNotNull(noteTime))
                {
                    temp.setCreatetime(noteTime);
                }
                if (Tools.isNotNull(noteDesc))
                {
                    temp.setNotedesc(noteDesc);
                }
                if (Tools.isNotNull(iconUrl))
                {
                    temp.setIconurl(iconUrl);
                }
                if (Tools.isNotNull(recordUrl))
                {
                    temp.setRecordurl(recordUrl);
                }
                boolean result = userNoteFS.updateUserNote(temp);
                if (result == true)
                {
                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                }
            }

        }
        catch (Exception e)
        {
            log.error("添加、修改用户笔记详情接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
        }
        finally
        {
            log.info("添加、修改用户笔记详情接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {

        try
        {
            String content = getRequestContent();

            log.info("请求的Json类型的结果字符串：" + content);
            if (null == content)
            {
                return false;
            }

            JSONObject obj = JSONObject.fromObject(content);
            if (null == obj)
            {
                return false;
            }
            /**
             * 1：添加2：修改
             */
            type = obj.get("type") + "";
            if (Tools.isNull(type))
            {
                return false;
            }

            detailIndex = obj.get("detailIndex") + "";
            userIndex = obj.get("userIndex") + "";
            if ("1".equals(type))
            {

                if (Tools.isNull(userIndex))
                {
                    return false;
                }
            }
            else if ("2".equals(type))
            {

                if (Tools.isNull(detailIndex))
                {
                    return false;
                }

            }

            noteTitle = obj.get("noteTitle") + "";
            noteTime = obj.get("noteTime") + "";
            noteDesc = obj.get("noteDesc") + "";
            iconUrl = obj.get("iconUrl") + "";
            recordUrl = obj.get("recordUrl") + "";
        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }
        return true;
    }

}
