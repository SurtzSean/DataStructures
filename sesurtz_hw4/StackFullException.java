//Name: Sean Surtz
//CSU ID: 2708486
//CIS 265: Assignment #4
public class StackFullException extends Exception{
   StackFullException(){
      System.out.println("Stack full exception");
   }
   StackFullException(String n){
      System.out.println("Stack full exception: " + n);
   }
}