<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>

  </head>
  
<body style="width: 200px;margin: 0px;padding: 0px;background-color: #E8FFFF;">

<div class="easyui-accordion" style="width:200px;height:300px;">
	<div title="上传数据与模板" data-options="iconCls:'icon-add'" style="overflow:auto;padding:10px;">
		<a href="<%=path %>/inputInDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%">上传源数据</a>
		<a href="<%=path %>/inputOutDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">上传最终模板</a>		
	</div>
	<div title="导出" data-options="iconCls:'icon-print'" style="padding:10px;">
		<a href="<%=path %>/outputDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%">导出数据与文件</a>
	</div>
	<div title="手动模式" data-options="iconCls:'icon-large-shapes'" style="padding:10px;">
		<a href="<%=path %>/outputDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%">手动调整电信表数据</a>
		<a href="<%=path %>/outputDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">手动调整移动表数据</a>
		<a href="<%=path %>/outputDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">手动调整汇总表数据</a>
		<a href="<%=path %>/outputDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">手动调整最终表数据</a>
	</div>
	<div title="模板管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
		<a href="<%=path %>/outputDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%">查看模板</a>
		<a href="<%=path %>/outputDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">添加模板</a>
		<a href="<%=path %>/outputDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">修改模板</a>
		<a href="<%=path %>/outputDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">删除模板</a>
	</div>
	<div title="使用说明和注意事项" data-options="iconCls:'icon-help'" style="padding:5px;">
		操作流程：
		<br/>
		1,依次上传所有的源文件
		<br/>
		2,上传最终数据的模板
		<br/>
		3,处理数据
		<br/>
		4,下载文件
		<br/>
		注意：
		<br/>
		1,只能读取xls文件，对xlsx文件不支持，如果是请转下格式
	</div>
</div>
</body>
</html>
