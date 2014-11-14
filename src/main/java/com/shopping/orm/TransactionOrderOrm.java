package com.shopping.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Transaction_Order")
public class TransactionOrderOrm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2885102041112910386L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "Txn_order_id")
	private String txnOrderID;
	@ManyToOne
	@JoinColumn(name = "transaction_status")
	private TransactionStatusOrm transactionStatus;
	@Column(name = "total_price")
	private double totalPrice;
	@ManyToOne
	@JoinColumn(name = "discount_type")
	private DiscountTypeOrm discountType;
	@Column(name = "discount_value")
	private double discountValue;
	@Column(name = "price_after_discount")
	private double priceAfterDiscount;
	@Column(name = "product_count")
	private int productCount;
	
	@OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL},targetEntity=TransactionOrderAddressOrm.class)
	@JoinColumn(name="transaction_order_id",nullable=false)
	private TransactionOrderAddressOrm address = new TransactionOrderAddressOrm();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="transactionOrder",cascade={CascadeType.ALL},targetEntity=TransactionOrderProductListOrm.class)
	private Collection<TransactionOrderProductListOrm> productList = new ArrayList<TransactionOrderProductListOrm>();
	//Common  Fields
	@ManyToOne
	@JoinColumn(name="created_by")
	private UserOrm createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	@ManyToOne
	@JoinColumn(name="modified_by")
	private UserOrm modifiedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date")
	private Date modifiedDate;	
	
	
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
	
	public TransactionOrderAddressOrm getAddress() {
		return address;
	}
	public void setAddress(TransactionOrderAddressOrm address) {
		this.address = address;
	}
	public UserOrm getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserOrm createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public UserOrm getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(UserOrm modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public Collection<TransactionOrderProductListOrm> getProductList() {
		return productList;
	}
	public void setProductList(
			Collection<TransactionOrderProductListOrm> productList) {
		this.productList = productList;
	}

	public TransactionStatusOrm getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(TransactionStatusOrm transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public DiscountTypeOrm getDiscountType() {
		return discountType;
	}
	public void setDiscountType(DiscountTypeOrm discountType) {
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
