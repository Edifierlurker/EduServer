package com.pinke.uni.mobile.protal.adapter.action;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.adapter.fs.ILoginFS;
import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

public class ModifyPasswordAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private String oldPassword;
    private String newPassword;
    private String verifyPassword;
    private String userCode;
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");

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
        log.info("用户修改密码接口接收到的请求参数：usercode=" + userCode + ",oldPassword=" + oldPassword + ",newPassword="
                + newPassword + ",verifyPassword=" + verifyPassword);

        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            TStudentinfo userInfo = loginFS.getUserInfoByUserCode(userCode);
            if (userInfo == null && Tools.isNotNull(userInfo.getStudentindex() + ""))
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "用户不存在");
            }
            else
            {
                if (!oldPassword.equals(userInfo.getPassword()))
                {
                    resultJobj.put("result", "1");
                    resultJobj.put("desc", "用户密码不正确");
                }
                else
                {
                    if (!newPassword.equals(verifyPassword))
                    {
                        resultJobj.put("result", "1");
                        resultJobj.put("desc", "用户输入的两次密码不一致");
                    }
                    else
                    {
                        userInfo.setPassword(newPassword);
                        boolean errorcode = loginFS.updateUserInfo(userInfo);
                        if (errorcode = true)
                        {
                            resultJobj.put("result", "0");
                            resultJobj.put("desc", "");
                        }
                        else
                        {
                            resultJobj.put("result", "1");
                            resultJobj.put("desc", "用户密码更新失败");
                        }

                    }
                }
            }

        }
        catch (Exception e)
        {
            log.info("更新密码接口异常", e);

        }
        finally
        {
            log.info("更新密码接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {
        try
        {
            oldPassword = this.getRequest().getParameter("oldPassword");
            newPassword = this.getRequest().getParameter("newPassword");
            verifyPassword = this.getRequest().getParameter("verifyPassword");
            userCode = this.getRequest().getParameter("userCode");

            if (Tools.isNull(oldPassword) || Tools.isNull(newPassword) || Tools.isNull(verifyPassword)
                    || Tools.isNull(userCode))
            {
                return false;
            }

        }
        catch (Exception e)
        {
            log.error("获取数据异常", e);
            return false;
        }

        return true;

    }
}
