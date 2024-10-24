package com.otz.entity;

public class Customer {
	private int custId;
	private String  custFname ;
	private String  custLname ;
	private String  custEmail ;
	private String  custPass ;
	private String  custPhone ;
	private String  custRedgDate ;
	private String  custDOB ;
	private String  custAddress ;
	private String  custImg ;	
	private int  custUserId ;
	private int deviceId;
    private String latitude;
    private String longitude;
    private String loginDate;
    
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
	public String getCustRedgDate() {
		return custRedgDate;
	}
	public void setCustRedgDate(String custRedgDate) {
		this.custRedgDate = custRedgDate;
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
	public int getCustUserId() {
		return custUserId;
	}
	public void setCustUserId(int custUserId) {
		this.custUserId = custUserId;
	}
	public String getCustImg() {
		return custImg;
	}
	public void setCustImg(String custImg) {
		this.custImg = custImg;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
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
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custFname=" + custFname + ", custLname=" + custLname + ", custEmail="
				+ custEmail + ", custPass=" + custPass + ", custPhone=" + custPhone + ", custRedgDate=" + custRedgDate
				+ ", custDOB=" + custDOB + ", custAddress=" + custAddress + ", custImg=" + custImg + ", custUserId="
				+ custUserId + ", deviceId=" + deviceId + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", loginDate=" + loginDate + "]";
	}
	
	
	
}
