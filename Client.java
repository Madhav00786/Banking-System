/*
* Name: Madhav Sachdeva 
* Student ID: 040918899
* Course & Section: CST8132 305 
* Assignment: Lab 3
* Date: Sept 30, 2018
*/

public class Client {

	private String firstName = new String();
	private String lastName = new String();
	private long phoneNum;
	private String email = new String();

	
	// constructor
	public Client(String fName, String lName, long pNum, String mail) {
		
		firstName = fName;
		lastName = lName;
		phoneNum = pNum;
		email = mail;
	}

	
	// getter for full name
	public String getName() {
		
		return (firstName + " " + lastName);
	}

	
	// getter for phone number
	public long getPhoneNum() {
		
		return (phoneNum);
	}

	
	// getter for e-mail
	public String getEmail() {
		
		return (email);
	}

}
