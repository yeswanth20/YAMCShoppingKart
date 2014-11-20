package com.shopping.to;

import java.util.ArrayList;
import java.util.Collection;

public class TransactionOrderTo {
	private int id;
	private String txnOrderID;
	private int transactionStatus;
	private double totalPrice;
	private int discountType;
	private double discountValue;
	private double priceAfterDiscount;
	private int productCount;
	private TransactionOrderAddressTo address;
	private Collection<TransactionOrderProductListTo> productList = new ArrayList<TransactionOrderProductListTo>();
	
	//	getter& Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTxnOrderID() {
		return txnOrderID;
	}
	public void setTxnOrderID(String txnOrderID) {
		this.txnOrderID = txnOrderID;
	}
	public TransactionOrderAddressTo getAddress() {
		return address;
	}
	public void setAddress(TransactionOrderAddressTo address) {
		this.address = address;
	}
	public Collection<TransactionOrderProductListTo> getProductList() {
		return productList;
	}
	public void setProductList(Collection<TransactionOrderProductListTo> productList) {
		this.productList = productList;
	}
	public int getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(int transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getDiscountType() {
		return discountType;
	}
	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}
	public double getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	public double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}
	public void setPriceAfterDiscount(double priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
}
