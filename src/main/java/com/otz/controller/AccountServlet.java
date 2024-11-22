package com.otz.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import com.otz.dao.AccountDao;
import com.otz.dao.CustomerDao;
import com.otz.dao.DeviceDao;
import com.otz.entity.Account;
import com.otz.entity.Customer;
import com.otz.util.DbConnection;

@WebServlet("/accountServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		if(event.equals("addAccount")){
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
			String s=request.getParameter("branchid");
			
			int branchId=Integer.parseInt(request.getParameter("branchid"));
			int accTypeId=Integer.parseInt(request.getParameter("typeId"));
			double balance=Double.parseDouble(request.getParameter("balance"));
			long accNumber=accountNum();
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
				int custId=cd.saveCustomerGetCustId(cust);
				if(custId>0) {
					AccountDao ad=new AccountDao();
					int status=ad.createNewAccount(accNumber,custId,accTypeId,balance,branchId);
					if(status>0) {
						if(custEmail!=null || !custEmail.equals("")) {


							String to = custEmail;// change accordingly
							// Get the session object
							Properties props = new Properties();
							props.put("mail.smtp.host", "smtp.gmail.com");
							props.put("mail.smtp.socketFactory.port", "465");
							props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
							props.put("mail.smtp.auth", "true");
							props.put("mail.smtp.port", "465");
							Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
								protected PasswordAuthentication getPasswordAuthentication() {
									return new PasswordAuthentication("rajaswain6969@gmail.com", "nglabxcvnfgrpdxs"
											+ "");// Put your email
									// id and
									// password here
								}
							});
							// compose message
							try {
								MimeMessage message = new MimeMessage(session);
								message.setFrom(new InternetAddress(custEmail));// change accordingly
								message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
								message.setSubject("Congratulation ");
								message.setText("your account is created successfully ,your User Id is: " + userId+"  & your Password is: " + custPass +"  It may take 1 hour to activated your account ,Once ADMIN approved your request ,you will be allowed to login . THANK YOU! ");

								// send message
								Transport.send(message);
								out.print("done");
							}

							catch (MessagingException e) {
								throw new RuntimeException(e);
							}
						}else {
							out.print("failed");
						}
					}else {
						out.print("failed");
					}
				}
			}
		}

		else if(event.equals("viewAccounts")) {
			try {
				AccountDao ad=new AccountDao();
				List<Account> listacc= ad.viewAccounts();
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(listacc);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(event.equals("account_delete")){
			int accId=Integer.parseInt(request.getParameter("accId"));
			int status=AccountDao.deactivatedAccount(accId);
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}
		}else if(event.equals("fatchAccById")) {
			try {
				int accId=Integer.parseInt(request.getParameter("accId"));
				AccountDao ad=new AccountDao();
				List<Account> acc= ad.fatchAccountById(accId);
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(acc);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(event.equals("getAccountDetails")) {
			try {
				HttpSession session=request.getSession(false);  
			    int accId=(int)session.getAttribute("accId");  
				AccountDao ad=new AccountDao();
				List<Account> acc= ad.fatchAccountById(accId);
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(acc);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(event.equals("updateAccount")){
			int accId=Integer.parseInt(request.getParameter("accId"));
			int branchId=Integer.parseInt(request.getParameter("branchid"));
			int accTypeId=Integer.parseInt(request.getParameter("typeId"));
			int acctStatus=Integer.parseInt(request.getParameter("acctStatus"));
			double balance=Double.parseDouble(request.getParameter("balance"));
			Long  accNumber=Long.parseLong(request.getParameter("accNum"));


			int custId=Integer.parseInt(request.getParameter("custId"));
			String  custFname=request.getParameter("custfname");
			String  custLname=request.getParameter("custlname");
			String  custEmail=request.getParameter("custemail");
			String  custPass=request.getParameter("custpass");
			String  custPhone=request.getParameter("custphone");
			String  custDOB=request.getParameter("custdob");
			String  custAddress=request.getParameter("custadd");

			Customer cust=new Customer();
			cust.setCustAddress(custAddress);
			cust.setCustDOB(custDOB);
			cust.setCustEmail(custEmail);
			cust.setCustFname(custFname);
			cust.setCustLname(custLname);
			cust.setCustPass(custPass);
			cust.setCustPhone(custPhone);
			cust.setCustId(custId);

			Account acc=new Account();
			acc.setAccId(accId);
			acc.setBalance(balance);
			acc.setAccNumber(accNumber);
			acc.setBranchId(branchId);
			acc.setAccTypeId(accTypeId);
			acc.setAcctStatus(acctStatus);

			AccountDao ad=new AccountDao();
			int status1=ad.updateAccount(acc);
			
			CustomerDao cd=new CustomerDao();
			int status2=cd.updateCustomerByAccount(cust);
			if(status1>0 && status2>0) {
				out.print("done");
			}else {
				out.print("failed");
			}
		}
	}


	public static int userId() {
		Random random = new Random();
		int randomNumber = random.nextInt(900000) + 100000;
		return randomNumber;
	}
	private boolean validateImage1(String imageName1){
		String fileExt1 = imageName1.substring(imageName1.length()-3);
		if("jpg".equals(fileExt1) || "png".equals(fileExt1) || "gif".equals(fileExt1))
		{ 
			return true;
		}
		return false;
	}
	public static long generateRandom10DigitNumber(Random random) {
		// Generate a random number between 1000000000 and 9999999999 (inclusive)
		long min = 1000000000L;
		long max = 9999999999L;
		return min + ((long) (random.nextDouble() * (max - min)));
	}
	public static long accountNum() {
		Random random = new Random();
		long randomNumber = generateRandom10DigitNumber(random);
		return randomNumber;
	}
}
