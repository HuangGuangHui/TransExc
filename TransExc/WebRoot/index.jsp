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
	form{
		background-color: #E8FAFE;
		width: 100%;
		padding: 5px;
		border: 1px solid red;
	}
	</style>
  </head>
  
  <body>
    <form action="file!transtion" method="post" enctype="multipart/form-data">
    	<input name="files" type="file"/>
    	<br/>
    	<input name="year" type="number"/>年
    	<input name="month" type="number"/>月
    	<br/>
    	<input name="type" type="radio" value="来源"/>来源
    	<input name="type" type="radio" value="最终"/>最终
    	<br/>
    	<input type="submit" value="上传数据"/>
    </form>
    <form action="file!outEndDate" method="post">
    	<input name="year" type="number"/>年
    	<input name="month" type="number"/>月
    	<br/>
    	<input type="submit" value="处理数据"/>
    </form>
    <br/>
<pre>
操作流程：
1,先上传一个最终表，用于确定表的格式
2,上传所有的源文件
3,点击【处理数据】
注意：只是暂时的思路。




</pre>    
    
    
  </body>
</html>
