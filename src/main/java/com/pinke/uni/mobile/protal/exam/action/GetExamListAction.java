package com.pinke.uni.mobile.protal.exam.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.exam.fs.IExamInfoFS;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfo;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 查询用户考试列表
 * 
 * @author lucuiping
 * 
 */
public class GetExamListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IExamInfoFS examInfoFS = (IExamInfoFS) SSBBus.findDomainService("mexamInfoFS");;
    private String userIndex;
    private String type;

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
        log.info("查询用户考试列表接口,userIndex=" + userIndex + ",type=" + type);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray examInfoArray = new JSONArray();

        try
        {
            jsonObj.put("result", "0");
            jsonObj.put("desc", "");
            jsonObj.put("totalCount", 0);
            /**
             * 查询考试列表
             */
            if ("1".equals(type))
            {
                UserScheduleExaminfo userScheduleExaminfo = new UserScheduleExaminfo();
                userScheduleExaminfo.setStudentindex(Long.parseLong(userIndex));
                List<UserScheduleExaminfo> list = examInfoFS.getExamList(userScheduleExaminfo);

                if (list != null && list.size() > 0)
                {
                    jsonObj.put("totalCount", list.size());
                    for (UserScheduleExaminfo tempExamInfo : list)
                    {
                        JSONObject tempJobj = new JSONObject();
                        tempJobj.put("examIndex", tempExamInfo.getExamindex() + "");
                        tempJobj.put("examTitle", tempExamInfo.getExamname() + "");
                        tempJobj.put("site", tempExamInfo.getSite() + "");
                        tempJobj.put("examStartTime", tempExamInfo.getExamstarttime() + "");
                        tempJobj.put("examEndTime", tempExamInfo.getExamendtime() + "");
                        tempJobj.put("isOpen", tempExamInfo.getOpenexam() + "");
                        examInfoArray.add(tempJobj);
                    }
                }

            }
            jsonObj.put("data", examInfoArray);

        }
        catch (Exception e)
        {
            log.error("查询用户考试列表接口异常" + e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "服务器内部错误");
            jsonObj.put("data", examInfoArray);
        }
        finally
        {
            log.info("查询用户考试列表接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }
    }

    private boolean confirm()
    {
        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            type = this.getRequest().getParameter("type");

            if (Tools.isNull(type) || Tools.isNull(userIndex))
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
