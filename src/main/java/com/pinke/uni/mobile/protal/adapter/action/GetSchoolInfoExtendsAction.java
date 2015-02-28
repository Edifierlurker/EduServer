package com.pinke.uni.mobile.protal.adapter.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.adapter.fs.ILoginFS;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfo;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfoHis;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取某一学校的具体信息
 * 
 * @author Administrator
 * 
 */
public class GetSchoolInfoExtendsAction extends Business
{
    private Log log = SSBBus.getLog(getClass());
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");
    private String schoolIndex;
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
        log.info("获取学校具体信息接口接收到的参数：schoolindex:" + schoolIndex + ",userindex:" + userIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        JSONArray schoolArray = new JSONArray();
        try
        {
            jsonObj.put("result", "1");
            jsonObj.put("desc", "查询失败");
            TSchoolinfo tschoolinfo = loginFS.getSchoolInfo(Tools.isNull(schoolIndex) == true ? 1l : Long
                    .parseLong(schoolIndex));

            if (tschoolinfo != null && tschoolinfo.getSchoolstatus() == 1)
            {
                jsonObj.put("result", "0");
                jsonObj.put("desc", "");

                jsonObj.put("weeks", tschoolinfo.getWeeks() + "");
                jsonObj.put("weekBegin", tschoolinfo.getWeekbegin() + "");
                jsonObj.put("sections", tschoolinfo.getSections() + "");
                TSchoolinfoHis tschoolinfoHis = new TSchoolinfoHis();
                tschoolinfoHis.setStatus(1);
                tschoolinfoHis.setSchoolindex(Tools.isNull(schoolIndex) == true ? 1l : Long.parseLong(schoolIndex));
                List<TSchoolinfoHis> list = loginFS.getSchoolfoExtendsList(tschoolinfoHis);
                if (list != null && list.size() > 0)
                {
                    for (TSchoolinfoHis tempHis : list)
                    {
                        JSONObject tempJobj = new JSONObject();
                        tempJobj.put("sections", tempHis.getSections() + "");
                        tempJobj.put("sectionstarttime", tempHis.getSectionstarttime() + "");
                        tempJobj.put("sectionendtime", tempHis.getSectionendtime() + "");
                        schoolArray.add(tempJobj);

                    }
                }
                jsonObj.put("Data", schoolArray);
            }

        }
        catch (Exception e)
        {
            log.info("查询学校具体信息接口异常", e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "查询学校具体信息失败");

        }
        finally
        {
            log.info("查询学校具体信息接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            schoolIndex = this.getRequest().getParameter("schoolIndex");
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
