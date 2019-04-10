<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.crowfea.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>

<html lang="en">
<head>
<base herf="<%=basePath %>"> <!-- 链接到css样式  -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>login</title>
	
	<meta name="viewport" content="width=device-width, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">

	<style>
	.div{
		background-image: url(/image/LBG.png); 
		background-size: cover;
		margin: 0px;
		overflow: hidden;
		position: absolute;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		text-align: center
		}
	a{color: red;}
		
	.div img {position: relative;z-index: 1001;width:400px;margin-top: 100px}
	</style>
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/login.css"/>
    <script type="text/javascript" src="<%=basePath %>/js/login.js"></script>

</head>
 
<body style="background:url(image/LBG.png) ;background-size:cover; ">

<div id="login_frame">
		<form method="post" action="LoginServlet">

			<p><input name="username" placeholder="   请输入用户名..." type="text" style="border-radius:20px;" id="username" class="text_field" required/></p>
		
			<p><input  name="userpass" placeholder="   请输入密码..." type="text" style="border-radius:20px;" id="password" class="text_field" required/></p>

			<div id="login_control">
				<input type="submit" id="btn_login" value="登录"  />
				<input type="button" id="btn_register" value="注册" onclick = "window.location.href = 'pages/register.jsp'"/>
				<a id="forget_pwd" href="forget_pwd.html">忘记密码？</a>
			</div>
		</form>
	</div>
 
</body>
</html>