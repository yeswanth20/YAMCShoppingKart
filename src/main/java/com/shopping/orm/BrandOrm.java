package com.shopping.orm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Brand")
public class BrandOrm implements Serializable{

	private static final long serialVersionUID = 8413936688211630043L;
	@Id 
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;
	@Column(name = "brand_name_eng")
	private String brandNameEng;
	@Column(name = "brand_name_tel")
	private String brandNameTel;
	@Column(name = "brand_name_hindi")
	private String brandNameHindi;
	@Column(name = "brand_name_tamil")
	private String brandNameTamil;

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


	//	Getters & Setters
	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrandNameEng() {
		return brandNameEng;
	}
	public void setBrandNameEng(String brandNameEng) {
		this.brandNameEng = brandNameEng;
	}
	public String getBrandNameTel() {
		return brandNameTel;
	}
	public void setBrandNameTel(String brandNameTel) {
		this.brandNameTel = brandNameTel;
	}
	public String getBrandNameHindi() {
		return brandNameHindi;
	}
	public void setBrandNameHindi(String brandNameHindi) {
		this.brandNameHindi = brandNameHindi;
	}
	public String getBrandNameTamil() {
		return brandNameTamil;
	}
	public void setBrandNameTamil(String brandNameTamil) {
		this.brandNameTamil = brandNameTamil;
	}

}
