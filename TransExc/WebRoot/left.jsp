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
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/black/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>

  </head>
  
<body style="width: 200px;margin: 0px;padding: 0px;background-color: #3D3D3D;">

<div class="easyui-accordion" style="width:200px;height:auto;">
	<div title="数据上传" data-options="iconCls:'icon-add'" style="overflow:auto;padding:10px;">
		<a href="<%=path %>/file!gotoInputInDate" target="right" class="easyui-linkbutton c1" style="width:100%">上传源数据</a>
		<a href="<%=path %>/file!gotoInputOutDate" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">上传最终模版</a>		
	</div>
	<div title="数据导出" data-options="iconCls:'icon-print'" style="padding:10px;">
		<a href="<%=path %>/outputDate.jsp" target="right" class="easyui-linkbutton c1" style="width:100%">导出数据与文件</a>
	</div>
	<div title="数据编辑" data-options="iconCls:'icon-large-shapes'" style="padding:10px;">
		<a href="<%=path %>/manual!queryDx" target="right" class="easyui-linkbutton c1" style="width:100%">电信表数据编辑</a>
		<a href="<%=path %>/manual!queryYd" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">移动明细表数据编辑</a>
		<a href="<%=path %>/manual!queryHz" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">移动汇总表数据编辑</a>
		<a href="<%=path %>/manual!queryDetail" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">最终表数据编辑</a>
	</div>
	<div title="上传模版管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
		<a href="<%=path %>/model!query" target="right" class="easyui-linkbutton c1" style="width:100%">查看模版</a>
		<a href="<%=path %>/modelAdd.jsp" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">添加模版</a>
		<a href="<%=path %>/model!update" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">修改模版</a>
		<a href="<%=path %>/model!delete" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">删除模版</a>
	</div>
	<div title="系统管理" data-options="iconCls:'icon-system'" style="padding:10px;">
		<a href="<%=path %>/users!query" target="right" class="easyui-linkbutton c1" style="width:100%">用户管理</a>
		<a href="<%=path %>/role!query" target="right" class="easyui-linkbutton c1" style="width:100%;margin-top: 2px;">角色管理</a>
	</div>
	<div title="使用说明和注意事项" data-options="iconCls:'icon-help'" style="padding:5px;">
		操作流程：
		<br/>
		1.依次上传所有的源文件
		<br/>
		2.上传最终数据的模版或选择模版
		<br/>
		3.处理数据
		<br/>
		4.下载文件
		<br/>
		<br/>
		注意：
		<br/>
		1.只能读取xls文件，对xlsx文件不支持，解决办法：打开文件然后点击另存为，选择保存类型为xls保存即可。
		<br/>
		<br/>
		错误编号解释:
		<br/>
		691:用户未登录
		<br/>
		400:用户权限不够
		<br/>
		<br/>
		详细教程请下载<a href="<%=basePath %>office/office.pptx">韵达报表工具讲解.ppt</a>
	</div>
</div>
</body>
</html>
