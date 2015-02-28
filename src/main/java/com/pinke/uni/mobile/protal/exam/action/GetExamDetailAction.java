package com.pinke.uni.mobile.protal.exam.action;

import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.exam.fs.IExamInfoFS;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfo;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 查询用户考试详情
 * 
 * @author lucuiping
 * 
 */
public class GetExamDetailAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IExamInfoFS examInfoFS = (IExamInfoFS) SSBBus.findDomainService("mexamInfoFS");;
    private String userIndex;
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
        log.info("查询用户考试详情接口,userIndex=" + userIndex + ",detailIndex=" + detailIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray examInfoArray = new JSONArray();

        try
        {
            jsonObj.put("result", "0");
            jsonObj.put("desc", "");
            /**
             * 查询考试详情
             */

            UserScheduleExaminfo userScheduleExaminfo = examInfoFS.getUserScheduleExaminfoByIndex(Long
                    .parseLong(detailIndex));

            if (userScheduleExaminfo != null)
            {
                jsonObj.put("examIndex", userScheduleExaminfo.getExamindex() + "");
                jsonObj.put("examTitle", userScheduleExaminfo.getExamname() + "");
                jsonObj.put("site", userScheduleExaminfo.getSite() + "");
                jsonObj.put("isOpen", userScheduleExaminfo.getOpenexam() + "");
                jsonObj.put("examDate", userScheduleExaminfo.getExamdate() + "");
                jsonObj.put("examStartTime", userScheduleExaminfo.getExamstarttime() + "");
                jsonObj.put("examEndTime", userScheduleExaminfo.getExamendtime() + "");

            }

        }
        catch (Exception e)
        {
            log.error("查询用户考试详情接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
            jsonObj.put("data", examInfoArray);
        }
        finally
        {
            log.info("查询用户考试详情接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            detailIndex = this.getRequest().getParameter("detailIndex");
            if (Tools.isNull(userIndex) || Tools.isNull(detailIndex))
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
