package com.news.file.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.file.bean.SpotType;
import com.news.file.dao.SpotDao;
import com.news.file.dao.SpotTypeDao;
import com.news.file.dao.impl.SpotDaoImpl;
import com.news.file.dao.impl.SpotTypeDaoImpl;
import com.news.file.service.SpotTypeService;
import com.news.file.service.impl.SpotTypeServiceImpl;

public class ProcessServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
    	String opr = request.getParameter("opr");
    	SpotTypeDao sTypeDao = new SpotTypeDaoImpl();
    	SpotDao spotDao = new SpotDaoImpl();
    	SpotTypeService sTypeService = new SpotTypeServiceImpl();
    	PrintWriter out = response.getWriter();
    	HttpSession session = request.getSession();
    	if(opr.equals("add")){
    		String tName = request.getParameter("tName");
    		int result = sTypeService.addSpotType(tName);
    		if(result==1){
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"当前主题创建成功，点击确认返回后台管理界面！\");");
    			out.println("location.href=\""+basePath+"\\admin.jsp\";");
    			out.println("</script>");
    		}else{
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"当前主题已存在，请输入不同的主题！\");");
    			out.println("location.href=\""+basePath+"\\newspages/topic_add.jsp\";");
    			out.println("</script>");
    		}
    	}else if(opr.equals("change")){
    		String tid = (String)session.getAttribute("tid");
    		String tName = request.getParameter("tName");
    		SpotType spotType = new SpotType();
    		spotType.setnTname(tName);
    		spotType.setnTid(tid);
    		int result = sTypeService.updateSpotType(spotType);
    		if(result==1){
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"当前主题修改成功，点击确认返回后台管理界面！\");");
    			out.println("location.href=\""+basePath+"admin.jsp\";");
    			out.println("</script>");
    		}else{
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"当前主题已存在，请输入不同的主题！\");");
    			out.println("location.href=\""+basePath+"newspages/topic_change.jsp\";");
    			out.println("</script>");
    		}
    	}else if(opr.equals("del")){
    		String tid = (String)request.getParameter("tid");
    		int result = sTypeService.delSpotType(tid);
    		if(result==1){
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"已经成功删除主题，点击确认返回后台管理界面！\");");
    			out.println("location.href=\""+basePath+"admin.jsp\";");
    			out.println("</script>");
    		}else if(result==0) {
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"删除主题失败，请联系数据库管理人员，点击确认返回后台管理界面！\");");
    			out.println("location.href=\""+basePath+"admin.jsp\";");
    			out.println("</script>");
    		}else{
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"该主题下还有文章，不能删除，点击确认返回后台管理界面！\");");
    			out.println("location.href=\""+basePath+"admin.jsp\";");
    			out.println("</script>");
    		}
    	}
	}
	
}
