package com.otz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.otz.dao.AdminLoginDao;
import com.otz.entity.Admin;

@WebServlet("/al")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    AdminLoginDao dao ;
    public void init() {
        dao = new AdminLoginDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		int status = 0;
		Admin bean = new Admin();
		bean.setAdminEmail(username);
		bean.setAdminPassword(password);
		 HttpSession session = request.getSession(true);
		if(dao.validate(bean))
		{
			Admin admin= dao.fatchAdminDetails(username,password);
			session.setAttribute("img", admin.getAdminPhoto());
			session.setAttribute("name", admin.getAdminName());
			session.setAttribute("username", username);
			status=1;
			out.println(status);
		}
		 // Create a session object if it is already not created.
      
       
		
	}

}
