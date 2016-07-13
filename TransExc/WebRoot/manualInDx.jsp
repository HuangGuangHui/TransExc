<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  
<body>
	<script type="text/javascript">
		$(function(){
			$('#w').window('close');
		});
		function add(){
			$('#cz').val('add');
			$('#num').val('');
			$('#month').val('');
			$('#num').attr("readonly",false);
			$('#month').attr("readonly",false);
			$('#w').window('close');
			$('#w').window({
				title:'添加'
			});
			$('#w').window('open');
		};
		function updtate(number,month,id){
			$('#cz').val('update');
			$('#id').val(id);
			$('#num').val(number);
			$('#month').val(month);
			$('#num').attr("readonly",true);
			$('#month').attr("readonly",true);
			$('#w').window('close');
			$('#w').window({
				title:'修改'
			});
			$('#w').window('open');
		};
	</script>
	<div id="tt">
		<a href="javascript:void(0)" class="icon-add" onclick="add()"></a>
	</div>
	<div id="w" class="easyui-window" title="添加" data-options="iconCls:'icon-save'" style="width:500px;height:600px;padding:5px;">
		<form action="manual!addOrUpdateDx" method="post">
			<input id="cz" name="cz" type="text" style="display: none;"/>
			<input id="id" name="id" type="text" style="display: none;"/>
			<div style="margin-bottom:20px">
				<div>设备号:</div>
				<input id="num" name="dx.equipmentNumber" type="text" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>终端类型:</div>
				<input name="dx.type" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>套餐费	:</div>
				<input name="dx.costPackage" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>月基本费:</div>
				<input name="dx.costBase" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>本地话费:</div>
				<input name="dx.costLocal" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>长话费:</div>
				<input name="dx.costLong" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>数据费:</div>
				<input name="dx.costData" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>短信费:</div>
				<input name="dx.costShort" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>综合增值服务费:</div>
				<input name="dx.costComplex" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>其他费用:</div>
				<input name="dx.costOther" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>代收费:</div>
				<input name="dx.costInstead" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>优惠赠送:</div>
				<input name="dx.costPreferential" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>预付金支付:</div>
				<input name="dx.costAdvancePay" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>已付费用:</div>
				<input name="dx.costPaid" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>集团支付:</div>
				<input name="dx.costGroupPay" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>本期应付:</div>
				<input name="dx.costMustPay" class="easyui-textbox" style="width:100%;height:32px">
			</div>
			<div style="margin-bottom:20px">
				<div>月份:</div>
				<input id="month" name="dx.month" type="text" style="width:100%;height:32px">
			</div>
			<div>
				<input type="submit" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px" value="确认添加"/>
			</div>
		</form>
	</div>
	
	
	
	
	
	
	<div class="easyui-panel" title="电信数据" style="width:1600px;padding:10px;height: 450px;" data-options="tools:'#tt'">
		<form action="">
		快速查询:
		<select name="month">
			<c:forEach items="${dxs}" var="dx">
			<option value="${dx.month }">${dx.month}</option>
			</c:forEach>
		</select>
		+
		<input name="number" class="easyui-textbox" data-options="prompt:'设备号(不是必须填)'" style="width:200px"/>
		<input class="easyui-linkbutton" type="submit" value="查询" style="padding: 5px;width: auto;"/>
		</form>
		
		<table border="0" width="100%" align="center">
			<tr align="center" style="font-weight: bold;">
				<td>日期</td>
				<td>设备号</td>
				<td>终端类型</td>
				<td>套餐费</td>
				<td>月基本费</td>
				<td>本地话费</td>
				<td>长话费</td>
				<td>数据费</td>
				<td>短信费</td>
				<td>综合增值服务费</td>
				<td>其他费用</td>
				<td>代收费</td>
				<td>优惠赠送</td>
				<td>预付金支付</td>
				<td>已付费用</td>
				<td>集团支付</td>
				<td>本期应付</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${inDxs}" var="dx">
			<tr align="center">
				<td>${dx.month}</td>
				<td>${dx.equipmentNumber}</td>
				<td>${dx.type }</td>
				<td>${dx.costPackage}</td>
				<td>${dx.costBase}</td>
				<td>${dx.costLocal}</td>
				<td>${dx.costLong}</td>
				<td>${dx.costData}</td>
				<td>${dx.costShort}</td>
				<td>${dx.costComplex}</td>
				<td>${dx.costOther}</td>
				<td>${dx.costInstead}</td>
				<td>${dx.costPreferential}</td>
				<td>${dx.costAdvancePay}</td>
				<td>${dx.costPaid}</td>
				<td>${dx.costGroupPay}</td>
				<td>${dx.costMustPay}</td>
				<td>
					<a href="javascript:void(0)" onclick="updtate('${dx.equipmentNumber}','${dx.month }','${dx.id }')" class="easyui-linkbutton" data-options="plain:true">修改</a>
					<a href="<%=path %>/manual!deleteDx?id=${dx.id}" class="easyui-linkbutton" data-options="plain:true">删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<div class="easyui-panel" style="padding: 3px;width: 100%;">
			<a href="<%=path %>/manual!queryDx?pageOn=1&month=${month}" class="easyui-linkbutton" data-options="plain:true">首页</a>
			<c:choose>
				<c:when test="${page.pageOn<=1}">
					<a href="<%=path %>/manual!queryDx?pageOn=${page.pageOn}&month=${month}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">上一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/manual!queryDx?pageOn=${page.pageOn-1}&month=${month}" class="easyui-linkbutton" data-options="plain:true">上一页</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.pageOn>=page.pageMax}">
					<a href="<%=path %>/manual!queryDx?pageOn=${page.pageOn}&month=${month}" class="easyui-linkbutton" data-options="plain:true" style="background-color: #EAEAEA;color:#939393; ">下一页</a>
				</c:when>
				<c:otherwise>
					<a href="<%=path %>/manual!queryDx?pageOn=${page.pageOn+1}&month=${month}" class="easyui-linkbutton" data-options="plain:true">下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="<%=path %>/manual!queryDx?pageOn=${page.pageMax}&month=${month}" class="easyui-linkbutton" data-options="plain:true">末页</a>
			<div style="float: right;margin-top:4px;">当前第${page.pageOn }页/总共${page.pageMax }页</div>
		</div>
	</div>
</body>
</html>
