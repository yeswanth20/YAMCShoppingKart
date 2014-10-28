package com.shopping.to;

public class BrandTo {
	private int id;
	private String brandNameEng;
	private String brandNameTel;
	private String brandNameHindi;
	private String brandNameTamil;

	private int createdBy;
	private int modifiedBy;


	// Getters & Setters
	
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
