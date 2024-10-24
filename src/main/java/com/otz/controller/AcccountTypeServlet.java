package com.otz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.otz.dao.AccountTypeDao;
import com.otz.dao.BranchDao;
import com.otz.entity.AccountType;
import com.otz.entity.Branch;

@WebServlet("/accTypeServlet")
public class AcccountTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		if(event.equals("addAccType")) {
			String accTypeName=request.getParameter("acctypename");
			AccountTypeDao atd=new AccountTypeDao();
			int status=atd.addAccountType(accTypeName);
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}
		}else if(event.equals("getAllAccTypes")) {
			try {
				AccountTypeDao atd=new AccountTypeDao();
				List<AccountType> listAccType= atd.viewAllAccType();
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(listAccType);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(event.equals("acctyp_delete")){
			int accTypeId=Integer.parseInt(request.getParameter("accTypeId"));
			String status=AccountTypeDao.deleteAccountType(accTypeId)==1?"done":"";
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(status);
			System.out.print(JSONObject);
			out.print(JSONObject);

		}else if(event.equals("fatchAccTypeById")) {
			try {
				int accTypeId=Integer.parseInt(request.getParameter("accTypeId"));
				AccountTypeDao atd=new AccountTypeDao();
				List<AccountType> accType = atd.sortAccTypeById(accTypeId);
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(accType);
				System.out.println(JSONObject);
				out.print(JSONObject);
			}catch(Exception e) {e.printStackTrace();}
		}else if(event.equals("updateAccType")) {
			try {
				int accTypeId=Integer.parseInt(request.getParameter("accTypeId"));
				String accTypeName=request.getParameter("acctypename");
				AccountTypeDao atd=new AccountTypeDao();
				int status=atd.updateAccountType(accTypeName,accTypeId);
				if(status>0) {
					out.print("done");
				}else {
					out.print("failed");
				}
			}catch(Exception e) {e.printStackTrace();}
		}
	}

}
