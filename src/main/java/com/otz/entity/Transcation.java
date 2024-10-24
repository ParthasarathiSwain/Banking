package com.otz.entity;

public class Transcation {
	private int tId;
	private long  transNum ;
	private String  transType ;
	private String  transMode ;
	private double  amount ;
	private String  transDate ;
	private int  transStatus ;
	private int accId;
	private long accNumber;
	private int custId;
	private String  custFname ;
	private String  custLname ;
	private int billerId;
	private String bFname;
	private String bLname;
	private long bAccNum;
	
	public long getbAccNum() {
		return bAccNum;
	}
	public void setbAccNum(long bAccNum) {
		this.bAccNum = bAccNum;
	}
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public long getTransNum() {
		return transNum;
	}
	public void setTransNum(long transNum) {
		this.transNum = transNum;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getTransMode() {
		return transMode;
	}
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public int getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(int transStatus) {
		this.transStatus = transStatus;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustFname() {
		return custFname;
	}
	public void setCustFname(String custFname) {
		this.custFname = custFname;
	}
	public String getCustLname() {
		return custLname;
	}
	public void setCustLname(String custLname) {
		this.custLname = custLname;
	}
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
	@Override
	public String toString() {
		return "Transcation [tId=" + tId + ", transNum=" + transNum + ", transType=" + transType + ", transMode="
				+ transMode + ", amount=" + amount + ", transDate=" + transDate + ", transStatus=" + transStatus
				+ ", accId=" + accId + ", accNumber=" + accNumber + ", custId=" + custId + ", custFname=" + custFname
				+ ", custLname=" + custLname + ", billerId=" + billerId + ", bFname=" + bFname + ", bLname=" + bLname
				+ ", bAccNum=" + bAccNum + "]";
	}
		
}
