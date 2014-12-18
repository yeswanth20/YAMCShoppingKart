package com.shopping.orm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Transaction_Order_Product_List")
public class TransactionOrderProductListOrm implements Serializable{
	private static final long serialVersionUID = 6545382071005355023L;
	@Id 
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name="unit_id")
	private UnitsOrm unit;
	@ManyToOne
	@JoinColumn(name = "discount_type_id")
	private DiscountTypeOrm discountType;
	
	@Column(name = "discount_value")
	private double discountValue;
	
	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="weight_id")
	private WeightsOrm weight;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private ProductOrm product;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transaction_order_id", nullable=false)
	private TransactionOrderOrm transactionOrder;
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
	public UnitsOrm getUnit() {
		return unit;
	}
	public void setUnit(UnitsOrm unit) {
		this.unit = unit;
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
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public WeightsOrm getWeight() {
		return weight;
	}
	public void setWeight(WeightsOrm weight) {
		this.weight = weight;
	}
	public ProductOrm getProduct() {
		return product;
	}
	public void setProduct(ProductOrm product) {
		this.product = product;
	}
	public TransactionOrderOrm getTransactionOrder() {
		return transactionOrder;
	}
	public void setTransactionOrder(TransactionOrderOrm transactionOrder) {
		this.transactionOrder = transactionOrder;
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
	
}
