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
    			out.println("alert(\"��ǰ���ⴴ���ɹ������ȷ�Ϸ��غ�̨������棡\");");
    			out.println("location.href=\""+basePath+"\\admin.jsp\";");
    			out.println("</script>");
    		}else{
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"��ǰ�����Ѵ��ڣ������벻ͬ�����⣡\");");
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
    			out.println("alert(\"��ǰ�����޸ĳɹ������ȷ�Ϸ��غ�̨������棡\");");
    			out.println("location.href=\""+basePath+"admin.jsp\";");
    			out.println("</script>");
    		}else{
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"��ǰ�����Ѵ��ڣ������벻ͬ�����⣡\");");
    			out.println("location.href=\""+basePath+"newspages/topic_change.jsp\";");
    			out.println("</script>");
    		}
    	}else if(opr.equals("del")){
    		String tid = (String)request.getParameter("tid");
    		int result = sTypeService.delSpotType(tid);
    		if(result==1){
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"�Ѿ��ɹ�ɾ�����⣬���ȷ�Ϸ��غ�̨������棡\");");
    			out.println("location.href=\""+basePath+"admin.jsp\";");
    			out.println("</script>");
    		}else if(result==0) {
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"ɾ������ʧ�ܣ�����ϵ���ݿ������Ա�����ȷ�Ϸ��غ�̨������棡\");");
    			out.println("location.href=\""+basePath+"admin.jsp\";");
    			out.println("</script>");
    		}else{
    			out.println("<script type=\"text/javascript\">");
    			out.println("alert(\"�������»������£�����ɾ�������ȷ�Ϸ��غ�̨������棡\");");
    			out.println("location.href=\""+basePath+"admin.jsp\";");
    			out.println("</script>");
    		}
    	}
	}
	
}
