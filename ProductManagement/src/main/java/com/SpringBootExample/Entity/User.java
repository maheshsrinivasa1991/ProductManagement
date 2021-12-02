package com.SpringBootExample.Entity;

import java.util.Collection;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
@SQLDelete(sql="UPDATE User SET deleted=true WHERE id=?")
@Where(clause ="deleted=false")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="Mobile")
	private int Mobile;
	
	@Column(name="isActive")
	private boolean isActive;
	
	@Column(name="createAt")
	private Date createdAt;
	
	@Column(name="createBy")
	private String createdBy;
	
	@Column(name="modifiedAt")
	private Date modifiedAt;
	
	@Column(name="modifiedBy")
	private String modifiedBy;
	
	private boolean deleted = Boolean.FALSE;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile() {
		return Mobile;
	}
	public void setMobile(int mobile) {
		Mobile = mobile;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	public User(Long id, String username, String email, int mobile, boolean isActive, Date createdAt, String createdBy,
			Date modifiefdAt, String modifiedBy) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		Mobile = mobile;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.modifiedAt = modifiefdAt;
		this.modifiedBy = modifiedBy;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", Mobile=" + Mobile + ", isActive="
				+ isActive + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", modifiefdAt=" + modifiedAt
				+ ", modifiedBy=" + modifiedBy + "]";
	}
	
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "user_roles",
	        joinColumns = @JoinColumn(
	            name = "user_id", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(
	            name = "role_id", referencedColumnName = "id"))

	    private Collection < Role > roles;
	 	public User() {

	    }
		public boolean isDeleted() {
			return deleted;
		}
		public void setDeleted(boolean deleted) {
			this.deleted = deleted;
		}
}
