//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment 0
public abstract class BankAccount {
	protected String firstname;
	protected String lastname;
	protected int ssn;
	
   public BankAccount(String first, String last, int ssn){
		this.firstname = first;
		this.lastname = last;
		this.ssn = ssn;
	}
   
   abstract void deposit(double amount);
   abstract boolean withdraw(double amount);
}
