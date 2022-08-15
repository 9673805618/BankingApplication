package com.mindgate.main;

import java.util.Scanner;

import com.mindgate.pojo.Current;
import com.mindgate.pojo.Savings;

public class BankingAccountMain {

	public static void main(String[] args) {
		double amount;
		boolean result;
		int choice;
		double overdraftBalance;
		double initialOverdraftBalance;
		String continueChoice;
		System.out.println("Welcome User..!");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Account Number");
		int accountNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter your Name");
		String name = scanner.next();
		System.out.println("Enter your Account Balance ");
		double accountBalance = scanner.nextDouble();
		System.out.println("which account do you prefer");
		System.out.println("1 for saving");
		System.out.println("2 for current");
		choice=scanner.nextInt();
		
		switch (choice) {
		case 1: {
			System.out.println("enter saving amount");
			double savingAmount=scanner.nextDouble();
			Savings savings=new Savings(accountNumber, name, accountBalance, false,savingAmount);
			do {
				System.out.println("Menu");
				System.out.println("1 for withdraw");
				System.out.println("2 for deposit");
				System.out.println("3 for check Balance");
				System.out.println("enter your choice");
				choice = scanner.nextInt();

				switch (choice) {
				case 1: {
					System.out.println("enter withdraw amount");
					amount = scanner.nextDouble();
					result = savings.withdraw(amount);
					if (result) {
						System.out.println("transaction is successfully..!");
					} else {
						System.out.println("Invalid fund");
					}
					break;
				}
				case 2: {
					System.out.println("enter your deposit amount");
					amount = scanner.nextDouble();
					result = savings.deposit(amount);
					if (result) {
						System.out.println("Amount is Deposited");
					} else {
						System.out.println("transaction failed");
					}
					break;
				}
				case 3: {
					System.out.println("Your Account Balance is " + savings.getAccountBalance());
					break;
				}
				default: 
					System.out.println("Invalid Input");
				}
				System.out.println("do you want to continue yes|no ");
				continueChoice=scanner.next();
			}
			while(continueChoice.equalsIgnoreCase("yes"));
			System.out.println("Thanks for visit");
			
		}
		case 2:{
			System.out.println("Set Overdraft Balance");
			overdraftBalance=scanner.nextDouble();
			initialOverdraftBalance=overdraftBalance;
			Current current=new Current(accountNumber, name, accountBalance, overdraftBalance, initialOverdraftBalance);
			do {
				System.out.println("Menu");
				System.out.println("1 for withdraw");
				System.out.println("2 for deposit");
				System.out.println("3 for check Balance");
				System.out.println("enter your choice");
				choice = scanner.nextInt();

				switch (choice) {
				case 1: {
					System.out.println("enter withdraw amount");
					amount = scanner.nextDouble();
					result = current.withdraw(amount);
					if (result) {
						System.out.println("transaction is successfully..!");
					} else {
						System.out.println("Invalid fund");
					}
					break;
				}
				case 2: {
					System.out.println("enter your deposit amount");
					amount = scanner.nextDouble();
					result = current.deposit(amount);
					if (result) {
						System.out.println("Amount is Deposited");
					} else {
						System.out.println("transaction failed");
					}
					break;
				}
				case 3: {
					System.out.println("Your Account Balance is " + current.getAccountBalance() +"and Overdraft Balance is "+current.getOverdraftBalance());
					break;
				}
				default: 
					System.out.println("Invalid Input");
				}
				System.out.println("do you want to continue yes|no ");
				continueChoice=scanner.next();
			}
			while(continueChoice.equalsIgnoreCase("yes"));
			System.out.println("Thanks for visit");
		}
		}
	}
}
