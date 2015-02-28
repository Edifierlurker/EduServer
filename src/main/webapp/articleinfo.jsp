<%@ page import="com.pinke.uni.mobile.protal.bbs.model.TArticleinfo" %>
<%@ page import="org.apache.commons.lang.time.DateFormatUtils" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.StringTokenizer" %>
<%@ page import="com.ericsson.cqtmsfw.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<%
    String webctx = request.getContextPath();
    String upload = "/upload/";
%>
<head>

    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=2.0"/>
    <title>文章详情</title>
</head>
<style type="text/css">
    * {
        padding: 0;
        margin: 0;
    }

    .title {
        padding: 20px 20px 0 20px;
    }

    .title p {
        font-size: 20px;
        color: #2d3e50;
    }

    .list-group {
        list-style: none;
    }

    .list-group hr {
        border: none;
        border-top: 1px solid #ccc;
        height: 0;
    }

    .list-group .wrap {
        height: 46px;
        margin-bottom: 25px;
        margin-top: 15px;
        margin-right: 20px;
    }

    .head-img {
        width: 46px;
        height: 46px;
        float: left;
        margin-left: 20px;
    }

    .head-img img {
        border-style: none;
        border-radius: 50px;
    }

    .zuozhe {
        height: 46px;
        padding-left: 80px;
        line-height: 25px;
    }

    .zuozhe h4 {
        color: #2d3e50;
        font-weight: 200;
        font-size: 16px;
    }

    .zuozhe h5 {
        color: #ababab;
        font-weight: 200;
        font-size: 16px;
    }

    .content {
        padding-left: 20px;
        padding-bottom: 25px;
        margin-right: 20px;
        text-align: justify;
        text-justify: inter-ideograph;
    }

    .content p {
        line-height: 1.5em;
        margin: 0 0 10px 0;
        font-size: 16px;
        color: #0e0e10;
    }

    .layer {
        float: right;
        margin-top: -38px;
    }

    .layer p {
        color: #aaacab;
    }
</style>
<body>

<%
    TArticleinfo articleinfo = (TArticleinfo) request.getAttribute("articleinfo");
    if (articleinfo != null) {
%>
<div class="title"><p><%=articleinfo.getArticletitle()%>
</p>
</div>

<div class="main">
    <ul class="list-group">
        <li class="list-group-item">
            <div class="wrap">
                <div class="head-img"><a href="#"><img src="<%=webctx+upload+articleinfo.getHeadpic()%>" width="46" height="46"/></a></div>
                <div class="zuozhe"><h4><%=articleinfo.getCreator() == null ? "火星人" :articleinfo.getCreator()%>
                </h4>
                    <h5><%=DateFormatUtils.format(new SimpleDateFormat("yyyyMMddHHmmss").parse(articleinfo.getCreatetime()), "MM-dd HH:mm")%>
                    </h5></div>
            </div>
            <div class="content">
                <%="<p>" + articleinfo.getArticledesc().replace("\n\r", "</p><p>").replace(" ", "&nbsp;") + "</p>"%>
                <%
                    String pics = articleinfo.getArticlepic();
                    if(pics != null){
                    StringTokenizer st = new StringTokenizer(pics, "|");
                    while (st.hasMoreElements()) {
                        String img = st.nextToken();
                        if (!StringUtils.isEmpty(img) ){ %><img src="<%=webctx + upload + img%>" width="150" height="150"/><%} } }%>
            </div>

        </li>
        <hr/>
    </ul>
</div>
<%
    }
%>
</body>
</html>
<script src="<%=webctx%>/js/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        <%
            if (articleinfo != null) {
        %>
        refreshCommentlist();
        <%
            }
        %>
    });

    function refreshCommentlist() {
        $(".list-group").eq(1).remove();
        $.ajax({
            url: "<%=webctx%>/pages/html/articlecommentlist?aid=<%=articleinfo == null ? "" : articleinfo.getArticleindex()%>",
            type: "POST",
            cache: false,
            success: function (result) {
                $(".main").append(result);
            },
            error: function (result) {
                $(".main").append(result);
            }
        });
    }

    function getNext(index) {
        $.ajax({
            url: "<%=webctx%>/pages/html/articlecommentlist?aid=<%=articleinfo == null ? "" : articleinfo.getArticleindex()%>&r="+index,
            type: "POST",
            cache: false,
            success: function (result) {
                $(result).insertBefore($(" .list-group-item").last());
                $(" .list-group-item").last().remove();
            },
            error: function (result) {
//                $(".main").append(result);
            }
        });
    }
</script>
