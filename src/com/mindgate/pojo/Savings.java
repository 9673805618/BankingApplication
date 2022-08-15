package com.mindgate.pojo;

public class Savings extends Account{

	private boolean isSalary;
	double savingAmount;
	public Savings() {
		// TODO Auto-generated constructor stub
	}
	public Savings(int accountNumber, String name, double accountBalance, boolean isSalary, double savingAmount) {
		super(accountNumber, name, accountBalance);
		this.isSalary = isSalary;
		this.savingAmount=savingAmount;
	}
	public boolean isSalary() {
		return isSalary;
	}
	public void setSalary(boolean isSalary) {
		this.isSalary = isSalary;
	}
	public boolean withdraw(double amount) {
		if(isSalary && amount>0) {
			if(amount<=getAccountBalance()) {
				setAccountBalance(getAccountBalance()-amount);
				return true;
			}
		}
		else {
			if(amount>0 && (getAccountBalance()-amount)>=savingAmount) {
				setAccountBalance(getAccountBalance()-amount);
				return true;
			}
		}
		return false;
	}
	// deposit
	
	public boolean deposit(double amount) {
		if(amount>0) {
			setAccountBalance(getAccountBalance()+amount);
			return true;
		}
		return false;
	}
	//get account balance
	
	public void getAccountbalance() {
		System.out.println("Your account balance is " + getAccountBalance());

	}
}
