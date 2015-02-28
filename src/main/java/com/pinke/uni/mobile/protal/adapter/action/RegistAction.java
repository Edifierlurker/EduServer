package com.pinke.uni.mobile.protal.adapter.action;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.mobile.protal.adapter.fs.ILoginFS;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.AppstoreOnlineErrorCode;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.MD5Two;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

/**
 * 用户注册
 * 
 * @author lucuiping 2014.11.10
 * 
 */
public class RegistAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");
    private static final String OPENFLAG = ApplicationGlobalResource.getInstance().getValueByKey("memcache.openFlag");
    MemcachedClient mcc = new MemcachedClient();
    String userName;
    String loginPass;
    String confirmPass;
    String verifyCode;

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
        log.info("用户注册接口接收到的请求参数：usercode=" + userName + ",loginpass=" + loginPass + ",confirmPass=" + confirmPass
                + ",verifyCode=" + verifyCode);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "用户注册失败");

            if (Tools.isNumeric(userName) && userName.length() == 11)
            {
                if (!loginPass.equals(confirmPass))
                {
                    resultJobj.put("result", "1");
                    resultJobj.put("desc", "两次密码输入不一致");
                }
                else
                {
                    String verKey = "getUserVercode";
                    if ("false".equals(OPENFLAG))
                    {
                        mcc = null;
                    }
                    if (mcc != null)
                    {
                        String cacheverifyycode = (String) mcc.get(new String(verKey + "_" + userName));
                        if (!verifyCode.equals(cacheverifyycode))
                        {
                            resultJobj.put("result", "1");
                            resultJobj.put("desc", "验证码错误");
                        }
                        else
                        {
                            String errorcode = loginFS.signUp(userName, loginPass);
                            log.info("用户注册返回的状态码:" + errorcode);
                            if (AppstoreOnlineErrorCode.SUCCESS.equals(errorcode))
                            {
                                resultJobj.put("result", "0");
                                resultJobj.put("desc", "");
                            }
                            else if (AppstoreOnlineErrorCode.CHECK_ADD_USER.equals(errorcode))
                            {
                                resultJobj.put("result", "1");
                                resultJobj.put("desc", "用户已经注册");
                            }
                            else
                            {
                                resultJobj.put("result", "1");
                                resultJobj.put("desc", "用户注册失败");
                            }

                        }
                    }

                }
            }
            else
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "手机号码输入不规范");
            }

        }
        catch (Exception e)
        {
            log.error("用户注册接口异常" + e);

        }
        finally
        {
            log.info("用户注册接口响应：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {
//        return true;
         try
         {
         userName = this.getRequest().getParameter("userCode");
        
         loginPass = this.getRequest().getParameter("loginPass");
        
         confirmPass = this.getRequest().getParameter("confirmPass");
        
         verifyCode = this.getRequest().getParameter("verifyCode");
        
         if (Tools.isNull(userName) || Tools.isNull(loginPass) || Tools.isNull(confirmPass)
         || Tools.isNull(verifyCode))
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

    public static void main(String[] args)
    {
        
        System.out.println(MD5Two.MD5Str("1".getBytes()));
//        ChannelDataSourceUtil dsu = new ChannelDataSourceUtil();
//        StringBuffer sqlStr = new StringBuffer();
//        sqlStr.append("SELECT * FROM ofproperty t WHERE t.name= 'passwordKey' ");
//        List listMap = dsu.getList(sqlStr.toString(), new Object[] {});
//        if (listMap != null && listMap.size() > 0)
//        {
//            String[] temp = (String[]) listMap.get(0);
//            String passwordkey = temp[0];
//        }

    }

}
