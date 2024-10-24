package com.otz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.otz.dao.AccountDao;
import com.otz.dao.BillerDao;
import com.otz.dao.TransactionDao;
import com.otz.entity.Biller;

@WebServlet("/billerServlet")
public class BillerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		if(event.equals("getAllBiller")) {
			try {
				
				BillerDao bd=new BillerDao();
				List<Biller> billerList= bd.getAllBiller();
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(billerList);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(event.equals("billerTransfer")) {
			String bFname=request.getParameter("bfname");
			String bLname=request.getParameter("bLname");
			long bAccNum=Long.parseLong(request.getParameter("baccnum"));
			String mode=request.getParameter("mode");
			String type=request.getParameter("type");
			double transferAmount=Double.parseDouble(request.getParameter("ammount"));
            HttpSession session = request.getSession(true);
			int custId= (int) session.getAttribute("custId");
			int accId= (int) session.getAttribute("accId");
			AccountDao cd=new AccountDao();
			double availableBalance=cd.getCustAmount(custId);
			
			if(availableBalance>=transferAmount) {
				double finalAmount=availableBalance-transferAmount;
				BillerDao bd=new BillerDao();
				int billerId=bd.addBiller(bFname,bLname,bAccNum);
				if(billerId>0) {
					TransactionDao td=new TransactionDao();
					long transNum=transactionNum();
					int status1=td.saveTrasaction(transNum,transferAmount,mode,type,billerId,custId,accId);
					int status2=AccountDao.updateAccountBalance(accId,custId,finalAmount);
					if(status1>0 &&status2>0) {
						out.print("done");
					}
				}else {
					out.print("failed");
				}
			}else {
				out.print("insuficientBalance");
			}
		}
	}
	public static long generateRandom10DigitNumber(Random random) {
		// Generate a random number between 1000000000 and 9999999999 (inclusive)
		long min = 1000000000L;
		long max = 9999999999L;
		return min + ((long) (random.nextDouble() * (max - min)));
	}
	public static long transactionNum() {
		Random random = new Random();
		long randomNumber = generateRandom10DigitNumber(random);
		return randomNumber;
	}

	

}
