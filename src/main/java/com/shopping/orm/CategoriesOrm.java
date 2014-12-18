package com.shopping.orm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Categories")
public class CategoriesOrm implements Serializable{

	private static final long serialVersionUID = -1932242021588311605L;
	@Id 
//	@GeneratedValue
	private int id;
	@Column(name = "category_name_eng")
	private String categoryNameEng;
	@Column(name = "category_name_tel")
	private String categoryNameTel;
	@Column(name = "category_name_hindi")
	private String categoryNameHindi;
	@Column(name = "category_name_tamil")
	private String categoryNameTamil;
	@ManyToOne
	@JoinColumn(name="parent_category_id")
	private CategoriesOrm parentCategory;
	@ManyToOne
	@JoinColumn(name="root_category_id")
	private CategoriesOrm rootCategory;

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
	public String getCategoryNameEng() {
		return categoryNameEng;
	}
	public void setCategoryNameEng(String categoryNameEng) {
		this.categoryNameEng = categoryNameEng;
	}
	public String getCategoryNameTel() {
		return categoryNameTel;
	}
	public void setCategoryNameTel(String categoryNameTel) {
		this.categoryNameTel = categoryNameTel;
	}
	public String getCategoryNameHindi() {
		return categoryNameHindi;
	}
	public void setCategoryNameHindi(String categoryNameHindi) {
		this.categoryNameHindi = categoryNameHindi;
	}
	public String getCategoryNameTamil() {
		return categoryNameTamil;
	}
	public void setCategoryNameTamil(String categoryNameTamil) {
		this.categoryNameTamil = categoryNameTamil;
	}
	public CategoriesOrm getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(CategoriesOrm parentCategory) {
		this.parentCategory = parentCategory;
	}
	public CategoriesOrm getRootCategory() {
		return rootCategory;
	}
	public void setRootCategory(CategoriesOrm rootCategory) {
		this.rootCategory = rootCategory;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
