<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String  webctx = request.getContextPath();
    String redirect_url = request.getAttribute("rl") == null ? "" : request.getAttribute("rl").toString();
    System.out.println(redirect_url);
    response.sendRedirect(webctx + "/login.jsp?rl="+ URLEncoder.encode(redirect_url,"utf-8"));
%>