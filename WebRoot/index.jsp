<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.news.file.bean.SpotType"%>
<%@page import="com.news.file.bean.Spot"%>
<%@page import="com.news.file.dao.impl.UserDaoImpl"%>
<%@page import="com.news.file.dao.UserDao"%>
<%@page import="com.news.file.dao.impl.SpotTypeDaoImpl"%>
<%@page import="com.news.file.dao.SpotTypeDao"%>
<%@page import="com.news.file.dao.impl.SpotDaoImpl"%>
<%@ page import="com.news.file.bean.User" %>
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
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	<div id="head_login">
  	<%!
  		SpotDao spotDao = new SpotDaoImpl();
  		SpotTypeDao sTypeDao = new SpotTypeDaoImpl();
  		UserDao userDao = new UserDaoImpl();
  	 %>
    <%
   		User user =(User)session.getAttribute("uesr"); 	
   		if(user==null){	
   	 %>
   	 	<a href="login.jsp">登录</a>
   	 	<a href="register.jsp">注册</a>
   	 <%
   	 	}else{
   	  %>
   	  	<a href="userInfo.jsp"><%=user.getuName()%></a>
   	  	<a href="admin.jsp">后台管理</a>
   	  	<a href="process.jsp?proType=exit">退出</a>
   	  <%
   	  	}
   	  %>
   	 </div>
   	 <div id="left">
   	 	<div id="domestic">
   	 		<div>国内新闻</div>
   	 		<ul>
   	 		<%
   	 			List<Spot> spots1 = spotDao.getSpotsByType(1);
   	 			for(int i=0;i<spots1.size();i++){
   	 				if(i==5){
   	 					break;
   	 				}
   	 		%>
   	 			<li><a href="spotInfo.jsp?spotId=<%=spots1.get(i).getnId()%>"><%=spots1.get(i).getnTitle() %></a></li>
   	 		<%
   	 				
   	 			}
   	 		 %>
   	 		</ul>
   	 	</div>
   	 	<div id="International">
   	 		<div>国际新闻</div>
   	 		<ul>
   	 		<%
   	 			List<Spot> spots2 = spotDao.getSpotsByType(2);
   	 			for(int i=0;i<spots2.size();i++){
   	 				if(i==5){
   	 					break;
   	 				}
   	 		%>
   	 			<li><a href="spotInfo.jsp?spotId=<%=spots2.get(i).getnId()%>"><%=spots2.get(i).getnTitle() %></a></li>
   	 		<%
   	 				
   	 			}
   	 		 %>
   	 		</ul>
   	 	</div>
   	 </div>
   	 <div id="content">
   	 	<div id="con_head">
   	 		<div><span>新闻中心</span></div>
   	 		<ul>
   	 		<%
   	 			List<SpotType> spList = sTypeDao.getSpotTypes();
   	 			for(int i=0;i<spList.size();i++){
   	 		%>
   	 			<li><a href="spotType.jsp?spotId=<%=spList.get(i).getnTid()%>"><%=spList.get(i).getnTname() %></a></li>
   	 		<%
   	 			}
   	 		 %>
   	 		</ul>
   	 	</div>
   	 	<ul>
   	 		<%
   	 			for(int i=0;i<spList.size();i++){
   	 		%>
   	 			<li>
   	 				<ul>
   	 					<%
   	 						List<Spot> spots = spotDao.getSpotsByType(Integer.parseInt(spList.get(i).getnTid()));
   	 						for(int j=0;j<spots.size();j++){
   	 							if(j<5){
   	 							SimpleDateFormat format = new SimpleDateFormat();
   	 							String time = format.format(spots.get(j).getnTime());
   	 					%>
   	 							<li>
   	 							<a href="spotInfo.jsp?spotId=<%=spots.get(j).getnId()%>"><%=spots.get(j).getnTitle()%></a>
   	 							<span><%=time%></span>
   	 							</li>
   	 					<%
   	 							}else{
   	 								break;
   	 							}
   	 						}
   	 					%>
   	 				</ul>
   	 			</li>
   	 		<%
				}
   	 		 %>
   	 	</ul>
   	 </div>
  </body>
</html>
