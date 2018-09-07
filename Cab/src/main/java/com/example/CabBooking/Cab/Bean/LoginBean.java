package com.example.CabBooking.Cab.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="login_table")
public class LoginBean {
	
	@Id
	private String loginid;
	private String password;
	private String userType;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_address")
	private String userAddress;
	@Column(name="user_contact_number")
	private String userContactNumber; 
	public LoginBean() {
		
	}

	public LoginBean(String loginid, String password,String userType) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.userType= userType;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setConfirmPasswird(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserContactNumber() {
		return userContactNumber;
	}

	public void setUserContactNumber(String userContactNumber) {
		this.userContactNumber = userContactNumber;
	}
	
	
	
}
