package com.cg.health.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 @Entity
@Table(name = "InsuranceUser")
public class PolicyUser {
	  @Id
	  @Column(name="userId")
	   @GeneratedValue(strategy = GenerationType.AUTO)
	  private int userId;
	  private String userName;
	  private String password;
	  private long phoneNo;
	  private String emailId;
	  private long aadhaarNo;
	  private LocalDate dob;
	  
	public PolicyUser(int userId, String userName, String password, long phoneNo, String emailId, long aadhaarNo,LocalDate dob) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.aadhaarNo = aadhaarNo;
		this.dob= dob;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public PolicyUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	@Override
	public String toString() {
		return "PolicyUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phoneNo="
				+ phoneNo + ", emailId=" + emailId + ", aadhaarNo=" + aadhaarNo + ", dob=" + dob + "]";
	}

	
}
