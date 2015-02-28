<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<%
    String webctx = request.getContextPath();
%>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=2.0"/>
    <meta charset="utf-8"/>
    <title>彩票</title>
    <link rel="stylesheet" type="text/css" href="<%=webctx%>/css/paysuccess.css"/>
</head>

<body>
<script>
    window.showDownClient = {
        'img': '',
        'url': ''
    };
</script>

<div class="main-wrap">
    <div class="tipCon">


        <div class="btnBox"><a href="<%=webctx%>/pages/html/caipiao" target="_self" class="greenBtn">返回彩票首页</a></div>
    </div>
</div>
<script src="<%=webctx%>/js/jquery.min.js"></script>
<script type="text/javascript">

    $(document).ready(function () {
        $.ajax({
            url: "<%=webctx%>/services/caipiao/issue?lottery=<%=request.getParameter("lottery")%>",
            type: "POST",
            cache: false,
            dataType: "json",
            success: function (result) {
                if (result.code != 0 || result.lottery != "<%=request.getParameter("lottery")%>")return;
                var str = '<span class="ico_right"></span><strong>恭喜您，购彩成功！</strong></p><p>预计开奖时间：<em>今天（01-15）'+result.endTime+'</em></p>';
                $(".tipCon").prepend(str);
            },
            error: function (result) {
            }
        });
    })
</script>
</body>

</html>