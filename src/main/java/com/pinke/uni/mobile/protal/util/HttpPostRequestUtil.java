package com.pinke.uni.mobile.protal.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinke.uni.mobile.protal.common.service.DataAdapter;
import com.pinke.uni.mobile.protal.common.service.DataParser;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class HttpPostRequestUtil
{

    /**
     * 向3.0服务端发送请求服务
     * 
     * @param context
     *            soap请求的内容
     * @param flag
     *            1：申请 2：修改 3:删除
     * @return 返回响应解析的结果，[0] :sessionid ,[1]返回码
     */
    public static Map doService(HttpServletRequest request, HttpServletResponse response, String param,
            String serviceName)
    {
        Map resultMap = new HashMap();
        DataAdapter de = null;
        int flag =0;
        if("batchVersionNew".equals(serviceName)){
            flag = 1;
        }
        String resultStr = null;
        HttpURLConnection urlConnection = null;
        try
        {
            String urlStr = ApplicationGlobalResource.getInstance().getValueByKey("MobileServer.requestUrl");
            String serverUrl = ApplicationGlobalResource.getInstance().getValueByKey("MobileServer.serverUrl");
            String serverPort = ApplicationGlobalResource.getInstance().getValueByKey("MobileServer.port");
            String agentFlag = ApplicationGlobalResource.getInstance().getValueByKey("MobileServer.agentFlag");
            String timeOut = ApplicationGlobalResource.getInstance().getValueByKey("MobileServer.timeout");
            int timeout = Tools.isNull(timeOut) ? 0 : Integer.parseInt(timeOut);
            urlStr += serviceName;
            if (urlStr == null || "".equals(urlStr.trim()))
            {
                return null;
            }
            URL url = new URL(urlStr);
            System.out.println(urlStr);

            if ("true".equals(agentFlag))
            {
                InetSocketAddress addr = new InetSocketAddress(serverUrl, serverPort == null ? 80 : Integer
                        .parseInt(serverPort));
                Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
                // // // 打开和URL之间的连接
                urlConnection = (HttpURLConnection) url.openConnection(proxy);

            }
            else
            {
                urlConnection = (HttpURLConnection) url.openConnection();

            }

            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setInstanceFollowRedirects(false);
            urlConnection.setReadTimeout(timeout);
            urlConnection.setConnectTimeout(timeout);

            urlConnection.setRequestProperty("Charsert", "UTF-8");
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/octet-stream");

            urlConnection.setRequestProperty("handphone", Tools.isNull(request.getHeader("handphone")) ? "" : request
                    .getHeader("handphone").trim()
                    + "");
            urlConnection.setRequestProperty("version", Tools.isNull(request.getHeader("version")) ? "" : request
                    .getHeader("version").trim()
                    + "");
            urlConnection.setRequestProperty("storeua", Tools.isNull(request.getHeader("storeua")) ? "" : request
                    .getHeader("storeua").trim()
                    + "");
            urlConnection.setRequestProperty("x-up-calling-line-id", Tools.isNull(request
                    .getHeader("x-up-calling-line-id")) ? "" : request.getHeader("x-up-calling-line-id").trim() + "");
            urlConnection.setRequestProperty("handua", Tools.isNull(request.getHeader("handua")) ? "" : request
                    .getHeader("handua").trim()
                    + "");
            urlConnection.setRequestProperty("settertype", Tools.isNull(request.getHeader("settertype")) ? "" : request
                    .getHeader("settertype").trim()
                    + "");
            urlConnection.setRequestProperty("version", Tools.isNull(request.getHeader("version")) ? "" : request
                    .getHeader("version").trim()
                    + "");
            urlConnection.setRequestProperty("imei", Tools.isNull(request.getHeader("imei")) ? "" : request.getHeader(
                    "imei").trim());
            urlConnection.setRequestProperty("imsi", Tools.isNull(request.getHeader("imsi")) ? "" : request.getHeader(
                    "imsi").trim());
            urlConnection.setRequestProperty("preassemble", Tools.isNull(request.getHeader("preassemble")) ? ""
                    : request.getHeader("preassemble").trim());
            urlConnection.setRequestProperty("companylogo", Tools.isNull(request.getHeader("companylogo")) ? null
                    : request.getHeader("companylogo").trim());
            urlConnection.setRequestProperty("sessionid", "");
            urlConnection.setRequestProperty("appfrom", Tools.isNull(request.getHeader("appfrom")) ? "" : request
                    .getHeader("appfrom").trim());
            urlConnection.setRequestProperty("newclient", Tools.isNull(request.getHeader("newclient")) ? "" : request
                    .getHeader("newclient").trim());
            urlConnection.setRequestProperty("phoneAccessMode", Tools.isNull(request.getHeader("phoneAccessMode")) ? ""
                    : request.getHeader("phoneAccessMode").trim());
            urlConnection.setRequestProperty("networkOperator", Tools.isNull(request.getHeader("networkOperator")) ? ""
                    : request.getHeader("networkOperator").trim());
            urlConnection.setRequestProperty("signal", Tools.isNull(request.getHeader("signal")) ? "" : request
                    .getHeader("signal").trim());
            urlConnection.setRequestProperty("mac", Tools.isNull(request.getHeader("mac")) ? "" : request.getHeader(
                    "mac").trim());
            urlConnection.setRequestProperty("user-agent", Tools.isNull(request.getHeader("user-agent")) ? "" : request
                    .getHeader("user-agent").trim());
            urlConnection.setRequestProperty("usertype", Tools.isNull(request.getHeader("usertype")) ? "0" : request
                    .getHeader("usertype").trim());
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
            out.write(param);
            out.flush();
            out.close();

            urlConnection.connect();
            int responsecode = urlConnection.getResponseCode();
            resultMap.put("responseCode", responsecode);
            if (responsecode == 200)
            {
                InputStream in = null;
                ByteArrayOutputStream baos = null;
                try
                {
                    in = urlConnection.getInputStream();

                    baos = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int rc = 0;
                    while ((rc = in.read(buff, 0, 1024)) > 0)
                    {
                        baos.write(buff, 0, rc);
                    }
                    byte[] content = baos.toByteArray();
                    if(flag ==1){
                        resultStr = baos.toString("utf-8");
                    }
                    else{
                        de = DataParser.parser(content); 
                    }
                   
                    in.close();
                    baos.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (in != null)
                    {
                        try
                        {
                            in.close();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }

                    }
                    if (baos != null)
                    {
                        try
                        {
                            baos.close();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }

            }
            urlConnection.disconnect();

        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
        finally
        {
            if (urlConnection != null)
            {
                try
                {
                    urlConnection.disconnect();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }

        
        if(flag ==1){
            resultMap.put("data", resultStr); 
        }
        else{
            resultMap.put("data", de);
        }
        return resultMap;

    }
}
