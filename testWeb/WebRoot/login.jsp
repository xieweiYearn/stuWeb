<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<!--  
 用EL标签的话不需要获取name值，value="<%//=name%>"改写成￥{name};不用EL标签的话就获取name值，下面注释的部分
 -->
 <body>
<%
//String name=(String)request.getAttribute("name");
%>
<form action="user?type=doLogin" method="post">

	账号<input type="text" value="${name}" name="name"><br>
	密码 <input type="password" value="" name="password"><br> 
	<input type="radio" name="time" value="1">不保存
	 <input type="radio" name="time" value="2" checked>保存30秒
	<input type="radio" name="time" value="3">保存1分钟
	
	<input
		type="submit" value="登录">

</form>
</body>
</html>
