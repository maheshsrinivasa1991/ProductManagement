package com.SpringBootExample.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="address")
@SQLDelete(sql="UPDATE User SET deleted=true WHERE id=?")
@Where(clause ="deleted=false")
public class Address {
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AddressId;
	
 

//	@PrimaryKeyJoinColumn
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="pincode")
	private int Pincode;
	
	@Column(name="isActive")
	private boolean isActive;
	
	@Column(name="isPrimary")
	private boolean isPrimary;
	
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
	
	private boolean deleted = Boolean.FALSE;
	
	
	public String getAddress() {
		return getAddress();
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getPincode() {
		return Pincode;
	}
	public void setPincode(int pincode) {
		Pincode = pincode;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isPrimary() {
		return isPrimary;
	}
	public void setPrimary(boolean isPrimary) {
		this.isPrimary =isPrimary;
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
	public Date getModifiefdAt() {
		return modifiedAt;
	}
	public void setModifiefdAt(Date modifiefdAt) {
		this.modifiedAt = modifiefdAt;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
	public Address(Long addressId, int userId, String address1, String address2, int pincode, boolean isActive,
			boolean isPrimary, Date createdAt, String createdBy, Date modifiefdAt, String modifiedBy) {
		super();
		AddressId = addressId;
		this.userId = userId;
		this.address1 = address1;
		this.address2 = address2;
		this.Pincode = pincode;
		this.isActive = isActive;
		this.isPrimary = isPrimary;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.modifiedAt = modifiefdAt;
		this.modifiedBy = modifiedBy;
	}
	@Override
	public String toString() {
		return "Address [AddressId=" + AddressId + ", userId=" + userId + ", address1=" + address1 + ", address2="
				+ address2 + ", Pincode=" + Pincode + ", isActive=" + isActive + ", isPrimary=" + isPrimary
				+ ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", modifiefdAt=" + modifiedAt
				+ ", modifiedBy=" + modifiedBy + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean getisActive() {
		return isActive;
	}
	public boolean getisPrimary() {
		return isPrimary;
	}
	public String getAddress1() {
		return address1;
	}


}
