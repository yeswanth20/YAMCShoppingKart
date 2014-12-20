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
@Table(name = "Weights")
public class WeightsOrm implements Serializable{

	private static final long serialVersionUID = -2311520133124657188L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "weight_name")
	private String weightName;
	@Column(name="weight_value")
	private double weightValue;
	@ManyToOne
	@JoinColumn(name="unit_id")
	private UnitsOrm unit;

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
	public String getWeightName() {
		return weightName;
	}
	public void setWeightName(String weightName) {
		this.weightName = weightName;
	}
	public double getWeightValue() {
		return weightValue;
	}
	public void setWeightValue(double weightValue) {
		this.weightValue = weightValue;
	}
	public UnitsOrm getUnit() {
		return unit;
	}
	public void setUnit(UnitsOrm unit) {
		this.unit = unit;
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
