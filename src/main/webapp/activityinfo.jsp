<%@ page import="com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.apache.commons.lang.time.DateFormatUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width,initial-scale=0.7,minimum-scale=0.5,maximum-scale=1.0"/>
    <%
        String webctx = request.getContextPath();
        String upload = "/upload/";

        UserScheduleActivity detail = (UserScheduleActivity)request.getAttribute("info");

    %>
    <title><%=detail == null?"活动详情":detail.getActivitytitle()%></title>
</head>
<style type="text/css">
    *{padding:0;
        margin:0;}
    .container{min-width: 500px;
        width:expression(document.body.clientWidth < 500? "500px": "auto" ); }
    .bg-img{
        height:25em;
        background:url(../../images/37-120224093U055.jpg) center ;
        margin-bottom:2em;
        position:relative;
    }
    .inner{ width:100%;
        position:absolute;
        height:7em; bottom:0; left:0;
        /*IE*/
        background-color: rgb(0, 0, 0);
        filter: alpha(opacity=50);
        *zoom: 1;
        /*NO-IE*/
        background-color: rgba(0, 0, 0, .5);
        /*IE9*/
        background-color: #0009; background:url(../../images/bantouming.png) repeat;

    }
    .inner p{      color:#FFF;
        font-size:40px;
        margin-left:32px;
        margin-top:32px;
        position: relative;
        font-family:'微软雅黑',Arial, Helvetica, sans-serif;
    }

    .body{ width:70%;
        margin-top:2em;
        margin:0 auto;
    }
    .body-1{margin-left:32px;height:26px;line-height:26px;
    }

    .time{ height:26px;}
    .body .text{ vertical-align:middle;
        height:26px;
        line-height:26px;
        margin-left:46px;
        margin-top:-1.2em;
        font-size:21px;
        color:#9b9b99;
        font-family:'微软雅黑',Arial, Helvetica, sans-serif;
        padding:0;
    }
    .body-2{margin-left:32px;
        margin-top:25px;height:26px;
        line-height:26px; vertical-align:middle;
    }
    .location{ float:left;
    }
    .text2{ height:31px;
        line-height:31px;

        margin-left:21px;
        font-family:'微软雅黑',Arial, Helvetica, sans-serif;
        float:left;
    }
    a{
        text-decoration:none;}
    .button{ background:#34495e;
        width:70%;
        height:80px; border-radius:0.6em;
        -webkit-border-radius:0.6em;
        -moz-border-radius:0.6em;
        margin:0 auto;
        margin-top:2em;
        height:5em;
        width:70%;
        overflow:hidden;
    }
    .button img{border:none;}
    .body-3{ margin-left:32px; margin-top:1.5em; height:31px; line-height:31px; vertical-align:middle;}
    .row{ float:right; height:31px; line-height:31px; padding-top:4px; margin-right:25px;}
    .button .text2 p{
        font-size:26px;
        color:#FFF;
        font-family:'微软雅黑',Arial, Helvetica, sans-serif;
    }
    .content{margin:0 auto ;
        margin-top:2em;
        width:70%;
    }
    .content h2{ color:#4a4a4a;
        font-size:32px;
        font-family:'微软雅黑',Arial, Helvetica, sans-serif;
    }
    .content p{ margin-top:0.5em;
        font-size:24px;
        color:#4a4a48;
        text-align:justify;
        line-height:2em;
        font-family: '微软雅黑',Arial, Helvetica, sans-serif;
    }

</style>

<body>
<div class="container">

<%
    if(detail != null){

%>
<div class="bg-img"><div class="inner"><p><%=detail.getActivitytitle()%></p></div></div>

<div class="body">
    <div class="body-1">
            <div class="time"> <div class="img"><img src="<%=webctx%>/images/clock 2.png" width="25" height="25" /></div>
            <div class="text"><p><%=DateFormatUtils.format(new SimpleDateFormat("yyyyMMddHHmmss").parse(detail.getStarttime()), "MM-dd HH:mm")%>-<%=DateFormatUtils.format(new SimpleDateFormat("yyyyMMddHHmmss").parse(detail.getEndtime()), "MM-dd HH:mm")%></p></div></div>
    </div>
    <div class="body-2">
        <div class="bookmark"> <div class="img"><img src="<%=webctx%>/images/bookmark9.png" width="24" height="26" /></div>
            <div class="text"><p>发起人：<%=detail.getOriginatorName() == null ? "" : detail.getOriginatorName()%></p></div></div>
    </div>
</div>
<div class="button">
    <div class="body-3">
        <div class="location"><img src="<%=webctx%>/images/pinpoint 3.png" width="23" height="31"/></div>
        <div class="text2"><p><%=detail.getSite() == null ? "火星" : (detail.getSite().length() > 8 ?detail.getSite().substring(0,8) +"..." : detail.getSite()) %></p></div>
        <a href="javascript:;"> <div class="row"><img src="<%=webctx%>/images/row.png" width="15" height="25"  <% if(detail.getLatitude() != null && detail.getLongitude() != null){%>onclick="getPosition('<%=detail.getLatitude()%>','<%=detail.getLongitude()%>')" <%}%>/></div></a>
    </div>
</div>

<div class="content"><h2>活动介绍</h2>
    <%
        if(detail.getRecordurl() != null){
            %>
    <audio controls="controls">
        <source src="<%=webctx + detail.getRecordurl()%>" />
    </audio>
    <%
        }
    %>
    <%="<p>" + (detail.getContent() == null ? "" : detail.getContent().replace("\n\r", "</p><p>").replace(" ", "&nbsp;")) + "</p>"%>
</div>
<%
    }
%>
</div>
</body>
</html>
<script src="<%=webctx%>/js/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        <%
            if(detail != null){
        %>
        $(".bg-img").attr("style", "background:url(<%=webctx + upload + detail.getIconurl()%>) center repeat;");
        <%
         }else{
        %>
        $(".bg-img").attr("style", "background:url(../../images/37-120224093U055.jpg) center repeat;");
        <%
         }
        %>
    })
function getPosition(w,j){
    if(w == null || w =="null" || j == null || j =="null") return;
    window.location.href = '<%=webctx%>/activitysitemap.jsp?w='+w+'&j='+j;
}
</script>