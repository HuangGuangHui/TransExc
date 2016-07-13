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
    
    <title>My JSP 'modelQuery.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="<%=path %>/css/mycss.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/myjs.js"></script>


  </head>
  
  <body>
  	<CENTER>
  	<div style="padding:10px;text-align: center;font-size: 18px;">修改模板名称</div>
  	<form action="model!update" method="post">
  	<table width="500" border="0">
  		<tr>
  			<td>请选择模板</td>
  			<td>
  				<select name="mname">
					<c:forEach items="${models}" var="model">
					<option value="${model.modelNameKey }">${model.modelName}</option>
					</c:forEach>
				</select>
  			</td>
  		</tr>	
  		<tr>
  			<td>请输入新名称</td>
  			<td>
  				<input name="newName" class="easyui-textbox" data-options="prompt:'请输入新名称'" style="width:300px"/>
  			</td>
  		</tr>	
  		<tr>
  			<td colspan="2">
  				<input class="easyui-linkbutton" type="submit" value="确定修改" style="padding: 5px;width: 100%;margin-top: 15px;"/>
  			</td>
  		</tr>
  	</table>
  	</form>
  	</CENTER>
  </body>
</html>
