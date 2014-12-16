package com.shopping.to;

import java.util.Date;


public class UsersTo {
	private int id;
	private String userName;
	private String password;
	
	private String mobile;
	private String emailId;
	private boolean isActive;
	private String orderedCount;
	private String totalTxnAmt;
	private int role;
	private int langId;
	private Date lastLoginDate;
	private String lastLoginIp;
	private UserAddressTo address;
	
	
	
	
//	Getters & Setters
	
	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getOrderedCount() {
		return orderedCount;
	}
	public void setOrderedCount(String orderedCount) {
		this.orderedCount = orderedCount;
	}
	public String getTotalTxnAmt() {
		return totalTxnAmt;
	}
	public void setTotalTxnAmt(String totalTxnAmt) {
		this.totalTxnAmt = totalTxnAmt;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getLangId() {
		return langId;
	}
	public void setLangId(int langId) {
		this.langId = langId;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public UserAddressTo getAddress() {
		return address;
	}
	public void setAddress(UserAddressTo address) {
		this.address = address;
	}
	
	
}
