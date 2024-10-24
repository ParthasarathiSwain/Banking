package com.otz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.otz.entity.AccountType;
import com.otz.entity.Branch;
import com.otz.util.DbConnection;

public class AccountTypeDao {
	public  int addAccountType(String  accTypeName) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="INSERT INTO accounttype(accTypeName)VALUES(?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,accTypeName);
			status=ps.executeUpdate();
        }catch (SQLException e) {
           e.printStackTrace();
		}	
        return status;
	}

	public List<AccountType> viewAllAccType() {
		ArrayList<AccountType> acctypeList=new ArrayList<AccountType>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select * from accounttype";
			PreparedStatement ps=con.prepareStatement(sql);  
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				AccountType acctype = new AccountType();
				acctype.setAccTypeId(rs.getInt(1));
				acctype.setAccTypeName(rs.getString(2));
				acctypeList.add(acctype);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return acctypeList ;
	} 
	
	public static int deleteAccountType(int accTypeId) {
		int status=0;
		try{  
			Connection con=DbConnection.getConnection(); 
			String sql="delete from accounttype where accTypeId=?";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1,accTypeId);  
			status =ps.executeUpdate();  
		}catch(Exception e){System.out.println(e);}  				  
		return status; 
		
	}

	public List<AccountType> sortAccTypeById(int accTypeId) {
		ArrayList<AccountType> acctypeList=new ArrayList<AccountType>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select * from accounttype where accTypeId=?";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1, accTypeId);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				AccountType acctype = new AccountType();
				acctype.setAccTypeId(rs.getInt(1));
				acctype.setAccTypeName(rs.getString(2));
				acctypeList.add(acctype);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return acctypeList ;
	}

	public int updateAccountType(String accTypeName, int accTypeId) {
		int status=0;
	
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update accounttype set accTypeName=?  where accTypeId=?");
			ps.setString(1,accTypeName);
			ps.setInt(2, accTypeId);
			status=ps.executeUpdate();
		}catch(Exception ex) {ex.printStackTrace();}
		return status;
	}
}
