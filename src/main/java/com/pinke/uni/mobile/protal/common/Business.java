package com.pinke.uni.mobile.protal.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinke.uni.mobile.protal.common.config.ConfigContent;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

/**
 * 业务抽象类
 * 
 * @author Administrator
 * 
 */
public abstract class Business
{
    private Log log = SSBBus.getLog(this.getClass());

    /**
     * 用户名
     */
    private String phone;
    /**
     * 手机型号ua
     */
    private String ua = null;
    /**
     * 用户设置ua
     */
    private String handua = null;
    /**
     * 客户端版本号
     */
    private String version;
    /**
     * 客户端渠道号
     */

    private String preassemble;
    /**
     * sessionid
     */
    private String sessionid;

    /**
     * http请求
     */
    private HttpServletRequest request;
    /**
     * http响应
     */
    private HttpServletResponse response;
    /**
     * 用于获取分辨率ua
     */
    private String ratio_handua;
    /**
     * 手机imei号
     */
    private String userimei;

    private String userimsi;

    private Map<String, String> requestParams = new HashMap<String, String>();

    /**
     * 业务处理
     */
    public abstract void execute();

    public void setHttpServletRequestForGet(HttpServletRequest request, HttpServletResponse response)
    {
        this.request = request;
        this.response = response;
    }

    /**
     * 接收http请求和响应，并获取用户手机号码
     * 
     * @param request
     *            请求对象
     * @param response
     *            响应对象
     * @param islogin
     *            是否登录 true 登陆 false 非登陆
     * @return -2 获取必要信息失败 -1 获取号码失败 0 成功 1黑名单用户
     */
    public int setHttpServletRequest(HttpServletRequest request, HttpServletResponse response)
    {
        this.request = request;
        this.response = response;

        this.ua = this.request.getHeader(ConfigContent.getXmlconfig().getHttpHeaderUa());
        this.ua = this.ua == null ? "" : this.ua;

        // 获取设置客户端特别设置的ua
        this.handua = this.request.getHeader("handua");
        // 手机IMEI号
        this.userimei = this.request.getHeader("imei");
        this.userimei = this.userimei == null ? "" : this.userimei;
        // 手机IMSI号
        this.userimsi = this.request.getHeader("imsi");
        this.userimsi = this.userimsi == null ? "" : this.userimsi;

        this.preassemble = this.request.getHeader("preassemble");

        this.phone = this.request.getHeader(ConfigContent.getXmlconfig().getHttpHeaderPhone());
        if (this.phone == null || this.phone.trim().equals(""))
        {
            this.phone = this.request.getHeader(ConfigContent.getXmlconfig().getHttpHeaderHandphone());
            if (this.phone == null || this.phone.trim().equals(""))
            {
                log.info("获取用户手机号码失败，不对业务进行处理");
                return -1;
            }

        }

        if (Tools.isNull(this.phone))
        {
            log.error("用户名【" + this.phone + "】验证不通过，不进行业务处理");
            log.info("用户名【" + this.phone + "】验证不通过，不进行业务处理");
            return -2;
        }

        // 版本号，用来获取版本更新，用户手机所适配的所有机型
        this.version = this.request.getHeader(ConfigContent.getXmlconfig().getHttpHeaderVersion());
        String clientVersion = Tools.isNull(this.version) ? "" : this.version.toLowerCase();
        log.info("客户端版本号：" + clientVersion);

        // session 信息，登陆时有用
        this.sessionid = request.getHeader("sessionid");

        log.info("必要信息【手机号:" + this.phone + "(" + this.handua + ")" + ",版本号:" + this.version + ",sessionid:"
                + sessionid + "】");

        return 0;
    }

    /**
     * 发送数据到客户端
     * 
     * @param response
     *            http响应，用来获取输出流
     * @param send
     *            发送内容的字节数组
     */
    protected void sendMessage(HttpServletResponse response, byte[] send)
    {
        try
        {
            response.setContentLength(send.length);
            ServletOutputStream out = response.getOutputStream();
            out.write(send);
            out.flush();
            out.close();
            log.info("发送数据成功，长度：" + send.length);
        }
        catch (IOException e)
        {
            log.error("发送数据错误，客户端已关闭连接" + e.getMessage());
        }
    }

    /**
     * 获取post请求的参数
     * 
     * @return
     */
    protected String getRequestContent()
    {
        try
        {
            InputStream in = this.getRequest().getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int rc = 0;
            while ((rc = in.read(buff, 0, 1024)) > 0)
            {
                baos.write(buff, 0, rc);
            }
            byte[] content = baos.toByteArray();
            in.close();
            baos.close();
            if (content == null || "".equals(content) || content.length <= 0)
            {
                log.error("未获取到需要处理的数据");
                return null;
            }
            String tablename = new String(content, "UTF-8");
            return tablename;
        }
        catch (UnsupportedEncodingException e)
        {
            log.error("获取需要处理的数据异常");
            e.printStackTrace();

        }
        catch (IOException e)
        {
            log.error("获取需要处理的数据异常");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取用户号码
     * 
     * @return 用户号码
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * 设置用户设置的ua信息
     * 
     * @return 用户设置ua信息
     */
    public String getUa()
    {
        return ua;
    }

    /**
     * 获取http请求对象
     * 
     * @return http请求对象
     */
    public HttpServletRequest getRequest()
    {
        return request;
    }

    /**
     * 设置http请求对象
     * 
     * @param request
     *            http请求对象
     */
    public void setRequest(HttpServletRequest request)
    {
        this.request = request;
    }

    /**
     * 获取http响应信息
     * 
     * @return http响应信息
     */
    public HttpServletResponse getResponse()
    {
        return response;
    }

    /**
     * 设置http响应信息
     * 
     * @param response
     *            http响应信息
     */
    public void setResponse(HttpServletResponse response)
    {
        this.response = response;
    }

    /**
     * 设置用户手机号码
     * 
     * @param phone
     *            用户手机号码
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * 设置用户设置的ua信息
     * 
     * @param ua
     *            用户设置的ua信息
     */
    public void setUa(String ua)
    {
        this.ua = ua;
    }

    public String getHandua()
    {
        return handua;
    }

    public void setHandua(String handua)
    {
        this.handua = handua;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getSessionid()
    {
        return sessionid;
    }

    public void setSessionid(String sessionid)
    {
        this.sessionid = sessionid;
    }

    public String getRatio_handua()
    {
        return ratio_handua;
    }

    public void setRatio_handua(String ratioHandua)
    {
        ratio_handua = ratioHandua;
    }

    public String getUserimei()
    {
        return userimei;
    }

    public void setUserimei(String userimei)
    {
        this.userimei = userimei;
    }

    public Map<String, String> getRequestParams()
    {
        return requestParams;
    }

    public void setRequestParams(Map<String, String> requestParams)
    {
        this.requestParams = requestParams;
    }

    public String getUserimsi()
    {
        return userimsi;
    }

    public void setUserimsi(String userimsi)
    {
        this.userimsi = userimsi;
    }

    public String getPreassemble()
    {
        return preassemble;
    }

    public void setPreassemble(String preassemble)
    {
        this.preassemble = preassemble;
    }

    // 2011.07.19修改，下载链接，设置添加IP
    // 得到手机IP地址
    protected String getRemortIP(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }

        if (ip.indexOf(",") > 0)
        {
            List<String> list = Arrays.asList(ip.split(","));
            Iterator<String> iter = list.iterator();
            while (iter.hasNext())
            {
                String tmp = iter.next();
                if (!"unknown".equalsIgnoreCase(ip) && ip != null)
                    ip = tmp;
            }
        }
        return ip;
    }

    public static String formatIp(String ip, char[] format)
    {

        if (format == null)
            throw new NullPointerException("the array for format is null!!!");

        for (int i = 0; i < format.length; i++)
        {
            format[i] = ' ';
        }
        for (int index = 0; index < ip.length(); index++)
        {
            format[index] = ip.charAt(index);
        }
        return String.valueOf(format);

    }

    public String fetchIp(HttpServletRequest request, char[] format)
    {
        if (format == null || request == null)
            throw new NullPointerException("the array for format is null!!! || the request is null!!!!");
        String ip = getRemortIP(request);
        return formatIp(ip, format);
    }

    protected String getPicPath()
    {
        return ApplicationGlobalResource.getInstance().getValueByKey("upload.entpic");
    }
}
