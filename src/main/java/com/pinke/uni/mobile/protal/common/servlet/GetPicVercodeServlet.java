package com.pinke.uni.mobile.protal.common.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.StoreUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class GetPicVercodeServlet extends HttpServlet
{
    private static final String OPENFLAG = ApplicationGlobalResource.getInstance().getValueByKey("memcache.openFlag");
    private static final Long DCACHETIME_LEVERL1 = Tools.getMemcacheTime("memcache.time_level_vercode");
    private static final Long DCACHETIME_LEVERL2 = Tools.getMemcacheTime("memcache.time_level_piccode");
    MemcachedClient mcc = new MemcachedClient();
    /**
     * 
     */
    private static final long serialVersionUID = 6692040237015023755L;

    /**
     * Constructor of the object.
     */
    public GetPicVercodeServlet()
    {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy()
    {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     * 
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONObject resultJobj = new JSONObject();
        SendUtil sendUtil = new SendUtil();
        try
        {
            String strKey = "getPicVercode";
            if ("false".equals(OPENFLAG))
            {
                mcc = null;
            }
            if (mcc != null)
            {
                String sessionID = StoreUtil.getSessionid();
                String picCode = Tools.createRandomCheck(4);
                JSONObject sessionJobj = new JSONObject();
                sessionJobj.put("picCode", picCode);
                sessionJobj.put("usercode", "");
                boolean success = mcc.set(new String(strKey + "_" + sessionID), sessionJobj.toString(), new Date(
                        DCACHETIME_LEVERL2 * 1000));
                if (success == true)
                {
                    resultJobj.put("result", "0");
                    resultJobj.put("desc", "");
                    resultJobj.put("sessionID", sessionID);
                    resultJobj.put("picVercode", picCode);

                }
                else
                {
                    resultJobj.put("result", "1");
                    resultJobj.put("desc", "生成失败");
                }

            }
            else
            {
                resultJobj.put("result", "1");
                resultJobj.put("desc", "保存失败");
            }
        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部异常");
        }
        finally
        {
            System.out.println("生成图形验证码接口返回的数据是：" + resultJobj.toString());
            sendUtil.sendMessage(response, resultJobj.toString());

        }


    }

    /**
     * The doPost method of the servlet. <br>
     * 
     * This method is called when a form has its tag value method equals to post.
     * 
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    /**
     * Initialization of the servlet. <br>
     * 
     * @throws ServletException
     *             if an error occurs
     */
    public void init() throws ServletException
    {

        // Put your code here
    }

}
