package com.otz.entity;

public class ContactSupport {
	private int compId;
	private String  fname ;
	private String  lname ;
	private String  email ;
	private String  subject ;
	private String  msg ;
	private String date;
	private int status;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ContactSupport [compId=" + compId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", subject=" + subject + ", msg=" + msg + ", date=" + date + ", status=" + status + "]";
	}
	
	
}
