<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传源数据</title>
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
  	<div class="easyui-panel" title="上传源数据" style="width:600px;padding: 5px;">
    <form action="file!uploadInData" method="post" enctype="multipart/form-data">
  	<table width="580px;" border="0" align="center">
  		<tr>
  			<td>上传源数据文件</td>
  			<td><input class="easyui-filebox" name="files" data-options="prompt:'Choose a file...'" style="width:100%"/></td>
  		</tr>
  		<tr>
  			<td>时间</td>
  			<td>
 				<input name="year" class="easyui-numberspinner" value="${year }" data-options="increment:1" style="width:120px;"/>年
    			<input name="month" class="easyui-numberspinner" value="${month }" data-options="increment:1" style="width:120px;"/>月 			
  			</td>
  		</tr>
  		<tr>
  			<td>源数据类型</td>
  			<td>
	  			<input name="type" type="radio" value="电信" checked="checked"/>电信
		    	<input name="type" type="radio" value="移动"/>移动
		    	<input name="type" type="radio" value="汇总"/>汇总
    		</td>
  		</tr>
  		<tr>
  			<td colspan="2"><input class="easyui-linkbutton" type="submit" value="上传源数据" style="padding: 5px;width: 100%;margin-top: 15px;"/></td>
  		</tr>
  	</table>
    </form>
    </div>
  </body>
</html>
