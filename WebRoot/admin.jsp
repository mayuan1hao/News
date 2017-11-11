<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
  <script type="text/javascript"> 
	 $(function(){
		if (window != top) 
		top.location.href = location.href; 
	 });
</script>
  <body>
    <%
    	String url = "";
    %>
    <div id="opt_list">
    	<ul>
    		<li><a href="newspages/news_add.jsp" target="editFrame">添加新闻</a></li>
    		<li><a href="newspages/news_list.jsp" target="editFrame">编辑新闻</a></li>
    		<li><a href="newspages/topic_add.jsp" target="editFrame">添加主题</a></li>
    		<li><a href="newspages/topic_list.jsp" target="editFrame">编辑主题</a></li>
    	</ul>
    </div>
    <iframe name="editFrame" width="800px" height="400px" src="newspages/news_add.jsp"></iframe>
  </body>
</html>
