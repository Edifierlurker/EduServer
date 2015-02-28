package com.pinke.uni.mobile.protal.util;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

/**
 * 数据封装工具类
 * 
 * @author zhouyuqiang
 * */
public class SendUtil
{

    private static Log log = SSBBus.getLog(SendUtil.class);

    /**
     * 缓存空间
     */
    public static char dcacheSpace = getDcacheSpace();


    /**
     * 发送数据到客户端
     * 
     * @param response
     *            http响应，用来获取输出流
     * @param send
     *            发送内容的字节数组
     */
    public void sendMessage(HttpServletResponse response, String json)
    {
        try
        {
            // 数据加密操作
//            String jobjStr = SendUtil.encrypt(json);
            byte[] send = json.getBytes("UTF-8");
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

    private static char getDcacheSpace()
    {
        char result = '\000';
        try
        {
            /* 获取配置的缓存空间地址 */
            String key = ApplicationGlobalResource.getInstance().getValueByKey("store.dcacheSpace");
            if ("0".equals(key))
            {
                result = '\000';
            }
            if ("1".equals(key))
            {
                result = '\001';
            }
            else if ("2".equals(key))
            {
                result = '\002';
            }
            else if ("3".equals(key))
            {
                result = '\003';
            }
            else if ("4".equals(key))
            {
                result = '\004';
            }
            else if ("5".equals(key))
            {
                result = '\005';
            }
            else if ("6".equals(key))
            {
                result = '\006';
            }
            else if ("7".equals(key))
            {
                result = '\007';
            }
            else if ("8".equals(key))
            { /* char 类型为八进制，所以此处 十进制 8 = 八进制 10 */
                result = '\010';
            }
            else if ("9".equals(key))
            { /* 同上 */
                result = '\011';
            }

        }
        catch (Exception e)
        {
            log.error("获取缓存空间失败", e);
        }
        return result;
    }

}
