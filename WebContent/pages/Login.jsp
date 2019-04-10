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
	<title>DDLhub</title>
	<meta name="keywords" content="作业提交" />
	<meta name="description" content="同济大学作业提交" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/register-login.css">
	<link rel="shortcut icon" href="<%=basePath %>/image/icon.ico"/>
</head>
</head>

<body>
<body>
<div id="box"></div>
<div class="cent-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">DDLhub</h1>
		<h2 class="sub-title">今天有DDL吗</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="<%=basePath %>/pages/Login.jsp" class="active">登录</a>
				<a href="<%=basePath %>/pages/register.jsp">注册</a>
				<div class="slide-bar"></div>				
			</div>
		</div>
		
		<form method="post" action="<%=basePath %>/LoginServlet">
		<div class="login form">
			<div class="group">
				<div class="group-ipt email">
					<input type="text" name="username" id="username" class="ipt" placeholder="用户名" required>
				</div>
				<div class="group-ipt password">
					<input type="password" name="userpass" id="userpass" class="ipt" placeholder="输入您的登录密码" required>
				</div>
				
			</div>
		
		</div>
		
		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">登录</button>
		</div>
		</form>
		<div class="remember clearfix">
			<label class="remember-me"><span class="icon"><span class="zt"></span></span><input type="checkbox" name="remember-me" id="remember-me" class="remember-mecheck" checked>记住我</label>
			<label class="forgot-password">
				<a href="#">忘记密码？</a>
			</label>
		</div>
	</div>
</div>

<div class="footer">
	<p>DDLhub</p>
	<p>Designed By crowfea 刘思源 2019</p>
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
	});
	$("#remember-me").click(function(){
		var n = document.getElementById("remember-me").checked;
		if(n){
			$(".zt").show();
		}else{
			$(".zt").hide();
		}
	});
</script>
</body>
</html>