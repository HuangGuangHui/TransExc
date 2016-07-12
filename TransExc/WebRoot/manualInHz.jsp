<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>

  </head>
  
<body>
	<div class="easyui-panel" title="汇总数据" style="width:1600px;padding:10px;height: 430px;">
		快速查询:<input class="easyui-searchbox" data-options="prompt:'请输入设备号查询'" style="width:300px"></input>
		<br/>
		<table border="0" width="100%" align="center">
			<tr align="center">
				<td>日期</td>
				<td>产品号码</td>
				<td>产品名称</td>
				<td>费用金额</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${inHzs}" var="hz">
			<tr align="center">
				<td>${hz.month}</td>
				<td>${hz.equipmentNumber}</td>
				<td>${hz.name }</td>
				<td>${hz.cost}</td>
				<td>
					<a href="#" class="easyui-linkbutton" data-options="plain:true">修改</a>
					<a href="#" class="easyui-linkbutton" data-options="plain:true">删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<div class="easyui-panel" style="padding: 3px;">
			<a href="<%=path %>/manual!queryHz?pageOn=1" class="easyui-linkbutton" data-options="plain:true">首页</a>
			<c:choose>
				<c:when test="${page.pageOn<=1}">
					<a href="<%=path %>/manual!queryHz?pageOn=${page.pageOn}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">上一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/manual!queryHz?pageOn=${page.pageOn-1}" class="easyui-linkbutton" data-options="plain:true">上一页</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.pageOn>=page.pageMax}">
					<a href="<%=path %>/manual!queryHz?pageOn=${page.pageOn}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">下一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/manual!queryHz?pageOn=${page.pageOn+1}" class="easyui-linkbutton" data-options="plain:true">下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="<%=path %>/manual!queryHz?pageOn=${page.pageMax}" class="easyui-linkbutton" data-options="plain:true">末页</a>
			<div style="float: right;margin-top:4px;">当前第${page.pageOn }页/总共${page.pageMax }页</div>
		</div>
	</div>
</body>
</html>
