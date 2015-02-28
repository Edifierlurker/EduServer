package com.pinke.uni.mobile.protal.common.filter;

import com.pinke.uni.mobile.protal.common.CommonConstants;
import com.pinke.uni.mobile.protal.common.model.LoginUserInfo;
import org.apache.commons.collections.CollectionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 15-1-8.
 */
public class LoginFilter implements Filter {

    private Set<String> includePageService = new HashSet<String>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String paths = filterConfig.getInitParameter("includePageService");
        if(paths != null ) {
            String[] arr = paths.split(",");
            for(String s : arr){
                includePageService.add(s);
            }
        }

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        String uri = httpServletRequest.getRequestURI();
        String service = uri.substring(uri.lastIndexOf("/")+1);
        LoginUserInfo userInfo = (LoginUserInfo)session.getAttribute(CommonConstants.PAGE_LOGIN_USER);

        if(userInfo == null &&  includePageService.contains(service)){
            String str = httpServletRequest.getQueryString();
            request.setAttribute("rl",uri + (str == null ? "" : "?"+str));
            request.getRequestDispatcher("/jump.jsp").forward(request,response);
        }else{
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
