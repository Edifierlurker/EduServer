package com.pinke.uni.mobile.protal.adapter.action;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.adapter.fs.ILoginFS;
import com.pinke.uni.mobile.protal.adapter.model.AppVersionmgt;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 客户端自升级
 * 
 * @author Administrator
 * 
 */
public class ClientUpAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");
    String packageName;
    String versionCode;

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
        log.info("客户端自升级接口接收到的参数：packageName=" + packageName + ",versionCode=" + versionCode);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "客户端自升级失败");
            AppVersionmgt versionInfo = loginFS.getAppVersion(packageName);
            if (versionInfo != null && versionInfo.getVersionindex() != null)
            {
                /**
                 * result String 20 是 记录结果 0 成功 1 失败 desc String UTF 是 成功:返回用户的userID 失败:填写原因展现给用户 updateFlag String UTF
                 * 是 升级标志：0：无升级；1：建议升级；2：强制升级 newVersionName String UTF 是 返回新版本升级版本(如：v6.4.0主要是显示给用户看) newVersionCode
                 * String UTF 是 返回新版本的版本号：如640 updateDesc String UTF 是 升级信息的描述
                 */
                resultJobj.put("result", "0");
                resultJobj.put("desc", "");
                resultJobj.put("updateFlag", versionInfo.getUpdateflag() + "");
                resultJobj.put("newVersionName", versionInfo.getVersioname() + "");
                resultJobj.put("newVersionCode", versionInfo.getVersioncode() + "");
                resultJobj.put("updateDesc", versionInfo.getUpdatedesc() + "");
                resultJobj.put("updateDownUrl", Tools.serverURL + versionInfo.getApppath() + "");

            }

            else
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "客户端自升级失败");
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("客户端自升级接口异常", e);

        }
        finally
        {
            log.info("客户端自升级接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {
        try
        {
            packageName = this.getRequest().getParameter("packageName");
            versionCode = this.getRequest().getParameter("versionCode");
            if (Tools.isNull(packageName) || Tools.isNull(versionCode))
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
