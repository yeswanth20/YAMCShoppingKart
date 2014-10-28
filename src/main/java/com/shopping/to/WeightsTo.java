package com.shopping.to;

public class WeightsTo {
	private int id;
	private String weightName;
	private int unit;

	//Common  Fields
	private int createdBy;
	private int modifiedBy;
	
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
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
