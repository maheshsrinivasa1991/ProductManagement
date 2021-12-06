package com.SpringBootExample.Resource;

import java.sql.Date;

import javax.persistence.Column;

import com.SpringBootExample.Entity.Product;
import com.SpringBootExample.Entity.User;

public class ProductResource {
	private Long ProductId;
	private User userId;
	private String Productname;
	private String ProductSKU;
	private Float Price;
	private String isActive;
	private int Qty;
	private Date createdAt;
	private String createdBy;
	private Date modifiedAt;
	private String modifiedBy;
	
	 public ProductResource(Product Entity){

	 }

	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUser(User user) {
		this.userId = user;
	}

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

	public void setPath(String filename) {
		// TODO Auto-generated method stub
		
	}

}
