package com.shopping.to;

public class CategoriesTo {
	private int id;
	private String categoryNameEng;
	private String categoryNameTel;
	private String categoryNameHindi;
	private String categoryNameTamil;
	private int parentCategory;
	private int rootCategory;


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
	public int getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(int parentCategory) {
		this.parentCategory = parentCategory;
	}
	public int getRootCategory() {
		return rootCategory;
	}
	public void setRootCategory(int rootCategory) {
		this.rootCategory = rootCategory;
	}
}
