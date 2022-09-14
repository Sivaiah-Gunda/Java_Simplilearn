package com.hibernate.mvc.dto;

public class Account {
	private String acc_id;
	private String password;
	//private AccountStatus status;
	private String account_type;
	
	
	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public Account() {}

	
	public String getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password= password;
	}

	@Override
	public String toString() {
		return "Account [id=" + acc_id + ", password=" + password + ", account_type=" + account_type + "]";
	}

//	public AccountStatus getStatus() {
//		return status;
//	}
//
//	public void setStatus(AccountStatus status) {
//		this.status = status;
//	}

	

	
	
	

}
