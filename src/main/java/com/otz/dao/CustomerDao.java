package com.otz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.otz.entity.Customer;
import com.otz.util.DbConnection;



public class CustomerDao {
	// fatch Password
		public String fatchPassWord(int id) {
			String status="";
			try{  
				Connection con=DbConnection.getConnection(); 
				String sql="Select custPass from  customer where custId=?";
				PreparedStatement ps=con.prepareStatement(sql);  
				ps.setInt(1,id);  
				ResultSet rs=ps.executeQuery(); 
				while(rs.next())
				{
					status=rs.getString(1);

				}
			}catch(Exception e){System.out.println(e);}  

			return status;  
		}
		// change Password
		public int updatePassword(String confirm ,int id) {
			int status=0;
			try{  
				Connection con=DbConnection.getConnection(); 
				String sql="update customer set custPass=?  where custId=?";
				PreparedStatement ps=con.prepareStatement(sql);  
				ps.setString(1,confirm); 
				ps.setInt(2,id);
				status=ps.executeUpdate(); 

			}catch(Exception e){System.out.println(e);}  	
			return status;
		}
	//save cust get cust Id
	public int saveCustomerGetCustId(Customer cust) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="INSERT INTO customer(custFname,custLname,custEmail,custPhone,custRedgDate,custDOB,custAddress,custUserId,custPass,deviceId,custImg)VALUES(?,?,?,?,now(),?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,cust.getCustFname());
			ps.setString(2,cust.getCustLname());
			ps.setString(3,cust.getCustEmail());
			ps.setString(4,cust.getCustPhone());
			ps.setString(5,cust.getCustDOB());
			ps.setString(6,cust.getCustAddress());
			ps.setInt(7,cust.getCustUserId());
			ps.setString(8,cust.getCustPass());
			ps.setInt(9,cust.getDeviceId());
			ps.setString(10,cust.getCustImg());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys(); 
	        if (rs.next()) { 
	        	status = rs.getInt(1); 
	        } 
			con.close();  
		}  catch (SQLException e) {e.printStackTrace();}	
		return status;
	}
//	public int saveCustomer(Customer cust) {
//		int status=0;
//		try {
//			Connection con=DbConnection.getConnection();
//			String query="INSERT INTO customer(custFname,custLname,custEmail,custPhone,custRedgDate,custDOB,custAddress,custUserId,custPass,deviceId,custImg)VALUES(?,?,?,?,now(),?,?,?,?,?,?)";
//			PreparedStatement ps=con.prepareStatement(query);
//			ps.setString(1,cust.getCustFname());
//			ps.setString(2,cust.getCustLname());
//			ps.setString(3,cust.getCustEmail());
//			ps.setString(4,cust.getCustPhone());
//			ps.setString(5,cust.getCustDOB());
//			ps.setString(6,cust.getCustAddress());
//			ps.setInt(7,cust.getCustUserId());
//			ps.setString(8,cust.getCustPass());
//			ps.setInt(9,cust.getDeviceId());
//			ps.setString(10,cust.getCustImg());
//			status=ps.executeUpdate();
//			con.close();  
//		}  catch (SQLException e) {e.printStackTrace();}	
//		return status;
//	}
	public List<Customer> viewCustomers() {
		ArrayList<Customer> custList=new ArrayList<Customer>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select C.custId,C.custFname,C.custLname,C.custEmail,C.custPhone,C.custRedgDate,C.custDOB,C.custAddress,C.custUserId,C.custPass,C.deviceId,C.custImg,M.latitude,M.longitude from customer C inner join mobiledevice M on C.deviceId=M.deviceId";
			PreparedStatement ps=con.prepareStatement(sql);  
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				Customer cust = new Customer();
				cust.setCustId(rs.getInt(1));
				cust.setCustFname(rs.getString(2));
				cust.setCustLname(rs.getString(3));
				cust.setCustEmail(rs.getString(4));
				cust.setCustPhone(rs.getString(5));
				cust.setCustRedgDate(rs.getString(6));
				cust.setCustDOB(rs.getString(7));
				cust.setCustAddress(rs.getString(8));
				cust.setCustUserId(rs.getInt(9));
				cust.setCustPass(rs.getString(10));
				cust.setDeviceId(rs.getInt(11));
				cust.setCustImg(rs.getString(12));
				cust.setLatitude(rs.getString(13));
				cust.setLongitude(rs.getString(14));
				custList.add(cust);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return custList ;
	}
	public static int deleteCustomer(int custId) {
		int status=0;
		try{  
			Connection con=DbConnection.getConnection(); 
			String sql="delete from Customer where custId=?";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1,custId);  
			status =ps.executeUpdate();  
		}catch(Exception e){System.out.println(e);}  				  
		return status;  	
	}
	public List<Customer> fatchCustById(int custId) {
		ArrayList<Customer> custList=new ArrayList<Customer>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select C.custId,C.custFname,C.custLname,C.custEmail,C.custPhone,C.custRedgDate,C.custDOB,C.custAddress,C.custUserId,C.custPass,C.deviceId,C.custImg,M.latitude,M.longitude from customer C inner join mobiledevice M on C.deviceId=M.deviceId where custId=?";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1, custId);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				Customer cust = new Customer();
				cust.setCustId(rs.getInt(1));
				cust.setCustFname(rs.getString(2));
				cust.setCustLname(rs.getString(3));
				cust.setCustEmail(rs.getString(4));
				cust.setCustPhone(rs.getString(5));
				cust.setCustRedgDate(rs.getString(6));
				cust.setCustDOB(rs.getString(7));
				cust.setCustAddress(rs.getString(8));
				cust.setCustUserId(rs.getInt(9));
				cust.setCustPass(rs.getString(10));
				cust.setDeviceId(rs.getInt(11));
				cust.setCustImg(rs.getString(12));
				cust.setLatitude(rs.getString(13));
				cust.setLongitude(rs.getString(14));
				custList.add(cust);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return custList ;
	}
	public int getDeviceId(int custId) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="select deviceId from customer where custId=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,custId);
			ResultSet rs=ps.executeQuery();
			 
	        if (rs.next()) { 
	        	status = rs.getInt(1); 
	        } 
			con.close();  
		}  catch (SQLException e) {e.printStackTrace();}	
		return status;
	}
	public int updateCustomerBasicDetails(Customer cust) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update Customer set custFname=?,custLname=?,custEmail=?,custPhone=?,custAddress=? where custId=?");
			ps.setString(1, cust.getCustFname());
			ps.setString(2, cust.getCustLname());
			ps.setString(3, cust.getCustEmail());
			ps.setString(4, cust.getCustPhone());
			ps.setString(5, cust.getCustAddress());
			ps.setInt(6, cust.getCustId());
			status=ps.executeUpdate();
		}catch (SQLException e) {e.printStackTrace();}
		return status;
	}
	public int updateCustomer(Customer cust) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update Customer set custFname=?,custLname=?,custEmail=?,custPass=?,custPhone=?,custDOB=?,custAddress=?,custImg=? where custId=?");
			ps.setString(1, cust.getCustFname());
			ps.setString(2, cust.getCustLname());
			ps.setString(3, cust.getCustEmail());
			ps.setString(4, cust.getCustPass());
			ps.setString(5, cust.getCustPhone());
			ps.setString(6, cust.getCustDOB());
			ps.setString(7, cust.getCustAddress());
			ps.setString(8, cust.getCustImg());
			ps.setInt(9, cust.getCustId());
			status=ps.executeUpdate();
		}catch (SQLException e) {e.printStackTrace();}
		return status;
	}
	public int updateCustomerByAccount(Customer cust) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update Customer set custFname=?,custLname=?,custEmail=?,custPass=?,custPhone=?,custDOB=?,custAddress=? where custId=?");
			ps.setString(1, cust.getCustFname());
			ps.setString(2, cust.getCustLname());
			ps.setString(3, cust.getCustEmail());
			ps.setString(4, cust.getCustPass());
			ps.setString(5, cust.getCustPhone());
			ps.setString(6, cust.getCustDOB());
			ps.setString(7, cust.getCustAddress());
			ps.setInt(8, cust.getCustId());
			status=ps.executeUpdate();
		}catch (SQLException e) {e.printStackTrace();}
		return status;
	}
	public int checkValidUser(int custUserId, String password) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String sql="SELECT count(*) FROM customer where custUserId=? AND custPass=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, custUserId);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				status=rs.getInt(1);
			}
		}catch (SQLException e) {e.printStackTrace();}
		return status;
	}
	public Customer getCustDetails(int custUserId, String password) {
		Customer cust=new Customer();
		try {
			Connection con = DbConnection.getConnection();
			String sql="select custId,custFname,custEmail,custImg,deviceId from customer where custUserId=? AND custPass=?";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1, custUserId);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				cust.setCustId(rs.getInt(1));
				cust.setCustFname(rs.getString(2));
				cust.setCustEmail(rs.getString(3));
				cust.setCustImg(rs.getString(4));
				cust.setDeviceId(rs.getInt(5));
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		return cust;
	}
	
}
