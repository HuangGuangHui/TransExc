<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传最终数据</title>
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
    <div class="easyui-tabs" style="width:600px;height: 170px;">
    	<div title="上传最终模板" style="padding:10px">
    		<form action="file!uploadOutData" method="post" enctype="multipart/form-data">
	  		<table width="580px;" border="0" align="center">
	    		<tr>
	    			<td>最终模板文件</td>
	    			<td><input name="files" class="easyui-filebox" data-options="prompt:'Choose a file...'" style="width:100%"/></td>
	    		</tr>
	    		<tr>
		  			<td>时间</td>
		  			<td>
		 				<input name="year" class="easyui-numberspinner" value="${year }" data-options="increment:1" style="width:120px;"/>年
		    			<input name="month" class="easyui-numberspinner" value="${month }" data-options="increment:1" style="width:120px;"/>月 			
		  			</td>
		  		</tr>
		  		<tr>
		  			<td colspan="2"><input class="easyui-linkbutton" type="submit" value="上传最终数据" style="padding: 5px;width: 100%;margin-top: 15px;"/></td>
		  		</tr>
	  		</table>
	    	</form>
    	</div>
    	<div title="选择最终模板" style="padding:10px">
    		<form action="file!selectModel" method="post">
    		<table width="580px;" border="0" align="center">
    			<tr>
    				<td>选择一个模板</td>
    				<td>
    					<select name="mname">
    						<c:forEach items="${modelNames}" var="name">
    							<option value="${name }">${name }</option>
    						</c:forEach>
    					</select>
    				</td>
    			</tr>
    			<tr>
		  			<td>时间</td>
		  			<td>
		 				<input name="year" class="easyui-numberspinner" value="${year }" data-options="increment:1" style="width:120px;"/>年
		    			<input name="month" class="easyui-numberspinner" value="${month }" data-options="increment:1" style="width:120px;"/>月 			
		  			</td>
		  		</tr>
    			<tr>
    				<td colspan="2"> 
    					<input class="easyui-linkbutton" type="submit" value="确定选择" style="padding: 5px;width: 100%;margin-top: 15px;"/>
    				</td>
    			</tr>
    		</table>
    		</form>
		</div>
    </div>
  </body>
</html>
