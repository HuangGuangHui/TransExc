<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link href="<%=path %>/css/mycss.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/myjs.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$('#w').window('close');
		});
		function add(){
			$('#cz').val('add');
			$('#num').val('');
			$('#num').attr("readonly",false);
			
			$("#key").focus(function(){
			}); 
			$("#key").change(function(){
			}); 
			
			$('#w').window('close');
			$('#w').window({
				title:'添加'
			});
			$('#w').window('open');
		};
		function updtate(number,key,id){
			$('#cz').val('update');
			$('#id').val(id);
			$('#num').val(number);
			
			$("#key").val(key); 
			$("#key").focus(function(){
				this.defaultIndex=this.selectedIndex;
			}); 
			$("#key").change(function(){
				this.selectedIndex=this.defaultIndex;
			}); 
			$('#num').attr("readonly",true);
			
			$('#w').window('close');
			$('#w').window({
				title:'修改'
			});
			$('#w').window('open');
		};
	</script>


  </head>
  
  <body style="padding: 5px;">
  	
  	<div id="tt">
		<a href="javascript:void(0)" class="icon-add" onclick="add()"></a>
	</div>
	<div id="w" class="easyui-window" title="添加" data-options="iconCls:'icon-save'" style="width:500px;height:auto;padding:5px;">
		<form action="model!addOrUpdateModel" method="post">
			<input id="cz" name="cz" type="text" style="display: none;"/>
			<input id="id" name="id" type="text" style="display: none;"/>
			<input id="nameKey" name="nameKey" type="text" style="display: none;"/>
			<div style="margin-bottom:20px">
				<div>项目号码:<font color="red">*</font></div>
				<input id="num" name="mod.equipmentNumber" type="text" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>类型:</div>
				<input name="mod.type" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>二级部门:</div>
				<input name="mod.department" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>备注:</div>
				<input name="mod.note" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>一级部门:</div>
				<input name="mod.firstDepartment" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>发票号码:</div>
				<input name="mod.invoice" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>模版:<font color="red">*</font>
					<select id="key" name="key">
						<c:forEach items="${models}" var="model">
						<option value="${model.modelNameKey }">${model.modelName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div style="font-size: 10px;color: red;margin-bottom: 10px;">温馨提示：带“*”为必填项</div>
			<div>
				<input type="submit" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px" value="确认" onclick="return check()"/>
			</div>
		</form>
	</div>
	
	
  
	<div class="easyui-panel" title="查看模版" style="width:100%;padding:10px;height: auto;" data-options="tools:'#tt'"> 
		<form action="model!query" method="post">
		请选择模版名称:
		<select name="mname">
			<c:forEach items="${models}" var="model">
			<option value="${model.modelNameKey }">${model.modelName}</option>
			</c:forEach>
		</select>
		<input class="easyui-linkbutton" type="submit" value="查询" style="padding: 5px;width: auto;"/>
		</form>
		<table width="100%" align="center" border="1" bordercolor="#D3D3D3" style="border-collapse:collapse;">
			<tr align="center" style="font-weight: bold;background-color: #E6E6E6;">
				<td style="padding: 5px;">模版名称</td>
				<td>类型</td>
				<td>二级部门</td>
				<td>备注</td>
				<td>项目号码</td>
				<td>一级部门</td>
				<td>发票号码</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${model}" var="mode">
			<tr align="center">
				<td>${mode.modelName}</td>
				<td>${mode.type }</td>
				<td>${mode.department}</td>
				<td>${mode.note}</td>
				<td>${mode.equipmentNumber}</td>
				<td>${mode.firstDepartment}</td>
				<td>${mode.invoice}</td>
				<td>
					<a href="javascript:void(0)" onclick="updtate('${mode.equipmentNumber}','${mode.modelNameKey }','${mode.id }')" class="easyui-linkbutton" data-options="plain:true">修改</a>
					<a href="<%=path %>/model!deleteFromId?id=${mode.id}" class="easyui-linkbutton" data-options="plain:true">删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<div class="easyui-panel" style="padding: 3px;margin-top: 5px;">
			<a href="<%=path %>/model!query?pageOn=1&mname=${mname}" class="easyui-linkbutton" data-options="plain:true">首页</a>
			<c:choose> 
				<c:when test="${page.pageOn<=1}">
					<a href="<%=path %>/model!query?pageOn=${page.pageOn}&mname=${mname}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">上一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/model!query?pageOn=${page.pageOn-1}&mname=${mname}" class="easyui-linkbutton" data-options="plain:true">上一页</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.pageOn>=page.pageMax}">
					<a href="<%=path %>/model!query?pageOn=${page.pageOn}&mname=${mname}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">下一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/model!query?pageOn=${page.pageOn+1}&mname=${mname}" class="easyui-linkbutton" data-options="plain:true">下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="<%=path %>/model!query?pageOn=${page.pageMax}&mname=${mname}" class="easyui-linkbutton" data-options="plain:true">末页</a>
			<div style="float: right;margin-top:4px;">当前第${page.pageOn }页/总共${page.pageMax }页</div>
		</div>
	</div>
  </body>
</html>
