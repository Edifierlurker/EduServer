<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<%
    String webctx = request.getContextPath();
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires",   0);
%>
<head>

    <meta charset="utf-8"/>

    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=2.0"/>
    <title>彩票-双色球-购物车</title>
    <link rel="stylesheet" href="<%=webctx%>/css/lottery.css"/>
    <link rel="stylesheet" href="<%=webctx%>/css/lotterycart.css"/>
</head>
<body class="" id="notInWebView">
<noscript>
    <div id="noScript">请开启浏览器的Javascript功能，或使用支持javascript的浏览器访问</div>
</noscript>
<article class="docBody clearfix  ">
    <header id="header">
        <h1>双色球</h1>
        <%--<a href="javascript:;" cpurl="/t/award/ssq/" class="rightBox" rel="nofollow">往期开奖</a>--%>
        <a class="goBack " href="<%=webctx%>/pages/html/caipiao/ssq" target="_self" rel="nofollow">返回</a>
    </header>
    <div class="gameBanner hide">
        <span class="period"></span>
        <%--<span class="awardPool">奖池<span class="c_ba142b">5亿2111万</span>，可开出<span class="c_ba142b">104注</span>500万</span>--%>
    </div>
    <div class="btnBox" id="ctrl">
        <a href="javascript:;" class="GrayBtn" id="selfSelectBtn"><i class="add">+</i>手动选号</a>
        <a href="javascript:;" class="GrayBtn" id="randomBtn"><i class="add">+</i>机选一注</a>
        <a href="javascript:;" class="GrayBtn" id="clearBtn"><i class="recycle"><z></i>清空列表</a>
    </div>
    <section id="wrap">
        <div class="scroller">
            <div class="betBoxWrap" style="height: auto;">
                <%--<div class="pullHolder hide"><img src="http://pimg1.126.net/caipiao/wap/img/cart/hand.png"/></div>--%>
                <div class="betBox hide">
                    <dl class="numList ptNumList">
                    </dl>
                    <div class="pactTip">
                        <label>
                            <span class="disabledCheckbox"></span> 我已阅读并同意<a href="http://caipiao.163.com/t/rule.html">《委托投注规则》</a>
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <%--<div class="pullState">--%>
        <%--<img class="pullDown" src="http://pimg1.126.net/caipiao/wap/img/cart/pullDown.png" />--%>
        <%--<img class="pullUp hide" src="http://pimg1.126.net/caipiao/wap/img/cart/pullUp.png" />--%>
        <%--</div>--%>
        <div class="betResult">
            <a href="javascript:;" class="redBtn" id="payBtn">至少选择一注幸运号码</a>
        </div>
    </section>
    <div class="cartKeyboardOverlay hide"></div>
</article>
<div id="touchStrikeLayout"></div>
<script>window.setTimeout(function () {
    var l = document.getElementById("touchStrikeLayout");
    l && l.parentNode.removeChild(l)
}, 500);</script>
<script src="<%=webctx%>/js/jquery.min.js"></script>
<script src="<%=webctx%>/js/jquery.cookie.js"></script>
<script type="text/javascript">
    var caipiaoArr = new Array();
    var ballList = new Array();
    var ballCount = 0;
    var betCount = 0;

    function factorial(num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * arguments.callee(num - 1);
        }
    }


    function delBall(dd) {
        var index = $(dd).index();
        ballList.splice(index, 1);
        caipiaoArr.splice(index, 1);
        betCount -= parseInt($(dd).find(".type").attr("data-count"));
        $(dd).remove();
        if (betCount > 0) {
            $(".betResult").find("a").html('<span>立即付款</span>' + (2 * betCount) + '元');
        } else {
            $(".betResult").find("a").html('至少选择一注幸运号码');
        }
        $.cookieHelper('balls', caipiaoArr.join("#"),{expires:1,path:'/'});
    }

    function appendBall(red, blue,pos) {
        var redStr = red.replace(/,/g, " ");
        var blueStr = blue.replace(/,/g, " ");
        var redLen = red.split(",").length;
        var blueLen = blue.split(",").length;
        var moneyLen = factorial(redLen) / (factorial(6) * factorial(redLen - 6)) * blueLen;
        var money = 2 * moneyLen;
        var str = '<dd gid="' + (ballCount + 1) + '"><a pid="' + (ballCount + 1) + '" href="#del" class="roundDeleBtn"><i></i></a><span class="redNums">' + redStr + '</span>&nbsp;<span class="blueNums">' + blueStr + '</span><em class="type" data-count="' + moneyLen + '">' + (moneyLen == 1 ? "单式" : "复式" ) + '  ' + moneyLen + '注  ' + money + '元</em></dd>';
        if(pos == 'pre')
            ballList.unshift(str);
        else
            ballList.push(str);
        betCount += moneyLen;
        ballCount++;
    }

    function modifyBall() {

    }

    function showBallList() {
        var obj = $(".betBox");
        if (ballList.length > 0) {
            $(obj).attr("style", "display:block");
            $(".betResult").find("a").html('<span>立即付款</span>' + (2 * betCount) + '元');
            $(obj).find(".numList").html(ballList.join(""));
        }
    }

    function init() {
        var caipiao = $.cookieHelper('balls');
        var count = (caipiao == null ? "0" : caipiao.split("|").length - 1);
        if (parseInt(count) > 0) {
            caipiaoArr = caipiao.split("#");
        }
        for (var i = 0; i < caipiaoArr.length; i++) {
            var red = caipiaoArr[i].split("|")[0];
            var blue = caipiaoArr[i].split("|")[1];
            appendBall(red, blue);
        }
    }

    function clearAll() {
        if(betCount == 0) return;
        $("#notInWebView").append('<div class="iDialog iDialogNoTitle iDialogAlert" style="z-index: 1002; width: 22.91rem; margin-left: -275px; margin-top: -77.5px; top: 403px; left: 50%; visibility: visible;" id="iDialog1"><div class="iDialogContent"><div class="iDialogBody"><div class="iDialogMain">确定要清空选号？</div></div><div class="iDialogFoot"><a href="#" rel="0" class="iDialogBtn"><span>取消</span></a><a href="#" rel="1" class="iDialogBtn"><span>确定</span></a></div></div></div><div style="z-index: 1001;" class="iDialogLayout"></div>');
        $(".iDialogBtn").bind("click", function () {
            var obj = $(this);
            if (obj.attr("rel") == "0") {

            } else if (obj.attr("rel") == "1") {
                clearAllReal();
            }
            $(".iDialogBtn").unbind("click");
            $(this).parents("div.iDialog").remove();
            $("div.iDialogLayout").remove();
        })
    }

    function clearAllReal(){
        var obj = $(".betBox");
        if (ballList.length > 0) {
            caipiaoArr = new Array();
            ballList = new Array();
            ballCount = 0;
            betCount = 0;
            $(obj).removeAttr("style");
            $(".betResult").find("a").html('至少选择一注幸运号码');
            $(obj).find(".numList").html('');
            $.cookieHelper('balls', '');
        }
    }

    function randomBall(){
        var redarr = new Array();
        var redarr2 = new Array();
        var bluearr = new Array();
        var bluearr2 = new Array();
        for(var i=0 ;i<33;i++){
            redarr.push(i);
        }
        for(var i=0 ;i<6;i++){
            var t = Math.floor(Math.random() * redarr.length);
            redarr2.push((redarr[t]+1) <10?("0"+(redarr[t]+1)) :(redarr[t]+1) );
            redarr.splice(t,1);
        }

        for(var i=0 ;i<16;i++){
            bluearr.push(i);
        }
        var s = Math.floor(Math.random() * bluearr.length);
        bluearr2.push((bluearr[s] + 1) <10 ? ("0"+(bluearr[s] + 1)):(bluearr[s] + 1));
        bluearr.splice(s,1);
        redarr2.sort();
        var ball = redarr2.join(",")+"|"+bluearr2.join(",");
        caipiaoArr.unshift(ball);
        appendBall(redarr2.join(","),bluearr2.join(","),'pre');
        showBallList();
        $.cookieHelper('balls', caipiaoArr.join("#"),{expires:1,path:'/'});
    }

    function handBall(){
        window.location.href =  '<%=webctx%>/pages/html/caipiao/ssq';
    }

    $(document).ready(function () {
        init();
        showBallList();

        $.ajax({
            url: "<%=webctx%>/services/caipiao/issue?lottery=001",
            type: "POST",
            cache: false,
            dataType:"json",
            success: function (result) {
                if(result.code != 0 || result.lottery != "001")return;
                var obj = $(".gameBanner").removeClass("hide");
                obj.find(".period").text("第" + result.nextIssue + "期");
            },
            error: function (result) {
                $(".gameBanner").hide();
            }
        });

        $("body").on("click",".roundDeleBtn", function () {
            var obj = $(this);
            var dd = $(obj).parent();
            delBall(dd);
            return false;
        });

        $("body").on("click",".redBtn", function () {
            var obj = $(this);
            if(ballCount == 0){
                $("#notInWebView").append('<div class="iDialog iDialogNoTitle iDialogAlert" style="z-index: 1002; width: 22.91rem; margin-left: -275px; margin-top: -77.5px; top: 403px; left: 50%; visibility: visible;" id="iDialog1"><div class="iDialogContent"><div class="iDialogBody"><div class="iDialogMain">机选一注试试手气？</div></div><div class="iDialogFoot"><a href="#" rel="0" class="iDialogBtn"><span>取消</span></a><a href="#" rel="1" class="iDialogBtn"><span>确定</span></a></div></div></div><div style="z-index: 1001;" class="iDialogLayout"></div>');
                $(".iDialogBtn").bind("click", function () {
                    var obj = $(this);
                    if (obj.attr("rel") == "0") {

                    } else if (obj.attr("rel") == "1") {
                        randomBall();
                    }
                    $(".iDialogBtn").unbind("click");
                    $(this).parents("div.iDialog").remove();
                    $("div.iDialogLayout").remove();
                })
                return ;
            }

            window.location.href =  "<%=webctx%>/pages/html/caipiao/payconfirm?lottery=001";
            return false;
        });

        $(".GrayBtn").bind("click", function () {
            var obj = $(this);
            var id = obj.attr("id");
            if (id == 'clearBtn') {
                clearAll();
            }
            else if (id == 'selfSelectBtn') {
                handBall();
            }
            else if (id == 'randomBtn') {
                randomBall();
            }
        });

        $("body").on("click",'dl.numList dd', function () {
            var dd = $(this);
            var red = dd.find(".redNums").text();
            var blue = dd.find(".blueNums").text();
//            alert((red.replace(/ /g,',') +'|'+ blue.replace(/ /g,',')) +'&i='+dd.index());
            window.location.href = '<%=webctx%>/pages/html/caipiao/ssq?b=' + (red.replace(/ /g, ',') + '|' + blue.replace(/ /g, ',')) + '&i=' + dd.index();
            return false;
        });

    });
</script>
</body>
</html>
