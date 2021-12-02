package com.SpringBootExample.Entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="Product")
@SQLDelete(sql="UPDATE User SET deleted=true WHERE id=?")
@Where(clause ="deleted=false")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProductId;


	@ManyToMany
	@JoinTable(
			name = "address",
			joinColumns = @JoinColumn(name = "product"),
			inverseJoinColumns = @JoinColumn(name = "product")
			)
	Set<Address> enrolledStudents = new HashSet<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User", referencedColumnName = "id")
	private User user;


	@Column(name="Productname")
	private String Productname;

	@Column(name="ProductSKU")
	private String ProductSKU;

	@Column(name="Price")
	private Float Price;

	@Column(name="isActive")
	private String isActive;

	@Column(name="Qty")
	private int Qty;

	@Column(name="CreatedAt")
	private Date createdAt;

	@Column(name="CreatedBy")
	private String createdBy;

	@Column(name="modifiedAt")
	private Date modifiedAt;

	@Column(name="modifiedBy")
	private String modifiedBy;
	
	private boolean deleted = Boolean.FALSE;

	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	public String getProductSKU() {
		return ProductSKU;
	}
	public void setProductSKU(String productSKU) {
		ProductSKU = productSKU;
	}
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public int getQty() {
		return Qty;
	}
	public void setQty(int qty) {
		Qty = qty;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Product(Long productId, String productname, String productSKU, Float price, String isActive, int qty,
			Date createdAt, String createdBy, Date modifiedAt, String modifiedBy) {
		super();
		ProductId = productId;
		Productname = productname;
		ProductSKU = productSKU;
		Price = price;
		this.isActive = isActive;
		Qty = qty;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
	}
	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", Productname=" + Productname + ", ProductSKU=" + ProductSKU
				+ ", Price=" + Price + ", isActive=" + isActive + ", Qty=" + Qty + ", createdAt=" + createdAt
				+ ", createdBy=" + createdBy + ", modifiedAt=" + modifiedAt + ", modifiedBy=" + modifiedBy + "]";
	}
	public Object getaddress1() {
		// TODO Auto-generated method stub
		return null;
	}




}
