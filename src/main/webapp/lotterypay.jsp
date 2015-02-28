<%@ page import="com.pinke.uni.lottery.common.GameErrors" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%
    String webctx = request.getContextPath();
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires",   0);
%>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=2.0"/>
    <meta name="keywords" content="付款"/>
    <meta name="description" content="付款"/>
    <title>付款-彩票</title>
    <script type="text/javascript"> window.__loadindStartTime = new Date();</script>

    <link rel="stylesheet" href="<%=webctx%>/css/lottery.css"/>
    <link rel="stylesheet" href="<%=webctx%>/css/lotterypay.css"/>
</head>
<body class="" id="notInWebView">
<noscript>
    <div id="noScript">请开启浏览器的Javascript功能，或使用支持javascript的浏览器访问</div>
</noscript>
<%
    String result = String.valueOf(request.getAttribute("result"));
    if((GameErrors.SUCCESS + "").equals(result)){
        Double money = request.getAttribute("money") == null ? 0.00 : Double.valueOf(request.getAttribute("money").toString())/100;

%>
<article class="docBody clearfix">
    <header id="header">
        <h1>支付</h1>
        <a class="goBack " href="<%=webctx%>/pages/html/caipiao/ssq" target="_self" rel="nofollow">返回</a>
    </header>
    <section class="gameName hide">
    </section>
    <section class="orderDetail">
        <dl>
            <dd>
                <span class="title">订单金额</span>
                <em class="sum orderMoney c_d80f2b" ordermoney="2"><%=money%>元</em>
            </dd>
            <dd class="payMoneyWrap">
                <span class="title">还需支付</span>
                <em class="sum payMoney"><%=money%>元</em>
            </dd>

        </dl>
    </section>
    <section class="payDetail ">
        <dl class="payWrap">
            <dt class="paytitle">选择支付方式</dt>
            <dd class="uniPay checked" data-payway="unipay"><i class="payIcon"></i><em class="checkIcon"></em>账户支付</dd>
            <dd class="aliPay" data-payway="alipay"><i class="payIcon"></i><em class="checkIcon"></em>支付宝支付</dd>
            <dd class="otherPay" data-payway="quickpay"><i class="payIcon"></i><em class="checkIcon"></em>银行卡及其他支付</dd>
        </dl>
    </section>
    <section class="btnBox">
        <a href="javascript:;" class="bigRedbtn" id="pay">立即支付</a>
        <input type="hidden" value='<%=request.getParameter("lottery")%>' id="lottery"/>
        <input type="hidden" value='' id="issue"/>
        <input type="hidden" value='<%=request.getAttribute("checkCode")%>' id="checkCode"/>
        <input type="hidden" value='<%=request.getAttribute("balllist")%>' id="balllist"/>
        <input type="hidden" value='<%=request.getAttribute("securepara")%>' id="securepara"/>
    </section>
</article>
<div id="touchStrikeLayout"></div>
<script>window.setTimeout(function () {
    var l = document.getElementById("touchStrikeLayout");
    l && l.parentNode.removeChild(l)
}, 500);</script>
</body>
<script src="<%=webctx%>/js/jquery.min.js"></script>
<script src="<%=webctx%>/js/jquery.cookie.js"></script>
<script type="text/javascript">

    $(document).ready(function () {
            $.ajax({
                url: "<%=webctx%>/services/caipiao/issue?lottery=<%=request.getParameter("lottery")%>",
                type: "POST",
                cache: false,
                dataType: "json",
                success: function (result) {
                    if (result.code != 0 || result.lottery != "<%=request.getParameter("lottery")%>")return;
                    var obj = $(".gameName").removeClass("hide");
                    obj.text(result.lotteryname + " 第" + result.nextIssue + "期");
                    $("#issue").val(result.nextIssue);
                },
                error: function (result) {
                    $(".gameName").removeClass("hide").addClass("hide");
                }
            });

            $(".checkIcon").bind("click",function () {
                var obj = $(this);
                if ($(obj).parent().hasClass("checked")) {
                    return;
                } else {
                    $(obj).parent().parent().find("dd").removeClass("checked");
                    $(obj).parent().addClass("checked");
                }
            })

            $("#pay").bind("click",function(){
                $("#notInWebView").append('<div class="iDialog iDialogNoTitle iDialogAlert" style="z-index: 1002; width: 22.91rem; margin-left: -275px; margin-top: -77.5px; top: 403px; left: 50%; visibility: visible;" id="iDialog1"><div class="iDialogContent"><div class="iDialogBody"><div class="iDialogMain">支付中...</div></div></div></div><div style="z-index: 1001;" class="iDialogLayout"></div>');
                var obj = $(this);
                var paytype = $(".checked").attr("data-payway");
                if(paytype == 'unipay'){
                    var parr = new Array();
                    $(".btnBox").find("input").each(function(index){
                        var obj = $(this);
                        parr.push(obj.attr("id")+"="+obj.val());
                    })
                    $.ajax({
                        url: "<%=webctx%>/services/caipiao/pay?rt="+Math.random(),
                        type: "POST",
                        data : parr.join("&"),
                        cache: false,
                        dataType: "json",
                        success: function (msg) {
                            alert(msg.result);
                            if(msg) {
                                if(msg.result == "0")
                                {
                                    window.location.href ="<%=webctx%>/pages/html/caipiao/success?lottery=<%=request.getParameter("lottery")%>&msg="+msg.result;
                                }else {
                                    window.location.href = "<%=webctx%>/paysuccess.jsp?lottery=<%=request.getParameter("lottery")%>";
                                }
                            }else{
                                window.location.href ="<%=webctx%>/pages/html/caipiao/fail?msg=-999";
                            }

                        },
                        error: function (a, b, c) {

                        }
                    });
                }
            });
     })
</script>

<%
    }else{
%>
<div>信息错误</div>
<%
    }
%>
</html>
