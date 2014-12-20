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
@Table(name = "Units")
public class UnitsOrm implements Serializable{
	private static final long serialVersionUID = 8631961939663219113L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "unit_name", unique = true)
	private String unitName;
	@Column(name = "conversion_value")
	private String conversionValue;
	@ManyToOne
	@JoinColumn(name="basic_unit_id")
	private UnitsOrm basicUnit;

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
	
  
	//	getter& Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
	public String getConversionValue() {
		return conversionValue;
	}
	public void setConversionValue(String conversionValue) {
		this.conversionValue = conversionValue;
	}
	public UnitsOrm getBasicUnit() {
		return basicUnit;
	}
	public void setBasicUnit(UnitsOrm basicUnit) {
		this.basicUnit = basicUnit;
	}


}
