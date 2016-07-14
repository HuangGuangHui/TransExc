<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
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
	
	
	<c:if test="${isSuc}">
	<script type="text/javascript">
		alert("生成文件成功!");
	</script>
	</c:if>
	
  </head>
  
  <body>
  	<div class="easyui-panel" title="导出数据与文件" style="width:600px;padding: 5px;">
	    <form action="file!outEndDate" method="post">
  		<table width="580px;" border="0" align="center">
  			<tr>
  				<td>请选择时间</td>
  				<td>
  					<input name="year" class="easyui-numberspinner" value="${year }" data-options="increment:1" style="width:120px;" />年
	    			<input name="month" class="easyui-numberspinner" value="${month }" data-options="increment:1" style="width:120px;"/>月
  				</td>
  			</tr>
  			<tr>
	  			<td colspan="2"><input class="easyui-linkbutton" type="submit" value="处理数据" style="padding: 5px;width: 100%;margin-top: 15px;"/></td>
	  		</tr>
  		</table>
    	</form>
    	<form action="file!exportExc" method="post">
    		<input class="easyui-linkbutton" type="submit" value="生成文件" style="padding: 5px;width: 575px;margin-left: 7px;"/>
    	</form>
    	<table width="580px;" border="0" align="center">
    		<tr>
    			<td style="padding-right: 12px;">
    				<a href="<%=basePath %>output/outputExcle.xls" target="right" class="easyui-linkbutton" style="width:100%;">下载文件</a>
    			</td>
    		</tr>
    	</table>
    </div>
    <div class="easyui-panel" title="输出结果" style="width:600px;height:300px;padding: 5px;text-align: left;">
    	耗时：${cost_time }
    	<br/>
    	电信数据异常：${fn:length(errorInDxs)}
    	<br/>
    	<c:forEach items="${errorInDxs}" var="dx">
			设备号：${dx.equipmentNumber } | 金额：${dx.costMustPay }
			<br/>  	
    	</c:forEach>
    	移动数据异常：${fn:length(errorInYds)}
    	<br/>
    	<c:forEach items="${errorInYds}" var="yd">
			设备号：${yd.equipmentNumber } | 金额：${yd.costMustPay }
			<br/>  	
    	</c:forEach>
    	汇总数据异常：${fn:length(errorInHzs)}
    	<br/>
    	<c:forEach items="${errorInHzs}" var="hz">
			设备号：${hz.equipmentNumber } | 金额：${hz.cost }
			<br/>  	
    	</c:forEach>
    </div>
  </body>
</html>
