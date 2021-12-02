package com.SpringBootExample.Entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long OrderId;
	
	@ManyToMany
	@JoinTable(
			name = "product",
			joinColumns = @JoinColumn(name = "order"),
			inverseJoinColumns = @JoinColumn(name = "order")
			)
	
	@Column(name="orderNo")
	private String OrderNo;
	
	@PrimaryKeyJoinColumn
	@Column(name="userId")
	private Long UserId;
	
	@PrimaryKeyJoinColumn
	@Column(name="ProductId")
	private Long ProductId;
	
	@Column(name="orderTotal")
	private int OrderTotal;
	
	@Column(name="totalQty")
	private int TotalQty;
	
	@Column(name="createdAt")
	private Date createdAt;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="modifiedAt")
	private Date modifiedAt;
	
	@Column(name="modifiedBy")
	private String modifiedBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User User;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Product Product;
	
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
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
	public Orders(Long orderId, String orderNo, Long userId, int orderTotal, int totalQty, Date createdAt,
			String createdBy, Date modifiedAt, String modifiedBy) {
		super();
		OrderId = orderId;
		OrderNo = orderNo;
		UserId = userId;
		OrderTotal = orderTotal;
		TotalQty = totalQty;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
	}
	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", OrderNo=" + OrderNo + ", UserId=" + UserId + ", OrderTotal="
				+ OrderTotal + ", TotalQty=" + TotalQty + ", createdAt=" + createdAt + ", createdBy=" + createdBy
				+ ", modifiedAt=" + modifiedAt + ", modifiedBy=" + modifiedBy + "]";
	}
	
	
}

