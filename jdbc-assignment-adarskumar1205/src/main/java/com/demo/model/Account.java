package com.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long accountNumber;
	
	private String name;
	private boolean isActive;
	private String city;
	private String country;
	
//	private Set<Benificiary> benificiaries;
//
//	private Address address;
	
	private int balance;
	private String emailAddress;
	
	
	public Account() {
		
	}
	
	public Account(String name, boolean isActive,
			 int balance, String emailAddress,String city,String country) {
			super();
			
			this.name = name;
			this.isActive = isActive;	
			this.balance = balance;
			this.emailAddress = emailAddress;
			this.city = city;
			this.country = country;
			
//			Address address= new Address();
//			address.setCity(city);
//			address.setCountry(country);;
//			this.address=address;
		}


//	public Account(Long accountNumber, String name, boolean isActive,
//		 int balance, String emailAddress,String city,String country) {
//		super();
//		this.accountNumber = accountNumber;
//		this.name = name;
//		this.isActive = isActive;	
//		this.balance = balance;
//		this.emailAddress = emailAddress;
//		
////		Address address= new Address();
////		address.setCity(city);
////		address.setCountry(country);;
////		this.address=address;
//	}

	public void debit(int amount){
		balance-=amount;
	}
	
	public void credit(int amount){
		balance+=amount;
	}
	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

//	public Set<Benificiary> getBenificiaries() {
//		return benificiaries;
//	}
//
//	public void setBenificiaries(Set<Benificiary> benificiaries) {
//		this.benificiaries = benificiaries;
//	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//	
//	


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", isActive=" + isActive + ", city="
				+ city + ", country=" + country + ", balance=" + balance + ", emailAddress=" + emailAddress + "]";
	}

	
}
