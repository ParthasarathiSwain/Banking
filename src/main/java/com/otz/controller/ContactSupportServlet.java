package com.otz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.otz.dao.BranchDao;
import com.otz.dao.ContactSupportDao;
import com.otz.entity.Branch;
import com.otz.entity.ContactSupport;
@WebServlet("/contactSupport")
public class ContactSupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		if(event.equals("addComplain")) {
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String email=request.getParameter("email");
			String subject=request.getParameter("subject");
			String msg=request.getParameter("message");
			ContactSupport cs=new ContactSupport();
			cs.setEmail(email);
			cs.setFname(fname);
			cs.setLname(lname);
			cs.setMsg(msg);
			cs.setSubject(subject);
			ContactSupportDao csd=new ContactSupportDao();
			int status=csd.saveComplain(cs);
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}
		}else if(event.equals("viewComplains")) {
			try {
				ContactSupportDao csd=new ContactSupportDao();
				List<ContactSupport> csList=csd.viewContactSupport();
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(csList);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(event.equals("fatchCompID")) {
			try {
				int compId=Integer.parseInt(request.getParameter("compId"));
				List<ContactSupport> l=new ArrayList<>();
				ContactSupport csd=new ContactSupport();
				csd.setCompId(compId);
				l.add(csd);
				List<ContactSupport> csdList=l ;
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(csdList);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(event.equals("updateComplain")) {
			try {
				int compId=Integer.parseInt(request.getParameter("compId"));
				int status=Integer.parseInt(request.getParameter("status"));
				ContactSupportDao csd=new ContactSupportDao();
				csd.updateContactSupport(compId,status);
				out.print("done");
			}catch(Exception e) {e.printStackTrace();}
		}
	}

}
