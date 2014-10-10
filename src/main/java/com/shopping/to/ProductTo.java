package com.shopping.to;

import java.util.ArrayList;
import java.util.Collection;

import com.shopping.orm.UserOrm;


public class ProductTo {
	private int id;
	private String productNameEng;
	private String productNameHindi;
	private String productNameTel;
	private String productNameTamil;
	private boolean isStockAvailable;
	private BrandTo brand;
	private String productAutoGenId;
	
//	private byte[] productImage;
	
	private Collection<ProductUnitDetailsTo> productUnitDetails = new ArrayList<ProductUnitDetailsTo>();

	//Common  Fields
	private UserOrm createdBy;
	private UserOrm modifiedBy;
	private String statusMsg;
	
	
	//	Getter & Setters
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductNameEng() {
		return productNameEng;
	}
	public void setProductNameEng(String productNameEng) {
		this.productNameEng = productNameEng;
	}
	public Collection<ProductUnitDetailsTo> getProductUnitDetails() {
		return productUnitDetails;
	}
	public void setProductUnitDetails(
			Collection<ProductUnitDetailsTo> productUnitDetails) {
		this.productUnitDetails = productUnitDetails;
	}
	public String getProductNameHindi() {
		return productNameHindi;
	}
	public void setProductNameHindi(String productNameHindi) {
		this.productNameHindi = productNameHindi;
	}
	public String getProductNameTel() {
		return productNameTel;
	}
	public void setProductNameTel(String productNameTel) {
		this.productNameTel = productNameTel;
	}
	public String getProductNameTamil() {
		return productNameTamil;
	}
	public void setProductNameTamil(String productNameTamil) {
		this.productNameTamil = productNameTamil;
	}
	public boolean isStockAvailable() {
		return isStockAvailable;
	}
	public void setStockAvailable(boolean isStockAvailable) {
		this.isStockAvailable = isStockAvailable;
	}
//	public byte[] getProductImage() {
//		return productImage;
//	}
//	public void setProductImage(byte[] productImage) {
//		this.productImage = productImage;
//	}
	public BrandTo getBrand() {
		return brand;
	}
	public void setBrand(BrandTo brand) {
		this.brand = brand;
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
	public String getProductAutoGenId() {
		return productAutoGenId;
	}
	public void setProductAutoGenId(String productAutoGenId) {
		this.productAutoGenId = productAutoGenId;
	}



}
