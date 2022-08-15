package com.mindgate.pojo;

public class Current extends Account {

	private double overdraftBalance;
	private double initialOverdraftBalance;
	
	public Current() {
		// TODO Auto-generated constructor stub
	}

	public Current(int accountNumber, String name, double accountBalance, double overdraftBalance,
			double initialOverdraftBalance) {
		super(accountNumber, name, accountBalance);
		this.overdraftBalance = overdraftBalance;
		this.initialOverdraftBalance = initialOverdraftBalance;
	}

	public double getOverdraftBalance() {
		return overdraftBalance;
	}

	public void setOverdraftBalance(double overdraftBalance) {
		this.overdraftBalance = overdraftBalance;
	}
	//withdraw
	
	public boolean withdraw(double amount){
		if(amount>0) {
			if(amount<=getAccountBalance()) {
				setAccountBalance((getAccountBalance()-amount));
				return true;
			}
			if(amount<(getAccountBalance()+initialOverdraftBalance) &&  amount>getAccountBalance()) {
				amount=amount-getAccountBalance();
				setAccountBalance(0);
				setOverdraftBalance((overdraftBalance-amount));
				return true;
			}
		}
		else {
			System.out.println("plz input valid amount");
		}
		return false;
	}
	// deposit
	public boolean deposit(double amount) {
		if(amount>0) {
			if(overdraftBalance<initialOverdraftBalance) {
				double difference=initialOverdraftBalance-overdraftBalance;
				if(difference>=amount) {
					setOverdraftBalance(getOverdraftBalance()+amount);
					return true;
				}
				else {
					amount=amount-difference;
					setOverdraftBalance(initialOverdraftBalance);
					setAccountBalance(getAccountBalance()+amount);
					return true;
				}
				
			}
			else {
				setAccountBalance(getAccountBalance()+amount);
				return true;
			}
		}
		else {
			System.out.println("enter valid amount");
		}
		return false;
	}
}
