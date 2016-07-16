<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/myjs.js"></script>


  </head>
  
  <body style="padding: 5px;">
  	<div class="easyui-panel" title="添加模板" style="width:100%;padding:10px;height: auto;" data-options="tools:'#tt'">
  	<form action="model!add" method="post" enctype="multipart/form-data">
	<table width="580px;" border="0" align="center">
   		<tr>
   			<td>最终模板文件</td>
   			<td><input class="easyui-filebox" name="files" data-options="prompt:'请选择文件...',buttonText:'选择文件'" style="width:100%"/></td>
   		</tr>
   		<tr>
 			<td>模板名称</td>
  			<td>
 				 <input name="modelName" class="easyui-textbox" data-options="prompt:'请输入模板名称'" style="width:100%"/>			
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2"><input class="easyui-linkbutton" type="submit" value="确认添加" style="padding: 5px;width: 100%;margin-top: 15px;"/></td>
  		</tr>
	</table>
   	</form>
   	</div>
  </body>
</html>
