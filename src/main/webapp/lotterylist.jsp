<%@ page import="com.pinke.uni.mobile.protal.common.CommonConstants" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="com.pinke.uni.mobile.protal.common.model.LoginUserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<%
    String webctx = request.getContextPath();
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + webctx + "/pages/html/caipiao";
%>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=2.0"/>
    <title>彩票首页</title>
    <script type="text/javascript"> window.__loadindStartTime = new Date();</script>
    <link rel="stylesheet" href="<%=webctx%>/css/lottery.css"/>
    <link rel="stylesheet" href="<%=webctx%>/css/lotterylogo.css"/>
</head>
<body class="" id="notInWebView">
<noscript>
    <div id="noScript">请开启浏览器的Javascript功能，或使用支持javascript的浏览器访问</div>
</noscript>
<article class="docBody clearfix">
    <header id="header">
        <h1>彩票首页</h1>
        <%
            Object obj = session.getAttribute(CommonConstants.PAGE_LOGIN_USER);
            if (obj == null) {
        %>
        <a href="<%=webctx + "/pages/html/tologin?rl=" + URLEncoder.encode(url,"utf-8")%>" class="rightBox"
           rel="nofollow">登录</a>
        <%
        } else {
        %>
        <a href="<%=webctx%>/pages/html/caipiao/mylottery" class="rightBox" rel="nofollow">我的彩票</a>
        <%
            }
        %>
    </header>
    <section class="hall">
        <a href="<%=webctx%>/pages/html/caipiao/ssq" class="hallLink">
            <dl class="hallList" id="ssq">
                <dt class="logo icon_ssq"></dt>
                <dd class="text">
                    <h2 class="title">
                        <span class="gameName">双色球</span>
                        <%--<em class="todaykj">今日开奖</em>--%>
                        <%--<em class="tip_jiajiang">5亿大派奖</em>--%>
                    </h2>
                    <%--<cite class="intro c_red">奖池：512,536,696元</cite>--%>
                    <%--<p class="timerBox" seconds1="9025070" seconds2="9205070" period="2015002">&nbsp;</p>--%>
                    <i class="rightArrow"></i>
                </dd>
            </dl>
        </a>
        <a href="<%=webctx%>/pages/html/caipiao/jsk3" class="hallLink">
            <dl class="hallList" id="oldkuai3">
                <dt class="logo icon_oldkuai3"></dt>
                <dd class="text">
                    <h2 class="title">
                        <span class="gameName">江苏快3</span>
                        <em class="tip_jiajiang">奖上奖</em>
                    </h2>
                    <cite class="intro ellipsis">人人都会玩的骰子游戏！好玩好赚<br>每天8:30~22:10销售</cite>
                    <i class="rightArrow"></i>
                </dd>
            </dl>
        </a>
        <a href="<%=webctx%>/pages/html/caipiao/dlt" class="hallLink">
            <dl class="hallList" id="dlt">
                <dt class="logo icon_dlt"></dt>
                <dd class="text">
                    <h2 class="title">
                        <span class="gameName">大乐透</span>
                    </h2>
                    <cite class="intro c_red">奖池：1,084,864,825元</cite>

                    <p class="timerBox" seconds1="95305068" seconds2="95605068" period="15002">&nbsp;</p>
                    <i class="rightArrow"></i>
                </dd>
            </dl>
        </a>
        <%
            if (obj != null) {
        %>
        <a href="<%=webctx%>/pages/html/caipiao/mylottery" class="hallLink">
            <dl class="hallList">
                <dt class="logo order"></dt>
                <dd class="text">
                    <h2 class="title">我的彩票</h2>
                    <cite class="intro">查看我购买的彩票</cite>
                    <i class="rightArrow"></i>
                </dd>
            </dl>
        </a>
        <%
            }
        %>
    </section>
    <div id="docFoot">
        <div id="loginNav">
            <a href="http://caipiao.163.com/t/coupon/buy.html">购买红包</a>
            <a href="http://caipiao.163.com/t/coupon/exchange.html">兑换红包</a>
            <a class="getBalance"
               href="https://epay.163.com/servlet/controller?operation=mFillValueView&returnUrl=http%3A%2F%2Fcaipiao.163.com%2Ft%2F">充值</a>
            <a href="https://epay.163.com/wap/drawcash/view.htm?from=caipiao&returnUrl=http%3A%2F%2Fcaipiao.163.com%2Ft%2Fmylottery%2F">提现</a>
        </div>

        <% if (obj != null) { %>
        <div class="exitNav clearfix">
		<span class="l_box">
			<a href="<%=webctx%>/pages/html/caipiao/mylottery"
               class="nickName ellipsis">欢迎您，<%=(((LoginUserInfo) obj).getNickname() == null ? ((LoginUserInfo) obj).getUseraccount() == null ? "" : ((LoginUserInfo) obj).getUseraccount() : ((LoginUserInfo) obj).getNickname())%>
            </a>
			<a class="exitLink" href="<%=webctx%>/pages/html/logout">退出登录</a>
		</span>
		<span class="r_box" id="gotoTop">
			<a href="#top" class="gotoTop">Top</a>
		</span>
        </div>
        <%}%>
        <p class="bottomLink"><em>触屏版</em>
            <a href="http://caipiao.163.com/m/toComputer.jsp">电脑版</a>
            <a id="clientGuide" href="http://caipiao.163.com/t/ntyyf.html?channel=wap">客户端</a>
        </p>

        <p class="copye">版权所有 &copy;2015-2016</p>
    </div>
    <!--abroad_notice-->
</article>
<div id="touchStrikeLayout"></div>
<script>window.setTimeout(function () {var l = document.getElementById("touchStrikeLayout"); l && l.parentNode.removeChild(l)}, 500);</script>
<script src="<%=webctx%>/js/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            url: '<%=webctx%>/services/caipiao/lotteries',
            type: 'POST',
            data: {},
            dataType: 'json',
            success: function (result) {

            },
            error: function (result) {

            }
        });
    })
</script>
</body>
</html>
