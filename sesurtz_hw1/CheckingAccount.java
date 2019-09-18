//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment 1
public class CheckingAccount extends BankAccount implements Payable {
	private double interest;
	private int acctNumber;
	private double balance;
	private String pin;
   private int accountNumber;
   
   //takes strings firstname and lastname, int social, and string pin, assigns accountnumber 
   //and sets balance to 0 & interest to .1%
   public CheckingAccount(String firstname, String lastname, int ssn, String pin){
      super(firstname, lastname, ssn);
      accountNumber = (int)(8999999+(Math.random()*1000000));
      balance = 0;
      interest = 0.001;
      this.pin = pin;
   }
   
   //takes one parameter, amount, and withdraws amount from balance if balance >= amount
   public boolean withdraw(double amount){
      if(amount<=balance){
         balance-=amount;
         System.out.println("Successfully withdrew $" + amount);
         return true;
      }
      System.out.println("Checking account has insufficient funds");
      return false;
   }
   
   //takes an int, adds that amount to balance
   public void deposit(double amount){
      this.balance += amount;
   }
   
   //takes a double amount, and string name and pin if amount>=balance and pin is correct it returns true
   public boolean makePayment(double amount, String name, String pin){
      if(amount<=balance && pin.equals(this.pin)){
         System.out.println("Paid " + name + " $" + amount);
         this.balance-=amount;
         return true;
      }
      else if(amount>=balance&&pin.equals(this.pin)){
         System.out.println("Payment failed: insufficient funds");
         return false;
      } 
      System.out.println("Payment failed: wrong pin"); 
      return false;
   }
   
   public String toString(){
      return"Firstname: " + this.firstname + "\nLastname: " + this.lastname + "\nChecking Account Number: "+ 
            this.accountNumber + "\nBalance: " + this.balance + "\nInterest: " + this.interest*100 + "%" + "\nPIN: " + this.pin;
   }
}
