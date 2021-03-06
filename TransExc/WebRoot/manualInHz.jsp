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
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>
	
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/mycss.css">
	<script type="text/javascript" src="<%=path %>/js/myjs.js"></script>
	
	
	<script type="text/javascript">
		$(function(){
			$('#w').window('close');
		});
		function add(){
			$('#cz').val('add');
			$('#num').val('');
			$('#month').val('');
			$('#num').attr("readonly",false);
			$('#month').attr("readonly",false);
			$('#w').window('close');
			$('#w').window({
				title:'添加'
			});
			$('#w').window('open');
		};
		function updtate(number,month,id){
			$('#cz').val('update');
			$('#id').val(id);
			$('#num').val(number);
			$('#month').val(month);
			$('#num').attr("readonly",true);
			$('#month').attr("readonly",true);
			$('#w').window('close');
			$('#w').window({
				title:'修改'
			});
			$('#w').window('open');
		};
	</script>	
  </head>
  
<body style="padding: 5px;">

	<div id="tt">
		<a href="javascript:void(0)" class="icon-add" onclick="add()"></a>
	</div>
	<div id="w" class="easyui-window" title="添加" data-options="iconCls:'icon-save'" style="width:500px;height:auto;padding:5px;">
		<form action="manual!addOrUpdateHz" method="post">
			<input id="cz" name="cz" type="text" style="display: none;"/>
			<input id="id" name="id" type="text" style="display: none;"/>
			<div style="margin-bottom:20px">
				<div>产品号码:<font color="red">*</font></div>
				<input id="num" name="hz.equipmentNumber" type="text" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>产品名称:</div>
				<input name="hz.name" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>费用金额:</div>
				<input name="hz.cost" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>月份:<font color="red">*</font></div>
				<input id="month" name="hz.month" type="text" style="width:100%;height:32px">
			</div>
			<div style="font-size: 10px;color: red;margin-bottom: 10px;">温馨提示：带“*”为必填项</div>
			<div>
				<input type="submit" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px" value="确认" onclick="return check()"/>
			</div>
		</form>
	</div>



	<div class="easyui-panel" title="汇总数据" style="width:100%;padding:10px;height: auto;" data-options="tools:'#tt'">
		<form action="">
		快速查询:
		<select name="month">
			<c:forEach items="${hzs}" var="hz">
			<option value="${hz.month }">${hz.month}</option>
			</c:forEach>
		</select>
		+
		<input name="number" class="easyui-textbox" data-options="prompt:'设备号(不是必须填)'" style="width:200px"/>
		<input class="easyui-linkbutton" type="submit" value="查询" style="padding: 5px;width: auto;"/>
		</form>
		
		<table width="100%" align="center" border="1" bordercolor="#D3D3D3" style="border-collapse:collapse;">
			<tr align="center" style="font-weight: bold;background-color: #E6E6E6;">
				<td style="padding: 5px;">日期</td>
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
					<a href="javascript:void(0)" onclick="updtate('${hz.equipmentNumber}','${hz.month }','${hz.id }')" class="easyui-linkbutton" data-options="plain:true">修改</a>
					<a href="<%=path %>/manual!deleteHz?id=${hz.id}" class="easyui-linkbutton" data-options="plain:true">删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<div class="easyui-panel" style="padding: 3px;margin-top: 5px;">
			<a href="<%=path %>/manual!queryHz?pageOn=1&month=${month}" class="easyui-linkbutton" data-options="plain:true">首页</a>
			<c:choose>
				<c:when test="${page.pageOn<=1}">
					<a href="<%=path %>/manual!queryHz?pageOn=${page.pageOn}&month=${month}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">上一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/manual!queryHz?pageOn=${page.pageOn-1}&month=${month}" class="easyui-linkbutton" data-options="plain:true">上一页</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.pageOn>=page.pageMax}">
					<a href="<%=path %>/manual!queryHz?pageOn=${page.pageOn}&month=${month}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">下一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/manual!queryHz?pageOn=${page.pageOn+1}&month=${month}" class="easyui-linkbutton" data-options="plain:true">下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="<%=path %>/manual!queryHz?pageOn=${page.pageMax}&month=${month}" class="easyui-linkbutton" data-options="plain:true">末页</a>
			<div style="float: right;margin-top:4px;">当前第${page.pageOn }页/总共${page.pageMax }页</div>
		</div>
	</div>
</body>
</html>
