package com.pinke.uni.mobile.protal.adapter.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.adapter.fs.ILoginFS;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfoHis;
import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.AppstoreOnlineErrorCode;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

public class LoginAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");
    String userName;
    String password;

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
        log.info("登录接口接收到的参数：userphone=" + userName + ",password=" + password);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            String errorcode = loginFS.login(userName, password);
            if (AppstoreOnlineErrorCode.SUCCESS.equals(errorcode))
            {
                TStudentinfo tstudentinfo = new TStudentinfo();
                tstudentinfo.setUserphone(userName);
                tstudentinfo.setStatus(1);
                TStudentinfo userinfo = loginFS.getUserInfoByExtends(tstudentinfo);
                if (userinfo != null)
                {
                    resultJobj.put("result", "0");
                    resultJobj.put("desc", userinfo.getStudentid() + "");
                    resultJobj.put("userIndex", userinfo.getStudentindex() + "");
                    resultJobj.put("schoolIndex", userinfo.getSchoolindex() + "");
                    resultJobj.put("weeks", userinfo.getWeeks() + "");
                    resultJobj.put("weekBegin", userinfo.getWeekbegin() + "");
                    resultJobj.put("headPic", Tools.serverURL + userinfo.getHeadpic() + "");

                    try
                    {
                        JSONArray schoolArray = new JSONArray();
                        TSchoolinfoHis tschoolinfoHis = new TSchoolinfoHis();
                        tschoolinfoHis.setSchoolindex(userinfo.getSchoolindex() == null ? 1l : userinfo
                                .getSchoolindex());
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
                        resultJobj.put("Data", schoolArray);
                    }
                    catch (Exception e)
                    {
                        log.error("查询用户学校信息异常",e);
                    }

                }

            }
            else if (AppstoreOnlineErrorCode.LOG_FAIL.equals(errorcode))
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "用户账户异常");
            }
            else if (AppstoreOnlineErrorCode.PASS_ERROR.equals(errorcode))
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "用户密码错误");
            }
            else if (AppstoreOnlineErrorCode.USERNOTEXIT.equals(errorcode))
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "用户不存在");
            }
            else
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "用户登录失败");
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("客户端登录接口异常", e);

        }
        finally
        {
            log.info("客户端登录接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {
        try
        {
            // String modulekey = getClass().getName() + "|" + new
            // java.lang.Exception().getStackTrace()[0].getMethodName();
            // System.out.println(modulekey);
            userName = this.getRequest().getParameter("userCode");
            if (Tools.isNull(userName))
            {
                return false;
            }
            password = this.getRequest().getParameter("password");
            if (Tools.isNull(password))
            {
                return false;
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
