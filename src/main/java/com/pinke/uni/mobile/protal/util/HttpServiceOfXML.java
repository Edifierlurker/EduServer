package com.pinke.uni.mobile.protal.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

public class HttpServiceOfXML
{

    private Log log = SSBBus.getLog(getClass());

    public String sendForPost()
    {

        return null;
    }

    /**
     * 
     * @param url
     * @param contimeout
     *            连接超时时间
     * @param readtimeout
     *            读取超时时间
     * @return
     */
    public Document sendForGet(String url, Integer contimeout, Integer readtimeout)
    {
        URL urlo = null;
        InputStream is = null;
        HttpURLConnection con = null;
        SAXReader sax = null;
        Document doc = null;
        try
        {
            log.debug("Get请求地址：" + url);
            urlo = new URL(url);
            con = (HttpURLConnection) urlo.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            if (contimeout != null)
            {
                con.setConnectTimeout(contimeout);
            }
            if (readtimeout != null)
            {
                con.setReadTimeout(readtimeout);
            }
            con.setRequestProperty("Content-type", "application/text");
            con.setRequestMethod("GET");
            is = con.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            int c;
            StringBuffer s = new StringBuffer();
            while ((c = isr.read()) != -1)
            {
                s.append((char) c);
            }
            log.debug("响应的结果字符串：" + s.toString());
            String result = s.toString();
            try
            {
                sax = new SAXReader();
                doc = sax.read(new ByteArrayInputStream(result.getBytes("UTF-8")));
            }
            catch (DocumentException e)
            {
                e.printStackTrace();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (con != null)
                con.disconnect();
            try
            {
                if (is != null)
                    is.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return doc;
    }
}
