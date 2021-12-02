package com.SpringBootExample.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="OrderProducts")
public class OrderProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long OrderItemId;
	
//	@PrimaryKeyJoinColumn
	@Column(name="OrderId")
	private Long OrderId;
	
	@ManyToMany
	@JoinTable(
			name = "orders",
			joinColumns = @JoinColumn(name = "orderproducts"),
			inverseJoinColumns = @JoinColumn(name = "orderproducts")
			)
	
	@Column(name="ProductPrice")
	private Double ProductPrice;
	
	@Column(name="ProductQty")
	private int ProductQty;
	
	public Double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(Double productPrice) {
		ProductPrice = productPrice;
	}
	public int getProductQty() {
		return ProductQty;
	}
	public void setProductQty(int productQty) {
		ProductQty = productQty;
	}
	public OrderProducts(Long orderItemId, Long orderId, Double productPrice, int productQty) {
		super();
		OrderItemId = orderItemId;
		OrderId = orderId;
		ProductPrice = productPrice;
		ProductQty = productQty;
	}
	@Override
	public String toString() {
		return "OrderProducts [OrderItemId=" + OrderItemId + ", OrderId=" + OrderId + ", ProductPrice=" + ProductPrice
				+ ", ProductQty=" + ProductQty + "]";
	}
	
		

}

