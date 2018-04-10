package com.hcl.telstraDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Registry")
public class Registry {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uid;
	
	@Column(name="loginname", nullable=false)
	private String loginName;
	
	@Column(name="password", nullable=false)
	private String password;

	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="displayname", nullable=false)
	private String displayName;
	
	@Column(name="phoneno", nullable=false)
	private String phoneNumber;
	
	@Column(name="activestatus", nullable=false)
	private boolean isActive;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
