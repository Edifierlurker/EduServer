<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.pinke.uni.mobile.protal.bbs.model.TBulletin" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<!DOCTYPE html>
<html>
<%
    String webctx = request.getContextPath();
%>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>校园公告详情</title>
    <link href="<%=webctx%>/css/style-bulletin.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="<%=webctx%>/css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="<%=webctx%>/js/html5shiv.min.3.7.2.js"></script>
      <script src="<%=webctx%>/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body style="background-color:#ECF0F1;">
   <!-- /navbar start -->
   <nav class="navbar navbar-default " role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">
      	<img alt="back"src="<%=webctx%>/images/back.svg" width="18px">
      </a>
      <p class="navbar-text">公告详情</p>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">分享</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav><!-- /navbar end -->
<%
    TBulletin bulletin = (TBulletin)request.getAttribute("info");
   Date dt = new SimpleDateFormat("yyyyMMddHHmmss").parse(bulletin.getCreatetime());
       Calendar cl  = new GregorianCalendar();cl.setTime(dt);
%>
<!-- /详情 开始 -->
<div class="container">
<div class="row">
<div class="col-md-12">
<hr>
<h1><%=bulletin.getTheme()%></h1>
<h6><small><%=cl.get(Calendar.YEAR) + "-" + (cl.get(Calendar.MONTH) + 1) + "-" + cl.get(Calendar.DAY_OF_MONTH)%></small></h6>
<hr>
    <%="<p>"+bulletin.getContent().replace("\n\r","</p><p>").replace(" ","&nbsp;") + "</p>"%>

<%--
<p>该项目只要通过英语考试就能读硕士！只用两年的寒暑假，一边工作一边就能拿学位！不出国门，便能享受澳大利亚教授全英文授课!</p>
   <p> 报名截止日期：2012年6月30日；入学考试考前英语培训：2012年7月2日—9日；入学考试：2012年7月10日；首次面授上课时间：2012年7月13日—24日。</p>
   <p> 2012年报名截止日期将近，欢迎我校的教师和应届毕业生踊跃报名！</p>
<p>一、录取条件 </p>
　　<p>具有大学本科学历，所学专业不限；或大学专科学历（三年制），且具有二年以上与教育相关的工作经验；托福成绩550分以上（TWE4.5），或网考80分以上（写和说20分）；或雅思6.0以上（说和写6.0）。英语成绩两年内有效。</p>
<p>Donec id elit non mi porta gravida at eget metus. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>

<p>Donec ullamcorper nulla non metus auctor fringilla. Maecenas faucibus mollis interdum. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Maecenas sed diam eget risus varius blandit sit amet non magna. Donec id elit non mi porta gravida at eget metus.</p>

<p>Nullam quis risus eget urna mollis ornare vel eu leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Cras mattis consectetur purus sit amet fermentum.</p>
<p>该项目只要通过英语考试就能读硕士！只用两年的寒暑假，一边工作一边就能拿学位！不出国门，便能享受澳大利亚教授全英文授课!</p>
   <p> 报名截止日期：2012年6月30日；入学考试考前英语培训：2012年7月2日—9日；入学考试：2012年7月10日；首次面授上课时间：2012年7月13日—24日。</p>
   <p> 2012年报名截止日期将近，欢迎我校的教师和应届毕业生踊跃报名！</p>
<p>一、录取条件 </p>
　　<p>具有大学本科学历，所学专业不限；或大学专科学历（三年制），且具有二年以上与教育相关的工作经验；托福成绩550分以上（TWE4.5），或网考80分以上（写和说20分）；或雅思6.0以上（说和写6.0）。英语成绩两年内有效。</p>
<p>Donec id elit non mi porta gravida at eget metus. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>

<p>Donec ullamcorper nulla non metus auctor fringilla. Maecenas faucibus mollis interdum. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Maecenas sed diam eget risus varius blandit sit amet non magna. Donec id elit non mi porta gravida at eget metus.</p>

<p>Nullam quis risus eget urna mollis ornare vel eu leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Cras mattis consectetur purus sit amet fermentum.</p>
--%>

</div>
</div>
</div>





<!-- /详情 结束 -->
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=webctx%>/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=webctx%>/js/bootstrap.min.js"></script>
  </body>
</html>