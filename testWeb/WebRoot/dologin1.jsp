<%@ page language="java" import="java.util.*,dao.*,entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dologin1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
  //jsp 第一个内置对象：out，第二个：request(重要) 第三个 ，response(重定向)跳到另一个页面
  request.setCharacterEncoding("utf-8");
  String username=request.getParameter("name");
 //username=new String(username.getBytes("ISO-8859-1"),"utf-8");
 //当method="get"时，写上面那一句，如果method="post"则不用
  
  String password=request.getParameter("password");
  User searchUser=new User();
  searchUser.setUsername(username);
  searchUser.setPassword(password);
  UserDao ud=new UserDao();
  User user=ud.searchByUserNameAndPassword(searchUser); 
  if(user!=null){
 // out.print("登陆成功");
 //response.sendRedirect("success.jsp");//重定向
  request.getRequestDispatcher("success.jsp").forward(request, response);
  //转发，转发就不用上面的重定向；
  }else{
  //out.print("登陆失败");
  response.sendRedirect("fail.jsp");//重定向
  request.getRequestDispatcher("fail.jsp").forward(request, response);
    //转发，转发就不用上面的重定向；
    } 
   %>
  </body>
</html>
