package com.shopping.to;


public class UserAddressTo{

	private int id;
	private String houseNumber;
	private String street;
	private String area;
	private String landmark;
	private int city;
	private long pincode;
	private long landlineNumber;
	
	//	getter& Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public long getLandlineNumber() {
		return landlineNumber;
	}
	public void setLandlineNumber(long landlineNumber) {
		this.landlineNumber = landlineNumber;
	}
}
