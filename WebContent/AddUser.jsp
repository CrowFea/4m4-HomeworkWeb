 <%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"         "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>添加用户页面</title>
    </head>
    <body>
    <form action = "AddUserServlet" method = "POST">
    用户名:<input type = "text" name = "username">
    密码:<input type = "password" name = "userpass">
    <input type = "submit" value = "注册">
    <input type = "reset" value = "重置">
    </form>
    </body>
    </html>