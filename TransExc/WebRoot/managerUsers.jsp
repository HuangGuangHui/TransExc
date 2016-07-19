<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modelQuery.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link href="<%=path %>/css/mycss.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/myjs.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$('#w').window('close');
		});
		function add(){
			$('#cz').val('add');
			$('#num').val('');
			$('#num').attr("readonly",false);
			$('#pass').val("");
			$('#name').val("");
			$('#w').window('close');
			$('#w').window({
				title:'添加'
			});
			$('#w').window('open');
		};
		function updtate(number,key,id,pass,name){
			$('#cz').val('update');
			$('#id').val(id);
			$('#num').val(number);
			$('#pass').val(pass);
			$('#name').val(name);
			$("#key").val(key); 
			$('#num').attr("readonly",true);
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
		<form action="users!addOrUpdate" method="post">
			<input id="cz" name="cz" type="text" style="display: none;"/>
			<input id="id" name="id" type="text" style="display: none;"/>
			<div style="margin-bottom:20px">
				<div>账号:<font color="red">*</font></div>
				<input id="num" name="user.num" type="text" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>密码:</div>
				<input id="pass" name="user.pass" type="text" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>姓名:</div>
				<input id="name" name="user.name" type="text" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>角色:<font color="red">*</font>
					<select id="key" name="user.role">
						<c:forEach items="${roles}" var="role">
						<option value="${role.id }">${role.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div style="font-size: 10px;color: red;margin-bottom: 10px;">温馨提示：带“*”为必填项</div>
			<div>
				<input type="submit" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px" value="确认" onclick="return check()"/>
			</div>
		</form>
	</div>
	
	
  
	<div class="easyui-panel" title="用户管理" style="width:100%;padding:10px;height: auto;" data-options="tools:'#tt'"> 
		<form action="users!query" method="post">
		快速查询:
		<select name="role">
			<c:forEach items="${roles}" var="role">
			<option value="${role.id }">${role.name}</option>
			</c:forEach>
		</select>
		+
		<input name="num" class="easyui-textbox" data-options="prompt:'账号(不是必须填,可以只输部分)'" style="width:200px"/>
		+
		<input name="name" class="easyui-textbox" data-options="prompt:'姓名(不是必须填,可以只输部分)'" style="width:200px"/>
		<input class="easyui-linkbutton" type="submit" value="查询" style="padding: 5px;width: auto;"/>
		</form>
		<table width="100%" align="center" border="1" bordercolor="#D3D3D3" style="border-collapse:collapse;">
			<tr align="center" style="font-weight: bold;background-color: #E6E6E6;">
				<td style="padding: 5px;">账号</td>
				<td>密码</td>
				<td>姓名</td>
				<td>角色</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${users}" var="u">
			<tr align="center">
				<td>${u.num}</td>
				<td>${u.pass }</td>
				<td>${u.name}</td>
				<td>${u.r.name}</td>
				<td>
					<a href="javascript:void(0)" onclick="updtate('${u.num}','${u.r.id}','${u.r.id}','${u.pass}','${u.name}')" class="easyui-linkbutton" data-options="plain:true">修改</a>
					<a href="<%=path %>/users!delete?n=${u.num}" class="easyui-linkbutton" data-options="plain:true">删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<div class="easyui-panel" style="padding: 3px;margin-top: 5px;">
			<a href="<%=path %>/users!query?pageOn=1&num=${num}&name=${name}&role=${role}" class="easyui-linkbutton" data-options="plain:true">首页</a>
			<c:choose> 
				<c:when test="${page.pageOn<=1}">
					<a href="<%=path %>/users!query?pageOn=${page.pageOn}&num=${num}&name=${name}&role=${role}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">上一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/users!query?pageOn=${page.pageOn-1}&num=${num}&name=${name}&role=${role}" class="easyui-linkbutton" data-options="plain:true">上一页</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.pageOn>=page.pageMax}">
					<a href="<%=path %>/users!query?pageOn=${page.pageOn}&num=${num}&name=${name}&role=${role}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">下一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/users!query?pageOn=${page.pageOn+1}&num=${num}&name=${name}&role=${role}" class="easyui-linkbutton" data-options="plain:true">下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="<%=path %>/users!query?pageOn=${page.pageMax}&num=${num}&name=${name}&role=${role}" class="easyui-linkbutton" data-options="plain:true">末页</a>
			<div style="float: right;margin-top:4px;">当前第${page.pageOn }页/总共${page.pageMax }页</div>
		</div>
	</div>
  </body>
</html>
