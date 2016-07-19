<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/mycss.css"/>
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/black/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>
	
	<script type="text/javascript" src="<%=path %>/jquery-cookie/jquery.cookie.js"></script>
	
	<script type="text/javascript" src="<%=path %>/js/myjs.js"></script>
	
  </head>
  
  <script type="text/javascript">
  $(function(){
  	$("#txt_username").addClass("input_blur");
  	$("#txt_password").addClass("input_blur");
  	if ($.cookie("rmbUser") == "true") {
	    $("#ck_rmbUser").attr("checked", true);
	    $("#txt_username").val($.cookie("username"));
	    $("#txt_password").val($.cookie("password"));
	};
  });
  
  function focus_name(){
  	if($("#txt_username").val()=="请输入账号"){
	  	$("#txt_username").val("");
	  	$("#txt_username").removeClass("input_blur");
	  	$("#txt_password").removeClass("input_blur");
	  	$("#txt_username").addClass("input_focus");
	  	$("#txt_password").addClass("input_focus");
	  	if($("#txt_password").val()=="请输入密码"){
	  		$("#txt_password").attr('type','password');
	  		$("#txt_password").val("");
	  	}
  	}
  }
  function focus_pass(){
  	if($("#txt_password").val()=="请输入密码"){
  		$("#txt_password").attr('type','password');
  		$("#txt_password").val("");
  		$("#txt_password").removeClass("input_blur");
  		$("#txt_password").addClass("input_focus");
  	}
  	
  	
  }
  function blur_name(){
  	if($.trim($("#txt_username").val())==""){
  		$("#txt_username").val("请输入账号");
  		$("#txt_username").removeClass("input_focus");
  		$("#txt_username").addClass("input_blur");
  		$("#txt_password").removeClass("input_focus");
  		$("#txt_password").addClass("input_blur");
  		if($("#txt_password").val()==""){
	  		$("#txt_password").attr('type','text');
	  		$("#txt_password").val("请输入密码");
	  	}
  	}
  }
  function blur_pass(){
  	if($("#txt_password").val()==""){
  		$("#txt_password").removeClass("input_focus");
  		$("#txt_password").addClass("input_blur");
  		$("#txt_password").attr('type','text');
  		$("#txt_password").val("请输入密码");
  	}
  }
  </script>
  
  
  
  
  <body bgcolor="#E6E6E6" style="padding: 0px;">
	<div class="easyui-layout" style="width: 100%;height: 100%;">
		<div region="north" border="false" class="p-search" style="background-color: #F9BE00;height: 250px;">
			<img class="login_logo" alt="" src="<%=path %>/image/logo2.png">
			<span class="login_text">通讯费用管理系统</span>
		</div>
		<div region="center" border="false" style="">
		</div>
	</div>
	
	<form action="<%=path %>/login!login" method="post" style="margin:0px;display: inline;">
	<div class="login_div">
		<div class="login_div1">
			<div style="height: 12px;"></div>
			<div class="login_div1_a">登录</div>
			<div style="height: 30px;"></div>
			<div class="login_div1_b">
				<center>
				<div class="login_input_div">
					<input name="num" id="txt_username" class="login_input" type="text" value="请输入账号" onfocus="focus_name()" onblur="blur_name()"/>
				</div>
				</center>
			</div>
			<div class="login_div1_b">
				<center>
				<div class="login_input_div">
					<input name="pass" id="txt_password" class="login_input" type="text" value="请输入密码" onfocus="focus_pass()" onblur="blur_pass()"/>
				</div>
				</center>
			</div>
			<div style="height: 40px;">
				<div style="height: 18px;"></div>
				<center>
				<div style="width: 250px;">
					<span style="float: left;">
						<input id="ck_rmbUser" type="checkbox" value="记住密码" style="float: left;"/><div style="width:auto;float: left;">记住密码</span>
					</span>
				</div>
				</center>
			</div>
			<div class="login_div1_b">
				<input type="submit" class="easyui-linkbutton" value="登  录" style="width: 250px;height: 40px;font-weight: bold;font-size: 16px;font-family: Microsoft YaHei;" onclick="return save()"/>
			</div> 
		</div>
	</div>
	</form>
	
	<img class="login_man" alt="" src="<%=path %>/image/man.png">
	<img class="login_lock" alt="" src="<%=path %>/image/lock.png">
	<!-- 这个是提示信息 -->
	<div class="login_hint">${hint }</div>
  </body>
</html>
