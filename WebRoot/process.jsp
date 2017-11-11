<%@page import="com.news.file.bean.User"%>
<%@page import="com.news.file.dao.impl.UserDaoImpl"%>
<%@page import="com.news.file.dao.UserDao"%>
<%@page import="com.news.file.dao.impl.SpotTypeDaoImpl"%>
<%@page import="com.news.file.dao.SpotTypeDao"%>
<%@page import="com.news.file.dao.impl.SpotDaoImpl"%>
<%@page import="com.news.file.dao.SpotDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'process.jsp' starting page</title>
    
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
  	<%!
  		SpotDao spotDao = new SpotDaoImpl();
  		SpotTypeDao sTypeDao = new SpotTypeDaoImpl();
  		UserDao userDao = new UserDaoImpl();
  	%>
    <%
    	request.setCharacterEncoding("UTF-8");
    	String proType = request.getParameter("proType");
    	if(proType.equals("login")){
    		String userId = request.getParameter("userId");
    		String password = request.getParameter("password");
    		User user = userDao.getUserByid(userId);
    		if(user!=null && user.getPassword().equals(password)){
    			session.setAttribute("uesr", user);
    			session.setAttribute("message", "");
    			response.sendRedirect("index.jsp");
    		}else{
    			response.sendRedirect("login.jsp");
    			session.setAttribute("message", "用户名与密码不匹配");
    		}
    	}else if(proType.equals("register")){
    		String userName = request.getParameter("userName");
    		String password = request.getParameter("password");
    		String rPsw = request.getParameter("rPsw");
    		if(rPsw.equals(password)){
    			User user = new User();
    			user.setuName(userName);
    			user.setPassword(password);
    			userDao.saveUser(user);
    			user = userDao.getUserByName(userName);
    			session.setAttribute("message", "注册成功，您的ID是："+user.getuId());
    			response.sendRedirect("login.jsp");
    		}else{
    			session.setAttribute("message", "两次密码不一致");
    			response.sendRedirect("register.jsp");
    		}
    		
    	}else if(proType.equals("exit")){
    		session.setAttribute("uesr", null);
    		response.sendRedirect("index.jsp");
    	}
    %>
  </body>
</html>
