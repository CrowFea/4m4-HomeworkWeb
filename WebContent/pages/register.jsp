<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base herf="<%=basePath %>"> <!-- 链接到css样式  -->
	<meta charset="utf-8">
	<title>注册 - 同济大学作业网</title>
	<meta author="crowfea 刘思源">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/register-login.css">
</head>
	
<body>
<div id="box"></div>
<div class="cent-box register-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">四毛四</h1>
		<h2 class="sub-title">今天有DDL吗</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="<%=basePath %>/pages/Login.jsp">登录</a>
				<a href="<%=basePath %>/pages/register.jsp" class="active">注册</a>
				<div class="slide-bar slide-bar1"></div>				
			</div>
		</div>
		<form action = "<%=basePath %>/AddUserServlet" method = "POST">
		<div class="login form">
		
			<div class="group">
				
				
				<div class="group-ipt user">
					<input type="text" name="username" id="username" class="ipt" placeholder="请输入学号或工号" required>
				</div>
				<div class="group-ipt name">
					<input type="text" name="name" id="name" class="ipt" placeholder="请输入姓名" required>
				</div>
				<div class="group-ipt category">
					<input type="text" name="category" id="category" class="ipt" placeholder="请输入身份：教师  or 学生" required>
				</div>
				<div class="group-ipt school">
					<input type="text" name="school" id="school" class="ipt" placeholder="请输入学院" required>
				</div>
				
				<div class="group-ipt password">
					<input type="password" name="userpass" id="userpass" class="ipt" placeholder="设置登录密码" required>
				</div>
				<div class="group-ipt password1">
					<input type="password" name="userpass1" id="userpass1" class="ipt" placeholder="重复密码" required>
				</div>
				
			</div>
		</div>

		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">注册</button>
		</div>
		</form>
	</div>
</div>

<div class="footer">
	<p>四毛四</p>
	<p>Designed By crowfea 2019</p>
</div>

<script src='<%=basePath %>/js/particles.js' type="text/javascript"></script>
<script src='<%=basePath %>/js/background.js' type="text/javascript"></script>
<script src='<%=basePath %>/js/jquery.min.js' type="text/javascript"></script>
<script src='<%=basePath %>/js/layer/layer.js' type="text/javascript"></script>
<script src='<%=basePath %>/js/index.js' type="text/javascript"></script>
<script>
	$('.imgcode').hover(function(){
		layer.tips("看不清？点击更换", '.verify', {
        		time: 6000,
        		tips: [2, "#3c3c3c"]
    		})
	},function(){
		layer.closeAll('tips');
	}).click(function(){
		$(this).attr('src','http://zrong.me/home/index/imgcode?id=' + Math.random());
	})

	$(".login-btn").click(function(){
		var email = $("#email").val();
		var password = $("#password").val();
		var verify = $("#verify").val();
		// $.ajax({
		// url: 'http://www.zrong.me/home/index/userLogin',
		// type: 'post',
		// jsonp: 'jsonpcallback',
  //       jsonpCallback: "flightHandler",
		// async: false,
		// data: {
		// 	'email':email,
		// 	'password':password,
		// 	'verify':verify
		// },
		// success: function(data){
		// 	info = data.status;
		// 	layer.msg(info);
		// }
		// })

	})
	$("#remember-me").click(function(){
		var n = document.getElementById("remember-me").checked;
		if(n){
			$(".zt").show();
		}else{
			$(".zt").hide();
		}
	})
</script>
</body>
</html>