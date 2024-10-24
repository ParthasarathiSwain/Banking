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
import com.otz.dao.BranchDao;
import com.otz.entity.Branch;
@WebServlet("/branchServlet")
public class BranchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		
		if(event.equals("addBranch")) {
			
			int bankId=Integer.parseInt(request.getParameter("bankId"));
			String branchName=request.getParameter("branchname");
			String location=request.getParameter("location");
			String createdBy=request.getParameter("createdby");
			Branch branch=new Branch();
			branch.setBankid(bankId);
			branch.setBranchName(branchName);
			branch.setCreatedBy(createdBy);
			branch.setLocation(location);
			
			BranchDao bd=new BranchDao();
			int status=bd.saveBranch(branch);
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}
		}else if(event.equals("getBranchByBankId")) {
			try {
				int bankId=Integer.parseInt(request.getParameter("bankId"));
				BranchDao bd=new BranchDao();
				List<Branch> listBranch= bd.getBranchByBankId(bankId);
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(listBranch);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(event.equals("getBranches")) {
			try {
				BranchDao bd=new BranchDao();
				List<Branch> listBranch= bd.viewBranches();
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(listBranch);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(event.equals("branch_delete")){
			int branchId=Integer.parseInt(request.getParameter("branchId"));
			String status=BranchDao.deleteBranch(branchId)==1?"done":"";
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(status);
			System.out.print(JSONObject);
			out.print(JSONObject);

		}else if(event.equals("fatchBranchById")) {
			try {
				int branchId=Integer.parseInt(request.getParameter("branchId"));
				BranchDao bd=new BranchDao();
				List<Branch> branch = bd.sortBranchById(branchId);
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(branch);
				System.out.println(JSONObject);
				out.print(JSONObject);
			}catch(Exception e) {e.printStackTrace();}
		}else if(event.equals("updateBranch")) {
			try {
				int branchId=Integer.parseInt(request.getParameter("branchid"));
				String branchName=request.getParameter("branchname");
				String location=request.getParameter("location");
				String createdBy=request.getParameter("createdby");
				String updatedBy=request.getParameter("updatedby");
				int isActive=Integer.parseInt(request.getParameter("isActive"));
				Branch branch=new Branch();
				branch.setBranchId(branchId);
				branch.setBranchName(branchName);
				branch.setCreatedBy(createdBy);
				branch.setLocation(location);
				branch.setUpdatedBy(updatedBy);
				branch.setIsActive(isActive);
				
				BranchDao bd=new BranchDao();
				bd.updateBranch(branch);
				out.print("done");
			}catch(Exception e) {e.printStackTrace();}
		}
	}

}
