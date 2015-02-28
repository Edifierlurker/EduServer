<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<%
    String webctx = request.getContextPath();
    String upload = "/upload/";


%>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=2.0"/>
    <meta name="keywords" content="订单详情"/>
    <meta name="description" content="订单详情"/>
    <title>订单详情</title>
    <script type="text/javascript"> window.__loadindStartTime = new Date();</script>

    <link rel="stylesheet" href="<%=webctx%>/css/lottery.css"/>
    <link rel="stylesheet" href="<%=webctx%>/css/orderinfo.css"/>
</head>
<body class="" id="notInWebView">
<noscript><div id="noScript">请开启浏览器的Javascript功能，或使用支持javascript的浏览器访问</div></noscript>
<article class="docBody clearfix">
    <header id="header">
        <h1>订单详情</h1>
        <a class="goBack " href="javascript:;" cpurl="history" target="_self" rel="nofollow">返回</a>
    </header>
    <section class="orderBox">
        <h1>双色球 第2015006期</h1>
        <ul class="detailList">
            <li>订单号 ：2015011211CP95048629</li>
            <li>下单时间 ：2015-1-12 11:22:20</li>

            <li orderType="1" status="0">订单状态 ：等待付款            </li>
            <li>付款金额 ：2.00 元</li>

            <li>注数 ：1</li>

            </li>

        </ul>
        <ul class="detailList">
            <li>出票状态 ：未出票</li>
            <li><span class='c_ba2636'>02 06 09 12 16 26</span>:<span class='c_1e50c2'>07</span></li>
            <li>  1倍</li>
        </ul>
        <input type="hidden" value="02 06 09 12 16 26:07" id="stakeNumber">
        <input type="hidden" value="ssq" id="gameEn">
        <a class="bigRedbtn" href="/t/continuepay.html?orderId=2015011211CP95048629&orderType=1">立即付款</a>
    </section>
</article>
<div id="touchStrikeLayout"></div>
<script>window.setTimeout(function(){var l=document.getElementById("touchStrikeLayout");l&&l.parentNode.removeChild(l)},500);</script>
</body>
</html>
