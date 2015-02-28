<%@ page import="com.zte.ssb.exportExcel.tableModel.TableDataInfo" %>
<%@ page import="com.pinke.uni.mobile.protal.bbs.model.TArticleinfoComment" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang.time.DateFormatUtils" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.apache.commons.lang.math.NumberUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String webctx = request.getContextPath();
    String upload = "/upload/";
%>

<ul class="list-group">
<%
    TableDataInfo pageData = (TableDataInfo) request.getAttribute("page");
    if (pageData != null) {
        int count = pageData.getTotalCount();
        List<TArticleinfoComment> list = pageData.getData();
        String rowStr = request.getParameter("r");
        int index = NumberUtils.isNumber(rowStr) ? Integer.valueOf(rowStr) : 0;;
        for (TArticleinfoComment obj : list) {
            index++;
%>

<li class="list-group-item">
    <div class="wrap">
        <div class="head-img"><a href="#"><img src="<%=webctx+ upload + obj.getArticletitle()%>" width="46"
                                               height="46"/></a></div>
        <div class="zuozhe"><h4><%=obj.getCommenter() == null ? "火星人" : obj.getCommenter()%>
        </h4>
            <h5><%=DateFormatUtils.format(new SimpleDateFormat("yyyyMMddHHmmss").parse(obj.getCreatetime()), "MM-dd HH:mm")%>
            </h5></div>
        <div class="layer"><p><%=index%>楼</p></div>
    </div>
    <div class="content">
        <%="<p>" + obj.getCommentdesc().replace("\n\r", "</p><p>").replace(" ", "&nbsp;") + "</p>"%>
    </div>
</li>
<hr/>
<%
    }
%>
<%
    if (count > index) {
%>
<li class="list-group-item">
    <div class="wrap"><h5 style="text-align: center" onclick="getNext('<%=index%>');">下一页</h5></div>
</li>
<%
    }
    }else{
%>
    <li class="list-group-item">没有评论！</li>
    <%
        }
    %>
    </ul>
