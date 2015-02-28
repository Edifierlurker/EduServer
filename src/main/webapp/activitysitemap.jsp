<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=2.0"/>
    <style type="text/css">
        body, html,#l-map {width: 100%;height: 100%;overflow: hidden;hidden;margin:0;}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?type=quick&ak=rHqU7XgFQXBPH64sj4nPuG0V&v=1.0"></script>
    <title>显示地图</title>
</head>
<%
    String w = request.getParameter("w");
    String j = request.getParameter("j");

%>
<body>
<div id="l-map"></div>
</body>
</html>
<script type="text/javascript">
    var map = new BMap.Map("l-map");
    map.centerAndZoom(new BMap.Point('<%=j%>','<%=w%>'), 16);
    map.addControl(new BMap. ZoomControl ());
    var scaleControl=new BMap.ScaleControl();
    map.addControl(scaleControl);//添加比例尺控件
    var marker = new BMap.Marker(new BMap.Point('<%=j%>','<%=w%>'));        // 创建标注
    map.addOverlay(marker);
</script>