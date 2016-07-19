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
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$('#w').window('close');
		});
		function updtate(num,pass,name){
			$('#num').val(num);
			$('#name').val(name);
			$('#pass').val(pass);
			$('#num').attr("readonly",true);
			$('#w').window('open');
		};
		function check(){
			var ban1=$('#name').val();
			var ban2=$('#pass').val();
			var str1=$.trim(ban1);
			var str2=$.trim(ban2);
			if((ban1!=undefined && str1=="") || (ban2!=undefined && str2=="")){
				alert("名称和密码不能为空！请重新输入！");
				return false;
			}else {
				return true;
			}	
		}
	</script>	
	<style type="text/css">
	tr td{
		text-align: center;	
	}
	</style>
	
  </head>
  
<body style="margin: 0px;padding: 5px;" >

	<div class="easyui-panel" title="个人中心" style="width:100%;height:100%;padding:10px;">
		<table width="400" align="center" border="0">
			<tr>
				<td width="40%">账号：</td>
				<td width="60%">${oneself.num }</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>${oneself.pass }</td>
			</tr>	
			<tr>
				<td>名字：</td>
				<td>${oneself.name }</td>
			</tr>
			<tr>
				<td>角色：</td>
				<td>${oneself.r.name }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a onclick="updtate('${oneself.num}','${oneself.pass }','${oneself.name }')" class="easyui-linkbutton" style="width: 100%;">修改个人基本信息</a>
				</td>
			</tr>
		</table>
	</div>
	
	
	<div id="w" class="easyui-window" title="修改个人基本信息" data-options="iconCls:'icon-save'" style="width:500px;height:auto;padding:5px;">
		<form action="center!update" method="post">
			<div style="margin-bottom:20px">
				<div>密码:</div>
				<input id="pass" name="oneself.pass" type="text" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>姓名:</div>
				<input id="name" name="oneself.name" type="text" style="width:100%;height:32px">
			</div>
			<div>
				<input type="submit" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px" value="确定" onclick="return check()"/>
			</div>
		</form>
	</div>
	
</body>
</html>
