package com.shopping.orm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Users")
public class UserOrm implements Serializable{

	private static final long serialVersionUID = -7523667360259054616L;
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "user_name")
	private String userName;
	@Column(name="password")
	private String password;
	
	@Column(name="mobile")
	private String mobile;
	@Column(name="email_id")
	private String emailId;
	@Column(name="is_active")
	private boolean isActive;
	@Column(name="ordered_count")
	private String orderedCount;
	@Column(name="total_txn_amt")
	private String totalTxnAmt;
	@Column(name="role_id")
	private RoleOrm role;
	@Column(name="lang_id")
	private LanguageOrm langId;
	@Column(name="last_login_date")
	private Date lastLoginDate;
	@Column(name="last_login_ip")
	private String lastLoginIp;
	
	@OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL},targetEntity=UserAddressOrm.class)
	@JoinColumn(name="user_id",nullable=false)
	private UserAddressOrm address = new UserAddressOrm();
	

	//Common  Fields
	@ManyToOne
	@JoinColumn(name="created_by")
	private UserOrm createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	@ManyToOne
	@JoinColumn(name="modified_by")
	private UserOrm modifiedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date")
	private Date modifiedDate;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public RoleOrm getRole() {
		return role;
	}
	public void setRole(RoleOrm role) {
		this.role = role;
	}
	public LanguageOrm getLangId() {
		return langId;
	}
	public void setLangId(LanguageOrm langId) {
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
	public UserOrm getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserOrm createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public UserOrm getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(UserOrm modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
