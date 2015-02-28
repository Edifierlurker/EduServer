<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<%
    String  webctx = request.getContextPath();
%>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=2.0"/>
    <meta name="keywords" content="支付成功"/>
    <meta name="description" content="支付成功"/>
    <title>支付成功</title>
    <script type="text/javascript"> window.__loadindStartTime = new Date();</script>

    <link rel="stylesheet" href="http://pimg1.126.net/caipiao/wap/css/base.css?264829"/>
    <link rel="stylesheet" href="http://pimg1.126.net/caipiao/wap/css/user/lottery.css?264829"/>
</head>
<body class="" id="notInWebView">
<noscript><div id="noScript">请开启浏览器的Javascript功能，或使用支持javascript的浏览器访问</div></noscript>
<section class="docBody clearfix" >
    <header id="header">
        <h1>我的彩票</h1>
        <a href="javascript:;" cpurl="/t/identity/" class="rightBox" rel="nofollow">身份信息</a>
        <a class="goBack " href="javascript:;" cpurl="history" target="_self" rel="nofollow">返回</a>
    </header>
    <section class="topBox">
        <div class="myInfo">
            <div class="name"><i></i>happy***</div>
            <div class="amt ">
				<span class="left">
					<a href="/t/account/balance.html?backName=%E6%88%91%E7%9A%84%E5%BD%A9%E7%A5%A8">余额：0.00元<i class="rArrow"></i></a>
					<a href="https://epay.163.com/servlet/controller?operation=mActivateAccount&method=activateView" class="cplInfoLink nowrap">补全信息</a>
				</span>
                <a href="/t/coupon/?backName=%E6%88%91%E7%9A%84%E5%BD%A9%E7%A5%A8">红包：0个<i class="rArrow"></i></a>
            </div>
        </div>
        <div class="operBox">
            <a href="/t/coupon/buy.html?backName=%E6%88%91%E7%9A%84%E5%BD%A9%E7%A5%A8" class="hb">买红包</a><hr/>
            <a href="https://epay.163.com/servlet/controller?operation=mFillValueView&returnUrl=http%3A%2F%2Fcaipiao.163.com%2Ft%2Fmylottery%2F" class="cz">充值</a><hr/>
            <a href="https://epay.163.com/wap/drawcash/view.htm?from=caipiao" class="tx">提现</a>
        </div>
    </section>
    <section class="orderBox">
        <ul class="orderNav">
            <li class="active"><a href="javascript:;" data-type="1">全部订单</a></li>
            <li><a href="javascript:;" data-type="2">中奖订单</a></li>
        </ul>
        <div class="allList" style="display:none"><a id="seeMore" class="J_loading" href="javascript:;"></a></div>
        <div class="winList" style="display:none"><a id="seeMore" class="J_loading" href="javascript:;"></a></div>
    </section>
</section>
<div id="touchStrikeLayout"></div>
<script>window.setTimeout(function(){var l=document.getElementById("touchStrikeLayout");l&&l.parentNode.removeChild(l)},500);</script>
</body>
</html>
