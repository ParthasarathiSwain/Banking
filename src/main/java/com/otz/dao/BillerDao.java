package com.otz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.otz.entity.Biller;
import com.otz.util.DbConnection;

public class BillerDao {
	public  int addBiller(String fname,String lname,long bAccNum) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="INSERT INTO biller(bFname,bLname,bAccNum)VALUES(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,fname);
			ps.setString(2,lname);
			ps.setLong(3, bAccNum);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys(); 
	        if (rs.next()) { 
	        	status = rs.getInt(1); 
	        } 
        }catch (SQLException e) {
           e.printStackTrace();
		}	
        return status;
	}
	public List<Biller> getAllBiller() {
		ArrayList<Biller> acctypeList=new ArrayList<Biller>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select * from biller";
			PreparedStatement ps=con.prepareStatement(sql);  
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				Biller biller = new Biller();
				biller.setBillerId(rs.getInt(1));
				biller.setbFname(rs.getString(2));
				biller.setbLname(rs.getString(3));
				biller.setbAccNum(rs.getLong(4));
				acctypeList.add(biller);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return acctypeList ;
	}

}
