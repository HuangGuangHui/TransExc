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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	</script>
	<style type="text/css">
	form{
		background-color: #E8FAFE;
		width: 100%;
		padding: 5px;
		border: 1px solid red;
	}
	</style>
  </head>
  
  <body>
    <form action="file!uploadInData" method="post" enctype="multipart/form-data">
    	<input name="files" type="file"/>
    	<br/>
    	<input name="year" type="number"/>年
    	<input name="month" type="number"/>月
    	<br/>
    	<input name="type" type="radio" value="电信"/>电信
    	<input name="type" type="radio" value="移动"/>移动
    	<br/>
    	<input type="submit" value="上传源数据"/>
    </form>
  </body>
</html>
