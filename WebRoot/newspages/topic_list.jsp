<%@page import="com.news.file.dao.impl.SpotTypeDaoImpl"%>
<%@page import="com.news.file.dao.SpotTypeDao"%>
<%@page import="com.news.file.bean.SpotType"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topic_list.jsp' starting page</title>
    
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
    	SpotTypeDao sTypeDao = new SpotTypeDaoImpl();
    	List<SpotType> sList = sTypeDao.getSpotTypes();
    	session.setAttribute("sList", sList);
    %>
    <div id="opt_area">
    	<ul class="classlist">
    		<%
    			for(SpotType spotType:sList){
    		%>
    		<li>
    			<span><%=spotType.getnTname()%></span>
    			<a href="newspages/topic_change.jsp?tid=<%=spotType.getnTid()%>">修改</a>
    			<a href="<%=basePath %>/ProcessServlet?opr=del&tid=<%=spotType.getnTid()%>">删除</a>
    		</li>
    		<%
    			}
    		%>
    	</ul>
    </div>
  </body>
</html>
