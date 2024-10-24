package com.otz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.otz.util.DbConnection;

public class DeviceDao {
	
	

	public int saveDevice(String latitude, String longitude) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="INSERT INTO 	mobiledevice (latitude,longitude,loginDate)VALUES(?,?,now())";
			PreparedStatement ps=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,latitude);
			ps.setString(2,longitude);
			ps.executeUpdate();
			// get the auto-generated keys 
	        ResultSet rs = ps.getGeneratedKeys(); 
	        if (rs.next()) { 
	        	status = rs.getInt(1); 
	        } 
			con.close();  
		}  catch (SQLException e) {e.printStackTrace();}	
		return status;
	}

	public int updateDevice(String latitude, String longitude, int deviceId) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="update mobiledevice set latitude=?,longitude=?,loginDate=now() where deviceId=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,latitude);
			ps.setString(2,longitude);
			ps.setInt(3, deviceId);
			status=ps.executeUpdate();
			
			con.close();  
		}  catch (SQLException e) {e.printStackTrace();}	
		return status;
	}

	
	
}
