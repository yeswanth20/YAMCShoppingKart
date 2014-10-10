package com.shopping.to;

import com.shopping.orm.UserOrm;

public class ProductUnitDetailsTo {

	private int id;
	private UnitsTo unit;
	private WeightsTo weight;
	private DiscountTypeTo discountType;
	private double discountValue;
	private double price;
	private ProductTo product;
	//Common  Fields
	private UserOrm createdBy;
	private UserOrm modifiedBy;
	private String statusMsg;
	
	
	//	Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ProductTo getProduct() {
		return product;
	}
	public void setProduct(ProductTo product) {
		this.product = product;
	}
	public UnitsTo getUnit() {
		return unit;
	}
	public void setUnit(UnitsTo unit) {
		this.unit = unit;
	}
	public WeightsTo getWeight() {
		return weight;
	}
	public void setWeight(WeightsTo weight) {
		this.weight = weight;
	}
	public DiscountTypeTo getDiscountType() {
		return discountType;
	}
	public void setDiscountType(DiscountTypeTo discountType) {
		this.discountType = discountType;
	}
	public double getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
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
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
}
