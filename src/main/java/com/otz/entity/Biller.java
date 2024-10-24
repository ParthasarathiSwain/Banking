package com.otz.entity;

public class Biller {
	private int billerId;
	private String bFname;
	private String bLname;
	private long bAccNum;
	public int getBillerId() {
		return billerId;
	}
	public void setBillerId(int billerId) {
		this.billerId = billerId;
	}
	public String getbFname() {
		return bFname;
	}
	public void setbFname(String bFname) {
		this.bFname = bFname;
	}
	public String getbLname() {
		return bLname;
	}
	public void setbLname(String bLname) {
		this.bLname = bLname;
	}
	public long getbAccNum() {
		return bAccNum;
	}
	public void setbAccNum(long bAccNum) {
		this.bAccNum = bAccNum;
	}
	@Override
	public String toString() {
		return "Biller [billerId=" + billerId + ", bFname=" + bFname + ", bLname=" + bLname + ", bAccNum=" + bAccNum
				+ "]";
	}
	
	
}
