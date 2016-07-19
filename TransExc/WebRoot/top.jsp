<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  
<body style="background-color: #F9BE00;margin: 0px;padding: 0px;" >
	<div style="margin-left: 30px;margin-top: 25px;">
		<img alt="" src="image/logo2.png" height="50" border="0"/>
	</div>
	<center style="margin-top: -52px;">
		<span style="color: #282828;font-size: 40px;font-weight: bold;font-family: Microsoft YaHei;">通讯费用管理系统</span>
	</center>
	<c:choose>
		<c:when test="${user==null}">
			<a href="login.jsp" target="_parent" style="font-size: 14px;font-weight: bold;color: red;float: right;margin-right: 30px;">登录</a>
			<span style="font-size: 14px;font-weight: bold;color: #0052A3;float: right;margin-right: 0px;">您还没有登录，请先</span>
		</c:when>
		<c:otherwise>
			<a href="login.jsp" target="_parent">
			<span style="font-size: 14px;font-weight: bold;color: #0052A3;float: right;margin-right: 30px;">${user.name }</span>
			<span style="font-size: 14px;font-weight: bold;color: red;float: right;margin-right: 10px;">${user.r.name}</span>
			</a>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>
