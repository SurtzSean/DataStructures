//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment 1
public class SavingAccount extends BankAccount {
	private double interest;
	private int acctNumber;
	private double balance;
	private int accountNumber;
	
	//takes first name, last name, and social, assigns random account number and sets balance to 0 and interest to 1%
	public SavingAccount(String first, String last, int ssn){
		super(first, last, ssn);
		accountNumber = (int)(899999+(Math.random()*100000));
      
		balance = 0;
		interest = 0.01;
	}
	//takes a double as a parameter, returns true if balance is greater than amount, false if it is not
	public boolean withdraw(double amount){
		if(amount<=balance){
			System.out.println("Successfully withdrew $" + amount);
         balance-=amount;
         return true;
		}
		System.out.println("Withdraw failed: balance too low.");
		return false;
	}

	public void deposit(double amount){
		balance+=amount;
	}

	public String toString(){
		return "Firstname: " + this.firstname + "\nLastname: " + this.lastname + "\nSavings account number: " +
							 this.accountNumber + "\nBalance: " + this.balance + "\nInterest: " + this.interest * 100 + "%";
	}
}
