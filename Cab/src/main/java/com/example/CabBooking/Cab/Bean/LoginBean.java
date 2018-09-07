package com.example.CabBooking.Cab.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="login_table")
public class LoginBean {
	
	@Id
	private String loginid;
	private String password;
	private String userType;
	
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
	
}
