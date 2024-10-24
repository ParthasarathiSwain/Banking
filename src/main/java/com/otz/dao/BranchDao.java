package com.otz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.otz.entity.Branch;
import com.otz.util.DbConnection;

public class BranchDao {
	public int saveBranch(Branch branch) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="INSERT INTO Branch(branchName,location,createdDate,createdBy,updatedDate,updatedBy,bankid)VALUES(?,?,now(),?,now(),?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,branch.getBranchName());
			ps.setString(2,branch.getLocation());
			ps.setString(3,branch.getCreatedBy());
			ps.setString(4,"Admin");
			ps.setInt(5,branch.getBankid());
			status=ps.executeUpdate();
			con.close();  
		}  catch (SQLException e) {e.printStackTrace();}	
		return status;
	}

	public List<Branch> viewBranches() {
		ArrayList<Branch> branchList=new ArrayList<Branch>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select A.branchId ,A.branchName,A.location,A.createdDate,A.createdBy,A.updatedDate,A.updatedBy ,A.IsActive,A.bankId,B.bankname  from branch A inner join Bank B on A.bankId=B.bankId ";
			PreparedStatement ps=con.prepareStatement(sql);  
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				Branch branch = new Branch();
				branch.setBranchId(rs.getInt(1));
				branch.setBranchName(rs.getString(2));
				branch.setLocation(rs.getString(3));
				branch.setCreatedDate(rs.getString(4));
				branch.setCreatedBy(rs.getString(5));
				branch.setUpdatedDate(rs.getString(6));
				branch.setUpdatedBy(rs.getString(7));
				branch.setIsActive(rs.getInt(8));
				branch.setBankid(rs.getInt(9));
				branch.setBankName(rs.getString(10));
				branchList.add(branch);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return branchList ;
	}

	public static int deleteBranch(int branchId) {
		int status=0;
		try{  
			Connection con=DbConnection.getConnection(); 
			String sql="delete from branch where branchId=?";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1,branchId);  
			status =ps.executeUpdate();  
		}catch(Exception e){System.out.println(e);}  				  
		return status; 
		
	}

	public List<Branch> sortBranchById(int branchId) {
		ArrayList<Branch> branchList=new ArrayList<Branch>();
		try {
			Connection con = DbConnection.getConnection();
			String sql="select A.branchId ,A.branchName,A.location,A.createdDate,A.createdBy,A.updatedDate,A.updatedBy ,A.IsActive,A.bankId,B.bankname  from branch A inner join Bank B on A.bankId=B.bankId where branchId=?";
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setInt(1, branchId);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				Branch branch = new Branch();
				branch.setBranchId(rs.getInt(1));
				branch.setBranchName(rs.getString(2));
				branch.setLocation(rs.getString(3));
				branch.setCreatedDate(rs.getString(4));
				branch.setCreatedBy(rs.getString(5));
				branch.setUpdatedDate(rs.getString(6));
				branch.setUpdatedBy(rs.getString(7));
				branch.setIsActive(rs.getInt(8));
				branch.setBankid(rs.getInt(9));
				branch.setBankName(rs.getString(10));
				branchList.add(branch);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return branchList ;
	}
	
	public void updateBranch(Branch branch) {
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update branch set branchName=?,location=?,createdBy=?,updatedBy=?,updatedDate=now(),IsActive=? where branchId=?");
			ps.setString(1, branch.getBranchName());
			ps.setString(2, branch.getLocation());
			ps.setString(3, branch.getCreatedBy());
			ps.setString(4, branch.getUpdatedBy());
			ps.setInt(5, branch.getIsActive());
			ps.setInt(6, branch.getBranchId());
			ps.executeUpdate();
		}catch (SQLException e) {e.printStackTrace();}
	}

	public List<Branch> getBranchByBankId(int bankId) {
		ArrayList<Branch> branchList=new ArrayList<Branch>();//Creating Arraylist 
		try {
			Connection con = DbConnection.getConnection();
			String sql="select A.branchId ,A.branchName,A.location,A.createdDate,A.createdBy,A.updatedDate,A.updatedBy  from branch A where A.IsActive=1 AND A.bankId=? ";
			PreparedStatement ps=con.prepareStatement(sql);  
			ps.setInt(1, bankId);
			ResultSet rs=ps.executeQuery();  
			while(rs.next())
			{
				Branch branch = new Branch();
				branch.setBranchId(rs.getInt(1));
				branch.setBranchName(rs.getString(2));
				branch.setLocation(rs.getString(3));
				branch.setCreatedDate(rs.getString(4));
				branch.setCreatedBy(rs.getString(5));
				branch.setUpdatedDate(rs.getString(6));
				branch.setUpdatedBy(rs.getString(7));
				
				branchList.add(branch);
			}
			con.close();  
		}catch(Exception ex) {ex.printStackTrace();}
		return branchList ;
	}	
}
