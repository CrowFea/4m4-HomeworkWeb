
<%@page import="com.crowfea.Clazz"%>
<%@page import="com.crowfea.ClazzDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>test</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script>
	</script>
  </head>
  <body>
 
  		 
	<% 
  		List<Clazz> clazzList = (List<Clazz>) request.getAttribute("clazzList");
  	%>

  		<h2 align = "center">课程列表</h2>
  	<table border = 1px align = "center">
  		<tr>
  			<th>课号</th>
  			<th>课程名称</th>
  			<th>老师名称</th>
  		</tr>
  		
  		<%
  			int i=0;
  		while(i<clazzList.size()){
  		
  				Clazz clazz =(Clazz) clazzList.get(i);%>
  				<tr>
  				<th><%=clazz.getClazzid() %></th>
  				<th><%=clazz.getClazzname()%></th>
  				<th><%=clazz.getTeaname()%></th>
  				</tr>
  				<%i++; %>
  			
  		<% }
  		 %>
		
		
  	
  	
  </body>
</html>