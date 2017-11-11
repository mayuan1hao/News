package com.news.file.bean;

public class User {
	private String uId;
	private String uName;
	private String password;
	private int uType;
	public User(String uId, String uName, String password, int uType) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.password = password;
		this.uType = uType;
	}
	public User() {
		super();
	}
	public String getuId() {
		return uId;
	}
	public String getuName() {
		return uName;
	}
	public String getPassword() {
		return password;
	}
	public int getuType() {
		return uType;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setuType(int uType) {
		this.uType = uType;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", password="
				+ password + ", uType=" + uType + "]";
	}
}
