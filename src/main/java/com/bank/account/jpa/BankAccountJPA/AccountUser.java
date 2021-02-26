package com.bank.account.jpa.BankAccountJPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usersdb")
public class AccountUser {
	protected AccountUser()
	{}
	
	public AccountUser(Integer accNum, double balance, String fName, String lName, String email, long phoneNumber) {
		super();
		this.accNum = accNum;
		this.balance = balance;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	@Id
	@Column(name = "AccNum", nullable = false, unique = true)
	private Integer accNum;
	
	@Column(name = "Balance")
	private double balance;
	
	@Column(name = "FirstName")
	private String fName;
		
    @Column(name = "LastName")
	private String lName;
	
    @Column(name ="email")
	private String email;
	

	
	@Column(name= "PhoneNumber")
	private long phoneNumber;

	public Integer getAccNum() {
		return accNum;
	}

	public void setAccNum(Integer accNum) {
		this.accNum = accNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
