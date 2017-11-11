<%@page import="com.news.file.service.impl.SpotTypeServiceImpl"%>
<%@page import="com.news.file.service.SpotTypeService"%>
<%@page import="com.news.file.dao.impl.SpotDaoImpl"%>
<%@page import="com.news.file.dao.SpotDao"%>
<%@page import="com.news.file.bean.SpotType"%>
<%@page import="com.news.file.dao.impl.SpotTypeDaoImpl"%>
<%@page import="com.news.file.dao.SpotTypeDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topic_control.jsp' starting page</title>
    
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
    	request.setCharacterEncoding("UTF-8");
    	String opr = request.getParameter("opr");
    	SpotTypeDao sTypeDao = new SpotTypeDaoImpl();
    	SpotDao spotDao = new SpotDaoImpl();
    	SpotTypeService sTypeService = new SpotTypeServiceImpl();
    	if(opr.equals("add")){
    		String tName = request.getParameter("tName");
    		int result = sTypeService.addSpotType(tName);
    		if(result==1){
    %>
    	<script type="text/javascript">
    		alert("当前主题创建成功，点击确认返回后台管理界面！");
    		location.href="admin.jsp";
    	</script>
    <%
    		}else{
    %>
    	<script type="text/javascript">
    		alert("当前主题已存在，请输入不同的主题！");
    		location.href="newspages/topic_add.jsp";
    	</script>
    <%
    		}
    	}else if(opr.equals("change")){
    		String tid = (String)session.getAttribute("tid");
    		String tName = request.getParameter("tName");
    		SpotType spotType = new SpotType();
    		spotType.setnTname(tName);
    		spotType.setnTid(tid);
    		int result = sTypeService.updateSpotType(spotType);
    		if(result==1){
    %>
    	<script type="text/javascript">
    		alert("当前主题修改成功，点击确认返回后台管理界面！");
    		location.href="admin.jsp";
    	</script>
    <%
    		}else{
    %>
    	<script type="text/javascript">
    		alert("当前主题已存在，请输入不同的主题！");
    		location.href="newspages/topic_change.jsp";
    	</script>
    <%
    		}
    	}else if(opr.equals("del")){
    		String tid = (String)request.getParameter("tid");
    		int result = sTypeService.delSpotType(tid);
    		if(result==1){
    			
    %>
    <script type="text/javascript">
    	alert("已经成功删除主题，点击确认返回后台管理界面！");
    	location.href="admin.jsp";
    </script>
    <%
    			}else if(result==0) {
    %>
    <script type="text/javascript">
    	alert("删除主题失败，请联系数据库管理人员，点击确认返回后台管理界面！");
    	location.href="admin.jsp";
    </script>
    <%
    			}else{
    %>
    <script type="text/javascript">
    	alert("该主题下还有文章，不能删除，点击确认返回后台管理界面！");
    	location.href="admin.jsp";
    </script>
    <%
    		}
    	}
    %>
  </body>
</html>
