<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body style="width: 190px;">
<a href="<%=path %>/inputInDate.jsp" target="right">上传源数据</a>
<br/>
<a href="<%=path %>/inputOutDate.jsp" target="right">上传最终数据格式</a>
<br/>
<a href="<%=path %>/outputDate.jsp" target="right">导出</a>
<br/>
<a href="<%=basePath %>output/outputExcle.xls" target="right">下载文件</a>
<br/>
<br/>
<br/>
操作流程：
<br/>
1,先上传一个最终表，用于确定表的格式
<br/>
2,上传所有的源文件
<br/>
3,点击【处理数据】
4，点击【生成Excle文件】
5，点击【下载文件】可以下载
<br/>
注意：
<br/>
1,只是暂时的思路,后续会有更改
<br/>
2,只能读取xls文件，对xlsx文件不支持，如果是请转下格式
</body>
</html>
