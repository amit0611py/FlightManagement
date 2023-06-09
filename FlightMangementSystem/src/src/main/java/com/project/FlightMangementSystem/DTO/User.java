package com.project.FlightMangementSystem.DTO;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	private String userType;
	@Id
    private BigInteger userId;
    private String userName;
    private String userPassword;
    private BigInteger userPhone;
    private String userEmail;
    
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public BigInteger getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(BigInteger userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "User [userType=" + userType + ", userId=" + userId + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userPhone=" + userPhone + ", userEmail=" + userEmail + "]";
	}
	
	public User() {

//	        this.userType = "admin";
//	        this.userId = new BigInteger("123456");
//	        this.userName = "admin";
//	        this.userPassword = "admin123";
//	        this.userPhone = new BigInteger("9876543210");
//	        this.userEmail = "admin@example.com";
//	    
	}
	
	public User(String userType, BigInteger userId, String userName, String userPassword, BigInteger userPhone,
			String userEmail) {
		super();
		this.userType = userType;
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}
    
    

}
