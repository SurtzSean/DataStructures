//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment 1
public class GiftCard implements Payable {
 private String pin;
 private double balance;
 
 public GiftCard(double amount, String pin){
   this.pin = pin;
   this.balance = amount;
 }
 
 //takes a double, ammount String, name and pin if amount<= balance it returns true, else it returns false
 public boolean makePayment(double amount, String name, String pin){
   if(amount<=balance&&pin.equals(this.pin)){
      System.out.println("Paid " + name + " " + amount);
      this.balance-=amount;
      return true;
   }
   else if(amount>balance && pin.equals(this.pin)){
      System.out.println("Payment Failed: Balance too low");
      return false;
   }
   System.out.println("Payment Failed: Wrong PIN");
   return false;
 }
 
 public String toString(){
   return"Gift Card Pin: " + this.pin + "\nGift Card Balance: " + this.balance;
 }
 
}
