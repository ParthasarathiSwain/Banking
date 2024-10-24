package com.otz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.otz.entity.Account;
import com.otz.entity.Customer;
import com.otz.util.DbConnection;

public class AccountDao {

	public int createNewAccount(long accNumber, int custId, int accTypeId, double balance,int branchId) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="INSERT INTO 	account (accNumber,openingDate,balance,closingDate,custId,accTypeId,branchId)VALUES(?,now(),?,DATE_ADD(NOW(), INTERVAL 2 YEAR),?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1,accNumber);
			ps.setDouble(2,balance);
			ps.setInt(3, custId);
			ps.setInt(4, accTypeId);
			ps.setInt(5, branchId);
			status =ps.executeUpdate();

			con.close();  
		}  catch (SQLException e) {e.printStackTrace();}
		return status;
	}
	public List<Account> viewAccounts() {
		ArrayList<Account> accList=new ArrayList<Account>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select A.accId,A.accNumber,A.openingDate,A.balance,A.closingDate,A.acctStatus,C.custFname,C.custLname,C.custImg,D.branchName,E.accTypeName from account A inner join customer C on A.custId=C.custId inner join accounttype E on A.accTypeId =E.accTypeId inner join branch D on A.branchId=D.branchId";
			PreparedStatement ps=con.prepareStatement(sql);  
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				Account acc = new Account();
				acc.setAccId(rs.getInt(1));
				acc.setAccNumber(rs.getLong(2));
				acc.setOpeningDate(rs.getString(3));
				acc.setBalance(rs.getDouble(4));
				acc.setClosingDate(rs.getString(5));
				acc.setAcctStatus(rs.getInt(6));
				acc.setCustFname(rs.getString(7));
				acc.setCustLname(rs.getString(8));
				acc.setCustImg(rs.getString(9));
				acc.setBranchName(rs.getString(10));
				acc.setAccTypeName(rs.getString(11));
				accList.add(acc);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return accList ;
	}
	public static int deactivatedAccount(int accId) {
		int status=0;
		try{  
			Connection con=DbConnection.getConnection(); 
			String sql="update account set acctStatus=?  where accId=?";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1,0);  
			ps.setInt(2,accId); 
			status =ps.executeUpdate();  
		}catch(Exception e){System.out.println(e);}  				  
		return status; 

	}

	public List<Account> fatchAccountById(int accId) {
		ArrayList<Account> accList=new ArrayList<Account>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select A.accId,A.accNumber,A.openingDate,A.balance,A.closingDate,A.acctStatus,A.branchId,C.custFname,C.custLname,C.custImg,C.custEmail,C.custPass,C.custPhone,C.custDOB,C.custAddress,C.custId,D.branchName,E.accTypeId,E.accTypeName from account A inner join customer C on A.custId=C.custId inner join accounttype E on A.accTypeId =E.accTypeId inner join branch D on A.branchId=D.branchId where accId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, accId);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				Account acc = new Account();
				acc.setAccId(rs.getInt(1));
				acc.setAccNumber(rs.getLong(2));
				acc.setOpeningDate(rs.getString(3));
				acc.setBalance(rs.getDouble(4));
				acc.setClosingDate(rs.getString(5));
				acc.setAcctStatus(rs.getInt(6));
				acc.setBranchId(rs.getInt(7));
				acc.setCustFname(rs.getString(8));
				acc.setCustLname(rs.getString(9));
				acc.setCustImg(rs.getString(10));
				acc.setCustEmail(rs.getString(11));
				acc.setCustPass(rs.getString(12));
				acc.setCustPhone(rs.getString(13));
				acc.setCustDOB(rs.getString(14));
				acc.setCustAddress(rs.getString(15));
				acc.setCustId(rs.getInt(16));
				acc.setBranchName(rs.getString(17));
				acc.setAccTypeId(rs.getInt(18));
				acc.setAccTypeName(rs.getString(19));
				accList.add(acc);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return accList ;
	}
	public int updateAccount(Account acc) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="update account set accNumber=?,balance=?,accTypeId=?,branchId=?,acctStatus=? where accId=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1,acc.getAccNumber());
			ps.setDouble(2,acc.getBalance());
			ps.setInt(3, acc.getAccTypeId());
			ps.setInt(4, acc.getBranchId());
			ps.setInt(5, acc.getAcctStatus());
			ps.setInt(6, acc.getAccId());
			status =ps.executeUpdate();

			con.close();  
		}  catch (SQLException e) {e.printStackTrace();}
		return status;
	}
	public Account getAccStatusAndId(int custId) {
		Account acc=new Account();
		try {
			Connection con = DbConnection.getConnection();
			String sql="select accId,acctStatus,accNumber from Account where custId=? ";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1, custId);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				acc.setAccId(rs.getInt(1));
				acc.setAcctStatus(rs.getInt(2));
				acc.setAccNumber(rs.getLong(3));
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		return acc;
	}
	public double getCustAmount(int custId) {
		double status=0;
		try {
			Connection con = DbConnection.getConnection();
			String sql="select balance from Account where custId=? ";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1, custId);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				status=rs.getDouble(1);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		return status;
	}
	public static int updateAccountBalance(int accId, int custId ,double updateAmount) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="update account set balance=?  where accId=? and custId=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setDouble(1,updateAmount);
			ps.setInt(2, accId);
			ps.setInt(3, custId);
			status =ps.executeUpdate();

			con.close();  
		}  catch (SQLException e) {e.printStackTrace();}
		return status;
	}

}
