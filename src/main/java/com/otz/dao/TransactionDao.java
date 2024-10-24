package com.otz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.otz.entity.Transcation;
import com.otz.util.DbConnection;

public class TransactionDao {
	public List<Transcation> viewTranscationsByCustId(int custId) {
		ArrayList<Transcation> custList=new ArrayList<Transcation>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select T.transNum,T.transType,T.transMode,T.amount,T.transDate,T.transStatus ,B.bFname,B.bLname,B.bAccNum   from transaction T inner join  biller B on  T.billerId=B.billerId where custId=?";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1, custId);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				Transcation tran = new Transcation();
				
				tran.setTransNum(rs.getLong(1));
				tran.setTransType(rs.getString(2));
				tran.setTransMode(rs.getString(3));
				tran.setAmount(rs.getDouble(4));
				tran.setTransDate(rs.getString(5));
				tran.setTransStatus(rs.getInt(6));
				
				tran.setbFname(rs.getString(7));
				tran.setbLname(rs.getString(8));
				tran.setbAccNum(rs.getLong(9));
				custList.add(tran);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return custList ;
	}
	public List<Transcation> viewTranscations() {
		ArrayList<Transcation> custList=new ArrayList<Transcation>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select T.tId,T.transNum,T.transType,T.transMode,T.amount,T.transDate,T.transStatus,A.accNumber,C.custFname ,C.custLname ,B.bFname,B.bLname,B.bAccNum   from transaction T inner join account A on T.accId=A.accId inner join customer C on A.custId=C.custId inner join biller B on  T.billerId=B.billerId";
			PreparedStatement ps=con.prepareStatement(sql);  
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				Transcation tran = new Transcation();
				tran.settId(rs.getInt(1));
				tran.setTransNum(rs.getLong(2));
				tran.setTransType(rs.getString(3));
				tran.setTransMode(rs.getString(4));
				tran.setAmount(rs.getDouble(5));
				tran.setTransDate(rs.getString(6));
				tran.setTransStatus(rs.getInt(7));
				tran.setAccNumber(rs.getLong(8));
				tran.setCustFname(rs.getString(9));
				tran.setCustLname(rs.getString(10));
				tran.setbFname(rs.getString(11));
				tran.setbLname(rs.getString(12));
				tran.setbAccNum(rs.getLong(13));
				custList.add(tran);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return custList ;
	}

	
	public int saveTrasaction(long transNum, double transferAmount, String mode, String type, int billerId, int custId, int accId) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="INSERT INTO transaction(transNum,transType,transMode,amount,transDate,transStatus,accId,custId,billerId)VALUES(?,?,?,?,now(),?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1, transNum);
			ps.setString(2, type);
			ps.setString(3, mode);
			ps.setDouble(4, transferAmount);
			ps.setInt(5, 1);
			ps.setInt(6, accId);
			ps.setInt(7, custId);
			ps.setInt(8, billerId);
			status=ps.executeUpdate();
			con.close();  
		}  catch (SQLException e) {e.printStackTrace();}	
		return status;
	}
}
