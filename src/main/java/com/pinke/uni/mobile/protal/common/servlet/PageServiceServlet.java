package com.pinke.uni.mobile.protal.common.servlet;

import com.pinke.uni.mobile.protal.common.model.PageService;
import com.pinke.uni.mobile.protal.common.model.ResultType;
import com.pinke.uni.mobile.protal.common.page.handle.HandleFactory;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageServiceServlet extends HttpServlet {
    private static Log log = SSBBus.getLog(PageServiceServlet.class);
    private static final long serialVersionUID = 3382908901985009755L;
    private static final String NOT_FOUND_PAGE = "/WEB-INF/page/404.jsp";
    private static final String ERROR_PAGE = "/WEB-INF/page/500.jsp";
    private static Map<String, PageService> config = new HashMap<String, PageService>();

    static {
        try {
            System.out.println("***************************page service init beginning*********************************");
            Document document = new SAXBuilder().build(PageServiceServlet.class.getResourceAsStream("/page_service_config.xml"));
            Element el = document.getRootElement();
            Element services = el.getChild("services");
            if (services != null) {
                List<Element> list = services.getChildren("service");
                for (Element service : list) {
                    PageService pageService = new PageService();
                    String name = service.getAttribute("name").getValue();
                    pageService.setServicename(name);
                    String dataType = service.getAttribute("dataType").getValue();
                    if(dataType == null)
                        throw new IOException("dataType is not a json ,xml ,html or text type!");
                    pageService.setDatatype(ResultType.valueOf(dataType.toUpperCase()));
                    pageService.setClasspath(service.getChildText("classname"));
                    pageService.setPage(service.getChildText("page"));
                    config.put(name, pageService);
                }
                HandleFactory.getInstance().setPageServiceMap(config);
            }
        } catch (JDOMException e) {
            e.printStackTrace();
            log.error("page_service_config.xml load error!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        log.info("proccess handle begin !");
        IPageServiceHandle bus = busHandle(request, response);
        log.info("proccess handle end !");
        if(bus == null) {
            request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
        }
        else{
            PageService ps = bus.getPageService();
            response.setCharacterEncoding("UTF-8");
            String result = bus.result();
            switch(ps.getDatatype()) {
                case HTML: ;request.getRequestDispatcher(ps.getPage()).forward(request, response);
                    break;
                case JSON :if(result != null ) {response.setContentType("application/json;charset=UTF-8");response.getWriter().write(result);response.getWriter().close();}break;
                case TEXT: if(result != null ) {response.setContentType("text/plain;charset=UTF-8");response.getWriter().write(result);response.getWriter().close();}break;
                case XML : if(result != null ) {response.setContentType("text/xml;charset=UTF-8");response.getWriter().write(result);response.getWriter().close();}break;
                case NULL : break;
                default:
                    request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
            }
        }

    }

    private IPageServiceHandle busHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IPageServiceHandle handle = HandleFactory.getInstance().getHandleInstance(getPageKeyFromURI(request));
        log.info("handle class is " + handle.getClass().getName());
        return handle.proccess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private String getPageKeyFromURI(HttpServletRequest request) {
        String path = request.getRequestURI();
        String key = StringUtils.substringAfter(path, "/pages/html/").trim();
        if(StringUtils.isEmpty(key))
            key = StringUtils.substringAfter(path, "/services/").trim();
        if(StringUtils.isEmpty(key))
            key = StringUtils.substringAfter(path, "/caipiao/").trim();
        return key;
    }

}
