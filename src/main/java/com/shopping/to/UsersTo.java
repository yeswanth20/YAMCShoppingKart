package com.shopping.to;

import com.shopping.orm.UserOrm;

public class UsersTo {
	private int id;
	private String userName;

	//Common  Fields
	private UserOrm createdBy;
	private UserOrm modifiedBy;
	private String statusMsg;
	
//	Getters & Setters
	
	public int getId() {
		return id;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
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
	public UserOrm getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserOrm createdBy) {
		this.createdBy = createdBy;
	}
	public UserOrm getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(UserOrm modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
