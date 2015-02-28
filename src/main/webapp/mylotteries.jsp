<%@ page import="com.pinke.uni.lottery.model.LotteryOrderRecord" %>
<%@ page import="org.apache.commons.collections.CollectionUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pinke.uni.lottery.common.GameConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<%
    String  webctx = request.getContextPath();
%>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=2.0"/>
    <meta name="keywords" content="我的彩票"/>
    <meta name="description" content="我的彩票"/>
    <title>我的彩票</title>
    <script type="text/javascript"> window.__loadindStartTime = new Date();</script>

    <link rel="stylesheet" href="http://pimg1.126.net/caipiao/wap/css/base.css?264829"/>
    <link rel="stylesheet" href="http://pimg1.126.net/caipiao/wap/css/user/lottery.css?264829"/>
</head>
<body class="" id="notInWebView">
<noscript><div id="noScript">请开启浏览器的Javascript功能，或使用支持javascript的浏览器访问</div></noscript>
<section class="docBody clearfix" >
    <header id="header">
        <h1>我的彩票</h1>
        <%--<a href="javascript:;" cpurl="/t/identity/" class="rightBox" rel="nofollow">身份信息</a>--%>
        <a class="goBack " href="<%=webctx%>/pages/html/caipiao" target="_self" rel="nofollow">返回</a>
    </header>
    <%--<section class="topBox">--%>
        <%--<div class="myInfo">--%>
            <%--<div class="name"><i></i>happy***</div>--%>
            <%--<div class="amt ">--%>
				<%--<span class="left">--%>
					<%--<a href="/t/account/balance.html?backName=%E6%88%91%E7%9A%84%E5%BD%A9%E7%A5%A8">余额：0.00元<i class="rArrow"></i></a>--%>
					<%--<a href="https://epay.163.com/servlet/controller?operation=mActivateAccount&method=activateView" class="cplInfoLink nowrap">补全信息</a>--%>
				<%--</span>--%>
                <%--<a href="/t/coupon/?backName=%E6%88%91%E7%9A%84%E5%BD%A9%E7%A5%A8">红包：0个<i class="rArrow"></i></a>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="operBox">--%>
            <%--<a href="/t/coupon/buy.html?backName=%E6%88%91%E7%9A%84%E5%BD%A9%E7%A5%A8" class="hb">买红包</a><hr/>--%>
            <%--<a href="https://epay.163.com/servlet/controller?operation=mFillValueView&returnUrl=http%3A%2F%2Fcaipiao.163.com%2Ft%2Fmylottery%2F" class="cz">充值</a><hr/>--%>
            <%--<a href="https://epay.163.com/wap/drawcash/view.htm?from=caipiao" class="tx">提现</a>--%>
        <%--</div>--%>
    <%--</section>--%>
    <section class="orderBox">
        <ul class="orderNav">
            <li class="active"><a href="javascript:;" data-type="1">全部订单</a></li>
            <li><a href="javascript:;" data-type="2">中奖订单</a></li>
        </ul>
        <%
            List<LotteryOrderRecord> orderlist = (List<LotteryOrderRecord>)request.getAttribute("orderlist");
            List<LotteryOrderRecord> winlist = (List<LotteryOrderRecord>)request.getAttribute("winlist");
        %>
        <div class="allList" <% if(CollectionUtils.isEmpty(orderlist)){%> style="display:none"<%}%>>
            <%
                if(CollectionUtils.isNotEmpty(orderlist)){
                    for(LotteryOrderRecord obj : orderlist){
            %>
            <a href="<%=webctx%>/pages/html/caipiao/orderinfo?oidx=<%=obj.getOrderindex()%>">
                <dl class="orderList">
                    <dt><%=GameConstants.LOTTERY.get(obj.getLtype())%></dt>
                    <dd>普通投注<br><%=Double.valueOf(obj.getPayfee())/100%>元</dd>
                    <dd class="status"><%=GameConstants.ORDER_STATUS.getName(obj.getStatus())%><i class="rightArrow"></i></dd>
                </dl>
            </a>
            <%
                    }
                }else{
            %>
            <a id="seeMore" class="J_loading" href="javascript:;">无相关记录信息！</a>
            <%
                }
            %>

            <a style="display: none;" id="seeMore" class="J_loading" href="javascript:;">加载中，请稍候...</a>
            </div>
        <div class="winList" style="display:none">
            <%
                if(CollectionUtils.isNotEmpty(winlist)){
                    for(LotteryOrderRecord obj : winlist){
            %>
            <a href="<%=webctx%>/pages/html/caipiao/orderinfo?oidx=<%=obj.getOrderindex()%>">
                <dl class="orderList">
                    <dt><%=GameConstants.LOTTERY.get(obj.getLtype())%></dt>
                    <dd>普通投注<br><%=Double.valueOf(obj.getPayfee())/100%>元</dd>
                    <dd class="status"><%=GameConstants.ORDER_STATUS.getName(obj.getStatus())%><i class="rightArrow"></i></dd>
                </dl>
            </a>
            <%
                    }
            }else{
            %>
            <a id="seeMore" class="J_loading" href="javascript:;">无相关记录信息！</a>
            <%
                }
            %>

        </div>
    </section>
</section>
<div id="touchStrikeLayout"></div>
<script>window.setTimeout(function(){var l=document.getElementById("touchStrikeLayout");l&&l.parentNode.removeChild(l)},500);</script>
<script src="<%=webctx%>/js/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".orderNav li").bind("click",function(){
            var obj = $(this);
            var dt = obj.find("a").attr("data-type");
            var div = $(".orderBox").find("div");
            $(div).eq(parseInt(dt)-1).removeAttr("style");
            $(div).eq(parseInt(dt)%2).attr("style","display:none");
            obj.removeClass("active").addClass("active");
            obj.siblings("li").removeClass("active")
        });
    })
</script>
</body>
</html>
