package com.otz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.otz.entity.Bank;
import com.otz.util.*;
public class BankDao {

	public int saveBank(Bank bank) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="INSERT INTO Bank(bankName,bankEmail,bankPhone,bankImg)VALUES(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,bank.getBankName());	
			ps.setString(2,bank.getBankEmail());		
			ps.setString(3,bank.getBankPhone());
			ps.setString(4,bank.getBankImg());
			status=ps.executeUpdate();
			con.close();  
		}  catch (SQLException e) {e.printStackTrace();}	
		return status;
	}

	public List<Bank> viewBanks() {
		ArrayList<Bank> bankList=new ArrayList<Bank>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select bankId,bankname,bankemail,bankphone,bankimg from bank";
			PreparedStatement ps=con.prepareStatement(sql);  
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				Bank bank = new Bank();
				bank.setBankId(rs.getInt(1));
				bank.setBankName(rs.getString(2));
				bank.setBankEmail(rs.getString(3));
				bank.setBankPhone(rs.getString(4));
				bank.setBankImg(rs.getString(5));
				bankList.add(bank);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return bankList ;	
	}

	public static int deleteBank(int bankId) {
		int status=0;
		try{  
			Connection con=DbConnection.getConnection(); 
			String sql="delete from bank where bankId=?";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1,bankId);  
			status =ps.executeUpdate();  
		}catch(Exception e){System.out.println(e);}  				  
		return status;  
	}
	// sort Bank by Id
	public List<Bank> sortBankById(int bankId) {
			ArrayList<Bank> bankList=new ArrayList<Bank>();
			try {
				Connection con = DbConnection.getConnection();
				String sql="select bankId,bankname,bankemail,bankphone,bankimg from bank where bankId=?";
				PreparedStatement ps=con.prepareStatement(sql); 
				ps.setInt(1, bankId);
				ResultSet rs=ps.executeQuery();  
				while(rs.next())
				{
					Bank bank = new Bank();
					bank.setBankId(rs.getInt(1));
					bank.setBankName(rs.getString(2));
					bank.setBankEmail(rs.getString(3));
					bank.setBankPhone(rs.getString(4));
					bank.setBankImg(rs.getString(5));
					bankList.add(bank);
				}
				con.close();  
			}catch(Exception ex) {ex.printStackTrace();}
			return bankList ;
		}
		//update Bank
	public void updateBank(Bank bank) {
			try {
				Connection con=DbConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("update bank set bankname=?,bankemail=?,bankphone=?,bankimg=? where bankid=?");
				ps.setString(1,bank.getBankName());
				ps.setString(2,bank.getBankEmail());
				ps.setString(3,bank.getBankPhone());
				ps.setString(4,bank.getBankImg());
				ps.setInt(5,bank.getBankId());
				ps.executeUpdate();
			}catch (SQLException e) {e.printStackTrace();}
		}	
	

	
		

}
