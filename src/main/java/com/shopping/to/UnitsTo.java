package com.shopping.to;

public class UnitsTo {
	private int id;
	private String unitName;
	private String conversionValue;
	private int basicUnit;

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
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
	public String getConversionValue() {
		return conversionValue;
	}
	public void setConversionValue(String conversionValue) {
		this.conversionValue = conversionValue;
	}
	public int getBasicUnit() {
		return basicUnit;
	}
	public void setBasicUnit(int basicUnit) {
		this.basicUnit = basicUnit;
	}

}
