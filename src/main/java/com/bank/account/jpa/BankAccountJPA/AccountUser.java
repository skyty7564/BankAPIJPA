package com.bank.account.jpa.BankAccountJPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usersdb")
public class AccountUser {
	
	public AccountUser(Integer iD, Integer accNum, double balance, String fName, String lName, String email,
			long phoneNumber) {
		super();
		ID = iD;
		this.accNum = accNum;
		this.balance = balance;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	protected AccountUser()
	{}
	


	@Id
	@Column(name="Id")
	private Integer ID;
	@Column(name = "acc_num")
	private Integer accNum;
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "first_name")
	private String fName;
		
    @Column(name = "last_name")
	private String lName;
	
    @Column(name ="email")
	private String email;
	

	
	@Column(name= "phone_number")
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
	public void setBalance(double d) {
		if(d > 0)
			this.balance = d;
		else
			System.out.println("Invalid Input");
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		if(checkRange(fName.length(),2))
			this.fName = fName;
		else
			System.out.println("Name must be greatee than 1 character");
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		
		if(checkRange(lName.length(),2))
			this.lName = lName;
		else
			System.out.println("Name must be greatee than 1 character");
			
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
		String s = Long.toString(phoneNumber);
		if(checkRange(s.length(),10))
			this.phoneNumber = phoneNumber;
		else
			System.out.println("Phone Number must be have 10 value");
	}
	
	
	private static boolean checkRange(int value, int numLength)
	{
		if (value < numLength)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}




}
