package com.shopping.to;

import java.util.ArrayList;
import java.util.Collection;

public class TransactionOrderTo {
	private int id;
	private String txnOrderID;
//	private int transactionStatus;
//	private double totalPrice;
//	private int discountType;
//	private double discountValue;
//	private double priceAfterDiscount;
//	private TransactionOrderAddressTo address;
//	
//	private Collection<TransactionOrderProductListTo> productList = new ArrayList<TransactionOrderProductListTo>();
//
//	//Common  Fields
//	private int createdBy;
//	private int modifiedBy;
//	private String statusMsg;
	
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
	
}
