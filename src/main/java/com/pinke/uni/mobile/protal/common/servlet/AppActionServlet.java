package com.pinke.uni.mobile.protal.common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.StoreUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

/**
 * 手机客户端请求转发类
 * 
 * @author Administrator
 * 
 */

public class AppActionServlet extends HttpServlet
{

    private Log log = SSBBus.getLog(this.getClass());
    /**
     * 序列化id
     */
    private static final long serialVersionUID = 5553816395024194842L;

    /** openfire服务器address */

    private final static String server = ApplicationGlobalResource.getInstance().getValueByKey("openfire.url");

    /**
     * Constructor of the object.
     */
    public AppActionServlet()
    {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy()
    {
        super.destroy();
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
        String serviceid = request.getParameter("serviceid");
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String user_agent = request.getHeader("user-agent");
        String p = request.getHeader("x-up-calling-line-id");
        String ip = request.getHeader("X-Real-IP");
        if (ip == null)
        {
            ip = request.getRemoteAddr();
        }
        String requestid = Tools.getUUID_32();
        log.info("wostorebegin,ip:" + ip + ",requestid:" + requestid + ",begin ");
        /** 打印头信息完毕 */
        log.info("接受到IP[" + ip + "]服务请求，服务ID【" + serviceid + "】");
        log.info("wap网关传递的数据" + ",x-up-calling-line-id:" + p);
        log.info("user-agent " + user_agent);

        String classpath = "";
        int stat = 0;
        try
        {
            classpath = StoreUtil.getReflectObj(serviceid.trim());
            if (classpath == null || classpath.equals(""))
            {
                log.error("classpath为空，无法处理业务");
                response.sendError(CodeConstant.SC_HTTP_500, CodeConstant.HTTP_500);
            }
            else
            {
                Business business = (Business) Class.forName(classpath).newInstance();

                stat = business.setHttpServletRequest(request, response);

                if (stat == 0)
                {
                    business.execute();
                }
                else if (stat == -1)
                {
                    response.setHeader("wostorestate", "420");
                    log.info("状态码:" + CodeConstant.SC_HTTP_420 + ",内容:" + CodeConstant.HTTP_420);
                    response.sendError(CodeConstant.SC_HTTP_420, CodeConstant.HTTP_420);
                }
                else if (stat == -2)
                {
                    response.setHeader("wostorestate", "403");
                    log.info("状态码:" + CodeConstant.SC_HTTP_403 + ",内容:" + CodeConstant.SC_HTTP_403);
                    response.sendError(CodeConstant.SC_HTTP_403, CodeConstant.HTTP_403);
                }
                else if (stat == 1)
                {// 黑名单用户
                    response.setHeader("wostorestate", "421");
                    log.info("状态码:" + CodeConstant.SC_HTTP_421 + ",内容:" + CodeConstant.SC_HTTP_421);
                    response.sendError(CodeConstant.SC_HTTP_421, CodeConstant.HTTP_421);
                }
            }

        }
        catch (InstantiationException e)
        {
            log.error("InstantiationException,classpath[" + classpath + "]", e);
        }
        catch (IllegalAccessException e)
        {
            log.error("IllegalAccessException,classpath[" + classpath + "]", e);
        }
        catch (ClassNotFoundException e)
        {
            log.error("ClassNotFoundException,classpath[" + classpath + "]", e);
        }
        catch (Exception e)
        {
            log.error("classpath[" + classpath + "]", e);
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
    {}


}
