
/*
* Name: Madhav Sachdeva 
* Student ID: 040918899
* Course & Section: CST8132 304 
* Assignment: Lab 3
* Date: Sept 30, 2018
*/

import java.util.regex.Matcher;//library to match the pattern of email
import java.util.regex.Pattern;//library to set the pattern to validate email
import java.util.Scanner;
import java.text.DecimalFormat;

public class Bank {

	private String bankName = new String();
	private  Account[] accounts;
	private  Scanner input = new Scanner(System.in);// instantiating scanner
	private  DecimalFormat df = new DecimalFormat("###,###.##");// instantiating decimal format

	
	// constructor
	public Bank() {

		System.out.print("                      Welcome \nPlease enter your bank name : ");
	    bankName = input.nextLine();
		
	    System.out.print("Please enter the number of accounts : ");
		String num = input.next();//storing the input as String to then change it into int because vice versa not possible

		boolean condition = false;//taking a variable condition to run the loop
		int index =1;
		
		//condition to enter a valid integer value(with exception handling) 
		while(condition==false || index<=0 ){
		
			try {
				index = Integer.parseInt(num);
				condition = true;
			
				while(index<=0) {//condition so that even if the input is integer ,it must not be less than or equal to 0
					System.out.print("Please enter a positive Integer value: ");
					num=input.next();
					index = Integer.parseInt(num);
					condition=true;
				}
				
				
			} catch (Exception e) {
				System.out.print("Please enter a positive Integer value: ");
				num = input.next();
			}
			
		}
		
		accounts = new Account[index]; // initiating array with certain amount of index

		// loop for total number of accounts to run
		for (int i = 0; i < accounts.length; i++) {
			System.out.print("                      For Account #"+ (i+1)+ "\nEnter First Name : ");
			String fName = input.next();
			
			System.out.print("Enter Last Name : ");
			String lName = input.next();
			
			System.out.print("Enter Phone Number : ");
			long pNum = input.nextLong();
			
			System.out.print("Enter E-Mail : ");
			String mail = input.next();
            
			//Pattern class to set a pattern to validate email
			Pattern valid_e_mail = Pattern.compile("^[A-Z/0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",
					Pattern.CASE_INSENSITIVE);
			
			//Matcher class to match the email with pattern and validate it.
			Matcher matcher = valid_e_mail.matcher(mail);
			
			while (! matcher.find()) {
				System.out.print("The given email is invalid.Enter again : ");
				mail = input.next();
				matcher = valid_e_mail.matcher(mail);
			}

			Client objectC = new Client(fName, lName, pNum, mail); // object of class 'Client'

			System.out.print("Enter an opening balance : ");
			double oBalance = input.nextDouble();
		
			Account objectA = new Account(objectC, oBalance); // object of class 'Account'
			accounts[i] = objectA; // storing in array

		}

	}

	
	// method to print accounts
	public void printAccounts() {

		for (int i = 0; i < accounts.length; i++) {//loop to display the accounts in rows

			System.out.println("\nName-> "+accounts[i].getName() + ", AccNum-> "+accounts[i].getAccountNum() +", PhoneNum-> "+ accounts[i].getClient().getPhoneNum() + 
					", Email-> "+ accounts[i].getClient().getEmail() + ", Balance-> " + df.format(accounts[i].getBalance()));
		}

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank obj = new Bank();// object of class 'Bank'
		
		String choice;

		// loop for choices to run until you press q
		do {
			System.out.println("\nChoose one of the following " + "\n1. P or p: For displaying the accounts"
					+ "\n2. W or w: For withdrawing" + "\n3. D or d: For deposit" + "\n4. Q or q: To quit");

			choice = obj.input.next().toLowerCase();
			
			//condition for next action according to the input
			switch (choice) {
			case "p":
				obj.printAccounts();// calling method
				break;

			case "w":
				System.out.print("Enter the index of the account :");
				int index = obj.input.nextInt();
	
				System.out.print("Enter the amount to withdraw :");
				double amt = obj.input.nextDouble();
				
				boolean result = obj.accounts[index].withdraw(amt);

				// condition to show insufficient funds
				if (result == false) {
					System.out.print("Insufficient Funds! Balance is " + obj.df.format(obj.accounts[index].getBalance()));
				}
				break;

			case "d":
				System.out.print("Enter the index of the account ");
				index = obj.input.nextInt();
				
				System.out.print("Enter the amount to deposit : ");
				amt = obj.input.nextDouble();
				
				obj.accounts[index].deposit(amt);
				break;

			case "q":
				System.out.print("Thanks...Have a good day ");
			    return;
				
			default:
				System.out.println("Please enter a valid choice or press 'q' to exit ");
                break;				
			}
			
		} while (choice != "q");

	}
}
