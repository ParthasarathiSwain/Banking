package com.otz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.otz.dao.AccountDao;
import com.otz.dao.CustomerDao;
import com.otz.dao.DeviceDao;
import com.otz.entity.Account;
import com.otz.entity.Customer;

@WebServlet("/custLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		int custUserId = Integer.parseInt(request.getParameter("userid"));
		String password = request.getParameter("password");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		CustomerDao cd=new CustomerDao();
		int status=cd.checkValidUser(custUserId,password);
		HttpSession session=request.getSession(true);
		if(status>0) {
			Customer cust=cd.getCustDetails(custUserId,password);
			String custImg=cust.getCustImg();
			String custEmail=cust.getCustEmail();
			String custFname=cust.getCustFname();
			int custId=cust.getCustId();
			int deviceId=cust.getDeviceId();
			if(cust!=null) {
				AccountDao ad=new AccountDao();
				Account acc=ad.getAccStatusAndId(custId);
				int accId=acc.getAccId();
				int acctStatus=acc.getAcctStatus();
				DeviceDao dd=new DeviceDao();
				int deviceStatus=dd.updateDevice(latitude,longitude,deviceId);
				if(acctStatus>0) {
					session.setAttribute("accNum", acc.getAccNumber());
                    session.setAttribute("img", custImg);
					session.setAttribute("name", custFname);
					session.setAttribute("username", custEmail);
					session.setAttribute("custId", custId);
					session.setAttribute("accId", accId);
					out.print("done");
				}else if(acctStatus==0){
					out.print("notConfirm");
				}
			}
		}else {
			out.print("failed");
		}


	}

	

}
