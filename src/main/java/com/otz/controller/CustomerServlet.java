package com.otz.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.otz.dao.CustomerDao;
import com.otz.dao.DeviceDao;
import com.otz.entity.Customer;
import com.otz.util.DbConnection;

@WebServlet("/custServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		if(event.equals("addCustomer")){
			String  custFname=request.getParameter("custfname");
			String  custLname=request.getParameter("custlname");
			String  custEmail=request.getParameter("custemail");
			String  custPass=request.getParameter("custpass");
			String  custPhone=request.getParameter("custphone");
			String  custDOB=request.getParameter("custdob");
			String  custAddress=request.getParameter("custadd");
			String  latitude=request.getParameter("latitude");
			String  longitude=request.getParameter("longitude");
			int userId=userId();
			//image start
			Part p1=request.getPart("custimg");
			String Path=DbConnection.Path();			
			String appPath =Path+"/custImg";
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
			DeviceDao device=new DeviceDao();
			int deviceId=device.saveDevice(latitude,longitude);
			if(deviceId>0) {
				Customer cust=new Customer();
				cust.setCustAddress(custAddress);
				cust.setCustDOB(custDOB);
				cust.setCustEmail(custEmail);
				cust.setCustFname(custFname);
				cust.setCustLname(custLname);
				cust.setCustPass(custPass);
				cust.setCustPhone(custPhone);
				cust.setCustUserId(userId);
				cust.setCustImg(imgname1);
				cust.setDeviceId(deviceId);
				CustomerDao cd=new CustomerDao();
				int status=cd.saveCustomerGetCustId(cust);
				if(status>0) {
					out.print("done");
				}else {
					out.print("failed");
				}
			}

		}else if(event.equals("viewCustomers")) {
			try {
				CustomerDao cd=new CustomerDao();
				List<Customer> custList= cd.viewCustomers();
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(custList);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(event.equals("cust_delete")){
			int custId=Integer.parseInt(request.getParameter("custId"));
			String status=CustomerDao.deleteCustomer(custId)==1?"done":"";
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(status);
			System.out.print(JSONObject);
			out.print(JSONObject);

		}else if(event.equals("fatchCustById")) {
			try {
				int custId=Integer.parseInt(request.getParameter("custId"));
				CustomerDao cd=new CustomerDao();
				List<Customer> custList= cd.fatchCustById(custId);
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(custList);
				System.out.println(JSONObject);
				out.print(JSONObject);
			}catch(Exception e) {e.printStackTrace();}
		}else if(event.equals("updateCustomer")) {
			try {
				int custId=Integer.parseInt(request.getParameter("custId"));
				String  custFname=request.getParameter("custfname");
				String  custLname=request.getParameter("custlname");
				String  custEmail=request.getParameter("custemail");
				String  custPass=request.getParameter("custpass");
				String  custPhone=request.getParameter("custphone");
				String  custDOB=request.getParameter("custdob");
				String  custAddress=request.getParameter("custadd");
				String  latitude=request.getParameter("latitude");
				String  longitude=request.getParameter("longitude");
				int userId=userId();
				//image start
				Part p1=request.getPart("custimg");
				String Path=DbConnection.Path();			
				String appPath =Path+"/custImg";
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
				CustomerDao cd=new CustomerDao();
				int deviceId=cd.getDeviceId(custId);
				DeviceDao device=new DeviceDao();
				int status=device.updateDevice(latitude,longitude,deviceId);
				if(status>0) {
					Customer cust=new Customer();
					cust.setCustAddress(custAddress);
					cust.setCustDOB(custDOB);
					cust.setCustEmail(custEmail);
					cust.setCustFname(custFname);
					cust.setCustLname(custLname);
					cust.setCustPass(custPass);
					cust.setCustPhone(custPhone);
					cust.setCustImg(imgname1);
					cust.setCustId(custId);
					int result=cd.updateCustomer(cust);
					if(result>0) {
						out.print("done");
					}else {
						out.print("failed");
					}
				}
			}catch(Exception e) {e.printStackTrace();}
		}else if(event.equals("updateCustBasicDetails")) {
			try {
				HttpSession session=request.getSession(false);  
			    int custId=(int)session.getAttribute("custId"); 
				String  custFname=request.getParameter("custFname");
				String  custLname=request.getParameter("custLname");
				String  custEmail=request.getParameter("custEmail");
				String  custPhone=request.getParameter("custPhone");
				String  custAddress=request.getParameter("address");
				
				Customer cust=new Customer();
				cust.setCustAddress(custAddress);
				cust.setCustEmail(custEmail);
				cust.setCustFname(custFname);
				cust.setCustLname(custLname);
				cust.setCustPhone(custPhone);
				cust.setCustId(custId);
				
				CustomerDao cd=new CustomerDao();
				int result=cd.updateCustomerBasicDetails(cust);
					if(result>0) {
						out.print("done");
					}else {
						out.print("failed");
					}
			}catch(Exception e) {e.printStackTrace();}
		}else if(event.equals("changePassword")){
			String oldPass=request.getParameter("oldPass");
			String newPass=request.getParameter("newPass");
			String confirm=request.getParameter("confirm");
            HttpSession session = request.getSession(true);
			String id= session.getAttribute("custId").toString();
			int id2=Integer.parseInt(id);
            CustomerDao cd=new CustomerDao();
			String password=cd.fatchPassWord(id2);
			String status="";
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			if(oldPass!=newPass) {
				if(newPass.trim().equals(confirm.trim())) {
					if(oldPass.trim().equals(password.trim())) {
						status=cd.updatePassword(confirm,id2)==1?"done":"";
						String JSONObject = gson.toJson(status);
						out.print(JSONObject);
					}else {
						status="error3";
						String JSONObject = gson.toJson(status);
						out.print(JSONObject);
					}
				}else {
					status="error2";
					String JSONObject = gson.toJson(status);
					out.print(JSONObject);
				}
			}else {
				status="error1";
				String JSONObject = gson.toJson(status);
				out.print(JSONObject);
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
	public static int userId() {
		Random random = new Random();
		int randomNumber = random.nextInt(900000) + 100000;
		return randomNumber;
	}
}
