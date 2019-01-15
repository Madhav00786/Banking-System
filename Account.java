/*
* Name: Madhav Sachdeva 
* Student ID: 040918899
* Course & Section: CST8132 304 
* Assignment: Lab 3
* Date: Sept 30, 2018
*/

import java.util.Random;

public class Account {

	private long accountNum;
	private Client client;
	private double balance;

	
	// constructor
	public Account(Client client1, double balance1) {
		
		client = client1;
		balance = balance1;
	}

	
	// method to deposit
	public void deposit(double amt) {
	
		balance = balance + amt;
	}

	
	// method to know if one can withdraw a certain amount
	public boolean withdraw(double amt) {
	
		boolean a;

		// condition to check if the amount entered is redeemable
		if (amt <= balance) {
			a = true;
			balance = balance - amt;
		} else {
			a = false;
		}
		
		return (a);
	}

	
	// getter for account number
	public long getAccountNum() {
		
		Random random = new Random();

		// loop to make sure the account number is greater than 0
		do {
			accountNum = random.nextLong();
		} while (accountNum > 0);

		return (accountNum);

	}

	
	// getter method to return client of class Client
	public Client getClient() {
	
		return client;
	}

	
	// getter method for balance
	public double getBalance() {
	
		return (balance);
	}

	
	// getter method for full name
	public String getName() {
	
		return client.getName();// calling getter method of class 'Client' with 'client' object
	}

}
