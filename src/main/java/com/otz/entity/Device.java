package com.otz.entity;

public class Device {
	private int deviceId;
	private String  latitude ;
	private String  longitude ;
	private String  loginDate ;
	private int userId;
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
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", latitude=" + latitude + ", longitude=" + longitude + ", loginDate="
				+ loginDate + ", userId=" + userId + "]";
	}
	
	
}
