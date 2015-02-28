package com.pinke.uni.mobile.protal.adapter.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.mobile.protal.adapter.fs.ILoginFS;
import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.common.config.ParseConfig;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.MD5Two;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

/**
 * 获取短信验证码(找回密码)
 * 
 * @author Administrator
 * 
 */
public class GetVerifycodeAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");
    private static final String OPENFLAG = ApplicationGlobalResource.getInstance().getValueByKey("memcache.openFlag");
    private static final Long DCACHETIME_LEVERL1 = Tools.getMemcacheTime("memcache.time_level_vercode");
    private static final Long DCACHETIME_LEVERL2 = Tools.getMemcacheTime("memcache.time_level_piccode");
    MemcachedClient mcc = new MemcachedClient();
    HttpServletRequest request;
    HttpServletResponse response;
    private String picVercode;
    private String sessionID;
    /**
     * 手机号码或邮箱
     */
    private String userName;
    /**
     * 请求类型
     */
    private String type;

    @Override
    public void execute()
    {
        if (!confirm())
        {
            try
            {
                this.response.sendError(CodeConstant.SC_HTTP_400, CodeConstant.HTTP_400);
            }
            catch (IOException e)
            {
                log.error("response流异常", e);
            }
            return;
        }
        log.info("接收到数据，手机号码userName=" + userName + ",type=" + type);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {

            boolean flag = true;
            boolean userFlag = false;
            resultJobj.put("result", "1");
            resultJobj.put("desc", "失败");
            // 验证号码是否是数字和长度是否 等于11位
            if (!Tools.isNumeric(userName) || userName.length() != 11)
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", ParseConfig.messageMaps.get("GetVerifycode.gvca_1"));
                flag = false;
            }

            if (flag)
            {
                // 获取6位验证码
                String verifycode = Tools.createRandomCheck(6);

                // //发送短信
                String mess = "";
                if ("1".equals(type))
                {
                    TStudentinfo userinfo = loginFS.getUserInfoByUserCode(userName);
                    if (userinfo != null)
                    {
                        resultJobj.put("result", "1");
                        resultJobj.put("desc", "用户已存在");
                    }
                    else
                    {
                        String strKey = "getPicVercode";
                        String verKey = "getUserVercode";
                        String sendVerKey = "sendVercodeFlag";
                        if ("false".equals(OPENFLAG))
                        {
                            mcc = null;
                        }
                        if (mcc != null)
                        {
                            // 查询此用户是否已发过验证码或验证码是否过期
                            String verCodeCache = (String) mcc.get(new String(sendVerKey + "_" + userName));
                            if (Tools.isNull(verCodeCache))
                            {
                                JSONObject picCodeJobj = new JSONObject();
                                String picCodeStr = (String) mcc.get(new String(strKey + "_" + sessionID));
                                if (Tools.isNotNull(picCodeStr))
                                {
                                    picCodeJobj = JSONObject.fromObject(picCodeStr);
                                }

                                if (picCodeJobj != null)
                                {
                                    String picCodeCache = picCodeJobj.get("picCode") + "";
                                    String userCodeCache = picCodeJobj.get("usercode") + "";

                                    if (Tools.isNotNull(picCodeCache) && picCodeCache.equals(picVercode)
                                            && (Tools.isNull(userCodeCache) || userName.equals(userCodeCache)))
                                    {

                                        /**
                                         * 将验证码放入缓存
                                         */
                                        boolean success = mcc.set(new String(verKey + "_" + userName), verifycode,
                                                new Date(DCACHETIME_LEVERL2 * 1000));
                                        /**
                                         * 将验证码发送标识放入缓存
                                         */
                                        mcc.set(new String(sendVerKey + "_" + userName), verifycode, new Date(
                                                DCACHETIME_LEVERL1 * 1000));
                                        /**
                                         * 将用户手机号更新到缓存
                                         */

                                        picCodeJobj.put("usercode", userName);
                                        mcc.set(new String(strKey + "_" + sessionID), verifycode, new Date(
                                                DCACHETIME_LEVERL2 * 1000));

                                        if (success == true)
                                        {
                                            userFlag = true;
                                        }

                                    }

                                }
                            }
                        }

                        mess = "您好，您的验证码是：" + verifycode;
                    }

                }
                else if ("0".equals(type))
                {
                    mess = "您好，您的手机密码是：" + verifycode;

                    TStudentinfo userinfo = loginFS.getUserInfoByUserCode(userName);
                    if (userinfo == null)
                    {
                        resultJobj.put("result", "1");
                        resultJobj.put("desc", "用户不存在");

                    }
                    else
                    {
                        userinfo.setPassword(MD5Two.MD5Str(verifycode.getBytes()));
                        loginFS.updateUserInfo(userinfo);
                        userFlag = true;
                    }
                }

                if (userFlag == true)
                {
                    log.info(mess);
                    Tools.appadd(userName, mess);
                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");

                }

            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.error("发送短信验证码", e);
        }

        log.info("用户验证码（重置密码）接口响应：" + resultJobj.toString());
        sendUtil.sendMessage(response, resultJobj.toString());

    }

    private boolean confirm()
    {
        userName = this.request.getParameter("userCode");
        if (userName == null || "".equals(userName.trim()))
        {
            log.error("获取号码失败，不对业务进行处理");
            return false;
        }
        type = this.request.getParameter("type");
        if (Tools.isNull(type))
        {
            return false;
        }
        picVercode = this.request.getParameter("picVercode");
        sessionID = this.request.getParameter("sessionID");
        if ("1".equals(type))
        {
            if (Tools.isNull(picVercode) || Tools.isNull(sessionID))
            {
                return false;
            }
        }
        return true;
    }

    public GetVerifycodeAction(HttpServletRequest request, HttpServletResponse response)
    {
        super();
        this.request = request;
        this.response = response;
    }
}
