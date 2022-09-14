package com.hibernate.mvc.dto;

public class Person {
	
	private int id;
	private String name;
	private String address;
	private String emailId;
	private int phone;
	private Account account;
	//private AccountStatus status;
	
	
		public Person() {}
	
		public Person(int id, String name, String address, String emailId, int phone,Account account) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.emailId = emailId;
		this.phone = phone;
		this.account.setAcc_id(account.getAcc_id());
		this.account.setPassword(account.getPassword());
		this.account.setAccount_type(account.getAccount_type());
		
	}
	
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", emailId=" + emailId + ", phone="
				+ phone + ", account=" + account + "]";
	}

	
		
	
		

}
