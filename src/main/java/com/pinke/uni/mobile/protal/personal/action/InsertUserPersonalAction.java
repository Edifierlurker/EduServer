package com.pinke.uni.mobile.protal.personal.action;

import java.io.IOException;
import java.util.Date;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.personal.fs.IPersonalFS;
import com.pinke.uni.mobile.protal.personal.model.UserSchedulePrivate;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 添加、修改用户个人详情
 * 
 * @author lucuiping
 * 
 */
public class InsertUserPersonalAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IPersonalFS personalFS = (IPersonalFS) SSBBus.findDomainService("mpersonalFS");
    /**
     * title string UTF 个人标题 longitude 位置经度 latitude 位置纬度 location 位置名称 startTime string UTF 开始时间 endTime string UTF
     * 结束时间 desc string UTF 个人描述
     */
    private String detailIndex;
    private String userIndex;
    private String type;
    private String title;
    private String longitude;
    private String location;
    private String latitude;
    private String endTime;
    private String startTime;
    private String desc;
    private String note;

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
        log.info("新增、修改用户个人详情接口，detailIndex=" + detailIndex + ",userIndex=" + userIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();

        try
        {
            jsonObj.put("result", "1");
            jsonObj.put("desc", "操作失败");
            if ("1".equals(type))
            {
                UserSchedulePrivate temp = new UserSchedulePrivate();

                if (Tools.isNotNull(title))
                {
                    temp.setTitle(title);
                }
                if (Tools.isNotNull(desc))
                {
                    temp.setContent(desc);
                }
                if (Tools.isNotNull(startTime))
                {
                    temp.setStarttime(startTime);
                }
                if (Tools.isNotNull(endTime))
                {
                    temp.setEndtime(endTime);
                }
                if (Tools.isNotNull(note))
                {
                    temp.setNote(note);
                }
                if (Tools.isNotNull(longitude))
                {
                    temp.setLongitude(longitude);
                }
                if (Tools.isNotNull(latitude))
                {
                    temp.setLatitude(latitude);
                }
                if (Tools.isNotNull(location))
                {
                    temp.setSite(location);
                }
                if (Tools.isNotNull(userIndex))
                {
                    temp.setStudentindex(Long.parseLong(userIndex));
                }
                String createTime = Tools.formatDate7(new Date());
                temp.setCreatetime(createTime);
                // 新增个人
                boolean result = personalFS.insertPersonalDetail(temp);
                if (result == true)
                {
                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                }
            }
            else if ("2".equals(type))
            {
                UserSchedulePrivate temp = new UserSchedulePrivate();
                if (Tools.isNotNull(detailIndex))
                {
                    temp.setPrivateindex(Long.parseLong(detailIndex));
                }
                if (Tools.isNotNull(userIndex))
                {
                    temp.setStudentindex(Long.parseLong(userIndex));
                }
                if (Tools.isNotNull(title))
                {
                    temp.setTitle(title);
                }
                if (Tools.isNotNull(desc))
                {
                    temp.setContent(desc);
                }
                if (Tools.isNotNull(startTime))
                {
                    temp.setStarttime(startTime);
                }
                if (Tools.isNotNull(endTime))
                {
                    temp.setEndtime(endTime);
                }
                if (Tools.isNotNull(note))
                {
                    temp.setNote(note);
                }
                if (Tools.isNotNull(longitude))
                {
                    temp.setLongitude(longitude);
                }
                if (Tools.isNotNull(latitude))
                {
                    temp.setLatitude(latitude);
                }
                if (Tools.isNotNull(location))
                {
                    temp.setSite(location);
                }
                String updateTime = Tools.formatDate7(new Date());
                temp.setUpdatetime(updateTime);
                // 新增个人
                boolean result = personalFS.updatePersonalDetail(temp);
                if (result == true)
                {
                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                }
            }

        }
        catch (Exception e)
        {
            log.error("新增用户个人详情接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
        }
        finally
        {
            log.info("新增用户个人详情接口响应的Json类型的结果字符串：" + jsonObj.toString());
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

            userIndex = obj.get("userIndex") + "";
            detailIndex = obj.get("detailIndex") + "";
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
            title = obj.get("title") + "";
            longitude = obj.get("longitude") + "";
            latitude = obj.get("latitude") + "";
            startTime = obj.get("startTime") + "";
            endTime = obj.get("endTime") + "";
            location = obj.get("location") + "";
            desc = obj.get("desc") + "";
            note = obj.get("note") + "";

        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }
        return true;
    }

}
