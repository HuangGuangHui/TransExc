<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>
	<style type="text/css">
	form{
		background-color: #E8FAFE;
		width: 100%;
		padding: 5px;
		border: 1px solid red;
	}
	</style>
  </head>
<frameset rows="100px,*" border="0">
	<frame name="top"  src="top.jsp" noresize="noresize"/>
	<frameset cols="200px,*" frameborder="yes">
		<frame name="left" src="left.jsp" noresize="noresize"/>
		<frameset rows="*,50px" frameborder="yes">
			<frame name="right" src="<%=path%>/file!gotoInputInDate" noresize="noresize"/>
			<frame name="bottom" src="bottom.jsp" noresize="noresize"/>
		</frameset> 
	</frameset>
</frameset>
</html>
