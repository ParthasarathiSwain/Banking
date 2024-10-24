package com.otz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.otz.entity.Admin;
import com.otz.util.DbConnection;

public class AdminLoginDao {
	boolean status;
	public boolean validate(Admin bean) {
		try {
		Connection con=DbConnection.getConnection();
		String sql="SELECT count(*) FROM admin WHERE adminEmail=? AND adminPassword=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,bean.getAdminEmail());
		ps.setString(2,bean.getAdminPassword());
		ResultSet rs=ps.executeQuery();
		while(rs.next()) 
		{
			int r=rs.getInt(1);
			if(r>0) {
				status=true;
			}else {
				status = false;
			}
		}
		} catch (SQLException e) {e.printStackTrace();}
		return status;
	}
	public Admin fatchAdminDetails(String username, String password) {
		Admin admin = new Admin();
		try {
			Connection con = DbConnection.getConnection();
			String sql="Select * from Admin WHERE adminEmail=? AND adminPassword=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				
				admin.setAdminId(rs.getInt(1));
				admin.setAdminName(rs.getString(2));
				admin.setAdminEmail(rs.getString(3));
				admin.setAdminPassword(rs.getString(4));
				admin.setAdminPhoto(rs.getString(5));
				admin.setAdminPNum(rs.getString(6));
				
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return admin ;
	}
	
	
}
