package com.mindgate.pojo;

public class Account {

	private int AccountNumber;
	private String Name;
	private double AccountBalance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public Account(int accountNumber, String name, double accountBalance) {
		super();
		AccountNumber = accountNumber;
		Name = name;
		AccountBalance = accountBalance;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		AccountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Account [AccountNumber=" + AccountNumber + ", Name=" + Name + ", AccountBalance=" + AccountBalance
				+ "]";
	}
	
	//withdraw 
	
	public boolean withdraw(double amount) {
		if (amount<= getAccountBalance()) {
			if(amount==0) {
				System.out.println("plz enter valid amount");
				
			}
			else {
				AccountBalance= AccountBalance-amount;
				return true;
			}
		}
		return false;
	}
	
	// Deposit
	
	public boolean deposit(double amount) {
		if(amount>0) {
			AccountBalance=AccountBalance+amount;
			return true;
		}
		return false;
	}
	
}
