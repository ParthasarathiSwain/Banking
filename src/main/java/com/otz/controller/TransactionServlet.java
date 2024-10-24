package com.otz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.otz.dao.TransactionDao;
import com.otz.entity.Transcation;

@WebServlet("/transServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();
		String event=request.getParameter("event");
		 if(event.equals("getAllTransaction")) {
			try {
				TransactionDao td=new TransactionDao();
				List<Transcation> transList= td.viewTranscations();
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(transList);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(event.equals("getAllTransactionCustID")) {
			try {
				HttpSession session = request.getSession(true);
				int custId= (int) session.getAttribute("custId");
				TransactionDao td=new TransactionDao();
				List<Transcation> transList= td.viewTranscationsByCustId(custId);
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson  gson = gsonBuilder.create();
				String JSONObject = gson.toJson(transList);				
				out.print(JSONObject);				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
