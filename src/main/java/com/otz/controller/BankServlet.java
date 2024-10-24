package com.otz.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.otz.dao.BankDao;
import com.otz.entity.Bank;
import com.otz.util.DbConnection;
@WebServlet("/bankServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		System.out.println(event);
		if(event.equals("addBank")) {
			String bankName=request.getParameter("bankname");
			String bankEmail=request.getParameter("bankemail");
			String bankPhone=request.getParameter("bankphone");
			//image start
			Part p1=request.getPart("bankimg");
			String Path=DbConnection.Path();			
			String appPath =Path+"/bankImg";
			String imagePath = appPath + "";
			File fileDir = new File(imagePath);
			if (!fileDir.exists()) 
				fileDir.mkdirs();
			//Get Image Name
			String imageName1 = p1.getSubmittedFileName();
			String fileExt1 = imageName1.substring(imageName1.length()-3);
			String imgname1=new Date().getTime() +"1"+"."+fileExt1;	        
			
			if(validateImage1(imageName1)){
				try{
					p1.write(imagePath + "/" + imgname1);
				}catch (Exception ex) { }
			}else{ out.print("<script> alert('Invalid Image Format')</script>");  }
			//img end
			Bank bank=new Bank();
			bank.setBankEmail(bankEmail);
			bank.setBankName(bankName);
			bank.setBankPhone(bankPhone);
			bank.setBankImg(imgname1);
			
			BankDao bankDao=new BankDao();
			int status=bankDao.saveBank(bank);
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}
		}
		else if(event.equals("getBanks")) {
			try {
				BankDao banDao=new BankDao();
				List<Bank> listBanks = banDao.viewBanks();
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(listBanks);
				System.out.print(JSONObject);
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(event.equals("bank_delete")){
			int bankId=Integer.parseInt(request.getParameter("bankId"));
			String status=BankDao.deleteBank(bankId)==1?"done":"";
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(status);
			System.out.print(JSONObject);
			out.print(JSONObject);

		}else if(event.equals("fatchBankById")) {
			try {
				int bankId=Integer.parseInt(request.getParameter("bankId"));
				BankDao bd=new  BankDao();
				List<Bank> bank = bd.sortBankById(bankId);
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(bank);
				System.out.println(JSONObject);
				out.print(JSONObject);
			}catch(Exception e) {e.printStackTrace();}
		}
		else if(event.equals("updateBank")) {
			try {
				int bankId=Integer.parseInt(request.getParameter("bankId"));
				String bankName=request.getParameter("bankname");
				String bankEmail=request.getParameter("bankemail");
				String bankPhone=request.getParameter("bankphone");
				//image start
				Part p1=request.getPart("bankimg");
				String Path=DbConnection.Path();			
				String appPath =Path+"/bankImg";
				String imagePath = appPath + "";
				File fileDir = new File(imagePath);
				if (!fileDir.exists()) 
					fileDir.mkdirs();
				//Get Image Name
				String imageName1 = p1.getSubmittedFileName();
				String fileExt1 = imageName1.substring(imageName1.length()-3);
				String imgname1=new Date().getTime() +"1"+"."+fileExt1;	        
				
				if(validateImage1(imageName1)){
					try{
						p1.write(imagePath + "/" + imgname1);
					}catch (Exception ex) { }
				}else{ out.print("<script> alert('Invalid Image Format')</script>");  }
				//img end
				Bank bank=new Bank();
				bank.setBankEmail(bankEmail);
				bank.setBankName(bankName);
				bank.setBankPhone(bankPhone);
				bank.setBankImg(imgname1);
				bank.setBankId(bankId);
				BankDao bankDao=new BankDao();
				bankDao.updateBank(bank);
				out.print("done");
			}catch(Exception e) {e.printStackTrace();}
		}
	
	}
	private boolean validateImage1(String imageName1){
		String fileExt1 = imageName1.substring(imageName1.length()-3);
		if("jpg".equals(fileExt1) || "png".equals(fileExt1) || "gif".equals(fileExt1))
		{ 
			return true;
		}
		return false;
	}

}
