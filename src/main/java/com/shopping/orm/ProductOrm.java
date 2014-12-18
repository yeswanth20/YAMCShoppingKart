package com.shopping.orm;

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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "Product")
public class ProductOrm {
	
//	private static final long serialVersionUID = -4696406355094112769L;
	@Id 
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "product_auto_gen_id")
	private String productAutoGenId;
	@Column(name = "product_name_eng")
	private String productNameEng;
	@Column(name = "product_name_hindi")
	private String productNameHindi;
	@Column(name = "product_name_tel")
	private String productNameTel;
	@Column(name = "product_name_tamil")
	private String productNameTamil;
	@Column(name = "is_stock_avaliable")
	private boolean isStockAvailable;
	@ManyToOne
	@JoinColumn(name="brand_id")
	private BrandOrm brand;
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	@Column(columnDefinition="bytea")
	private byte[] productImage;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="product",cascade={CascadeType.ALL},targetEntity=ProductUnitDetailsOrm.class)
//	@OneToMany(mappedBy = "product", cascade= CascadeType.ALL)
	private Collection<ProductUnitDetailsOrm> productUnitDetails = new ArrayList<ProductUnitDetailsOrm>();

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
	public String getProductNameEng() {
		return productNameEng;
	}
	public void setProductNameEng(String productNameEng) {
		this.productNameEng = productNameEng;
	}
	public Collection<ProductUnitDetailsOrm> getProductUnitDetails() {
		return productUnitDetails;
	}
	public void setProductUnitDetails(
			Collection<ProductUnitDetailsOrm> productUnitDetails) {
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
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	public BrandOrm getBrand() {
		return brand;
	}
	public void setBrand(BrandOrm brand) {
		this.brand = brand;
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
	public String getProductAutoGenId() {
		return productAutoGenId;
	}
	public void setProductAutoGenId(String productAutoGenId) {
		this.productAutoGenId = productAutoGenId;
	}

}
