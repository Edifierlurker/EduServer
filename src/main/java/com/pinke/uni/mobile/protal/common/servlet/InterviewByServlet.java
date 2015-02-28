package com.pinke.uni.mobile.protal.common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.StoreUtil;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

public class InterviewByServlet extends HttpServlet
{

    private Log log = SSBBus.getLog(this.getClass());
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor of the object.
     */
    public InterviewByServlet()
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
            String classpath = "";
            classpath = StoreUtil.getReflectObj(serviceid.trim());
            if (classpath == null || classpath.equals(""))
            {
                log.error("classpath为空，无法处理业务");
                response.sendError(CodeConstant.SC_HTTP_500, CodeConstant.HTTP_500);
            }
            try
            {
                Business business = (Business) Class.forName(classpath).newInstance();
                business.setHttpServletRequestForGet(request, response);
                business.execute();
            }
            catch (InstantiationException e)
            {
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            return;
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
