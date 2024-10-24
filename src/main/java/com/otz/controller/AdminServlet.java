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
import com.otz.dao.AdminDao;
import com.otz.entity.Admin;
import com.otz.util.DbConnection;


@WebServlet("/admin")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AdminServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		if(event.equals("getAdmins")) {
			AdminDao adminDao=new AdminDao();
			List<Admin> admins = adminDao.getAllAdmin();
			GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson  gson = gsonBuilder.create();
		    String JSONObject = gson.toJson(admins);
		    System.out.print(JSONObject);
			out.print(JSONObject);
		}else if(event.equals("addAdmin")) {
		 	String adminName=request.getParameter("adminName");
		 	String adminEmail=request.getParameter("adminEmail");
		 	String adminPass=request.getParameter("adminPass");
		 	String adminPNo=request.getParameter("adminPNo");
		  	
			Part p1=request.getPart("adminimg1");
			System.out.println(p1);	
			String Path=DbConnection.Path();
	        String appPath =Path+"/adminImg";
	        // File path where all files will be stored
	        String imagePath = appPath + "";
	        // Creates the file directory if it does not exists
	        File fileDir = new File(imagePath);
	        if (!fileDir.exists()) 
	                 fileDir.mkdirs();
	      //Get Image Name
	        String imageName1 = p1.getSubmittedFileName();
	        String fileExt1 = imageName1.substring(imageName1.length()-3);
	        String imgname1=new Date().getTime() +"1"+"."+fileExt1;
	        
	        String finalImgPath1="adminImg" + "/"+ imgname1;
	
			        if(validateImage1(imageName1)){
			            try{
			                p1.write(imagePath + "/" + imgname1);
			            }catch (Exception ex) { }
			        }else{ out.print("<script> alert('Invalid Image Format')</script>");  }
	        
				 Admin admin=new Admin();
				 admin.setAdminName(adminName) ;
				 admin.setAdminEmail(adminEmail);
				 admin.setAdminPassword(adminPass);
				 admin.setAdminPhoto(imgname1);
				 admin.setAdminPNum(adminPNo);
				 int status=AdminDao.addAdmin(admin);
				 if(status>0) {
						out.print("done");
					}else {
						out.print("failed");
					}
		}else if(event.equals("admin_delete") ){
			
			int adminId=Integer.parseInt(request.getParameter("adminId"));
			String status=AdminDao.deleteAdmin(adminId)==1?"done":"";
			GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson  gson = gsonBuilder.create();
		    String JSONObject = gson.toJson(status);
		    System.out.print(JSONObject);
			out.print(JSONObject);
			
		}
		else if(event.equals("fatchAdminById")) {
			int adminId=Integer.parseInt(request.getParameter("adminId"));
			AdminDao adminDao=new AdminDao();
			List<Admin> admin = adminDao.sortAdminByAdminId(adminId);
			GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson  gson = gsonBuilder.create();
		    String JSONObject = gson.toJson(admin);
		    System.out.print(JSONObject);
			out.print(JSONObject);
		}else if(event.equals("updateAdmin")) {
			//System.out.println(event);
			int adminId=Integer.parseInt(request.getParameter("adminId"));
			String adminName=request.getParameter("adminName");
			String adminEmail=request.getParameter("adminEmail");
			String adminPass=request.getParameter("adminPass");
			String adminPNo=request.getParameter("adminPNo");
			Part p1=request.getPart("adminimg1");
			System.out.println(p1);	
			String Path=DbConnection.Path();
	        String appPath =Path+"/adminImg";
	        // File path where all files will be stored
	        String imagePath = appPath + "";
	        // Creates the file directory if it does not exists
	        File fileDir = new File(imagePath);
	        if (!fileDir.exists()) 
	                 fileDir.mkdirs();
	      //Get Image Name
	        String imageName1 = p1.getSubmittedFileName();
	        String fileExt1 = imageName1.substring(imageName1.length()-3);
	        String imgname1=new Date().getTime() +"1"+"."+fileExt1;
	        
	        String finalImgPath1="adminImg" + "/"+ imgname1;
	
			        if(validateImage1(imageName1)){
			            try{
			                p1.write(imagePath + "/" + imgname1);
			            }catch (Exception ex) { }
			        }else{ out.print("<script> alert('Invalid Image Format')</script>");  }
	        
			 Admin admin=new Admin();
			 admin.setAdminName(adminName) ;
			 admin.setAdminEmail(adminEmail);
			 admin.setAdminPassword(adminPass);
			 admin.setAdminPNum(adminPNo);
			 admin.setAdminPhoto(imgname1);
			 admin.setAdminId(adminId);
			 AdminDao adminDao=new AdminDao();
			int status= adminDao.updateAdmin(admin);
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}
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
