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
	<div class="easyui-panel" title="电信数据" style="width:1600px;padding:10px;height: 430px;">
		快速查询:<input class="easyui-searchbox" data-options="prompt:'请输入设备号查询'" style="width:300px"></input>
		<br/>
		<table border="0" width="100%" align="center">
			<tr align="center">
				<td>日期</td>
				<td>设备号</td>
				<td>终端类型</td>
				<td>套餐费</td>
				<td>月基本费</td>
				<td>本地话费</td>
				<td>长话费</td>
				<td>数据费</td>
				<td>短信费</td>
				<td>综合增值服务费</td>
				<td>其他费用</td>
				<td>代收费</td>
				<td>优惠赠送</td>
				<td>预付金支付</td>
				<td>已付费用</td>
				<td>集团支付</td>
				<td>本期应付</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${inDxs}" var="dx">
			<tr align="center">
				<td>${dx.month}</td>
				<td>${dx.equipmentNumber}</td>
				<td>${dx.type }</td>
				<td>${dx.costPackage}</td>
				<td>${dx.costBase}</td>
				<td>${dx.costLocal}</td>
				<td>${dx.costLong}</td>
				<td>${dx.costData}</td>
				<td>${dx.costShort}</td>
				<td>${dx.costComplex}</td>
				<td>${dx.costOther}</td>
				<td>${dx.costInstead}</td>
				<td>${dx.costPreferential}</td>
				<td>${dx.costAdvancePay}</td>
				<td>${dx.costPaid}</td>
				<td>${dx.costGroupPay}</td>
				<td>${dx.costMustPay}</td>
				<td>
					<a href="#" class="easyui-linkbutton" data-options="plain:true">修改</a>
					<a href="#" class="easyui-linkbutton" data-options="plain:true">删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<div class="easyui-panel" style="padding: 3px;">
			<a href="<%=path %>/manual!queryDx?pageOn=1" class="easyui-linkbutton" data-options="plain:true">首页</a>
			<c:choose>
				<c:when test="${page.pageOn<=1}">
					<a href="<%=path %>/manual!queryDx?pageOn=${page.pageOn}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">上一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/manual!queryDx?pageOn=${page.pageOn-1}" class="easyui-linkbutton" data-options="plain:true">上一页</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.pageOn>=page.pageMax}">
					<a href="<%=path %>/manual!queryDx?pageOn=${page.pageOn}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">下一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/manual!queryDx?pageOn=${page.pageOn+1}" class="easyui-linkbutton" data-options="plain:true">下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="<%=path %>/manual!queryDx?pageOn=${page.pageMax}" class="easyui-linkbutton" data-options="plain:true">末页</a>
			<div style="float: right;margin-top:4px;">当前第${page.pageOn }页/总共${page.pageMax }页</div>
		</div>
	</div>
</body>
</html>
