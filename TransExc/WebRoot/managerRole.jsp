<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	
	<script type="text/javascript"><!--
		$(function(){
			$('#w').window('close');
			var all=$("#all");
			var un=$("#uncheck");
			var other=$("#othercheck");
			var allcheck=$("input:checkbox");
			all.click(function(){
				$("input:checkbox").attr("checked", true);
			});
			un.click(function(){
				$("input:checkbox").attr("checked", false);
			});
			other.click(function(){
				allcheck.each(function () {
                    $(this).attr("checked", !$(this).attr("checked"));
                });
			});
			
		});
		/*
		function 
		var allcheck=$("input:checkbox");
			alert(allcheck);
			$("input:checkbox").each(function(){
				$(this).attr("checked", false);
			});
		*/
		function add(){
			$('#cz').val('add');
			$('#num').val('');
			
			$('#w').window('close');
			$('#w').window({
				title:'添加'
			});
			$('#w').window('open');
		};
		function updtate(number,des,id){
			$('#cz').val('update');
			$('#id').val(id);
			$('#num').val(number);
			$('#des').val(des);
			
			$('#w').window('close');
			$('#w').window({
				title:'修改'
			});
			$('#w').window('open');
		};
	--></script>
	<style type="text/css">
	.role_list{
		font-size: 12px;
	}
	.role_list tr td input{
		float: left;
	}
	.role_list tr td span{
		float: left;
	}
	</style>

  </head>
  
  <body style="padding: 5px;">
  	
  	<div id="tt">
		<a href="javascript:void(0)" class="icon-add" onclick="add()"></a>
	</div>
	<div id="w" class="easyui-window" title="添加" data-options="iconCls:'icon-save'" style="width:500px;height:auto;padding:5px;">
		<form action="role!addOrUpdate" method="post">
			<input id="cz" name="cz" type="text" style="display: none;"/>
			<input id="id" name="role.id" type="text" style="display: none;"/>
			<div style="margin-bottom:20px">
				<div>角色名称:<font color="red">*</font></div>
				<input id="num" name="role.name" type="text" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>角色描述:</div>
				<input id="des" name="role.description" type="text" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:30px">
				<div>角色权限:</div>
				<div style="height: 200px;overflow: scroll;">
				<table id="role_table" width="100%" class="role_list">
					<c:forEach items="${pers}" var="per">
					<tr>
						<td>
							<input name="per${per.id }" type="checkbox" value="${per.id }"/>
							<span>(${per.id })${per.name }</span>
						</td>
					</tr>
					</c:forEach>
					<tr>
						<td>
							<input id="all" type="button" value="全选"/>
							<input id="uncheck" type="button" value="全不选"/>
							<input id="othercheck" type="button" value="反选"/>
						</td>
					</tr>
				</table>
				</div>
			</div>
			<div style="font-size: 10px;color: red;margin-bottom: 10px;width: 100%;">温馨提示：带“*”为必填项</div>
			<div>
				<input type="submit" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px" value="确认" onclick="return check()"/>
			</div>
		</form>
	</div>
	
	
  
	<div class="easyui-panel" title="角色管理" style="width:100%;padding:10px;height: auto;" data-options="tools:'#tt'"> 
		<form action="role!query" method="post">
		快速查询:
		<input name="name" class="easyui-textbox" data-options="prompt:'角色名称(不是必须填,可以只输部分)'" style="width:200px"/>
		<input class="easyui-linkbutton" type="submit" value="查询" style="padding: 5px;width: auto;"/>
		</form>
		<table width="100%" align="center" border="1" bordercolor="#D3D3D3" style="border-collapse:collapse;">
			<tr align="center" style="font-weight: bold;background-color: #E6E6E6;">
				<td style="padding: 5px;">角色名称</td>
				<td>角色描述</td>
				<td>角色权限</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${roles}" var="r">
			<tr align="center">
				<td>${r.name }</td>
				<td>${r.description }</td>
				<td style="width: 60%;font-size: 12px;text-align: left;padding-left: 10px;padding-right: 10px;">
					<c:forEach items="${r.rolePermissions}" var="rp" varStatus="status">
					(${rp.permission.id})${rp.permission.name}
					<c:if test="${fn:length(r.rolePermissions)>status.index+1}">
						,
					</c:if>
					</c:forEach>
				</td>
				<td>
					<a href="javascript:void(0)" onclick="updtate('${r.name}','${r.description }','${r.id }')" class="easyui-linkbutton" data-options="plain:true">修改</a>
					<a href="<%=path %>/role!delete?rid=${r.id}" class="easyui-linkbutton" data-options="plain:true">删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<div class="easyui-panel" style="padding: 3px;margin-top: 5px;">
			<a href="<%=path %>/role!query?pageOn=1&id=${id}&name=${name}" class="easyui-linkbutton" data-options="plain:true">首页</a>
			<c:choose> 
				<c:when test="${page.pageOn<=1}">
					<a href="<%=path %>/role!query?pageOn=${page.pageOn}&num=${u.num}&name=${u.name}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">上一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/role!query?pageOn=${page.pageOn-1}&num=${u.num}&name=${u.name}" class="easyui-linkbutton" data-options="plain:true">上一页</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.pageOn>=page.pageMax}">
					<a href="<%=path %>/role!query?pageOn=${page.pageOn}&num=${u.num}&name=${u.name}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">下一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/role!query?pageOn=${page.pageOn+1}&num=${u.num}&name=${u.name}" class="easyui-linkbutton" data-options="plain:true">下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="<%=path %>/role!query?pageOn=${page.pageMax}&num=${u.num}&name=${u.name}" class="easyui-linkbutton" data-options="plain:true">末页</a>
			<div style="float: right;margin-top:4px;">当前第${page.pageOn }页/总共${page.pageMax }页</div>
		</div>
	</div>
  </body>
</html>
