package com.SpringBootExample.Resource;

import java.util.Date;

import org.springframework.transaction.support.ResourceHolderSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResource extends ResourceHolderSupport{
    @JsonProperty
	private Long OrderId;
	private String OrderNo;
	private Long UserId;
	private Long ProductId;
	private int OrderTotal;
	private int TotalQty;
	private Date createdAt;
	private String createdBy;
	
	
	public OrderResource(Object order) {
		// TODO Auto-generated constructor stub
	}
	public OrderResource() {
		// TODO Auto-generated constructor stub
	}
	public Long getOrderId() {
		return OrderId;
	}
	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public Long getProductId() {
		return ProductId;
	}
	public void setProductId(Long productId) {
		ProductId = productId;
	}
	public int getOrderTotal() {
		return OrderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		OrderTotal = orderTotal;
	}
	public int getTotalQty() {
		return TotalQty;
	}
	public void setTotalQty(int totalQty) {
		TotalQty = totalQty;
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
	@Override
	public String toString() {
		return "OrderResource [OrderId=" + OrderId + ", OrderNo=" + OrderNo + ", UserId=" + UserId + ", ProductId="
				+ ProductId + ", OrderTotal=" + OrderTotal + ", TotalQty=" + TotalQty + ", createdAt=" + createdAt
				+ ", createdBy=" + createdBy + ", modifiedAt=" + modifiedAt + ", modifiedBy=" + modifiedBy + "]";
	}
	private Date modifiedAt;
	private String modifiedBy;


	public void add(Object createHateoasLink) {
		// TODO Auto-generated method stub
		
	}
}
