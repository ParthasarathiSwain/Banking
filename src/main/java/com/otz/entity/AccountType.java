package com.otz.entity;

public class AccountType {
	private int  accTypeId;
	private String accTypeName ;
	public int getAccTypeId() {
		return accTypeId;
	}
	public void setAccTypeId(int accTypeId) {
		this.accTypeId = accTypeId;
	}
	public String getAccTypeName() {
		return accTypeName;
	}
	public void setAccTypeName(String accTypeName) {
		this.accTypeName = accTypeName;
	}
	@Override
	public String toString() {
		return "AccountType [accTypeId=" + accTypeId + ", accTypeName=" + accTypeName + "]";
	}
	
	
}
