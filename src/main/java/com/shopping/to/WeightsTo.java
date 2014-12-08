package com.shopping.to;

public class WeightsTo {
	private int id;
	private String weightName;
	private double weightValue;
	private int unit;
	
	//	getter& Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getWeightValue() {
		return weightValue;
	}
	public void setWeightValue(double weightValue) {
		this.weightValue = weightValue;
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
}
