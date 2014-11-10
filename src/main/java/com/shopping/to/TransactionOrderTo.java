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
	private TransactionOrderAddressTo address;
//	
	private Collection<TransactionOrderProductListTo> productList = new ArrayList<TransactionOrderProductListTo>();
//
//	//Common  Fields
	private int createdBy;
	private int modifiedBy;
	private String statusMsg;
	
	//	getter& Setters
	public int getId() {
		return id;
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
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
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
	
}
