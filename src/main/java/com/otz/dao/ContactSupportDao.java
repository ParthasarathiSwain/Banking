package com.otz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.otz.entity.Branch;
import com.otz.entity.ContactSupport;
import com.otz.util.DbConnection;

public class ContactSupportDao {

	public int saveComplain(ContactSupport cs) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="INSERT INTO customersuport(fname,lname,email,subject,msg,date)VALUES(?,?,?,?,?,now())";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,cs.getFname());	
			ps.setString(2,cs.getLname());		
			ps.setString(3,cs.getEmail());
			ps.setString(4,cs.getSubject());
			ps.setString(5,cs.getMsg());
		
			status=ps.executeUpdate();
			con.close();  
		}  catch (SQLException e) {e.printStackTrace();}	
		return status;
	}

	public List<ContactSupport> viewContactSupport() {
		
			ArrayList<ContactSupport> csList=new ArrayList<ContactSupport>();//Creating Arraylist 
			try {
				Connection con = DbConnection.getConnection();
				String sql="select compId,fname,lname,email,subject,msg,date,status from customersuport ";
				PreparedStatement ps=con.prepareStatement(sql);  
				ResultSet rs=ps.executeQuery();  
				while(rs.next())
				{
					ContactSupport cs = new ContactSupport();
					cs.setCompId(rs.getInt(1));
					cs.setFname(rs.getString(2));
					cs.setLname(rs.getString(3));
					cs.setEmail(rs.getString(4));
					cs.setSubject(rs.getString(5));
					cs.setMsg(rs.getString(6));
					cs.setDate(rs.getString(7));
					cs.setStatus(rs.getInt(8));
					csList.add(cs);
				}
				con.close();  
			}catch(Exception ex) {ex.printStackTrace();}
			return csList ;
		
	}

	public void updateContactSupport(int compId, int status) {
		System.out.println(status);
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update customersuport set status=? where compId=?");
			ps.setInt(1, status);
			ps.setInt(2, compId);
			ps.executeUpdate();
		}catch (SQLException e) {e.printStackTrace();}
	}

}
