package com.otz.entity;

public class Account {
	private int accId;
	private long  accNumber ;
	private String  openingDate ;
	private double  balance ;
	private String  closingDate ;
	private int  acctStatus ;
	private String  custFname ;
	private String  custLname ;	
	private int deviceId;
	private int accTypeId;
	private String accTypeName;
	private int custId;
    private String latitude;
    private String longitude;
    private int branchId;
    private String branchName;
    private String custImg;
    private String  custEmail ;
	private String  custPass ;
	private String  custPhone ;
	private String  custDOB ;
	private String  custAddress ;
	
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustPass() {
		return custPass;
	}
	public void setCustPass(String custPass) {
		this.custPass = custPass;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustDOB() {
		return custDOB;
	}
	public void setCustDOB(String custDOB) {
		this.custDOB = custDOB;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustImg() {
		return custImg;
	}
	public void setCustImg(String custImg) {
		this.custImg = custImg;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
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
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public String getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	public int getAcctStatus() {
		return acctStatus;
	}
	public void setAcctStatus(int acctStatus) {
		this.acctStatus = acctStatus;
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
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accNumber=" + accNumber + ", openingDate=" + openingDate + ", balance="
				+ balance + ", closingDate=" + closingDate + ", acctStatus=" + acctStatus + ", custFname=" + custFname
				+ ", custLname=" + custLname + ", deviceId=" + deviceId + ", accTypeId=" + accTypeId + ", accTypeName="
				+ accTypeName + ", custId=" + custId + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", branchId=" + branchId + ", branchName=" + branchName + ", custImg=" + custImg + ", custEmail="
				+ custEmail + ", custPass=" + custPass + ", custPhone=" + custPhone + ", custDOB=" + custDOB
				+ ", custAddress=" + custAddress + "]";
	}
    
}
