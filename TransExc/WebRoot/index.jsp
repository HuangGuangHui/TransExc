<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
	#f1{
		background-color: gray;
		width: 200px;
		text-align: center;
		padding: 20px;
	}
	</style>
  </head>
  
  <body>
    This is my JSP page. <br>
    <form action="file!transtion" method="post" enctype="multipart/form-data">
    	<input name="files" type="file"/>
    	<br/>
    	<input name="year" type="number"/>年
    	<input name="month" type="number"/>月
    	<br/>
    	<input name="type" type="radio" value="来源"/>来源
    	<input name="type" type="radio" value="最终"/>最终
    	<input type="submit"/>
    </form>
  </body>
</html>
