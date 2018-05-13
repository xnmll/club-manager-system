<%@ page language="java" import="java.util.*,java.net.URLDecoder" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  <%
	//获取请求上下文
	String context = request.getContextPath();
   %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>社团管理系统-管理员端</title>
		<!-- Custom Theme files -->
		<link href="<%=context%>/css/style1.css" rel="stylesheet" type="text/css" media="all"/>
		<!-- Custom Theme files -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	</head>
	
<body>
	<div class="login">
		 <div class="login-main">
	 		<div class="login-top">
	 			<img src="images/head-img.png" alt=""/>
	 			<h1>社团管理系统-管理员端</h1>
	 			<form action="<%=context%>/loginCheckAction" id="form" method="post">
	 			<input type="text" name="username" value="xnmll" placeholder="用户名" required>
	 			<input type="password" name="password" value="123123" placeholder="密码" required>
	 			
	
	 			 
			      <br><br>
			     
	 			<input type="submit" value="登录" /><br><br>
	 			</form>
	 		</div>
	 	</div>
  </div>
</body>
</html>