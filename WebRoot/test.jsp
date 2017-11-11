<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
   		public int initNum = 0;
   		public int delNum = 0;
   		public int serviceNum = 0;
   		public void jspInit(){
   			System.out.println("init的执行次数："+(++initNum));
   		}
   		public void jspDestroy(){
   			System.out.println("delNum的执行次数："+(++delNum));
   		}
   	%>
   	<%
   		System.out.println("service的执行次数："+(++serviceNum));
   	%>
  </body>
</html>
