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
  
  
  	<div class="easyui-panel" title="导出数据与文件" style="width:600px;padding: 5px;">
	    <form action="file!outEndDate" method="post">
  		<table width="580px;" border="0" align="center">
  			<tr>
  				<td>请选择时间</td>
  				<td>
  					<input name="year" class="easyui-numberspinner" value="1" data-options="increment:1" style="width:120px;"/>年
	    			<input name="month" class="easyui-numberspinner" value="1" data-options="increment:1" style="width:120px;"/>月
  				</td>
  			</tr>
  			<tr>
	  			<td colspan="2"><input class="easyui-linkbutton" type="submit" value="处理数据" style="padding: 5px;width: 100%;margin-top: 15px;"/></td>
	  		</tr>
  		</table>
    	</form>
	    <form action="file!exportExc" method="post">
    	<table width="580px;" border="0" align="center">
    		<tr>
    			<td>
			    	<input class="easyui-linkbutton" type="submit" value="生成Excle文件" style="padding: 5px;width: 100%;"/></td>
    			</td>
    		</tr>
    		<tr>
    			<td style="padding-right: 12px;">
    				<a href="<%=basePath %>output/outputExcle.xls" target="right" class="easyui-linkbutton" style="width:100%;margin-top: 15px;">下载文件</a>
    			</td>
    		</tr>
    	</table>
	    </form>
  </body>
</html>
