<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<%
    String  webctx = request.getContextPath();
    String redirect_url = request.getParameter("rl") == null ? "" : URLDecoder.decode(request.getParameter("rl").toString(),"utf-8");
%>
<head>
    <meta name="keywords" content="登录"/>
    <meta name="description" content="登录"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=2.0"/>
    <title>登录-彩票</title>
    <script type="text/javascript"> window.__loadindStartTime = new Date();</script>

    <link rel="stylesheet" href="<%=webctx%>/css/lottery.css"/>
    <link rel="stylesheet" href="<%=webctx%>/css/login.css"/>
</head>
<body class="" id="notInWebView">
<noscript><div id="noScript">请开启浏览器的Javascript功能，或使用支持javascript的浏览器访问</div></noscript>
<div id="loading">处理中，请稍候</div>
<article class="docBody clearfix">
    <header id="header">
        <h1>登录</h1>
        <a class="goBack " href="javascript:window.history.go(-1);" target="_self" rel="nofollow">返回</a>
    </header>
    <section class="loginBox"><form id="loginHolderForm"><input type="submit" value="login" class="hide3"/>
        <dl>
            <dd class="userNameSelectBox">
                <label>账户</label>
                <div class="inputWrap">
                    <input type="text" value="" placeholder="账号/手机号" id="userName" class="imitateSelect quickDelInput">
                </div>
                <span class="optionList"></span>
            </dd>
            <dd>
                <label>密码</label>
                <div class="inputWrap">
                    <input type="password" value="" id="password" class="quickDelInput"/>
                </div>
            </dd>
            <dd><p class="errorTip"></p></dd>
        </dl></form>
    </section>
    <section class="btnBox">
    <p><a href="javascript:;" class="bigRedbtn" id="loginBtn">登&nbsp;录</a></p>
</section>
    <%--<section class="otherLogin">--%>
        <%--<p><b>其他方式登录：</b><a href="javascript:;" id="qqLogin"></a></p>--%>
    <%--</section>--%>
    <%--<div id="entrySpaceHolder"></div>--%>
    <%--<section class="bottomBox clearfix hide3">--%>
        <%--<a class="left" href="http://reg.163.com/reg/reg_mob2_retake_pw.jsp">忘记密码?</a>--%>
        <%--<a id="regLink" class="right" href="http://reg.163.com/reg/reg_mob.jsp?product=caipiao&url=http%3A%2F%2Fcaipiao.163.com%2Ft%2F&loginurl=http%3A%2F%2Fcaipiao.163.com%2Ft%2Flogin.html">注册</a>--%>
    <%--</section>--%>
</article>
<div id="touchStrikeLayout"></div>
<script>window.setTimeout(function(){var l=document.getElementById("touchStrikeLayout");l&&l.parentNode.removeChild(l)},500);</script>
</body>
</html>
<script src="<%=webctx%>/js/jquery.min.js"></script>
<script src="<%=webctx%>/js/md5.js"></script>
<script type="text/javascript">
    $(document).ready(function (){
        $("#loginBtn").bind("click",function(){
            var username = $("#userName").val().trim();
            var password = hex_md5($("#password").val().trim()).toLowerCase();
            if(username.trim() == "" || password.trim() == "") return;
            $.ajax({
                url: "<%=webctx%>/pages/html/login",
                type: "POST",
                data: {"userCode":username,"password":password},
                cache: false,
                dataType:"json",
                success: function (obj) {
                    if(obj.result != "0") {
                        var tip = $(".errorTip");
                        tip.show();
                        tip.text(obj.desc);
                    }else{
                        window.location.href = "<%=redirect_url %>";
                    }
                },
                error: function (obj) {
                    var tip = $(".errorTip");
                    tip.show();
                    tip.text("登录失败");
                }
            })

        });


    })
</script>
